package com.devahir.mastery.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devahir.mastery.data.repository.HabitRepository
import com.devahir.mastery.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class HabitViewModelFactory @Inject constructor(
    private val habitRepository: HabitRepository,
    private val schedulerProvider: SchedulerProvider,
    private val compositeDisposable: CompositeDisposable
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HabitViewModel::class.java)) {
            return HabitViewModel(
                habitRepository,
                schedulerProvider,
                compositeDisposable
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}