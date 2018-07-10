package com.example.nikitaverma.recyclerviewexample.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.nikitaverma.recyclerviewexample.R;
import com.example.nikitaverma.recyclerviewexample.apiCall.ApiClient;
import com.example.nikitaverma.recyclerviewexample.apiCall.ApiInterface;
import com.example.nikitaverma.recyclerviewexample.model.PostDataRequest;
import com.example.nikitaverma.recyclerviewexample.model.PostResponseBook;
import com.example.nikitaverma.recyclerviewexample.utility.ToastUtility;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Fetch data by POST
 */
public class PostDataActivity extends AppCompatActivity implements View.OnClickListener {

    private ApiInterface mApiInterface;
    private Toolbar mToolbar;
    private TextView mFirstNameTxt;
    private TextView mLastNameTxt;
    private TextView mAgeTxt;
    private Button mSendBtn;
    private EditText mNameEt;
    private EditText mJobEt;
    private ProgressBar mProgressBar;
    private final PostDataRequest data = new PostDataRequest();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_data);
        initialize();
    }

    /**
     * intilalizaion of all views
     */
    private void initialize() {
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mProgressBar = findViewById(R.id.progressBar);
        mFirstNameTxt = findViewById(R.id.first_name);
        mLastNameTxt = findViewById(R.id.last_name);
        mAgeTxt = findViewById(R.id.age);
        mSendBtn = findViewById(R.id.send);
        mNameEt = findViewById(R.id.et_name);
        mJobEt = findViewById(R.id.et_job);

        mApiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        mSendBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.send:
                data.setName(mNameEt.getText().toString());
                data.setJob(mJobEt.getText().toString());
                mProgressBar.setVisibility(View.VISIBLE);
                fetchResponse();
        }
    }

    /**
     * response from post api call
     */
    private void fetchResponse() {
        Call<PostResponseBook> call = mApiInterface.getData(data);
        call.enqueue(new Callback<PostResponseBook>() {
            @Override
            public void onResponse(Call<PostResponseBook> call, Response<PostResponseBook> response) {
                mProgressBar.setVisibility(View.GONE);
                if (response.code() == 201) {
                    PostResponseBook book = response.body();
                    mFirstNameTxt.setText(getString(R.string.name) + " " + book.getName());
                    mLastNameTxt.setText(getString(R.string.created_at) + " " + book.getCreatedAt());
                    mAgeTxt.setText(getString(R.string.id) + " " + book.getId());
                    ToastUtility.showToast(getApplicationContext(), getString(R.string.success_response) + response.code());
                } else {
                    ToastUtility.showToast(getApplicationContext(), getString(R.string.on_failure_call_of_api) + response.code());
                }
            }

            @Override
            public void onFailure(Call<PostResponseBook> call, Throwable t) {
                mProgressBar.setVisibility(View.GONE);
                ToastUtility.showToast(getApplicationContext(), t.getMessage());
            }
        });
    }
}

