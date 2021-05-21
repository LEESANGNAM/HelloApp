package kr.ac.yeonsung.fgh0116.tabhosttest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabSpecSong = tabHost.newTabSpec("song").setIndicator("음악별"); //setIndicator 문자열 지정
        tabSpecSong.setContent(R.id.tab_song);
        tabHost.addTab(tabSpecSong);

        TabHost.TabSpec tabSpecArtist = tabHost.newTabSpec("artist").setIndicator("가수별"); //setIndicator 문자열 지정
        tabSpecArtist.setContent(R.id.tab_artist);
        tabHost.addTab(tabSpecArtist);

        TabHost.TabSpec tabSpecAlbum = tabHost.newTabSpec("album").setIndicator("앨범별"); //setIndicator 문자열 지정
        tabSpecAlbum.setContent(R.id.tab_album);
        tabHost.addTab(tabSpecAlbum);

        tabHost.setCurrentTab(0);
    }
}