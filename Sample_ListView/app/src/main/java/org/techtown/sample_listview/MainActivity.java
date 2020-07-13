package org.techtown.sample_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] listMenu = {"리스트01","리스트02","리스트03","리스트04"};

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listMenu);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
