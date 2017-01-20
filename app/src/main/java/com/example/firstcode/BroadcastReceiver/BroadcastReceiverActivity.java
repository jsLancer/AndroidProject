package com.example.firstcode.BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.firstcode.R;

public class BroadcastReceiverActivity extends AppCompatActivity {

    private IntentFilter intentFilter;

    private NetworkChangeReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver);

        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");

        receiver = new NetworkChangeReceiver();
        //进行注册
        registerReceiver(receiver, intentFilter);

    }


    class NetworkChangeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "network changes", Toast.LENGTH_SHORT).show();

            //获得系统服务类实例
            //用于管理网络连接
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            //获得 NetworkInfo 实例
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            //根据 isAvailable 判断网络是否可用
            if (networkInfo != null && networkInfo.isAvailable()) {
                Toast.makeText(context, "network is available", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(context, "network is unavailable", Toast.LENGTH_LONG).show();
            }

        }
    }


}
