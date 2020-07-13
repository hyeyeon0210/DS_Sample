package org.techtown.sample_weatherapi;

import android.app.Activity;
import android.app.SearchManager;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class WeatherItemAsyncTask extends AsyncTask<String,Integer,String> {

    Manager manager = null;
    String context=null;
    int jsonCount=0;
    MainActivity mainActivity = null;

    public WeatherItemAsyncTask(HashMap<String,String> location, MainActivity mainActivity){
        manager=new Manager(location);
        this.mainActivity = mainActivity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }



    @Override
    protected String doInBackground(String... strings) {
        context=manager.connect();
        Log.i("json 결과",""+context);
        return context;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        JSONArray jsonArray=null;
        try {
            JSONObject total=new JSONObject(s);
            Log.i("결과체크",""+total);
            System.out.print(total);
            JSONObject jsonObject=new JSONObject(String.valueOf(total.get("tc")));
            Log.i("결과체크",""+jsonObject);

            mainActivity.setLocationWeather(jsonObject);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
