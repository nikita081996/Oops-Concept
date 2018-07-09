package com.example.nikitaverma.recyclerviewexample.API;

import com.example.nikitaverma.recyclerviewexample.Model.Book;
import com.example.nikitaverma.recyclerviewexample.Model.PostData;
import com.example.nikitaverma.recyclerviewexample.Model.PostResponseBook;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Interface to call appropriate URL
 */
public interface ApiInterface {

    @GET("api/users?page=2")
    Call<Book> getData();

    @POST("api/users?page=2")
    Call<PostResponseBook> getData(@Body PostData data);
}
