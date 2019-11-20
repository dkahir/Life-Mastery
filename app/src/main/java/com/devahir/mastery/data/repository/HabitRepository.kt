package com.devahir.mastery.data.repository

import com.devahir.mastery.data.network.model.LiveTrackResponse
import io.reactivex.Observable

interface HabitRepository {
    fun getLiveTrackData(list: List<String>): Observable<LiveTrackResponse>
}