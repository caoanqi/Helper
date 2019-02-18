package com.jerry.helper.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jerry.helper.R;
import com.jerry.helper.view.CustomViewActivity;
import com.jerry.helper.view.voice.AndroidSelfPlayVoiceActivity;
import com.jerry.helper.view.voice.SynthActivity;
import com.jerry.helper.view.voice.XunFeiPlayVoiceActivity;

import java.util.List;

/**
 * @author : 曹幼林
 * @date : 2019/2/18
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    List<String> datas;
    Context context;

    public MainAdapter(Context context, List<String> datas) {
        this.datas = datas;
        this.context = context;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_main, viewGroup, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder mainViewHolder, int i) {
        mainViewHolder.initData(i);
        mainViewHolder.itemView.setOnClickListener(v -> {
            goActivity(i);
        });
    }


    @Override
    public int getItemCount() {
        return datas.size();
    }

    private void goActivity(int i) {
        switch (i) {
            case 0:
                context.startActivity(new Intent().setClass(context, AndroidSelfPlayVoiceActivity.class));
                break;
            case 1:
                context.startActivity(new Intent().setClass(context, SynthActivity.class));
                break;
            case 2:
                context.startActivity(new Intent().setClass(context, XunFeiPlayVoiceActivity.class));
                break;
            case 3:
                context.startActivity(new Intent().setClass(context, CustomViewActivity.class));
                break;
            default:
                break;
        }
    }


    class MainViewHolder extends RecyclerView.ViewHolder {
        TextView tvFuncName;

        MainViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFuncName = itemView.findViewById(R.id.tv_item_name);
        }

        void initData(int index) {
            tvFuncName.setText(datas.get(index));
        }
    }

}
