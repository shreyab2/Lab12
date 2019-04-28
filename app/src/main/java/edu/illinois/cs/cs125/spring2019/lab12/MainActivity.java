package edu.illinois.cs.cs125.spring2019.lab12;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.EditText;

import java.util.Calendar;

import static edu.illinois.cs.cs125.spring2019.lab12.Notifications.CHANNEL_1_ID;
import static edu.illinois.cs.cs125.spring2019.lab12.Notifications.CHANNEL_2_ID;
import static java.lang.Integer.parseInt;

/**
 * Main class for our UI design lab.
 */
public final class MainActivity extends AppCompatActivity {

    private String title;
    private String message;

    private EditText editTitle;
    private EditText editMessage;
    private EditText editHour;
    private EditText editMinute;
    private EditText editAMPM;

    /**
     * runs when the app starts.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTitle = findViewById(R.id.edit_text_title);
        editMessage = findViewById(R.id.edit_text_message);

        editHour = findViewById(R.id.edit_hour);
        editMinute = findViewById(R.id.edit_minute);

        editAMPM = findViewById(R.id.edit_AMPM);


        findViewById(R.id.button).setOnClickListener(view -> {

            String h = editHour.getText().toString();
            String m = editMinute.getText().toString();

            String AMPM = editAMPM.getText().toString();

            int hour;
            try {
                hour = parseInt(h);
            } catch (Exception e) {
                hour = -1;
            }
            final int hour1;

            int minute;
            try {
                minute = parseInt(m);
            } catch (Exception e) {
                minute = -1;
            }
            final int min = minute;

            Calendar calendar = Calendar.getInstance();

            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MINUTE, min);

            if (hour == 12 && AMPM.equals("AM")) {
                hour1 = 0;
            } else if (AMPM.equals("PM") && hour != 12) {
                hour1 = hour + 12;
            } else {
                hour1 = hour;
            }
            calendar.set(Calendar.HOUR_OF_DAY, hour1);

            title = editTitle.getText().toString();
            message = editMessage.getText().toString();

            Intent intent = new Intent(getApplicationContext(), NotificationReceiver.class);
            intent.setAction("MY_NOTIFICATION_MESSAGE");
            intent.putExtra("title", title);
            intent.putExtra("message", message);

            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 100, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

        });
    }
}
