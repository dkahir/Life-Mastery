package com.devahir.mastery.data.network.track

import com.devahir.mastery.data.network.model.LiveTrackResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface LiveTrackApiHelper {
    @GET("getLiveTrackData")
    fun getLiveTrackData(@Query("vehicleList") vehicleList: List<String>): Observable<LiveTrackResponse>
}