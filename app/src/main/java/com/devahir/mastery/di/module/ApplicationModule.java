package com.devahir.mastery.di.module;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.devahir.mastery.R;
import com.devahir.mastery.data.DataManager;
import com.devahir.mastery.data.DataManagerImpl;
import com.devahir.mastery.data.db.MasteryAppDatabase;
import com.devahir.mastery.data.db.model.HabitCategory;
import com.devahir.mastery.data.db.model.HabitCategoryQuestionAssoc;
import com.devahir.mastery.data.db.model.Question;
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
import com.devahir.mastery.utils.JSONUtils;

import java.util.List;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;


@Module(includes = ApiModule.class)
public class ApplicationModule {

    private final Application mApplication;
    private MasteryAppDatabase masteryAppDatabase;

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
        masteryAppDatabase = Room.databaseBuilder(
                provideContext(),
                MasteryAppDatabase.class,
                AppConstants.DB_NAME
        ).addCallback(new RoomDatabase.Callback() {
            public void onCreate(SupportSQLiteDatabase db) {
                super.onCreate(db);
                Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        String habitCategoryJsonString = JSONUtils.getJsonFileAsClass(provideContext().getResources(),
                                R.raw.habitcategory, HabitCategory.class);
                        HabitCategory[] habitCategory = JSONUtils.constructUsingGson(HabitCategory[].class, habitCategoryJsonString);
                        List<Long> categoryIds = masteryAppDatabase.habitCategoryDao().insert(habitCategory);
                        Log.d("ApplicationModule", "HabitCategoryInserted ID is " + categoryIds);
                        List<HabitCategory> allCate = masteryAppDatabase.habitCategoryDao().getAll();
                        Log.d("ApplicationModule", "HabitCategoryInserted ID is " + categoryIds + "data is " + allCate.get(0).toString());

                        String questionsJsonString = JSONUtils.getJsonFileAsClass(provideContext().getResources(),
                                R.raw.questions, HabitCategory.class);
                        Question[] questions = JSONUtils.constructUsingGson(Question[].class, questionsJsonString);


                        List<Long> questionsIds = masteryAppDatabase.questionDao().insert(questions);
                        Log.d("ApplicationModule", "Question Inserted ID is " + questionsIds);
                        List<Question> allquestions = masteryAppDatabase.questionDao().getAll();
                        Log.d("ApplicationModule", "Question Inserted ID is " + categoryIds + "data is " + allquestions.get(0).toString());


                        String categoryQuestionsAssoc = JSONUtils.getJsonFileAsClass(provideContext().getResources(),
                                R.raw.habitcategoryquestionsassoc, HabitCategoryQuestionAssoc.class);
                        HabitCategoryQuestionAssoc[] categoryQuestionAssocs = JSONUtils.constructUsingGson(HabitCategoryQuestionAssoc[].class, categoryQuestionsAssoc);
                        List<Long> categoryQuestionsIds = masteryAppDatabase.habitCategoryQuestionAssocDao().insert(categoryQuestionAssocs);
                        Log.d("ApplicationModule", "HabitCategoryQuestionAssoc Inserted ID is " + categoryQuestionsIds);
                        List<HabitCategoryQuestionAssoc> allCategoryQuestionsAssocs = masteryAppDatabase.habitCategoryQuestionAssocDao().getAll();
                        Log.d("ApplicationModule", "HabitCategoryQuestionAssoc Inserted ID is " + categoryQuestionsIds + "data is " + allCategoryQuestionsAssocs.get(0).toString());
                    }
                });
            }
        }).build();
        return masteryAppDatabase;
    }

    // private static RoomDatabase.Callback dbCallback =

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
