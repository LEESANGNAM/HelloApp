package kr.ac.yeonsung.fgh0116.tabhosttest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity2 extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabSpecDog = tabHost.newTabSpec("dog").setIndicator("강아지"); //setIndicator 문자열 지정
        tabSpecDog.setContent(R.id.tab_dog);
        tabHost.addTab(tabSpecDog);

        TabHost.TabSpec tabSpecCat = tabHost.newTabSpec("cat").setIndicator("고양이"); //setIndicator 문자열 지정
        tabSpecCat.setContent(R.id.tab_cat);
        tabHost.addTab(tabSpecCat);

        TabHost.TabSpec tabSpecRabbit = tabHost.newTabSpec("rabbit").setIndicator("토끼"); //setIndicator 문자열 지정
        tabSpecRabbit.setContent(R.id.tab_rabbit);
        tabHost.addTab(tabSpecRabbit);

        TabHost.TabSpec tabSpecPanda = tabHost.newTabSpec("panda").setIndicator("판다"); //setIndicator 문자열 지정
        tabSpecPanda.setContent(R.id.tab_panda);
        tabHost.addTab(tabSpecPanda);

        tabHost.setCurrentTab(0);
    }
}