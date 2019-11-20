package com.devahir.mastery.ui.live

import com.devahir.mastery.data.network.track.LiveTrackRepository
import com.devahir.mastery.ui.base.BaseViewModel
import com.devahir.mastery.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class LiveTrackViewModel(
    var liveTrackRepository: LiveTrackRepository,
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) : BaseViewModel(schedulerProvider, compositeDisposable) {

    fun getLiveTrackData(list: List<String>) {
    }
}