package com.devahir.mastery.ui.base

interface LocationPermissionAware {
    fun onLocationStatusChange(isPermissionGranted: Boolean)
}