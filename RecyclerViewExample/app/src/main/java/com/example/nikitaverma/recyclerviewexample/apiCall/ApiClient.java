package com.example.nikitaverma.recyclerviewexample.apiCall;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit initialization
 */
public class ApiClient {

    private static final String BASE_URL = "https://reqres.in/";
    private static Retrofit retrofit = null;

    public static Retrofit getApiClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return  retrofit;
    }
}
