package kr.ac.yeonsung.fgh0116.viewcontainertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex6_15);

        Button btnPrev = findViewById(R.id.btn_prev);
        Button btnNext = findViewById(R.id.btn_next);

        viewFlipper = findViewById(R.id.flipper);

        btnPrev.setOnClickListener(btnListener);
        btnNext.setOnClickListener(btnListener);
    }
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case  R.id.btn_prev:
                    viewFlipper.showPrevious();
                    break;
                case  R.id.btn_next:
                    viewFlipper.showNext();
                    break;
            }
        }
    };
}