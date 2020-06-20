package com.arunv.poc_broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_my_receiver.*
import java.util.jar.Manifest


class MyReceiverActivity : AppCompatActivity() {

    private var myCustomBroadCastReceiver: MyCustomBroadCastReceiver? = null
    private var intentFilter: IntentFilter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_receiver)

        myCustomBroadcastReceiver()

        btnSendBroadcast.setOnClickListener {
            someCustomBroadcastActionMethod()
        }
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(
            myCustomBroadCastReceiver,
            intentFilter
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(this.myCustomBroadCastReceiver)
    }

    private fun myCustomBroadcastReceiver() {
        myCustomBroadCastReceiver = MyCustomBroadCastReceiver()
        intentFilter = IntentFilter("com.arunv.poc_broadcastreceiver.SOME_ACTION")
    }

    private fun someCustomBroadcastActionMethod() {
        val intent = Intent("com.arunv.poc_broadcastreceiver.SOME_ACTION")
        sendBroadcast(intent)
    }
}
