package com.devahir.mastery.di.component;

import com.devahir.mastery.di.PerActivity;
import com.devahir.mastery.di.module.ActivityModule;
import com.devahir.mastery.ui.habit.add.AddHabitFragment;
import com.devahir.mastery.ui.habit.show.HabitFragment;
import com.devahir.mastery.ui.live.LiveTrackFragment;
import com.devahir.mastery.ui.login.LoginFragment;

import dagger.Component;


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(LoginFragment loginFragment);

    void inject(LiveTrackFragment liveTrackFragment);

    void inject(HabitFragment habitFragment);

    void inject(AddHabitFragment addHabitFragment);
/*
    void inject(LoginActivity activity);

    void inject(SplashActivity activity);

    void inject(FeedActivity activity);

    void inject(AboutFragment fragment);

    void inject(OpenSourceFragment fragment);

    void inject(BlogFragment fragment);

    void inject(RateUsDialog dialog);*/

}
