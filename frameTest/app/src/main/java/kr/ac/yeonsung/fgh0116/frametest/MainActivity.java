package kr.ac.yeonsung.fgh0116.frametest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout l_sprinng,l_summer,l_fall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSpring = findViewById(R.id.btn_spring);
        Button btnSummer = findViewById(R.id.btn_summer);
        Button btnFall = findViewById(R.id.btn_fall);

        btnSpring.setOnClickListener(btnListener);
        btnSummer.setOnClickListener(btnListener);
        btnFall.setOnClickListener(btnListener);

        l_sprinng = findViewById(R.id.spring_layout);
        l_summer = findViewById(R.id.summer_layout);
        l_fall = findViewById(R.id.fall_layout);
    }
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            l_fall.setVisibility(View.INVISIBLE);
            l_sprinng.setVisibility(View.INVISIBLE);
            l_summer.setVisibility(View.INVISIBLE);
            switch (v.getId()){
                case R.id.btn_spring:
                    l_sprinng.setVisibility(View.VISIBLE);
                    break;
                case R.id.btn_summer:
                    l_summer.setVisibility(View.VISIBLE);
                    break;
                case R.id.btn_fall:
                    l_fall.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

}