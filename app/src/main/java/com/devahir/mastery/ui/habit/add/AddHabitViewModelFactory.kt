package com.devahir.mastery.ui.habit.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devahir.mastery.data.repository.HabitRepository
import com.devahir.mastery.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class AddHabitViewModelFactory @Inject constructor(
    private val habitRepository: HabitRepository,
    private val schedulerProvider: SchedulerProvider,
    private val compositeDisposable: CompositeDisposable
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddHabitViewModel::class.java)) {
            return AddHabitViewModel(
                habitRepository,
                schedulerProvider,
                compositeDisposable
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}