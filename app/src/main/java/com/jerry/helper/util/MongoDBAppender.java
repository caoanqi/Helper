package com.jerry.helper.util;

import android.util.Log;

import com.mongodb.BasicDBObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * @author : 曹幼林
 * @date : 2019/2/19
 */
public class MongoDBAppender extends BaseMongoDBAppender<ILoggingEvent> {

    public MongoDBAppender() {
        super("logback");
    }

    @Override
    protected BasicDBObject toMongoDocument(ILoggingEvent eventObject) {
        Log.e(this.getClass().getSimpleName(),"come");
        final BasicDBObject doc = new BasicDBObject();
        doc.append("date", new SimpleDateFormat("YYYY-MM-DD hh:mm:ss").format(new Date()));
        doc.append("source", "hello");
        doc.append("level", eventObject.getLevel().toString());
        doc.append("logger", eventObject.getLoggerName());
        doc.append("thread", eventObject.getThreadName());
        doc.append("message", eventObject.getFormattedMessage());
        if (eventObject.getMdc() != null && !eventObject.getMdc().isEmpty())
            doc.append("mdc", eventObject.getMdc());

        return doc;
    }

}
