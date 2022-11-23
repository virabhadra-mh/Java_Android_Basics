package com.example.androidjavabasics.service;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

public class ResultReceiverCustom extends ResultReceiver {

    private ReceiverInterface appReceiver;

    public ResultReceiverCustom(Handler handler, ReceiverInterface receiver ) {
        super(handler);
        appReceiver = receiver;
    }

    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        if (appReceiver != null) {
            /*
             * Step 2: We pass the resulting data from the service to the activity
             * using the Receiver interface
             */
            appReceiver.onMyData(resultCode, resultData);
        }
    }

    public interface ReceiverInterface {
         void onMyData(int resultCode, Bundle resultData);
    }
}
