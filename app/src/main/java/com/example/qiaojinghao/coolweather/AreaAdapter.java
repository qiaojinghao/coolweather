package com.example.qiaojinghao.coolweather;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AreaAdapter extends RecyclerView.Adapter {

    List<String> dataList;

    LayoutInflater inflater;

    private OnMyItemClickListener listener;

    public interface OnMyItemClickListener{
        void onClick(View v, int pos);
    }

    public void setOnMyClickListener(OnMyItemClickListener listener){
        this.listener = listener;
    }

    class AreaViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.area_name) TextView areaName;

        public AreaViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public AreaAdapter(Context context, List<String> dataList){
        this.dataList = dataList;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.area_item,viewGroup,false);
        return new AreaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        AreaViewHolder areaViewHolder =(AreaViewHolder) viewHolder;
        areaViewHolder.areaName.setText(dataList.get(i));
        if(listener != null){
            areaViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(v, i);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
