package com.example.nikitaverma.customlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.nikitaverma.customlistview.DataManager.UserData;
import com.example.nikitaverma.customlistview.Constants.Constants;
import com.example.nikitaverma.customlistview.Model.Item;

public class AddUser extends AppCompatActivity implements Constants{
    EditText mName, mAddress, mMobile;
    Button mAddUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);


        mName = (EditText) findViewById(R.id.name);
        mAddress = (EditText) findViewById(R.id.address);
        mMobile = (EditText) findViewById(R.id.mobile);
        mAddUser = (Button) findViewById(R.id.adduser);

        mAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mName.getText().toString();
                String address = mAddress.getText().toString();
                String  mobile = mMobile.getText().toString();
                Log.d("message",name+" "+address+" "+mobile);

                Item item = new Item(name,address,Long.parseLong(mobile));
              //  Log.d("Item", item.getmName()+" "+item.getmAddress()+" "+item.getmMobile());
                UserData.getInstance().arrayList.add(item);
                Intent i = new Intent(getApplicationContext(), ItemListView.class);
                startActivity(i);
            }
        });

    }
}
