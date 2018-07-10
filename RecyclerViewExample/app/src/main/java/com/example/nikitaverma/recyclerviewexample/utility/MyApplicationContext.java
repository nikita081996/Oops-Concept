package com.example.nikitaverma.recyclerviewexample.utility;

import android.app.Application;
import android.content.Context;

public class MyApplicationContext extends Application{

    public Context getMyApplicationContext(){
        return getApplicationContext();
    }
}
