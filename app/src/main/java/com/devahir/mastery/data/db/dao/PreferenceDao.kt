package com.devahir.mastery.data.db.dao

import androidx.room.*
import com.devahir.mastery.data.db.model.Preference
import io.reactivex.Observable

@Dao
interface PreferenceDao {
    @Query("Select * from Preference")
    fun getAll(): Observable<List<Preference>>

    @Query("Select * from Preference where preferenceId IN (:preferenceId)")
    fun getPreferenceById(preferenceId: String): Preference

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg preference: Preference)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(preference: Preference)

    @Delete
    fun delete(user: Preference)
}