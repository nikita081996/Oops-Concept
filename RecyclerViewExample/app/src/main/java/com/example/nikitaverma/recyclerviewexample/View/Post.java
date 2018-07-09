package com.example.nikitaverma.recyclerviewexample.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nikitaverma.recyclerviewexample.API.ApiClient;
import com.example.nikitaverma.recyclerviewexample.API.ApiInterface;
import com.example.nikitaverma.recyclerviewexample.Message.Message;
import com.example.nikitaverma.recyclerviewexample.Model.PostData;
import com.example.nikitaverma.recyclerviewexample.Model.PostResponseBook;
import com.example.nikitaverma.recyclerviewexample.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Fetch data by POST
 */
public class Post extends AppCompatActivity implements View.OnClickListener{

    private ApiInterface mApiInterface;
    private Toolbar mToolbar;
    private TextView mFirstnameTxt;
    private  TextView mLastnameTxt;
    private TextView mAgeTxt;
    private Button mSendBtn;
    private EditText mNameEt;
    private EditText mJobEt;
    private PostData data = new PostData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        intilize();
        setSupportActionBar(mToolbar);
    }


    private void intilize(){
        mToolbar = findViewById(R.id.toolbar);
        mFirstnameTxt = findViewById(R.id.firstname);
        mLastnameTxt = findViewById(R.id.lastname);
        mAgeTxt = findViewById(R.id.age);
        mSendBtn = findViewById(R.id.send);
        mNameEt = findViewById(R.id.etname);
        mJobEt = findViewById(R.id.etjob);

        mApiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        mSendBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.send:
                data.setName(mNameEt.getText().toString());
                data.setJob(mJobEt.getText().toString());
                fetchResponse();
        }
    }

    void fetchResponse(){
        Call<PostResponseBook> call = mApiInterface.getData(data);
        call.enqueue(new Callback<PostResponseBook>() {
            @Override
            public void onResponse(Call<PostResponseBook> call, Response<PostResponseBook> response) {
                PostResponseBook book = response.body();
                mFirstnameTxt.setText("Name "+book.getName());
                mLastnameTxt.setText("Created At "+book.getCreatedAt());
                mAgeTxt.setText("Id "+book.getId());
                Message.s(Post.this,"Getting "+response.code());
            }

            @Override
            public void onFailure(Call<PostResponseBook> call, Throwable t) {
                Message.s(getApplicationContext(),t.getMessage());
            }
        });
    }
}

