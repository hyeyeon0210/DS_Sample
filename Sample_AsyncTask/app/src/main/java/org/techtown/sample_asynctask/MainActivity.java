package org.techtown.sample_asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    BackgroundTask task;
    int value;
    ProgressBar progressBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button executeButton = (Button) findViewById(R.id.executeButton);
        Button cancelButton = (Button) findViewById(R.id.cancelButton);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        textView = (TextView) findViewById(R.id.textView);

        executeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task = new BackgroundTask();
                task.execute(100);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task.cancel(true);
            }
        });
    }

    class BackgroundTask extends AsyncTask<Integer , Integer , Integer>{

        @Override
        protected void onPreExecute() {
            value = 0;
            progressBar.setProgress(value);
        }

        @Override
        protected Integer doInBackground(Integer... values) {
            while(isCancelled()==false){
                value++;
                if(value>=100){
                    break;
                }else {
                    publishProgress(value);
                }

                //try문에 들어간게 시간을 늦춰줌
                try{
                    Thread.sleep(100);
                }catch (InterruptedException ex){}
            }
            return value;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBar.setProgress(values[0].intValue());
            textView.setText("Current Value : "+values[0].toString());
        }


        @Override
        protected void onPostExecute(Integer integer) {
            progressBar.setProgress(0);
            textView.setText("Finished.");
        }

        @Override
        protected void onCancelled() {
            progressBar.setProgress(0);
            textView.setText("Cancelled.");
        }
    }
}


