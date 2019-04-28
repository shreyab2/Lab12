package edu.illinois.cs.cs125.spring2019.lab12;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import static edu.illinois.cs.cs125.spring2019.lab12.Notifications.CHANNEL_1_ID;

public class NotificationBuilder extends AppCompatActivity {

    private Context context;
    private PendingIntent pendingIntent;
    private String title;
    private String message;

    NotificationBuilder(final Context context1, final PendingIntent pendingIntent1, final String title1, final String mes) {
        context = context1;
        pendingIntent = pendingIntent1;
        title = title1;
        message = mes;
    }

    public Notification buildNotification() {

        //setting the title and message is causing errors.
        //EditText editTextTitle = findViewById(R.id.edit_text_title);
        //String title = editTextTitle.getText().toString();

        //EditText editTextMessage = findViewById(R.id.edit_text_message);
        //String message = editTextMessage.getText().toString();

        Notification notification = new NotificationCompat.Builder(context, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_one)
                .setContentTitle(title)
                .setContentText(message)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();
        return notification;
    }
}
