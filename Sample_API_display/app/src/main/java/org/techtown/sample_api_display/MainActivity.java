package org.techtown.sample_api_display;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Button btnSearch;
    EditText txtSearch;
    HashMap<String,String> location=null;

    JSONObject myLocation=null;
    SearchAsyncTask searchAsyncTask=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSearch = (EditText) findViewById(R.id.txtSearch);
        btnSearch = (Button) findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchAsyncTask = new SearchAsyncTask();
                //task 실행
            }
        });
    }

    public void connectCheck(HashMap<String,String> location){
        ConnectivityManager connectivityManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();

        if((networkInfo!=null)&&networkInfo.isConnected()){
            searchAsyncTask=new SearchAsyncTask(location,this);
            searchAsyncTask.execute("");
        }else {
            Toast.makeText(getBaseContext(), "인터넷 연결상태를 확인해주세요", Toast.LENGTH_LONG).show();
        }
    }

}
