package com.harunkor.teknasyonmoviesample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesResources {

    @SerializedName("results")
    @Expose
    private List<MoviesModel> moviesModelList = null;

    public List<MoviesModel> getMoviesList() {
        return moviesModelList;
    }

    public void setMoviesList(List<MoviesModel> moviesModelList) {
        this.moviesModelList = moviesModelList;
    }

}
