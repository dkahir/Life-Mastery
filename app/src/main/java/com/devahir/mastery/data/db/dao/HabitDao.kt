package com.devahir.mastery.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.devahir.mastery.data.db.model.Habit
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface HabitDao : BaseDao<Habit> {
    @Query("Select * from Habit")
    fun getAll(): Observable<List<Habit>>

    @Query("Select * from Habit where habitId IN (:habitId)")
    fun getHabitById(habitId: String): Single<Habit>

}