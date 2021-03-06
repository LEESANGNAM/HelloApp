package kr.ac.yeonsung.fgh0116.project6_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    RadioButton radioCalendar, radioTime;
    CalendarView calendar;
    TimePicker time;
    Button btnStart, btnDone;
    Chronometer chrono1;
    TextView textResult;
    int year, month, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg=findViewById(R.id.rg);
        radioCalendar = findViewById(R.id.radio_cal);
        radioTime = findViewById(R.id.radio_time);
        calendar = findViewById(R.id.calendar);
        time = findViewById(R.id.time);
        btnStart = findViewById(R.id.btn_start);
        btnDone = findViewById(R.id.btn_done);
        chrono1 = findViewById(R.id.chrono1);
        textResult = findViewById(R.id.text_result);

        btnStart.setOnClickListener(btnListener);
        btnDone.setOnClickListener(btnListener);

        radioCalendar.setOnClickListener(radioListener);
        radioTime.setOnClickListener(radioListener);

        calendar.setOnDateChangeListener(calendarListener);
    }

    View.OnClickListener radioListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            calendar.setVisibility(View.INVISIBLE);
            time.setVisibility(View.INVISIBLE);
            switch (rg.getCheckedRadioButtonId()){
                case  R.id.radio_cal:
                    calendar.setVisibility(View.VISIBLE);
                    break;
                case  R.id.radio_time:
                    time.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case  R.id.btn_start:
                    chrono1.setBase(SystemClock.elapsedRealtime());
                    chrono1.start();
                    chrono1.setTextColor(Color.RED);
                    break;
                case  R.id.btn_done:
                    chrono1.stop();
                    chrono1.setTextColor(Color.BLUE);
                    textResult.setText(year+"??? "+month+"??? "+date+"???");
                    textResult.append(time.getCurrentHour()+"??? "+ time.getCurrentMinute()+"??? ?????? ?????????");
                    break;
            }
        }
    };

    CalendarView.OnDateChangeListener calendarListener = new CalendarView.OnDateChangeListener() {
        @Override
        public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
            MainActivity.this.year = year;
            MainActivity.this.month = month+1;
            MainActivity.this.date = dayOfMonth;
        }
    };
}