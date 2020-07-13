package com.example.seoulalarm;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentWeather extends Fragment {
    ImageView btnRefresh, btnPlusCity;
    RecyclerView horizontalDaily, horizontalWeekly;
    DailyAdapter dailyAdapter;
    WeeklyAdapter weeklyAdapter;
    LinearLayoutManager dManager, wManager;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_weather, container, false);

        InitView();


        return view;
    }

    private void InitView() {
        btnRefresh = (ImageView)view.findViewById(R.id.btnRefresh);
        btnPlusCity = (ImageView)view.findViewById(R.id.btnPlusCity);

        btnRefresh.setOnClickListener(imgViewHandler);
        btnPlusCity.setOnClickListener(imgViewHandler);

        horizontalDaily = (RecyclerView)view.findViewById(R.id.horizontalViewDaily);
        horizontalWeekly = (RecyclerView)view.findViewById(R.id.horizontalViewWeekly);

        dManager = new LinearLayoutManager(getContext());
        horizontalDaily.addItemDecoration(new DividerItemDecoration(getContext(), dManager.getOrientation()));
        horizontalDaily.setLayoutManager(dManager);
        ArrayList<WeatherDailyItem> dailyItems = new ArrayList<WeatherDailyItem>();
        //ArrayList에 담을 API 가공 처리 코드 넣기
        dailyAdapter = new DailyAdapter(getActivity(), dailyItems);


    }
    ImageView.OnClickListener imgViewHandler = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.btnRefresh:
                    break;
                case R.id.btnPlusCity:

                    break;
            }
        }
    };
}
