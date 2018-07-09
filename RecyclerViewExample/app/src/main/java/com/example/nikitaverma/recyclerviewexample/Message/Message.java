package com.example.nikitaverma.recyclerviewexample.Message;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Message class for Toast
 */
public class Message {

    public static void m(String message){
        Log.d("Message",message);
    }

    public static void s(Context context, String message){
        Toast.makeText(context, message,Toast.LENGTH_LONG).show();
    }
}