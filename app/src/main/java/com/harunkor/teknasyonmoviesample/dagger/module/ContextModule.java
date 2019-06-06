package com.harunkor.teknasyonmoviesample.dagger.module;

import android.content.Context;
import com.harunkor.teknasyonmoviesample.dagger.component.MoviesComponent;
import com.harunkor.teknasyonmoviesample.dagger.qualifier.ApplicationContext;
import com.harunkor.teknasyonmoviesample.dagger.scopes.ApplicationScope;
import dagger.Module;
import dagger.Provides;

import javax.inject.Inject;


@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context provideContext() {
        return context;
    }












}
