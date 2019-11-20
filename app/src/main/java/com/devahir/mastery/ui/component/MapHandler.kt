package com.devahir.mastery.ui.component

import android.Manifest
import android.app.Activity
import android.graphics.Color
import com.devahir.mastery.ui.live.MapEventListener
import com.devahir.mastery.utils.PermissionHandler
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions

class MapHandler : OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    val mapFragment: SupportMapFragment = SupportMapFragment()
    lateinit var mapEventListener: MapEventListener

    init {
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        if (::mapEventListener.isInitialized) {
            mapEventListener.onMapReady()
        }
    }

    fun setMapSetting() {
        mMap.uiSettings.isCompassEnabled = true
        if (PermissionHandler.isPermissionGranted(mapFragment.activity as Activity, Manifest.permission.ACCESS_FINE_LOCATION)) {
            mMap.isMyLocationEnabled = true
            mMap.uiSettings.isMyLocationButtonEnabled = true
        }
        mMap.uiSettings.isRotateGesturesEnabled = true
        mMap.uiSettings.isMapToolbarEnabled = true
        mMap.uiSettings.isZoomGesturesEnabled = true
    }

    fun addMarker(latLng: LatLng, title: String, icon: String) {
        val markerOptions = MarkerOptions()
        markerOptions.position(latLng)
        markerOptions.title(title)
        mMap.addMarker(markerOptions)
    }

    fun addPolyline(width: Float, color: String, route: List<LatLng>) {
        val options = PolylineOptions().width(width).color(Color.BLUE).geodesic(true)
        options.addAll(route)
        mMap.addPolyline(options)
    }

    fun animateToLocation(latLng: LatLng) {
        mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng))
    }
}