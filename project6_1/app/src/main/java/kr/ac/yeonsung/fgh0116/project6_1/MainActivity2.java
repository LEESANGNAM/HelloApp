package kr.ac.yeonsung.fgh0116.project6_1;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import static android.view.View.INVISIBLE;

public class MainActivity2 extends AppCompatActivity {
    RadioGroup rg;
    RadioButton radioCalendar, radioTime;
    DatePicker calendar;
    TimePicker time;
    Chronometer chrono1;
    TextView textResult;
    int year, month, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rg=findViewById(R.id.rg);
        radioCalendar = findViewById(R.id.radio_cal);
        radioTime = findViewById(R.id.radio_time);
        calendar = findViewById(R.id.calendar);
        time = findViewById(R.id.time);
        chrono1 = findViewById(R.id.chrono1);
        textResult = findViewById(R.id.text_result);

        radioCalendar.setOnClickListener(radioListener);
        radioTime.setOnClickListener(radioListener);

        chrono1.setOnClickListener(chronoListener);
        textResult.setOnLongClickListener(textListener);
    }

    View.OnClickListener radioListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            calendar.setVisibility(INVISIBLE);
            time.setVisibility(INVISIBLE);
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

    View.OnClickListener chronoListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            radioCalendar.setVisibility(View.VISIBLE);
            radioTime.setVisibility(View.VISIBLE);
            calendar.setVisibility(View.VISIBLE);
            chrono1.setBase(SystemClock.elapsedRealtime());
            chrono1.start();
            chrono1.setTextColor(Color.RED);
        }
    };

    View.OnLongClickListener textListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            chrono1.stop();
            chrono1.setTextColor(Color.BLUE);
            textResult.setText(calendar.getYear()+"년 "+(calendar.getMonth()+1)+"월 "+calendar.getDayOfMonth()+"일 ");
            textResult.append(time.getCurrentHour()+"시 "+time.getCurrentMinute()+"분 예약 완료");
            radioCalendar.setVisibility(INVISIBLE);
            radioTime.setVisibility(INVISIBLE);
            calendar.setVisibility(INVISIBLE);
            time.setVisibility(INVISIBLE);
            return false;
        }
    };

}