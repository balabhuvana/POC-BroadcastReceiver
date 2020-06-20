package com.arunv.poc_broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var myAirplaneModeBroadcastReceiver: MyAirplaneModeBroadcastReceiver
    private lateinit var filter: IntentFilter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myAirplaneBroadcastReceiver()

        btnStartReceiver.setOnClickListener {
            startActivity(Intent(this, MyReceiverActivity::class.java))
        }

    }

    private fun myAirplaneBroadcastReceiver() {
        myAirplaneModeBroadcastReceiver = MyAirplaneModeBroadcastReceiver()
        filter = IntentFilter()
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
    }

    override fun onStart() {
        registerReceiver(myAirplaneModeBroadcastReceiver, filter)
        super.onStart()
    }

    override fun onDestroy() {
        unregisterReceiver(myAirplaneModeBroadcastReceiver)
        super.onDestroy()
    }
}
