package com.harunkor.teknasyonmoviesample.dagger.module;


import android.content.Context;
import com.harunkor.teknasyonmoviesample.dagger.qualifier.ActivityContext;
import com.harunkor.teknasyonmoviesample.dagger.scopes.ActivityScope;
import com.harunkor.teknasyonmoviesample.view.MoviesActivity;
import dagger.Module;
import dagger.Provides;

@Module
public class MoviesModule {

    public MoviesActivity moviesActivity;

    public Context context;


    public MoviesModule(MoviesActivity moviesActivity) {
        this.moviesActivity = moviesActivity;
        context = moviesActivity;
    }


    @Provides
    @ActivityScope
    public MoviesActivity providesMoviesActivity() {
        return moviesActivity;
    }


    @Provides
    @ActivityScope
    @ActivityContext
    public Context provideContext() {
        return context;
    }








}
