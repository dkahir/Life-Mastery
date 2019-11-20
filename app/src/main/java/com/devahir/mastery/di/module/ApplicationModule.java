package com.devahir.mastery.di.module;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.devahir.mastery.data.DataManager;
import com.devahir.mastery.data.DataManagerImpl;
import com.devahir.mastery.data.db.MasteryAppDatabase;
import com.devahir.mastery.data.network.ApiHeader;
import com.devahir.mastery.data.network.ApiHelper;
import com.devahir.mastery.data.network.AppApiHelper;
import com.devahir.mastery.data.network.login.LoginRepository;
import com.devahir.mastery.data.network.login.LoginRepositoryImpl;
import com.devahir.mastery.data.network.track.LiveTrackRepository;
import com.devahir.mastery.data.network.track.LiveTrackRepositoryImpl;
import com.devahir.mastery.data.prefs.AppPreferencesHelper;
import com.devahir.mastery.data.prefs.PreferencesHelper;
import com.devahir.mastery.data.repository.HabitRepository;
import com.devahir.mastery.data.repository.HabitRepositoryImpl;
import com.devahir.mastery.di.ApiInfo;
import com.devahir.mastery.di.ApplicationContext;
import com.devahir.mastery.di.DatabaseInfo;
import com.devahir.mastery.di.PreferenceInfo;
import com.devahir.mastery.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;


@Module(includes = ApiModule.class)
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return "";
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(DataManagerImpl appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    MasteryAppDatabase provideMasteryAppDatabase() {
        return Room.databaseBuilder(
                provideContext(),
                MasteryAppDatabase.class,
                AppConstants.DB_NAME
        ).build();
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(apiKey, 0L, "");
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader retrofitClient(@ApiInfo String apiKey, PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(apiKey, 0L, "");
    }

    @Provides
    @Singleton
    LoginRepository provideLoginRepository(MasteryAppDatabase appDatabase, PreferencesHelper preferencesHelper, Retrofit retrofit) {
        return new LoginRepositoryImpl(appDatabase, preferencesHelper, retrofit);
    }

    @Provides
    @Singleton
    LiveTrackRepository provideLiveTrackRepository(MasteryAppDatabase appDatabase, PreferencesHelper preferencesHelper, Retrofit retrofit) {
        return new LiveTrackRepositoryImpl(appDatabase, preferencesHelper, retrofit);
    }

    @Provides
    @Singleton
    HabitRepository provideHabitRepository(MasteryAppDatabase appDatabase, PreferencesHelper preferencesHelper, Retrofit retrofit) {
        return new HabitRepositoryImpl(appDatabase, preferencesHelper, retrofit);
    }

    /*@Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder().setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf").setFontAttrId(R.attr.fontPath).build();
    }*/
}
