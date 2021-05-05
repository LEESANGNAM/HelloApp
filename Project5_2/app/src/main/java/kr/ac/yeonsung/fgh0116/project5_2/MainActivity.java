package kr.ac.yeonsung.fgh0116.project5_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1,edit2;
    TextView textResult;
    int[] btnNumIds = {R.id.btn_0,R.id.btn_1,R.id.btn_2,R.id.btn_3,R.id.btn_4,R.id.btn_5,R.id.btn_6,R.id.btn_7,R.id.btn_8,R.id.btn_9};
    Button[] btnNums = new Button[btnNumIds.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        textResult=findViewById(R.id.text_result);
        Button btnPlus = findViewById(R.id.btn_plus);
        Button btnMinus = findViewById(R.id.btn_minus);
        Button btnMul = findViewById(R.id.btn_mul);
        Button btnDiv = findViewById(R.id.btn_div);

        btnPlus.setOnTouchListener(btnTouchListener);
        btnMinus.setOnTouchListener(btnTouchListener);
        btnMul.setOnTouchListener(btnTouchListener);
        btnDiv.setOnTouchListener(btnTouchListener);

        for(int i=0; i<btnNums.length;i++){
            btnNums[i] = findViewById(btnNumIds[i]);
            btnNums[i].setOnClickListener(btnClickListener);
        }
    }

    View.OnTouchListener btnTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int num1 = Integer.parseInt(edit1.getText().toString());
            int num2 = Integer.parseInt(edit2.getText().toString());
            int result = 0; //지역변수는 자동 초기화 불가.

            switch (v.getId()){
                case R.id.btn_plus: result=num1+num2;
                    break;
                case R.id.btn_minus:result=num1-num2;
                    break;
                case R.id.btn_mul:result=num1*num2;
                    break;
                case R.id.btn_div:result=num1/num2;
                    break;
            }

            textResult.setText(R.string.text_result);
            textResult.append(result+"");

            return false;
        }
    };

    View.OnClickListener btnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button btn = (Button) v;
            if (edit1.isFocused()){
                edit1.setText(edit1.getText().toString()+btn.getText().toString());
            }else if(edit2.isFocused()){
                edit2.setText(edit2.getText().toString()+btn.getText().toString());
            }else {
                Toast.makeText(getApplicationContext(),"EditText를 선택해주세요",Toast.LENGTH_LONG).show();
            }
        }
    };
}