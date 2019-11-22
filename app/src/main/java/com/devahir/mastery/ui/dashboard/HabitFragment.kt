package com.devahir.mastery.ui.dashboard

import android.os.Bundle
import android.view.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.devahir.mastery.R
import com.devahir.mastery.data.db.model.Habit
import com.devahir.mastery.ui.base.BaseFragment
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
        habitViewModel.getAllHabits()
        bundle.let { }
        registerViewModelObserver()
        setHasOptionsMenu(true);
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentParenView = inflater.inflate(R.layout.fragment_habit, container, false)

        /* val toolbar: Toolbar = fragmentParenView.findViewById(R.id.toolbar)
         toolbar.setNavigationIcon(R.drawable.black_icon);
         (activity as BaseActivity).showActionBar(toolbar);*/

        setUp(fragmentParenView)
        return fragmentParenView;
    }

    override fun registerViewModelObserver() {
        habitViewModel.allHabit.observe(this, Observer<List<Habit>> { _ ->
        })

    }
    /*override fun onCreateOptionsMenu(menu: Menu, menuInflater : MenuInflater): Boolean {
        menuInflater.inflate(R.menu.menu_add, menu)
        return true
    }*/

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_add, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            /* R.id.action_settings -> {
                 val intent = Intent(this, SettingActivity::class.java)
                 startActivity(intent)
                 true
             }
             R.id.future, R.id.opened, R.id.all -> {
                 item.isChecked = !item.isChecked
                 val itemName = resources.getResourceEntryName(item.itemId)
                 try {
                     viewModel.filter(itemName)
                 } catch (e: IllegalArgumentException) {
                     Log.e(this.javaClass.name, "Invalid application state: ${e.message}")
                 }
                 true
             }*/
            else -> super.onOptionsItemSelected(item)
        }
    }
}