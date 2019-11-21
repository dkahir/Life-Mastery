package com.devahir.mastery.ui.live

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.devahir.mastery.R
import com.devahir.mastery.ui.base.BaseActivity
import com.devahir.mastery.ui.base.BaseFragment
import com.devahir.mastery.ui.component.MapHandler
import com.devahir.mastery.ui.factory.FragmentFactory
import com.devahir.mastery.ui.factory.IntentFactory
import com.devahir.mastery.utils.Screen
import javax.inject.Inject

class LiveTrackFragment : BaseFragment(), MapEventListener {
    @Inject
    lateinit var liveTrackViewModelFactory: LiveTrackViewModelFactory
    @Inject
    lateinit var mapHandler: MapHandler
    lateinit var liveTrackViewModel: LiveTrackViewModel

    override fun setUp(view: View?) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)
        liveTrackViewModel =
            ViewModelProviders.of(this, liveTrackViewModelFactory)[LiveTrackViewModel::class.java]
        bundle.let { }
        registerViewModelObserver()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentParenView = inflater.inflate(R.layout.fragment_habit, container, false)

        val toolbar: Toolbar = fragmentParenView.findViewById(R.id.toolbar)
        toolbar.setNavigationIcon(R.drawable.black_icon);
        (activity as BaseActivity).showActionBar(toolbar);

        mapHandler.mapEventListener = this;
        addChildFragment(
            mapHandler.mapFragment as Fragment,
            FragmentFactory.FragmentType.LIVE_TRACK
        )
        setUp(fragmentParenView)
        return fragmentParenView;
    }

    override fun onMapReady() {
        mapHandler.setMapSetting()
    }

    /* override fun onLocationStatusChange(isPermissionGranted: Boolean) {
         mapHandler.setMapSetting()
     }*/
    override fun registerViewModelObserver() {
        liveTrackViewModel.nextScreen.observe(this, Observer<Screen> { nextScreen ->
            when (nextScreen) {
                Screen.LIVE_TRACK -> {
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