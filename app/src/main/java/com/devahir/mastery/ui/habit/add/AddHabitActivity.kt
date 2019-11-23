package com.devahir.mastery.ui.habit.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.devahir.mastery.R
import com.devahir.mastery.ui.base.NavigationActivity
import com.devahir.mastery.ui.factory.FragmentFactory

class AddHabitActivity : NavigationActivity() {
    private lateinit var habitFragment: Fragment

    override fun setNavigationView() {
        setupNavigationView(R.id.navigation_journal)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        setUp()
        setNavigationView()
    }

    override fun setUp() {
        addFragment(
            FragmentFactory.newInstance(FragmentFactory.FragmentType.Add_HABIT),
            FragmentFactory.FragmentType.Add_HABIT
        )
    }
}
