package kr.ac.yeonsung.fgh0116.project10_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup rg;
        rg=findViewById(R.id.rg);
        Button btnNew = findViewById(R.id.btn_new);
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null;
                switch (rg.getCheckedRadioButtonId()){
                    case R.id.radio_second:
                        intent = new Intent(getApplicationContext(),SecondActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.radio_third:
                        intent = new Intent(getApplicationContext(),ThirdActivity.class);
                        startActivity(intent);
                        break;
                }

            }
        });
    }
}