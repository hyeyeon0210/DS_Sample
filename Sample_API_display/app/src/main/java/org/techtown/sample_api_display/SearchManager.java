package org.techtown.sample_api_display;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class SearchManager {

    URL url=null;
    HttpURLConnection httpURLConnection=null;
    BufferedReader bufferedReader=null;
    HashMap<String,String> myAddress=null;
    String params="";   //주소 뒷부분
    String data="";
    HashMap<String,String> searchItem=null;
    static final String MY_ADDRESS_URL="https://apis.sktelecom.com/v1/weather/status?";

    public SearchManager(HashMap<String,String> searchItem){
        this.searchItem=searchItem;

        double lat=Double.parseDouble(searchItem.get("lat").toString());
        double lon=Double.parseDouble(searchItem.get("lon").toString());
        String appKey=searchItem.get("appKey").toString();

        params="latitude="+lat+"&longitude="+lon+"&appKey="+appKey;

        try {
            url=new URL(MY_ADDRESS_URL+params);
            httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");    //헤더타입. 연결하는 곳과 타입이 맞아야함... //?


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
