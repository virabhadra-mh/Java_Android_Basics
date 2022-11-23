package com.example.androidjavabasics.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;

import androidx.annotation.Nullable;

public class IntentServiceCustom extends IntentService {

    public static final int STATUS_RUNNING = 0;
    public static final int STATUS_FINISHED = 1;
    public static final int STATUS_ERROR = 2;

    /**
     * @param name
     * @deprecated
     */
    public IntentServiceCustom(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        /*
         * Step 1: We pass the ResultReceiver from the activity to the intent service via intent.
         *  */
        final ResultReceiver receiver = intent.getParcelableExtra("receiver");


        //TODO: process background task here!

        /*
         * Step 2: Now background service is processed,
         * we can pass the status of the service back to the activity using the resultReceiver
         *  */
        Bundle b = new Bundle();
        receiver.send(STATUS_FINISHED, b);
    }
}
