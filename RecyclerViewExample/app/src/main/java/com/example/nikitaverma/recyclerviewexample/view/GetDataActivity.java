package com.example.nikitaverma.recyclerviewexample.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.example.nikitaverma.recyclerviewexample.R;
import com.example.nikitaverma.recyclerviewexample.adapter.BookAdapter;
import com.example.nikitaverma.recyclerviewexample.apiCall.ApiClient;
import com.example.nikitaverma.recyclerviewexample.apiCall.ApiInterface;
import com.example.nikitaverma.recyclerviewexample.model.Book;
import com.example.nikitaverma.recyclerviewexample.utility.ToastUtility;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Response class for GET method
 */
public class GetDataActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private BookAdapter mAdapter;
    private ApiInterface mApiInterface;
    private Toolbar mToolbar;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);
        initialize();

        //call api and bind response with the BookAdapter
        fetchData();
    }

    /**
     * initialize all views
     */
    private void initialize() {
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mProgressBar = findViewById(R.id.progressbar);
        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        //StaggeredGridLayoutManager mLayoutManager = new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL);
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mApiInterface = ApiClient.getApiClient().create(ApiInterface.class);

    }

    /**
     * Get Users list
     */
    private void fetchData() {
        Call<Book> call = mApiInterface.getData();

        call.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                mProgressBar.setVisibility(View.GONE);
                if (response.code() == 200)
                {
                    Book book = response.body();
                    mAdapter = new BookAdapter(book.getData(), getApplicationContext());
                    mRecyclerView.setAdapter(mAdapter);
                    ToastUtility.showToast(getApplicationContext(), getString(R.string.success_response) + response.code());
                }
                else
                {
                    ToastUtility.showToast(getApplicationContext(), getString(R.string.on_failure_call_of_api) + response.code());
                }
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {
                mProgressBar.setVisibility(View.GONE);
                ToastUtility.showToast(getApplicationContext(), t.getMessage());
            }
        });
    }
}

