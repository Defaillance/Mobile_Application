package com.example.mobile_application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.example.mobile_application.model.Movie;
import com.example.mobile_application.model.RestMovieResponse;

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
                .baseUrl("https://ghibliapi.herokuapp.com/films")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        restPokemonApi = retrofit.create(RestMovieApi.class);

        if(hasDataInDataBase()){
            List<Movie> movieList = getListFromDataBase();
            activity.showList(movieList);
        }else{
            makeApiCall();
        }
    }

    private void makeApiCall() {
        Call<RestMovieResponse> call = restMovieApi.getListMovie();
        call.enqueue(new Callback<RestMovieResponse>() {
            @Override
            public void onResponse(Call<RestMovieResponse> call,
                                   Response<RestMovieResponse> response) {
                RestMovieResponse restMovieResponse = response.body();
                List<Movie> listMovie = restMovieResponse.getResults();
                storeData(listMovie);
                activity.showList(listMovie);
            }

            @Override
            public void onFailure(Call<RestMovieResponse> call, Throwable t) {
                Log.d("ERROR", "Api Error");
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
