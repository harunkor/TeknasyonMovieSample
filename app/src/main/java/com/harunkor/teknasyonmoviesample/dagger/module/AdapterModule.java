package com.harunkor.teknasyonmoviesample.dagger.module;

import android.content.Context;
import com.harunkor.teknasyonmoviesample.adapter.RecyclerViewAdapter;
import com.harunkor.teknasyonmoviesample.dagger.scopes.ActivityScope;
import com.harunkor.teknasyonmoviesample.model.MoviesResources;
import com.harunkor.teknasyonmoviesample.view.MoviesActivity;
import dagger.Module;
import dagger.Provides;

@Module(includes = {MoviesModule.class})
public class AdapterModule {



    @Provides
    @ActivityScope
    public RecyclerViewAdapter getMoviesList(Context ctx, RecyclerViewAdapter.ClickListener clickListener) {
        return new RecyclerViewAdapter(ctx,clickListener);
    }

    @Provides
    @ActivityScope
    public RecyclerViewAdapter.ClickListener getClickListener(MoviesActivity moviesActivity) {
        return moviesActivity;
    }

}
