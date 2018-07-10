package com.example.nikitaverma.recyclerviewexample.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.nikitaverma.recyclerviewexample.R;

/**
 * StartActivity
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mPostBtn;
    private Button mGetBtn;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

    }

    /**
     * intilalizaion of all views
     */
    private void initialize() {
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mGetBtn = findViewById(R.id.get);
        mPostBtn = findViewById(R.id.post);

        mGetBtn.setOnClickListener(this);
        mPostBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.get:
                Intent intent1 = new Intent(this, GetDataActivity.class);
                startActivity(intent1);
                break;

            case R.id.post:
                Intent intent2 = new Intent(this, PostDataActivity.class);
                startActivity(intent2);
                break;

        }
    }
}

