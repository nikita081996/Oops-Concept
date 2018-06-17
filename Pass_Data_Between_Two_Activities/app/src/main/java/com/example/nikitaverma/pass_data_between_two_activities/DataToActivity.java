package com.example.nikitaverma.pass_data_between_two_activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DataToActivity extends AppCompatActivity implements KeyConstants{
    TextView mName;
    TextView mAddress;
    TextView mEmail;
    Button mSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_to);
        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //  setSupportActionBar(toolbar);

        mName = (TextView) findViewById(R.id.edit_name);
        mAddress = (TextView) findViewById(R.id.edit_address);
        mEmail = (TextView) findViewById(R.id.edit_email);
        mSend = (Button) findViewById(R.id.send);


        Intent i = getIntent();
        String name = i.getStringExtra(KEY_NAME);
        String address = i.getStringExtra(KEY_ADDRESS);
        String  email = i.getStringExtra(KEY_EMAIL);
        Log.d("Message",name+ " "+ address +" "+ email);
        Toast.makeText(getApplicationContext(),name+ " "+ address +" "+ email,Toast.LENGTH_LONG).show();
        mName.setText(name);
        mAddress.setText(address);
        mEmail.setText(email);
/*
        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), DataFromActivity.class);
                startActivity(i);
            }
        });*/
    }

}
