package com.example.nikitaverma.recyclerviewexample.apiCall;

import com.example.nikitaverma.recyclerviewexample.model.Book;
import com.example.nikitaverma.recyclerviewexample.model.PostDataRequest;
import com.example.nikitaverma.recyclerviewexample.model.PostResponseBook;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Interface to call appropriate URL
 */
public interface ApiInterface {

    @GET("api/users?pages=3")
    Call<Book> getData();

    @POST("api/users?pages=2")
    Call<PostResponseBook> getData(@Body PostDataRequest data);
}
