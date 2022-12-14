package com.example.androidjavabasics.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.androidjavabasics.R;

public class ActivityIntentService extends AppCompatActivity implements ResultReceiverCustom.ReceiverInterface {

    private ResultReceiverCustom resultReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        try {
            registerService();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
     * Step 1: Register the intent service in the activity
     * */
    private void registerService() {
        Intent intent = new Intent(getApplicationContext(), IntentServiceCustom.class);

        /*
         * Step 2: We pass the ResultReceiver via the intent to the intent service
         * */
        resultReceiver = new ResultReceiverCustom(new Handler(), ActivityIntentService.this);
        intent.putExtra("receiver", resultReceiver);
        startService(intent);
    }


    @Override
    public void onMyData(int resultCode, Bundle resultData) {
        /*
         * Step 3: Handle the results from the intent service here!
         * */

       String  myName=resultData.getString("myName");
       String  myName33=resultData.getString("myName");

        Log.d("RRRRRREEESS-> ",""+myName);
    }

}