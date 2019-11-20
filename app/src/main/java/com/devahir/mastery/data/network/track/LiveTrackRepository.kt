package com.devahir.mastery.data.network.track

import com.devahir.mastery.data.network.model.LiveTrackResponse
import io.reactivex.Observable

interface LiveTrackRepository {
    fun getLiveTrackData(list: List<String>): Observable<LiveTrackResponse>
}