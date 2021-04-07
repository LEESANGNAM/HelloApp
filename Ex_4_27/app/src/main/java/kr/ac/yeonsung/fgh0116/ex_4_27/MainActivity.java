package kr.ac.yeonsung.fgh0116.ex_4_27;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    Switch aSwitch;
    LinearLayout linearLayout;
    RadioGroup radioGroup;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pat);

        setTitle(R.string.title);

        aSwitch = findViewById(R.id.switch_start);
        linearLayout = findViewById(R.id.linear1);
        radioGroup = findViewById(R.id.rg);

        Button btnFinish = findViewById(R.id.btn_finish);
        Button btnFirst = findViewById(R.id.btn_first);
        btnFinish.setOnClickListener(btnListener);
        btnFirst.setOnClickListener(btnListener);


        imageView = findViewById(R.id.img1);


        aSwitch.setOnCheckedChangeListener(switchListener);
        RadioButton rbDog = findViewById(R.id.rb_dog);
        RadioButton rbCat = findViewById(R.id.rb_cat);
        RadioButton rbPanda = findViewById(R.id.rb_panda);
        rbDog.setOnClickListener(radioListener);
        rbCat.setOnClickListener(radioListener);
        rbPanda.setOnClickListener(radioListener);

    }

    CompoundButton.OnCheckedChangeListener switchListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
          if(isChecked){
              linearLayout.setVisibility(View.VISIBLE);
          }else{
              linearLayout.setVisibility(View.INVISIBLE);
          }
        }
    };

    View.OnClickListener radioListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (radioGroup.getCheckedRadioButtonId()){
                case R.id.rb_dog:
                    imageView.setImageResource(R.drawable.dog);
                    break;
                case R.id.rb_cat:
                    imageView.setImageResource(R.drawable.cat);
                    break;
                case R.id.rb_panda:
                    imageView.setImageResource(R.drawable.panda);
                    break;
            }
        }
    };
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_finish:
                    finish();
                    break;
                case R.id.btn_first:
                    linearLayout.setVisibility(View.INVISIBLE);
                    aSwitch.setChecked(false);
                    break;
            }
        }
    };

}