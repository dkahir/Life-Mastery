package com.devahir.mastery.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.devahir.mastery.R
import com.devahir.mastery.ui.base.BaseActivity
import com.devahir.mastery.ui.base.BaseFragment
import com.devahir.mastery.ui.factory.IntentFactory
import com.devahir.mastery.utils.Screen
import javax.inject.Inject

class HabitFragment : BaseFragment() {
    @Inject
    lateinit var habitViewModelFactory: HabitViewModelFactory
    lateinit var habitViewModel: HabitViewModel

    override fun setUp(view: View?) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)
        habitViewModel =
            ViewModelProviders.of(this, habitViewModelFactory)[HabitViewModel::class.java]
        bundle.let { }
        registerViewModelObserver()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentParenView = inflater.inflate(R.layout.fragment_live_track, container, false)

       /* val toolbar: Toolbar = fragmentParenView.findViewById(R.id.toolbar)
        toolbar.setNavigationIcon(R.drawable.black_icon);
        (activity as BaseActivity).showActionBar(toolbar);*/

        setUp(fragmentParenView)
        return fragmentParenView;
    }

    override fun registerViewModelObserver() {
        habitViewModel.nextScreen.observe(this, Observer<Screen> { nextScreen ->
            when (nextScreen) {
                Screen.HABIT -> {
                    startActivity(
                        IntentFactory.getCallingIntent(
                            activity!!,
                            IntentFactory.IntentType.LIVE_TRACK
                        )
                    )
                }
                else -> {

                }
            }
        })
    }
}