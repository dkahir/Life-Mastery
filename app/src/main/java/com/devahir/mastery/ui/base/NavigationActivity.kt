package com.devahir.mastery.ui.base

import android.content.Intent
import com.devahir.mastery.R
import com.devahir.mastery.ui.alerts.AlertsActivity
import com.devahir.mastery.ui.factory.IntentFactory
import com.google.android.material.bottomnavigation.BottomNavigationView

abstract class NavigationActivity : BaseActivity() {
    override fun setUp() {
    }

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_journal -> {
                    val liveTrackIntent =
                        IntentFactory.getCallingIntent(
                            this@NavigationActivity,
                            IntentFactory.IntentType.DASHBOARD
                        )
                    startActivity(liveTrackIntent)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_habit -> {
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_mood -> {
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_blog -> {
                    val intent = Intent(this@NavigationActivity, AlertsActivity::class.java)
                    startActivity(intent)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_profile -> {
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    abstract fun setNavigationView()

    fun setupNavigationView(itemId: Int) {
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.selectedItemId = itemId
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
}