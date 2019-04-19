package edu.illinois.cs.cs125.spring2019.lab12;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

/**
 * notification class.
 */
public class Notifications extends Application {
    /**
     * first notification channel.
     */
    public static final String CHANNEL_1_ID = "channel 1";
    /**
     * second notification channel.
     */
    public static final String CHANNEL_2_ID = "channel 2";
    /**
     * runs when the app opens.
     */
    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannels();
    }

    /**
     * Runs when app is open to create notification channels.
     */
    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID, "Channel 1", NotificationManager.IMPORTANCE_HIGH);
            channel1.setDescription("This is Channel 1");
            NotificationChannel channel2 = new NotificationChannel(
                    CHANNEL_2_ID, "Channel 2", NotificationManager.IMPORTANCE_LOW);
            channel2.setDescription("This is Channel 2");


            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);

        }
    }
}
