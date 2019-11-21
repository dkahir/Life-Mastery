package com.devahir.mastery.data.db.dao

import androidx.room.*
import com.devahir.mastery.data.db.model.Habit
import io.reactivex.Maybe
import io.reactivex.Observable

@Dao
interface HabitDao {
    @Query("Select * from Habit")
    fun getAll(): Observable<List<Habit>>

    @Query("Select * from Habit where habitId IN (:habitId)")
    fun getHabitById(habitId: String): Habit

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg habit: Habit): Maybe<Long>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(habit: Habit): Maybe<Long>

    @Delete
    fun delete(user: Habit): Maybe<Long>
}