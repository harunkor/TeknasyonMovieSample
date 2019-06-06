package com.harunkor.teknasyonmoviesample.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.DataBindingUtil;
import com.harunkor.teknasyonmoviesample.MyApplication;
import com.harunkor.teknasyonmoviesample.R;
import com.harunkor.teknasyonmoviesample.dagger.component.ApplicationComponent;
import com.harunkor.teknasyonmoviesample.dagger.component.DaggerDetailMovieComponent;
import com.harunkor.teknasyonmoviesample.dagger.component.DetailMovieComponent;
import com.harunkor.teknasyonmoviesample.dagger.qualifier.ApplicationContext;

import com.harunkor.teknasyonmoviesample.databinding.ActivityMoviesDetailBinding;
import com.harunkor.teknasyonmoviesample.model.MoviesModel;
import com.harunkor.teknasyonmoviesample.view.MoviesDetailActivity;

import javax.inject.Inject;


public class MoviesDetailViewModel extends BaseObservable {


    private Activity context;
    private DetailMovieComponent detailMovieComponent;


    @Inject
    @ApplicationContext
    public Context mContext;


    private ActivityMoviesDetailBinding moviesDetailBinding;



    public  MoviesDetailViewModel(Activity context, MoviesModel moviesModel)
    {
        this.context=context;


        ApplicationComponent applicationComponent = MyApplication.get(context).getApplicationComponent();
        detailMovieComponent = DaggerDetailMovieComponent.builder()
                .applicationComponent(applicationComponent)
                .build();

        detailMovieComponent.inject((MoviesDetailActivity) context);

        moviesDetailBinding = DataBindingUtil.setContentView(context, R.layout.activity_movies_detail);





        moviesDetailBinding.setDataMoviesDetail(moviesModel);















    }


}
