package com.harunkor.teknasyonmoviesample.dagger.component;

import android.content.Context;
import com.harunkor.teknasyonmoviesample.dagger.qualifier.ActivityContext;
import com.harunkor.teknasyonmoviesample.dagger.scopes.ActivityScope;
import com.harunkor.teknasyonmoviesample.view.MoviesDetailActivity;
import dagger.Component;

@Component(dependencies = ApplicationComponent.class)
@ActivityScope
public interface DetailMovieComponent {




    void inject(MoviesDetailActivity moviesDetailActivity);

}

