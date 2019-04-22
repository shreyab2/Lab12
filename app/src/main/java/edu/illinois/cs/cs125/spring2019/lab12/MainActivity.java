package edu.illinois.cs.cs125.spring2019.lab12;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.EditText;

import static edu.illinois.cs.cs125.spring2019.lab12.Notifications.CHANNEL_1_ID;
import static edu.illinois.cs.cs125.spring2019.lab12.Notifications.CHANNEL_2_ID;

/**
 * Main class for our UI design lab.
 */
public final class MainActivity extends AppCompatActivity {
    /**
     * shows all notifications.
     */
    private NotificationManagerCompat notificationManager;
    /**
     * edit text title.
     */
    private EditText editTextTitle;
    /**
     * edit text message.
     */
    private EditText editTextMessage;
    /**
     * runs when the app starts.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = NotificationManagerCompat.from(this);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextMessage = findViewById(R.id.edit_text_message);
    }

    /**
     * notification that goes through channel 1.
     * @param v notification
     */
    public void sendOnChannel1(final View v) {
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_one)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManager.notify(1, notification);
    }

    /**
     * notification that goes through channel 2.
     * @param v notification
     */
    public void sendOnChannel2(final View v) {
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_two)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();
        notificationManager.notify(2, notification);
    }
}
