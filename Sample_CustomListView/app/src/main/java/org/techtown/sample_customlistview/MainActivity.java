package org.techtown.sample_customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    ListView listView;
    SingerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        listView = (ListView)findViewById(R.id.listView);
        adapter = new SingerAdapter();

        adapter.addItem(new Item("리스트01","부가설명01","부가설명02"));
        adapter.addItem(new Item("리스트02","부가설명01","부가설명02"));
        adapter.addItem(new Item("리스트03","부가설명01","부가설명02"));
        adapter.addItem(new Item("리스트04","부가설명01","부가설명02"));
        adapter.addItem(new Item("리스트05","부가설명01","부가설명02"));

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Item item = (Item) adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"선택 : "+item.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void onButtonClicked(View v){
        String newItem = editText.getText().toString();

        Item item = new Item(newItem);
        adapter.addItem(item);
    }

    class SingerAdapter extends BaseAdapter{
        ArrayList<Item> items = new ArrayList<Item>();

        @Override
        public int getCount(){
            return items.size();
        }

        public void addItem(Item item){
            items.add(item);
        }

        @Override
        public Object getItem(int position){
            return items.get(position);
        }

        @Override
        public long getItemId(int position){
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup){
            ItemView view = new ItemView(getApplicationContext());
            Item item = items.get(position);
            view.setNameView(item.name);
            view.setExtra01(item.extra01);
            view.setExtra02(item.extra02);

            return view;
        }
    }

}

