package com.fourhours.modules.alarms;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;


import java.util.Calendar;

public class FourHoursAlarmModule extends ReactContextBaseJavaModule {
    private static ReactApplicationContext reactContext;
    private final int MORNING_CODE = 0;
    private final int COMPLINE_CODE = 1;
    private final int NOONDAY_CODE = 2;

    public FourHoursAlarmModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "Alarms";
    }

    @ReactMethod
    public void setAlarm(String type, int hour, int minute, Callback cb) {
        AlarmManager alarmMgr;
        PendingIntent pendingIntent;

        alarmMgr = (AlarmManager)reactContext.getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(reactContext, AlarmReceiver.class);
        intent.putExtra("NAME", type);
        int code = 0;
        switch(type) {
            case "MORNING":
                code = MORNING_CODE;
                break;
            case "COMPLINE":
                code = COMPLINE_CODE;
                break;
            case "NOONDAY":
                code = NOONDAY_CODE;
                break;
        }
        pendingIntent = PendingIntent.getBroadcast(reactContext, code, intent, 0);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);


        alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
        cb.invoke(null, "Set");
    }

    public static void sendEvent(String event, WritableNativeMap params) {
        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(event, params);
    }
}