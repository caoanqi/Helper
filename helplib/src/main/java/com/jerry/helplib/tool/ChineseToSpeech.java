package com.jerry.helplib.tool;

import android.app.Application;
import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;

import java.util.Locale;

/**
 * @author : 曹幼林
 * @date : 2019/2/12
 */
public class ChineseToSpeech {
    private TextToSpeech textToSpeech;

    public ChineseToSpeech(final Context context) {
        this.textToSpeech = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = textToSpeech.setLanguage(Locale.CHINA);
                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Toast.makeText(context, "不支持朗读功能", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    public void speech(String text) {
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    public void destroy() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }

}
