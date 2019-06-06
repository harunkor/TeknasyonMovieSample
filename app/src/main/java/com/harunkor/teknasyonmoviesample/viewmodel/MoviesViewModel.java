package com.harunkor.teknasyonmoviesample.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;
import android.widget.Toast;
import com.harunkor.teknasyonmoviesample.MyApplication;
import com.harunkor.teknasyonmoviesample.R;
import com.harunkor.teknasyonmoviesample.adapter.RecyclerViewAdapter;
import com.harunkor.teknasyonmoviesample.dagger.component.ApplicationComponent;
import com.harunkor.teknasyonmoviesample.dagger.component.DaggerMoviesComponent;
import com.harunkor.teknasyonmoviesample.dagger.component.MoviesComponent;
import com.harunkor.teknasyonmoviesample.dagger.module.MoviesModule;
import com.harunkor.teknasyonmoviesample.dagger.qualifier.ActivityContext;
import com.harunkor.teknasyonmoviesample.dagger.qualifier.ApplicationContext;
import com.harunkor.teknasyonmoviesample.model.MoviesModel;
import com.harunkor.teknasyonmoviesample.model.MoviesResources;
import com.harunkor.teknasyonmoviesample.view.MoviesActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.inject.Inject;


public class MoviesViewModel extends BaseObservable  {

    private Activity context;
    private MoviesResources moviesResources;

    private String page;


    public MoviesComponent moviesComponent;


    @Inject
    @ApplicationContext
    public  Context mContext;

    @Inject
    @ActivityContext
    public  Context activityContext;




    public  MoviesViewModel(Activity context, String page)
    {
        this.context=context;
        this.page=page;


     ApplicationComponent   applicationComponent = MyApplication.get(context).getApplicationComponent();
        moviesComponent = DaggerMoviesComponent.builder()
                .moviesModule( new MoviesModule((MoviesActivity) context))
                .applicationComponent(applicationComponent)
                .build();


        moviesComponent.injectMoviesActivity((MoviesActivity) context);





        applicationComponent.getApiInterface().MoviesAll(context.getResources().getString(R.string.apikey),context.getResources().getString(R.string.language),page)
        .enqueue(new Callback<MoviesResources>() {
            @Override
            public void onResponse(Call<MoviesResources> call, Response<MoviesResources> response) {
                moviesResources=response.body();

                setList(moviesResources);



            }

            @Override
            public void onFailure(Call<MoviesResources> call, Throwable t) {

                Toast.makeText(context, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("TAG",""+t.getMessage());

                call.cancel();


            }
        });





    }




    @Bindable
    public MoviesResources getList()
    {
        return  moviesResources;


    }


    @Bindable
    public void setList(MoviesResources mymoviesResources)
    {
        moviesResources.setMoviesList(mymoviesResources.getMoviesList());





    }



}
