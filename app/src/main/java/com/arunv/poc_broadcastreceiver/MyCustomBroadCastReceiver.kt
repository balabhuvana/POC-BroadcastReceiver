package com.arunv.poc_broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyCustomBroadCastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.i("-----> ", "MyCustomBroadCastReceiver -> onReceive()")
    }
}
