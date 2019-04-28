package edu.illinois.cs.cs125.spring2019.lab12;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.widget.EditText;

import static edu.illinois.cs.cs125.spring2019.lab12.Notifications.CHANNEL_1_ID;

/**
 * class that determines what happens when the notification is received.
 */
public class NotificationReceiver extends BroadcastReceiver {
    /**
     * edit text title.
     */
    private EditText editTextTitle;
    /**
     * edit text message.
     */
    private EditText editTextMessage;
    /**
     * adds a message when the notification pops up.
     * @param context
     * @param intent
     */
    @Override
    public void onReceive(final Context context, final Intent intent) {

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent intent1 = new Intent(context, MainActivity.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        String title = intent.getStringExtra("title");
        String message = intent.getStringExtra("message");

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 100, intent1, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationBuilder build = new NotificationBuilder(context, pendingIntent, title, message);

        Notification notification = build.buildNotification();
        if (intent.getAction().equals("MY_NOTIFICATION_MESSAGE")) {
            notificationManager.notify(100, notification);
        }

    }
}
