package com.example.qiaojinghao.coolweather;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.qiaojinghao.coolweather.db.City;
import com.example.qiaojinghao.coolweather.db.County;
import com.example.qiaojinghao.coolweather.db.Province;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChooseAreaFragment extends Fragment {
    public static final int LEVEL_PROVINCE = 0;

    public static final int LEVEL_CITY = 1;

    public static final int LEVEL_COUNTY = 2;

    private ProgressDialog progressDialog;

    @BindView(R.id.title_text) TextView titleText;

    @BindView(R.id.back_btn) Button backButton;

    @BindView(R.id.recycler_view) RecyclerView recyclerView;

    private List<String> dataList = new ArrayList<>();

    /**
     * 省列表
     * **/
    private List<Province> provinceList = new ArrayList<>();

    /**
     * 市列表
     * **/
    private List<City> cityList = new ArrayList<>();

    /**
     * 县列表
     * **/
    private List<County> countyList = new ArrayList<>();

    /**
     * 选中的省
     * **/
    private Province selectedProvince;

    /**
     * 选中的城市
     * **/
    private City selectedCity;

    /**
     * 当前选中的级别
     * **/
    private int currentLevel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.choose_area, container, false);
        ButterKnife.bind(this,view);
        recyclerView.setAdapter(new AreaAdapter(getContext(),dataList));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentLevel == LEVEL_COUNTY){

                }else if(currentLevel == LEVEL_CITY){

                }
            }
        });
        queryProvinces();
    }

    private void queryProvinces(){
        
    }

    private void queryCities(){

    }

    private void queryCounties(){

    }
}
