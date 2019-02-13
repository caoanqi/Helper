package com.jerry.helper;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jerry.helper.databinding.ActivityMainBinding;
import com.jerry.helper.voice.AndroidSelfPlayVoiceActivity;
import com.jerry.helper.voice.BaiDuPlayVoiceActivity;
import com.jerry.helper.voice.SynthActivity;
import com.jerry.helper.voice.XunFeiPlayVoiceActivity;

/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initListener();
    }

    private void initListener() {
        activityMainBinding.btAndroidSelfPlayVoice.setOnClickListener(v -> {
            startActivity(new Intent().setClass(this, AndroidSelfPlayVoiceActivity.class));
        });

        activityMainBinding.btBaiduPlayVoice.setOnClickListener(v ->
                startActivity(new Intent().setClass(this, SynthActivity.class)));

        activityMainBinding.btXunfeiPlayVoice.setOnClickListener(v ->
                startActivity(new Intent().setClass(this, XunFeiPlayVoiceActivity.class)));
    }
}
