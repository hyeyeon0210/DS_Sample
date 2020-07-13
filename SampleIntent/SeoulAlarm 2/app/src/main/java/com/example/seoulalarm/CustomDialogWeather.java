package com.example.seoulalarm;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CustomDialogWeather extends Dialog implements View.OnClickListener{
    Context context;
    EditText edtArea;
    ImageView btnCancel;
    TextView txtArea;

    public CustomDialogWeather(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_dialog_layout);

        edtArea = findViewById(R.id.edtArea);
        btnCancel = findViewById(R.id.btnCancel);
        txtArea = findViewById(R.id.txtArea);

        btnCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnCancel:
                cancel();
                break;
        }
    }
}
