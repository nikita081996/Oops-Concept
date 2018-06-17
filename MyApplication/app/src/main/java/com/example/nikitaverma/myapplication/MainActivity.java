package com.example.nikitaverma.Fragment to Fragment Communication;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Fragment1.OnMessageReadListener,KeyConstants{
    Fragment1 mFragment1;
    Fragment2 mFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragment1)!=null){
            if(savedInstanceState!=null){
                return;
            }
        }

        mFragment1 = new Fragment1();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment,mFragment1);
        ft.commit();

    }

    @Override
    public void onMessageReadListener(String message) {
        mFragment2 = new Fragment2();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_MESSAGE,message);

        mFragment2.setArguments(bundle);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment,mFragment2);
        ft.commit();
        Toast.makeText(getApplicationContext(),message+"",Toast.LENGTH_LONG).show();
    }

    /*public void changeFragment(View view){
        Fragment fragment;
        if (view == findViewById(R.id.button5)) {
            fragment = new Fragment1();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment,fragment);
            ft.commit();

        }
        else{
            fragment = new Fragment2();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment,fragment);
            ft.commit();
        }
    }*/
}
