package com.fourhours.modules.notifications;

import android.app.PendingIntent;
import android.content.Context;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.os.Build;
import android.support.v4.app.NotificationManagerCompat;
import android.content.Intent;
import android.net.Uri;

import com.fourhours.DailyOfficeActivity;
import com.fourhours.MainActivity;
import com.fourhours.R;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class FourHoursNotification extends ReactContextBaseJavaModule {
    private String CHANNEL_ID = "fourhourschannel";
    private Context context;
    private final ReactApplicationContext reactContext;

    public FourHoursNotification(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    public FourHoursNotification(Context context) {
        super(null);
        this.context = context;
        this.reactContext = null;
    }

    @Override
    public String getName() {
        return "FHNotifications";
    }

    @ReactMethod
    public void sendNotification(String title, String text, Callback cb) {
        if (this.reactContext != null) {
            Intent shortIntent = new Intent(this.reactContext, ShortBroadcastReceiver.class);
            PendingIntent shortPendingIntent = PendingIntent.getBroadcast(this.reactContext, 0, shortIntent, 0);

            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this.reactContext, CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_stat_onesignal_default)
                    .setContentTitle(title)
                    .setContentText(text)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .addAction(R.drawable.ic_stat_onesignal_default, "Short", shortPendingIntent);

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this.reactContext);

            notificationManager.notify(1, mBuilder.build());
        }

        if (this.context != null) {

            Intent mainIntent = new Intent(this.context, DailyOfficeActivity.class);

            PendingIntent shortPendingIntent = PendingIntent.getActivity(this.context, 0, mainIntent, 0);


            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this.context, CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_stat_onesignal_default)
                    .setContentTitle(title)
                    .setContentText(text)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .addAction(R.drawable.ic_stat_onesignal_default, "Daily Office", shortPendingIntent);

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this.context);

            notificationManager.notify(1, mBuilder.build());
        }


        if (cb != null) {
            cb.invoke(null, "Done");
        }
    }

    @ReactMethod
    public void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "FourHoursChannel";
            String description = "Four Hours Notifications";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            Context context = getReactApplicationContext();
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
