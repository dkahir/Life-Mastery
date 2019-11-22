package com.devahir.mastery.ui.factory

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.devahir.mastery.ui.habit.add.AddHabitActivity
import com.devahir.mastery.ui.dashboard.DashboardActivity
import com.devahir.mastery.ui.live.LiveTrackActivity
import com.devahir.mastery.ui.login.LoginActivity
import com.devahir.mastery.ui.welcome.WelcomeActivity

class IntentFactory {
    companion object {
        fun getCallingIntent(
            context: Context,
            intentType: IntentType,
            bundle: Bundle? = null
        ): Intent {
            return when (intentType) {
                IntentType.LOGIN -> {
                    val intent = Intent(context, LoginActivity::class.java)
                    bundle.let {
                        intent.putExtra(LoginActivity::class.java.simpleName, bundle)
                    }
                }
                IntentType.WELCOME -> {
                    val intent = Intent(context, WelcomeActivity::class.java)
                    bundle.let {
                        intent.putExtra(WelcomeActivity::class.java.simpleName, bundle)
                    }
                }
                IntentType.LIVE_TRACK -> {
                    val intent = Intent(context, LiveTrackActivity::class.java)
                    bundle.let {
                        intent.putExtra(LiveTrackActivity::class.java.simpleName, bundle)
                    }
                }
                IntentType.DASHBOARD -> {
                    val intent = Intent(context, DashboardActivity::class.java)
                    bundle.let {
                        intent.putExtra(DashboardActivity::class.java.simpleName, bundle)
                    }
                }
                IntentType.ADD_HABIT -> {
                    val intent = Intent(context, AddHabitActivity::class.java)
                    bundle.let {
                        intent.putExtra(AddHabitActivity::class.java.simpleName, bundle)
                    }
                }
            }
        }
    }

    enum class IntentType {
        WELCOME, LOGIN, LIVE_TRACK, DASHBOARD, ADD_HABIT
    }
}