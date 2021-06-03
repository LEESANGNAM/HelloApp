package kr.ac.yeonsung.fgh0116.project10_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class SecondActivity extends AppCompatActivity {
    RatingBar rating1, rating2, rating3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        rating1 = findViewById(R.id.rating1);
        rating2 = findViewById(R.id.rating2);
        rating3 = findViewById(R.id.rating3);

        Button btnInc = findViewById(R.id.btn_inc);
        Button btnDec = findViewById(R.id.btn_dec);

        btnInc.setOnClickListener(btnListener);
        btnDec.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_inc:
                    rating1.setRating(rating1.getRating()+rating1.getStepSize());
                    rating2.setRating(rating2.getRating()+rating2.getStepSize());
                    rating3.setRating(rating3.getRating()+rating3.getStepSize());
                    break;
                case R.id.btn_dec:
                    rating1.setRating(rating1.getRating()-rating1.getStepSize());
                    rating2.setRating(rating2.getRating()-rating2.getStepSize());
                    rating3.setRating(rating3.getRating()-rating3.getStepSize());
                    break;
            }
        }
    };

}