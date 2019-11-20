package com.devahir.mastery.ui.alerts

import android.os.Bundle
import com.devahir.mastery.R
import com.devahir.mastery.ui.base.NavigationActivity

class AlertsActivity : NavigationActivity() {
    override fun setNavigationView() {
        setupNavigationView(R.id.navigation_blog)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alerts)
        setNavigationView()
    }
}
