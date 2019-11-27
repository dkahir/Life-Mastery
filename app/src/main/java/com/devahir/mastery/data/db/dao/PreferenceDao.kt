package com.devahir.mastery.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.devahir.mastery.data.db.model.Preference
import io.reactivex.Observable

@Dao
interface PreferenceDao : BaseDao<Preference> {
    @Query("Select * from Preference")
    fun getAll(): Observable<List<Preference>>

    @Query("Select * from Preference where preferenceId IN (:preferenceId)")
    fun getPreferenceById(preferenceId: String): Preference

}