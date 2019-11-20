package com.devahir.mastery.data.repository

import com.devahir.mastery.data.db.MasteryAppDatabase
import com.devahir.mastery.data.network.model.LiveTrackResponse
import com.devahir.mastery.data.network.track.LiveTrackApiHelper
import com.devahir.mastery.data.prefs.PreferencesHelper
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject

class HabitRepositoryImpl @Inject constructor(
    private val appDatabase: MasteryAppDatabase,
    private val preferencesHelper: PreferencesHelper,
    private val retrofit: Retrofit
) : HabitRepository {
    override fun getLiveTrackData(list: List<String>): Observable<LiveTrackResponse> {
        val liveTrackApiHelper = retrofit.create(LiveTrackApiHelper::class.java)
        return liveTrackApiHelper.getLiveTrackData(list)
    }
}