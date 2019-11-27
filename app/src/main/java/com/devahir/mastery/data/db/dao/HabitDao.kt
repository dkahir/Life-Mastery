package com.devahir.mastery.data.db.dao

import androidx.room.*
import com.devahir.mastery.data.db.model.Habit
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface HabitDao {
    @Query("Select * from Habit")
    fun getAll(): Observable<List<Habit>>

    @Query("Select * from Habit where habitId IN (:habitId)")
    fun getHabitById(habitId: String): Single<Habit>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg habit: Habit): List<Long>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(habit: Habit): Maybe<Int>

    @Delete
    fun delete(user: Habit): Maybe<Int>
}