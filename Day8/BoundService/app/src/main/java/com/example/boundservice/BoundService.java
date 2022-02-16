package com.example.boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Date;

public class BoundService extends Service {
    MyBinder binder;
    public BoundService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        binder=new MyBinder();
        return binder;
    }
    public String getCurrentTime(){
        Date date=new Date();
        return  date.toString();
    }
    class MyBinder extends Binder {
        public BoundService getService(){
            return BoundService.this;
        }
    }
}