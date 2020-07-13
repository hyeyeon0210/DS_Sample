package org.techtown.sample_customlistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.jar.Attributes;

public class ItemView extends LinearLayout {

    TextView nameView;
    TextView extra01;
    TextView extra02;

    public ItemView(Context context){
        super(context);
        init(context);
    }
    public ItemView(Context context, AttributeSet attrs){
        super(context,attrs);
        init(context);
    }

    public void init(Context context){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.activity_item,this,true);

        nameView = (TextView) findViewById(R.id.nameView);
        extra01 = (TextView) findViewById(R.id.extra01);
        extra02 = (TextView) findViewById(R.id.extra02);
    }

    public void setNameView(String name){
        nameView.setText(name);
    }

    public void  setExtra01(String extra){
        extra01.setText(extra);
    }

    public void setExtra02(String extra){
        extra02.setText(extra);
    }

}
