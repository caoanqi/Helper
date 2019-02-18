package com.jerry.helper.view.voice;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jerry.helper.R;

import java.util.Locale;

/**
 * android 原声播报 不行
 * @author Administrator
 */
public class AndroidSelfPlayVoiceActivity extends AppCompatActivity {

    EditText playVoiceContent;
    Button btPlayVoice;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_self_play_voice);

        playVoiceContent = findViewById(R.id.et_play_content);
        btPlayVoice = findViewById(R.id.bt_voice_play);

        initListener();
        initTTS();
    }

    void initListener() {
        btPlayVoice.setOnClickListener(v -> {
            startAuto(playVoiceContent.getText().toString());
        });
    }

    private void initTTS() {
        //实例化自带语音对象
        textToSpeech = new TextToSpeech(this, status -> {
            if (status == textToSpeech.SUCCESS) {
                textToSpeech.setPitch(1.0f);//方法用来控制音调
                textToSpeech.setSpeechRate(1.0f);//用来控制语速

                //判断是否支持下面两种语言
                int result1 = textToSpeech.setLanguage(Locale.US);
                int result2 = textToSpeech.setLanguage(Locale.SIMPLIFIED_CHINESE);
                boolean a = (result1 == TextToSpeech.LANG_MISSING_DATA || result1 == TextToSpeech.LANG_NOT_SUPPORTED);
                boolean b = (result2 == TextToSpeech.LANG_MISSING_DATA || result2 == TextToSpeech.LANG_NOT_SUPPORTED);

                Log.i("zhh_tts", "US支持否？--》" + a + "\nzh-CN支持否》--》" + b);

            } else {
                Toast.makeText(AndroidSelfPlayVoiceActivity.this, "数据丢失或不支持", Toast.LENGTH_SHORT).show();
            }

        });
    }

    private void startAuto(String data) {
        // 设置音调，值越大声音越尖（女生），值越小则变成男声,1.0是常规
        textToSpeech.setPitch(1.0f);
        // 设置语速
        textToSpeech.setSpeechRate(0.3f);
        //输入中文，若不支持的设备则不会读出来
        textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);

    }

    @Override
    protected void onStop() {
        super.onStop();
        textToSpeech.stop(); // 不管是否正在朗读TTS都被打断
        textToSpeech.shutdown(); // 关闭，释放资源
    }

}
