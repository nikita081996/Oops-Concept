package com.example.nikitaverma.fragment_to_activity_communication;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Message_fragment.OnMessageReadListener{
    TextView mTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragment)!=null){
            if(savedInstanceState!=null){
                return;
            }
        }
        Message_fragment fragment = new Message_fragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment,fragment);
        ft.commit();
    }

    @Override
    public void onMessageReadListener(String message) {
        mTxt = (TextView)findViewById(R.id.text);
        mTxt.setText(message);
    }
}
