package org.techtown.sample_weatherapi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    TextView txtTemp;
    ImageView imgWeather;
    TextView txtTodayWeather;

    Button btnWeeklyWeather;

    JSONObject locationWeather = null;
    WeatherItemAsyncTask weatherItemAsyncTask = null;
    HashMap<String,String> location=null;
    String weatherCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTemp = (TextView)findViewById(R.id.txtTemp);
        txtTodayWeather = (TextView)findViewById(R.id.txtTodayWeather);
        imgWeather = (ImageView)findViewById(R.id.imgWeather);

        btnWeeklyWeather = (Button)findViewById(R.id.btnWeeklyWeather);

        location=new HashMap<String,String>();
        puts();
        connectCheck(location);

        btnWeeklyWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //이번주 날씨 보기
            }
        });
    }

    public void setLocationWeather(JSONObject locationWeather){
        this.locationWeather=locationWeather;

        try {
            txtTemp.setText(locationWeather.getString("tc")+"ºC");
            txtTodayWeather.setText(getDate()+" "+locationWeather.getString("name"));
            weatherCode = locationWeather.getString("code");
            changeIcon();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void connectCheck(HashMap<String,String> location){
        ConnectivityManager connectivityManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();

        if((networkInfo!=null)&&networkInfo.isConnected()){
            weatherItemAsyncTask=new WeatherItemAsyncTask(location,this);
            weatherItemAsyncTask.execute("");
        }else {
            Toast.makeText(getBaseContext(), "인터넷 연결상태를 확인해주세요", Toast.LENGTH_LONG).show();
        }
    }

    public void puts(){
        location.put("appKey","0000-00000000000-00000");    //인증키 및 다른 위치정보 등
    }

    public void changeIcon(){
        switch (weatherCode){
            case "SKY_A01":
                imgWeather.setImageResource(R.drawable.icon_white_sun);
                break;
            case "SKY_A02":
            case "SKY_A03":
            case "SKY_A07":
                imgWeather.setImageResource(R.drawable.icon_white_cloud);
                break;
            case "SKY_A04":
            case "SKY_A08":
                imgWeather.setImageResource(R.drawable.icon_white_rain);
                break;
            case "SKY_A05":
            case "SKY_A09":
                imgWeather.setImageResource(R.drawable.icon_white_snow2);
                break;
            case "SKY_A06":
            case "SKY_A10":
                //구름많고 비 또는 눈에 해당되는 아이콘 X
                //흐리고 비 또는 눈 X
                break;
            case "SKY_A11":
                imgWeather.setImageResource(R.drawable.icon_white_spark);
                break;
            case "SKY_A12":
                //뇌우/비 x
                break;
            case "SKY_A13":
                //뇌우/눈 x
                break;
            case "SKY_A14":
                //뇌우/비 또는 눈 x
                break;
        }
    }

    public static String getDate(){

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM.dd(aaa)", java.util.Locale.getDefault());

        Date date = new Date();

        String strDate = dateFormat.format(date);

        return strDate;

    }


}
