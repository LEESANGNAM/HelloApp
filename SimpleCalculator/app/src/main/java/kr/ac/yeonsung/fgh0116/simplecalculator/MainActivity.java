package kr.ac.yeonsung.fgh0116.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1,edit2;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_plus = findViewById(R.id.btn_plus);
        Button btn_minus = findViewById(R.id.btn_minus);
        Button btn_multi = findViewById(R.id.btn_multi);
        Button btn_div = findViewById(R.id.btn_div);
        Button btn_mod = findViewById(R.id.btn_mod);

        btn_plus.setOnClickListener(btnlistner);
        btn_minus.setOnClickListener(btnlistner);
        btn_multi.setOnClickListener(btnlistner);
        btn_div.setOnClickListener(btnlistner);
        btn_mod.setOnClickListener(btnlistner);

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);

        textView = findViewById(R.id.text_result);


    }

    View.OnClickListener btnlistner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String strEdit1 = edit1.getText().toString();
            String strEdit2 = edit2.getText().toString();
            if(strEdit1.equals("")||strEdit2.equals("")) {
                Toast.makeText(getApplicationContext(), "값을 입력하지 않았습니다.", Toast.LENGTH_LONG).show();
                return;
            }
            double num1 = Double.parseDouble(strEdit1);
            double num2 = Double.parseDouble(strEdit2);
            double result = 0;

            switch (v.getId()){
                case R.id.btn_plus:
                    result=num1+num2;
                    break;
                case R.id.btn_minus:
                    result=num1-num2;
                    break;
                case R.id.btn_multi:
                    result=num1*num2;
                    break;
                case R.id.btn_div:
                    if(num2==0){
                        Toast.makeText(getApplicationContext(), "나누는 수는 0이면 안됩니다.", Toast.LENGTH_LONG).show();
                        return;
                    }
                    result=num1/num2;
                    break;
                case R.id.btn_mod:
                    if(num2==0){
                        Toast.makeText(getApplicationContext(), "나누는 수는 0이면 안됩니다.", Toast.LENGTH_LONG).show();
                        return;
                    }
                    result=num1%num2;
                    break;
            }
            textView.setText(R.string.text_result);
            textView.append(" "+String.format("%.2f",result));
        }
    };
}