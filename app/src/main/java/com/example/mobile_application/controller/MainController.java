package com.example.mobile_application.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.example.mobile_application.vue.MainActivity;

import com.example.mobile_application.model.Movie;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainController {

    private MainActivity activity;

    private RestMovieApi restMovieApi;

    public MainController(MainActivity mainActivity) {
        this.activity = mainActivity;
    }

    public void onStart(){


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ghibliapi.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        restMovieApi = retrofit.create(RestMovieApi.class);

        makeApiCall();
    }

    private void makeApiCall() {
        Call<List<Movie>> call = restMovieApi.getListMovie();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call,
                                   Response<List<Movie>> response) {
                List<Movie> restMovieResponse = response.body();
                activity.showList(restMovieResponse);
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Log.d("ERROR", "Api Error");
                t.printStackTrace();
            }
        });
    }

    private void storeData(List<Movie> listMovie) {
        //TODO

    }

    private List<Movie> getListFromDataBase() {
        //TODO Implement With real logic
        return new ArrayList<>();
    }

    private boolean hasDataInDataBase() {
        //TODO Implement With real logic
        return true;
    }
}
