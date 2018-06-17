package com.example.nikitaverma.pass_data_between_two_activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DataFromActivity extends AppCompatActivity implements KeyConstants{
    EditText mName;
    EditText mAddress;
    EditText mEmail;
    Button mSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_from);

        mName = (EditText) findViewById(R.id.edit_name);
        mAddress = (EditText) findViewById(R.id.edit_address);
        mEmail = (EditText) findViewById(R.id.edit_email);
        mSend = (Button) findViewById(R.id.send);

        Intent i= getIntent();

        mSend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), DataToActivity.class);
                i.putExtra(KEY_NAME , mName.getText().toString());
                i.putExtra(KEY_ADDRESS , mAddress.getText().toString());
                i.putExtra(KEY_EMAIL , mEmail.getText().toString());
                startActivity(i);
            }
        });

    }
}
