package com.jerry.helper;

import android.app.Application;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;
import com.jerry.helper.util.XFTtsUtils;

/**
 * @author : 曹幼林
 * @date : 2019/2/12
 */
public class MyApplication extends Application {

    public static MyApplication INSTANCE;

    public static MyApplication getInstance() {
        if (INSTANCE == null) {
            synchronized (XFTtsUtils.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MyApplication();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // 应用程序入口处调用,避免手机内存过小,杀死后台进程后通过历史intent进入Activity造成SpeechUtility对象为null
        // 注意：此接口在非主进程调用会返回null对象，如需在非主进程使用语音功能，请增加参数：SpeechConstant.FORCE_LOGIN+"=true"
        // 参数间使用“,”分隔。
        // 设置你申请的应用appid

        // 注意： appid 必须和下载的SDK保持一致，否则会出现10407错误

        StringBuffer param = new StringBuffer();
        param.append("appid=5c629998");
        param.append(",");
        // 设置使用v5+
        param.append(SpeechConstant.ENGINE_MODE + "=" + SpeechConstant.MODE_MSC);
        SpeechUtility.createUtility(this, param.toString());
        INSTANCE = this;
    }


}
