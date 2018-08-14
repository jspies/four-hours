package com.fourhours.modules.alarms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.fourhours.modules.notifications.FourHoursNotification;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("ReactNative", "received");
        String hour = intent.getStringExtra("NAME");

        FourHoursNotification note = new FourHoursNotification(context);

        note.sendNotification(hour, String.format("It's time for %s!", hour), null);
    }
}
