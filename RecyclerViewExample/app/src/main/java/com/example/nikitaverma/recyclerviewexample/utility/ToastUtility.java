package com.example.nikitaverma.recyclerviewexample.utility;

import android.content.Context;
import android.widget.Toast;

public class ToastUtility {
    static MyApplicationContext myApplicationContext = new MyApplicationContext();

    public static void showToast(Context context,String message){
        Toast.makeText(context, message,Toast.LENGTH_LONG).show();
    }
}
