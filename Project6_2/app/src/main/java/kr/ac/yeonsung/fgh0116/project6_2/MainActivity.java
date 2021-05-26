package kr.ac.yeonsung.fgh0116.project6_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editURL;
    WebView web1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editURL =findViewById(R.id.edit_url);
        web1 =findViewById(R.id.web1);

        Button btnGo = findViewById(R.id.btn_go);
        Button btnBack = findViewById(R.id.btn_back);

        web1.setWebViewClient(new CookWebViewClient());
        WebSettings webSettings = web1.getSettings();
        webSettings.setBuiltInZoomControls(true); //줌인 줌아웃
        webSettings.setJavaScriptEnabled(true); // 자바스크립트 허가

        btnGo.setOnClickListener(btnListener);
        btnBack.setOnClickListener(btnListener);
    }

    class CookWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          switch (v.getId()){
              case R.id.btn_go:
                  web1.loadUrl(editURL.getText().toString());
                  break;
              case R.id.btn_back:
                  web1.goBack();
                  break;
          }
        }
    };
}