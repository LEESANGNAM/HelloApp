package kr.ac.yeonsung.fgh0116.viewcontainertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity2 extends AppCompatActivity {
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btnStart = findViewById(R.id.btn_start);
        Button btnStop = findViewById(R.id.btn_stop);

        viewFlipper = findViewById(R.id.flipper);
        viewFlipper.setFlipInterval(1000);

        btnStart.setOnClickListener(btnListener);
        btnStop.setOnClickListener(btnListener);
    }
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case  R.id.btn_start:
                    viewFlipper.startFlipping();
                    break;
                case  R.id.btn_stop:
                    viewFlipper.stopFlipping();
                    break;
            }
        }
    };
}