package com.harunkor.teknasyonmoviesample.utils;

import com.harunkor.teknasyonmoviesample.model.MoviesResources;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRetroMoviesInterface {




//api_key=5c14977999b58573a8b099dd535033b7&language=en-US&page=1

    @GET("/3/tv/popular?")
    Call<MoviesResources> MoviesAll(@Query("api_key") String api_key,@Query("language") String language,@Query("page") String page);


}
