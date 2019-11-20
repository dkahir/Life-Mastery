package com.devahir.mastery.ui.dashboard

import com.devahir.mastery.data.repository.HabitRepository
import com.devahir.mastery.ui.base.BaseViewModel
import com.devahir.mastery.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class HabitViewModel(
    var habitRepository: HabitRepository,
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) : BaseViewModel(schedulerProvider, compositeDisposable) {

    fun getLiveTrackData(list: List<String>) {
    }
}