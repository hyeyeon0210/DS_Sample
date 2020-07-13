package org.techtown.sample_weatherapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class Manager {

    URL url=null;
    HttpURLConnection httpURLConnection=null;
    BufferedReader bufferedReader=null;
    HashMap<String,String> myAddress=null;
    String params="";
    String data="";
    HashMap<String,String> myLocationWeather=null;
    //static final String MY_ADDRESS_URL="https://apis.sktelecom.com/v1/weather/status?"; //weather api
    static final String MY_ADDRESS_URL="https://api2.sktelecom.com/weather/current/minutely?version=1&";      //weather planet api

    public Manager(HashMap<String,String> myLocationWeather){
        this.myLocationWeather=myLocationWeather;

        //double lat=Double.parseDouble(myLocationWeather.get("latitude").toString());
        //double lon=Double.parseDouble(myLocationWeather.get("longitude").toString());
        double lat=Double.parseDouble(myLocationWeather.get("lat").toString());
        double lon=Double.parseDouble(myLocationWeather.get("lon").toString());
        String city=myLocationWeather.get("city").toString();
        String country=myLocationWeather.get("country").toString();
        String village=myLocationWeather.get("village").toString();
        String stnid=myLocationWeather.get("stnid").toString();
        String appKey=myLocationWeather.get("appKey").toString();

        //params="latitude="+lat+"&longitude="+lon+"&appKey="+appKey;
        params="lat="+lat+"&lon="+lon+"&city"+city+"&country"+country+"&village"+village+"&stnid"+stnid+"&appKey="+appKey;

        try {
            url=new URL(MY_ADDRESS_URL+params);
            httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public String connect(){
        String line="";

        try {
            httpURLConnection.connect();

            InputStream inputStream=httpURLConnection.getInputStream(); //데이터받기
            bufferedReader=new BufferedReader(new InputStreamReader(inputStream));

            while((line=bufferedReader.readLine())!=null){
                data+=line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }
}
