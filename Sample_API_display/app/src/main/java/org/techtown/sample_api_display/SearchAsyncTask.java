package org.techtown.sample_api_display;

import android.app.SearchManager;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class SearchAsyncTask extends AsyncTask<String,Integer,String>{

    SearchManager searchManager=null;
    String myLocation=null;
    int jsonCount=0;
    MainActivity mainActivity =null;

    public SearchAsyncTask(HashMap<String,String> location, MainActivity selectHotelsActivity){
        searchManager=new SearchManager(location);
        this.mainActivity=selectHotelsActivity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }



    @Override
    protected String doInBackground(String... strings) {
        myLocation=searchManager.connect();
        Log.i("json 결과",""+myLocation);
        return myLocation;
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
            JSONObject jsonObject=new JSONObject(String.valueOf(total.get("addressInfo")));
            Log.i("결과체크",""+jsonObject);

            mainActivity.setLocation(jsonObject);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
