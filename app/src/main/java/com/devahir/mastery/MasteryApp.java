package com.devahir.mastery;

import android.app.Application;

import com.devahir.mastery.data.DataManager;
import com.devahir.mastery.di.component.ApplicationComponent;
import com.devahir.mastery.di.component.DaggerApplicationComponent;
import com.devahir.mastery.di.module.ApplicationModule;
import com.devahir.mastery.utils.AppLogger;

import javax.inject.Inject;


public class MasteryApp extends Application {

    @Inject
    DataManager mDataManager;

   /* @Inject
    CalligraphyConfig mCalligraphyConfig;*/

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

        AppLogger.init();

        /*//AndroidNetworking.initialize(getApplicationContext());
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(Level.BODY);
        }*/

        // CalligraphyConfig.initDefault(mCalligraphyConfig);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
