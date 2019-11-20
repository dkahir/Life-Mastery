package com.devahir.mastery.ui.live

import android.Manifest
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.devahir.mastery.R
import com.devahir.mastery.ui.base.LocationPermissionAware
import com.devahir.mastery.ui.base.NavigationActivity
import com.devahir.mastery.ui.factory.FragmentFactory
import com.devahir.mastery.utils.PermissionHandler

class LiveTrackActivity : NavigationActivity(), LocationPermissionAware {
    private lateinit var liveTrackFragment: Fragment

    override fun setNavigationView() {
        setupNavigationView(R.id.navigation_journal)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_track)
        setUp()
        setNavigationView()
    }

    override fun setUp() {
        if (!PermissionHandler.isPermissionGranted(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
            PermissionHandler.requestPermission(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION))
        }
        liveTrackFragment = FragmentFactory.newInstance(FragmentFactory.FragmentType.LIVE_TRACK)
        addFragment(FragmentFactory.newInstance(FragmentFactory.FragmentType.LIVE_TRACK), FragmentFactory.FragmentType.LIVE_TRACK)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    override fun onLocationStatusChange(isPermissionGranted: Boolean) {
        //(liveTrackFragment as LocationPermissionAware).onLocationStatusChange(isPermissionGranted)
    }
}
