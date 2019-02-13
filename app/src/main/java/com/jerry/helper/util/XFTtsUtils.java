package com.jerry.helper.util;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SynthesizerListener;
import com.jerry.helper.MyApplication;

/**
 * @author : 曹幼林
 * @date : 2019/2/13
 */
public class XFTtsUtils implements InitListener, SynthesizerListener {

    private static volatile XFTtsUtils instance = null;
    private boolean isInitSuccess = false;
    private SpeechSynthesizer mTts;

    //单例模式
    public static XFTtsUtils getInstance() {
        if (instance == null) {
            synchronized (XFTtsUtils.class) {
                if (instance == null) {
                    instance = new XFTtsUtils();
                }
            }
        }
        return instance;
    }

    public XFTtsUtils() {

    }

    // 初始化合成对象
    public void init() {
        //判断进程是否已启动，初始化多次会报错
        //个人遇到问题：极光推送引入后，不加该条件回报错

            mTts = SpeechSynthesizer.createSynthesizer(MyApplication.getInstance().getApplicationContext(), this);
            // 清空参数
            mTts.setParameter(SpeechConstant.PARAMS, null);
            // 设置在线云端
            mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_CLOUD);

            // 设置发音人--发音人选择--具体见values-string
            mTts.setParameter(SpeechConstant.VOICE_NAME, "xiaoqi");

            // 设置发音语速
            mTts.setParameter(SpeechConstant.SPEED, "50");
            // 设置音调
            mTts.setParameter(SpeechConstant.PITCH, "50");
            // 设置合成音量
            mTts.setParameter(SpeechConstant.VOLUME, "100");
            // 设置播放器音频流类型
            mTts.setParameter(SpeechConstant.STREAM_TYPE, "3");
            // 设置播放合成音频打断音乐播放，默认为true
            mTts.setParameter(SpeechConstant.KEY_REQUEST_FOCUS, "true");
            // 设置音频保存路径，需要申请WRITE_EXTERNAL_STORAGE权限，如不需保存注释该行代码
//        mTts.setParameter(SpeechConstant.TTS_AUDIO_PATH,"./sdcard/iflytek.pcm");
            Log.i("zhh", "--初始化成完成-");


    }

    //开始合成
    public void speak(String msg) {
        if (isInitSuccess) {
            if (mTts.isSpeaking()) {
                mTts.stopSpeaking();
            }
            mTts.startSpeaking(msg, this);
        } else {
            init();
        }
    }


    @Override
    public void onInit(int i) {

    }

    @Override
    public void onSpeakBegin() {

    }

    @Override
    public void onBufferProgress(int i, int i1, int i2, String s) {

    }

    @Override
    public void onSpeakPaused() {

    }

    @Override
    public void onSpeakResumed() {

    }

    @Override
    public void onSpeakProgress(int i, int i1, int i2) {

    }

    @Override
    public void onCompleted(SpeechError speechError) {

    }

    @Override
    public void onEvent(int i, int i1, int i2, Bundle bundle) {

    }
}