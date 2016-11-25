package com.example.m107025201.lab8;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by m107025201 on 2016/11/25.
 */

public class MyService extends Service{
    public void onCreate(){
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(5000);

                    Intent intent=new Intent(MyService.this,MainActivity2.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    MyService.this.startActivity(intent);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
    @Override
    public IBinder onBind(Intent intent){return null;}
    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        super.onStartCommand(intent,flags,startId);
        return START_STICKY;
    }
}
