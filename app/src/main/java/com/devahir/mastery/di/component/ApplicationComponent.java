package com.devahir.mastery.di.component;

import android.app.Application;
import android.content.Context;

import com.devahir.mastery.MasteryApp;
import com.devahir.mastery.data.DataManager;
import com.devahir.mastery.data.network.login.LoginRepository;
import com.devahir.mastery.data.network.track.LiveTrackRepository;
import com.devahir.mastery.data.repository.HabitRepository;
import com.devahir.mastery.di.ApplicationContext;
import com.devahir.mastery.di.module.ApiModule;
import com.devahir.mastery.di.module.ApplicationModule;
import com.devahir.mastery.service.SyncService;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {

    void inject(MasteryApp app);

    void inject(SyncService service);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();

    LoginRepository loginRepository();

    LiveTrackRepository liveTrackRepository();

    HabitRepository habitRepository();

    // Retrofit provideRetrofit();
}