package com.example.nikitaverma.customlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button mAddUser, mShowUser, mDeleteUser;
    ItemListView mItemListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mItemListView = new ItemListView();
        mAddUser = (Button) findViewById(R.id.add);
        mShowUser = (Button) findViewById(R.id.show);
        mDeleteUser = (Button) findViewById(R.id.delete);

        mAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AddUser.class);
                startActivity(i);
            }
        });

        mShowUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ItemListView.class);
                startActivity(i);
            }
        });

        mDeleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Long press to delete Item",Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), ItemListView.class);
                startActivity(i);
            }
        });
    }
}
