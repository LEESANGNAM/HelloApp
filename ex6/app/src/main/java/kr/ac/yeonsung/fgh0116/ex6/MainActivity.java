package kr.ac.yeonsung.fgh0116.ex6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] items = {"CSI- 뉴욕","CSI-라스베가스","CSI-마이애미","프렌즈","미드나잇 선"};

        AutoCompleteTextView auto = findViewById(R.id.auto_text);
        MultiAutoCompleteTextView multi = findViewById(R.id.multi_text);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items);
        auto.setAdapter(adapter);

        MultiAutoCompleteTextView.CommaTokenizer tokenizer = new MultiAutoCompleteTextView.CommaTokenizer();
        multi.setTokenizer(tokenizer);
        multi.setAdapter(adapter);
    }
}