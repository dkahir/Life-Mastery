package com.devahir.mastery.data.db.dao

import androidx.room.*
import com.devahir.mastery.data.db.model.DailyUpdate
import io.reactivex.Observable

@Dao
interface DailyUpdateDao {
    @Query("Select * from DailyUpdate")
    fun getAll(): Observable<List<DailyUpdate>>

    @Query("Select * from DailyUpdate where updateId IN (:dailyUpdateId)")
    fun getDailyUpdateById(dailyUpdateId: String): DailyUpdate

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg dailyUpdate: DailyUpdate)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(dailyUpdate: DailyUpdate)

    @Delete
    fun delete(user: DailyUpdate)
}