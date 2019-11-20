package com.devahir.mastery.data.network.track

import com.devahir.mastery.data.db.MasteryAppDatabase
import com.devahir.mastery.data.network.model.LiveTrackResponse
import com.devahir.mastery.data.prefs.PreferencesHelper
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject

class LiveTrackRepositoryImpl @Inject constructor(
    private val appDatabase: MasteryAppDatabase,
    private val preferencesHelper: PreferencesHelper,
    private val retrofit: Retrofit
) : LiveTrackRepository {
    override fun getLiveTrackData(list: List<String>): Observable<LiveTrackResponse> {
        val liveTrackApiHelper = retrofit.create(LiveTrackApiHelper::class.java)
        return liveTrackApiHelper.getLiveTrackData(list)
    }
}