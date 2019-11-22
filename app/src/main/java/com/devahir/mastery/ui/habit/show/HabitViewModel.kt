package com.devahir.mastery.ui.habit.show

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.devahir.mastery.data.db.model.Habit
import com.devahir.mastery.data.repository.HabitRepository
import com.devahir.mastery.ui.base.BaseViewModel
import com.devahir.mastery.utils.Screen
import com.devahir.mastery.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class HabitViewModel(
    var habitRepository: HabitRepository,
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) : BaseViewModel(schedulerProvider, compositeDisposable) {
    var allHabit = MutableLiveData<List<Habit>>()
    fun getAllHabits() {
        compositeDisposable.add(
            habitRepository.getAllHabits()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe({ response ->
                    showLoading.value = false
                    allHabit.value = response
                }, { error ->

                    showLoading.value = false

                    // handle the login error here

                    handleApiError(error)
                })
        )

    }
}