package com.devahir.mastery.ui.addhabit

import android.os.Bundle
import android.view.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.devahir.mastery.R
import com.devahir.mastery.data.db.model.Habit
import com.devahir.mastery.ui.base.BaseFragment
import javax.inject.Inject

class AddHabitFragment : BaseFragment() {
    @Inject
    lateinit var addHabitViewModelFactory: AddHabitViewModelFactory
    lateinit var addHabitViewModel: AddHabitViewModel

    override fun setUp(view: View?) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)
        addHabitViewModel =
            ViewModelProviders.of(this, addHabitViewModelFactory)[AddHabitViewModel::class.java]
        addHabitViewModel.getAllHabits()
        bundle.let { }
        registerViewModelObserver()
        setHasOptionsMenu(true);
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentParenView = inflater.inflate(R.layout.fragment_add_habit, container, false)

        /* val toolbar: Toolbar = fragmentParenView.findViewById(R.id.toolbar)
         toolbar.setNavigationIcon(R.drawable.black_icon);
         (activity as BaseActivity).showActionBar(toolbar);*/

        setUp(fragmentParenView)
        return fragmentParenView;
    }

    override fun registerViewModelObserver() {
        addHabitViewModel.allHabit.observe(this, Observer<List<Habit>> { _ ->
        })

    }

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_save_habit, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_add_habit -> {
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}