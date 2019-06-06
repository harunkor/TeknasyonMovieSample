package com.harunkor.teknasyonmoviesample.dagger.component;


import android.content.Context;
import com.harunkor.teknasyonmoviesample.MyApplication;
import com.harunkor.teknasyonmoviesample.dagger.module.ContextModule;
import com.harunkor.teknasyonmoviesample.dagger.module.RetrofitModule;
import com.harunkor.teknasyonmoviesample.dagger.qualifier.ApplicationContext;
import com.harunkor.teknasyonmoviesample.dagger.scopes.ApplicationScope;
import com.harunkor.teknasyonmoviesample.utils.ApiRetroMoviesInterface;
import dagger.Component;


@ApplicationScope
@Component(modules = {ContextModule.class, RetrofitModule.class})
public interface ApplicationComponent {



    public ApiRetroMoviesInterface getApiInterface();




    @ApplicationContext
    public Context getContext();

    public void injectApplication(MyApplication myApplication);


}
