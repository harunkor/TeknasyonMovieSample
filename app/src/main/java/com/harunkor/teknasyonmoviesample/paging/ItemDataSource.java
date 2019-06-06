package com.harunkor.teknasyonmoviesample.paging;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;
import com.harunkor.teknasyonmoviesample.model.MoviesModel;
import com.harunkor.teknasyonmoviesample.model.MoviesResources;
import com.harunkor.teknasyonmoviesample.utils.ApiLoginClient;
import com.harunkor.teknasyonmoviesample.utils.ApiRetroMoviesInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ItemDataSource  extends PageKeyedDataSource<Integer, MoviesModel> {

    public static final int PAGE_SIZE = 50;
    private static final int FIRST_PAGE = 1;
    private static  String apikey="5c14977999b58573a8b099dd535033b7";
    private static  String  language="en-US";

    private ApiRetroMoviesInterface apiRetroInterface=ApiLoginClient.ClientLogin().create(ApiRetroMoviesInterface.class);


    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, MoviesModel> callback) {


       Call<MoviesResources> call=apiRetroInterface.MoviesAll(apikey,language,String.valueOf(FIRST_PAGE));
       call.enqueue(new Callback<MoviesResources>() {
           @Override
           public void onResponse(Call<MoviesResources> call, Response<MoviesResources> response) {

               if(response.body() != null){

                   callback.onResult(response.body().getMoviesList(), null, FIRST_PAGE + 1);

                   

               }
           }

           @Override
           public void onFailure(Call<MoviesResources> call, Throwable t) {

           }
       });

    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, MoviesModel> callback) {




        Call<MoviesResources> call=apiRetroInterface.MoviesAll(apikey,language,String.valueOf(params.key));
        call.enqueue(new Callback<MoviesResources>() {
            @Override
            public void onResponse(Call<MoviesResources> call, Response<MoviesResources> response) {

                if(response.body() != null){

                    Integer key = (params.key > 1) ? params.key - 1 : null;
                    callback.onResult(response.body().getMoviesList(), key);

                }
            }

            @Override
            public void onFailure(Call<MoviesResources> call, Throwable t) {

            }
        });





    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, MoviesModel> callback) {

        Call<MoviesResources> call=apiRetroInterface.MoviesAll(apikey,language,String.valueOf(params.key));
        call.enqueue(new Callback<MoviesResources>() {
            @Override
            public void onResponse(Call<MoviesResources> call, Response<MoviesResources> response) {

                if(response.body() != null){
                    Integer key = params.key + 1;
                    callback.onResult(response.body().getMoviesList(), key);
                }

            }

            @Override
            public void onFailure(Call<MoviesResources> call, Throwable t) {

            }
        });


    }
}
