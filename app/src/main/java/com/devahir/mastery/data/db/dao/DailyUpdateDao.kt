package com.devahir.mastery.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.devahir.mastery.data.db.model.DailyUpdate
import io.reactivex.Observable

@Dao
interface DailyUpdateDao : BaseDao<DailyUpdate> {
    @Query("Select * from DailyUpdate")
    fun getAll(): Observable<List<DailyUpdate>>

    @Query("Select * from DailyUpdate where updateId IN (:dailyUpdateId)")
    fun getDailyUpdateById(dailyUpdateId: String): DailyUpdate

}