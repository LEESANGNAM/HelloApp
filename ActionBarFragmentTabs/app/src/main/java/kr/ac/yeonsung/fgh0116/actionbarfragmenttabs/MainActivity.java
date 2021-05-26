package kr.ac.yeonsung.fgh0116.actionbarfragmenttabs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
    ActionBar.Tab tabSong,tabArtist, tabAlbum;
    MyTebFragment[] myFrags = new MyTebFragment[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tabSong = bar.newTab();
        tabSong.setText("음악별");
        tabSong.setTabListener(this);
        bar.addTab(tabSong);

        tabArtist = bar.newTab();
        tabArtist.setText("가수별");
        tabArtist.setTabListener(this);
        bar.addTab(tabArtist);

        tabAlbum = bar.newTab();
        tabAlbum.setText("앨범별");
        tabAlbum.setTabListener(this);
        bar.addTab(tabAlbum);
    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        MyTebFragment myTebFrag = null;
        if(myFrags[tab.getPosition()] == null){
            myTebFrag = new MyTebFragment();
            Bundle data  = new Bundle();
            data.putString("tabName",tab.getText().toString());
            myTebFrag.setArguments(data);
            myFrags[tab.getPosition()] = myTebFrag;
        }else {
            myTebFrag = myFrags[tab.getPosition()];
        }
        ft.replace(android.R.id.content,myTebFrag);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    public static class MyTebFragment extends Fragment{
        String tabName;

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle data = getArguments();
            tabName = data.getString("tabName");
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            LinearLayout linear1 = new LinearLayout(super.getActivity());
            linear1.setOrientation(LinearLayout.VERTICAL);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            linear1.setLayoutParams(params);

            if(tabName =="음악별")
                linear1.setBackgroundColor(Color.MAGENTA);
            if(tabName =="가수별")
                linear1.setBackgroundColor(Color.GRAY);
            if(tabName =="앨범별")
                linear1.setBackgroundColor(Color.BLUE);

            return linear1;
        }
    }
}