package com.example.seoulalarm;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView txtBottomMenuWeather, txtBottomMenuAlarm, txtBottomMenuMemo;
    ImageView imgBottomMenuWeather, imgBottomMenuAlarm, imgBottomMenuMemo;
    FrameLayout fragmentContainer;

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    FragmentWeather fragmentWeather;
    FragmentAlarm fragmentAlarm;
    FragmentMemo fragmentMemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitView();
        InitFragment();
        ListViewSettings();
    }

    private void ListViewSettings() {

    }

    private void InitFragment(){
        fragmentManager = getSupportFragmentManager();

        fragmentWeather = new FragmentWeather();
        fragmentMemo = new FragmentMemo();
        fragmentAlarm = new FragmentAlarm();

        fragmentTransaction.replace(R.id.fragmentContainer, fragmentWeather).commit();

    }

    private void InitView(){
        txtBottomMenuWeather = (TextView)findViewById(R.id.txtBottomMenuWeather);
        imgBottomMenuWeather = (ImageView)findViewById(R.id.imgBottomMenuWeather);
        txtBottomMenuAlarm = (TextView)findViewById(R.id.txtBottomMenuAlarm);
        imgBottomMenuAlarm = (ImageView)findViewById(R.id.imgBottomMenuAlarm);
        txtBottomMenuMemo = (TextView)findViewById(R.id.txtBottomMenuMemo);
        imgBottomMenuMemo = (ImageView)findViewById(R.id.imgBottomMenuMemo);

        txtBottomMenuWeather.setOnClickListener(bottomMenuTxtHanlder);
        txtBottomMenuMemo.setOnClickListener(bottomMenuTxtHanlder);
        txtBottomMenuAlarm.setOnClickListener(bottomMenuTxtHanlder);

        imgBottomMenuWeather.setOnClickListener(bottomMenuImgHandler);
        imgBottomMenuMemo.setOnClickListener(bottomMenuImgHandler);
        imgBottomMenuAlarm.setOnClickListener(bottomMenuImgHandler);

        fragmentContainer = findViewById(R.id.fragmentContainer);

    }

    ImageView.OnClickListener bottomMenuImgHandler = new ImageView.OnClickListener(){
        @Override
        public void onClick(View v) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            switch (v.getId())
            {
                case R.id.imgBottomMenuWeather:
                    fragmentTransaction.replace(R.id.fragmentContainer, fragmentWeather).commit();
                    imgBottomMenuWeather.setImageResource(R.drawable.weather);
                    imgBottomMenuAlarm.setImageResource(R.drawable.alarm_g);
                    imgBottomMenuMemo.setImageResource(R.drawable.memo_g);
                    txtBottomMenuWeather.setTextColor(getResources().getColor(R.color.textBlue));
                    txtBottomMenuAlarm.setTextColor(getResources().getColor(R.color.textGray));
                    txtBottomMenuMemo.setTextColor(getResources().getColor(R.color.textGray));
                    break;
                case R.id.imgBottomMenuAlarm:
                    fragmentTransaction.replace(R.id.fragmentContainer, fragmentAlarm).commit();
                    imgBottomMenuWeather.setImageResource(R.drawable.weather_g);
                    imgBottomMenuAlarm.setImageResource(R.drawable.alarm);
                    imgBottomMenuMemo.setImageResource(R.drawable.memo_g);
                    txtBottomMenuWeather.setTextColor(getResources().getColor(R.color.textGray));
                    txtBottomMenuAlarm.setTextColor(getResources().getColor(R.color.textBlue));
                    txtBottomMenuMemo.setTextColor(getResources().getColor(R.color.textGray));

                    break;
                case R.id.imgBottomMenuMemo:
                    fragmentTransaction.replace(R.id.fragmentContainer, fragmentMemo).commit();
                    imgBottomMenuWeather.setImageResource(R.drawable.weather_g);
                    imgBottomMenuAlarm.setImageResource(R.drawable.alarm_g);
                    imgBottomMenuMemo.setImageResource(R.drawable.memo);
                    txtBottomMenuWeather.setTextColor(getResources().getColor(R.color.textGray));
                    txtBottomMenuAlarm.setTextColor(getResources().getColor(R.color.textGray));
                    txtBottomMenuMemo.setTextColor(getResources().getColor(R.color.textBlue));
                    break;
            }
        }
    };
    TextView.OnClickListener bottomMenuTxtHanlder = new TextView.OnClickListener(){

        @Override
        public void onClick(View v) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            switch (v.getId()){
                case R.id.txtBottomMenuWeather:
                    fragmentTransaction.replace(R.id.fragmentContainer, fragmentWeather).commit();
                    imgBottomMenuWeather.setImageResource(R.drawable.weather);
                    imgBottomMenuAlarm.setImageResource(R.drawable.alarm_g);
                    imgBottomMenuMemo.setImageResource(R.drawable.memo_g);
                    txtBottomMenuWeather.setTextColor(getResources().getColor(R.color.textBlue));
                    txtBottomMenuAlarm.setTextColor(getResources().getColor(R.color.textGray));
                    txtBottomMenuMemo.setTextColor(getResources().getColor(R.color.textGray));
                    break;
                case R.id.txtBottomMenuAlarm:
                    fragmentTransaction.replace(R.id.fragmentContainer, fragmentAlarm).commit();
                    imgBottomMenuWeather.setImageResource(R.drawable.weather_g);
                    imgBottomMenuAlarm.setImageResource(R.drawable.alarm);
                    imgBottomMenuMemo.setImageResource(R.drawable.memo_g);
                    txtBottomMenuWeather.setTextColor(getResources().getColor(R.color.textGray));
                    txtBottomMenuAlarm.setTextColor(getResources().getColor(R.color.textBlue));
                    txtBottomMenuMemo.setTextColor(getResources().getColor(R.color.textGray));
                    break;
                case R.id.txtBottomMenuMemo:
                    fragmentTransaction.replace(R.id.fragmentContainer, fragmentMemo).commit();
                    imgBottomMenuWeather.setImageResource(R.drawable.weather_g);
                    imgBottomMenuAlarm.setImageResource(R.drawable.alarm_g);
                    imgBottomMenuMemo.setImageResource(R.drawable.memo);
                    txtBottomMenuWeather.setTextColor(getResources().getColor(R.color.textGray));
                    txtBottomMenuAlarm.setTextColor(getResources().getColor(R.color.textGray));
                    txtBottomMenuMemo.setTextColor(getResources().getColor(R.color.textBlue));
                    break;
            }
        }
    };

}
