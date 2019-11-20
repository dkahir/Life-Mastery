package com.devahir.mastery.utils

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class PermissionHandler {

    companion object {
        const val REQUEST_CODE: Int = 1
        fun requestPermission(activity: Activity, permissionList: Array<String>) {

            // Here, activity is the current activity
            val requestPermissionList = permissionList.filter { !isPermissionGranted(activity, it) }

            ActivityCompat.requestPermissions(activity, requestPermissionList.toTypedArray(), REQUEST_CODE)

            // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
            // app-defined int constant. The callback method gets the
            // result of the request.


        }


        fun isPermissionGranted(activity: Activity, permissionName: String): Boolean {
            return (ContextCompat.checkSelfPermission(activity, permissionName) == PackageManager.PERMISSION_GRANTED)
        }
    }
}

