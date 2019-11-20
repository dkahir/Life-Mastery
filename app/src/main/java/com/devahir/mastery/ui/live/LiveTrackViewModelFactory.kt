package com.devahir.mastery.ui.live

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devahir.mastery.data.network.track.LiveTrackRepository
import com.devahir.mastery.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class LiveTrackViewModelFactory @Inject constructor(
    private val liveTrackRepository: LiveTrackRepository,
    private val schedulerProvider: SchedulerProvider,
    private val compositeDisposable: CompositeDisposable
) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LiveTrackViewModel::class.java)) {
            return LiveTrackViewModel(
                liveTrackRepository,
                schedulerProvider,
                compositeDisposable
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}