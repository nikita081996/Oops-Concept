package com.example.nikitaverma.recyclerviewexample.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.nikitaverma.recyclerviewexample.API.ApiClient;
import com.example.nikitaverma.recyclerviewexample.API.ApiInterface;
import com.example.nikitaverma.recyclerviewexample.Adapter.BookAdapter;
import com.example.nikitaverma.recyclerviewexample.Message.Message;
import com.example.nikitaverma.recyclerviewexample.Model.Book;
import com.example.nikitaverma.recyclerviewexample.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Response class for GET method
 */
public class Get extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private BookAdapter mAdapter;
    private ApiInterface mApiInterface;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);
        intilize();
        setSupportActionBar(mToolbar);
        fetchData();
    }

    private void intilize(){
        mToolbar = findViewById(R.id.toolbar);
        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        //StaggeredGridLayoutManager mLayoutManager = new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL);
        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mApiInterface = ApiClient.getApiClient().create(ApiInterface.class);

    }

    void fetchData(){
        Call<Book> call = mApiInterface.getData();
        call.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                Book book = response.body();
                mAdapter = new BookAdapter(book.getData(),getApplicationContext());
                mRecyclerView.setAdapter(mAdapter);
                Message.s(Get.this,"Getting "+response.code());
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {
                Message.s(getApplicationContext(),t.getMessage());
            }
        });
    }
}

