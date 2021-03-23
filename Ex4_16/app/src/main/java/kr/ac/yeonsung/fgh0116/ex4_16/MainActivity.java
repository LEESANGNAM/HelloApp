package kr.ac.yeonsung.fgh0116.ex4_16;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4_17);

        TextView t1 = findViewById(R.id.text1);
        TextView t2 = findViewById(R.id.text2);
        TextView t3 = findViewById(R.id.text3);


        t1.setText(R.string.text1);
        t1.setTextColor(Color.BLUE);

        t2.setText(R.string.text2);
        t2.setTextSize(30);
        t2.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD_ITALIC);

        t3.setText(R.string.text3);
        t3.setSingleLine();
    }
}