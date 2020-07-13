package org.techtown.sample_fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private boolean isFragmentB =true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.fragmentBorC,new FragmentB());
        fragmentTransaction.commit();

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                switchFragment();
            }
        });
    }

    public void switchFragment(){
        Fragment fr;

        if(isFragmentB){
            fr = new FragmentB();
        }
        else {
            fr = new FragmentC();
        }

        isFragmentB = (isFragmentB)?false:true;

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentBorC, fr);
        fragmentTransaction.commit();
    }
}
