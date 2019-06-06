package com.harunkor.teknasyonmoviesample.dagger.component;


import android.content.Context;
import com.harunkor.teknasyonmoviesample.dagger.module.AdapterModule;
import com.harunkor.teknasyonmoviesample.dagger.module.RetrofitModule;
import com.harunkor.teknasyonmoviesample.dagger.qualifier.ActivityContext;
import com.harunkor.teknasyonmoviesample.dagger.scopes.ActivityScope;
import com.harunkor.teknasyonmoviesample.utils.ApiRetroMoviesInterface;
import com.harunkor.teknasyonmoviesample.view.MoviesActivity;
import dagger.Component;
import dagger.Provides;


@ActivityScope
@Component(modules = AdapterModule.class, dependencies = ApplicationComponent.class)
public interface MoviesComponent   {





    @ActivityContext
    Context getContext();



    void injectMoviesActivity(MoviesActivity moviesActivity);










}
