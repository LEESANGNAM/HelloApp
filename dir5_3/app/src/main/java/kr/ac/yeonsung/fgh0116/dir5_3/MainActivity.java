package kr.ac.yeonsung.fgh0116.dir5_3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText edit;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setContentView(linearLayout,params);

        edit = new EditText(this);
        Button btn = new Button(this);
        text = new TextView(this);

        edit.setTextSize(20);
        btn.setBackgroundColor(Color.rgb(255,255,0));
        btn.setTextColor(Color.BLACK);
        btn.setText("버튼입니다.");
        text.setTextSize(20);
        text.setTextColor(Color.rgb(189,36,169));

        linearLayout.addView(edit);
        linearLayout.addView(btn);
        linearLayout.addView(text);

        btn.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String editStr = edit.getText().toString();
            text.setText(editStr);
        }
    };

}