package com.harunkor.teknasyonmoviesample;

import android.app.Activity;
import android.app.Application;
import com.harunkor.teknasyonmoviesample.dagger.component.ApplicationComponent;
import com.harunkor.teknasyonmoviesample.dagger.component.DaggerApplicationComponent;
import com.harunkor.teknasyonmoviesample.dagger.module.ContextModule;
;


public class MyApplication extends Application {


    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder().contextModule(new ContextModule(this)).build();
        applicationComponent.injectApplication(this);











    }

    public static MyApplication get(Activity activity){
        return (MyApplication) activity.getApplication();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
