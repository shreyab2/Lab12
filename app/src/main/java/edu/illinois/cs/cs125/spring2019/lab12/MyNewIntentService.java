package edu.illinois.cs.cs125.spring2019.lab12;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;

import static edu.illinois.cs.cs125.spring2019.lab12.Notifications.CHANNEL_1_ID;

/**
 * shows the notification when the alarm is received.
 */
public class MyNewIntentService extends IntentService {
    /**
     * notifiaction ID.
     */
    private static final int NOTIFICATION = 1;
    /**
     * constructor for class.
     */
    public MyNewIntentService() {
        super("MyNewIntentService");
    }
    public void onHandleIntent(final Intent intent) {
        onCreate();
    }
    /**
     * triggers the notification.
     */
    @Override
    public void onCreate() {
        NotificationManager mNM = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification notification = new Notification(R.drawable.ic_one, "Notify Alarm start", System.currentTimeMillis());

        Intent myIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, myIntent, 0);
        mNM.notify(NOTIFICATION, notification);
    }
}
