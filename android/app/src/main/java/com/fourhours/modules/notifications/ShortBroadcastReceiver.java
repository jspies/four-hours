package com.fourhours.modules.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.fourhours.modules.alarms.FourHoursAlarmModule;

public class ShortBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d("ReactNative", "Short Broad received");
        FourHoursAlarmModule.sendEvent("shortIntent", null);
    }
}
