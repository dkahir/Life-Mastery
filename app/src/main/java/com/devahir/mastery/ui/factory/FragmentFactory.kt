package com.devahir.mastery.ui.factory

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.devahir.mastery.ui.dashboard.HabitFragment
import com.devahir.mastery.ui.live.LiveTrackFragment
import com.devahir.mastery.ui.login.LoginFragment

class FragmentFactory {
    companion object {
        fun newInstance(fragmentType: FragmentType, bundle: Bundle? = null): Fragment {
            return when (fragmentType) {
                FragmentType.LOGIN -> {
                    LoginFragment().apply {
                        arguments = bundle
                    }
                }
                FragmentType.LIVE_TRACK -> {
                    LiveTrackFragment().apply {
                        arguments = bundle
                    }
                }
                FragmentType.HABIT -> {
                    HabitFragment().apply {
                        arguments = bundle
                    }
                }
            }

        }
    }

    enum class FragmentType {
        LOGIN, LIVE_TRACK, HABIT
    }
}