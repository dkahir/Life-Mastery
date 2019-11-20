package com.devahir.mastery.data.db.dao

import androidx.room.*
import com.devahir.mastery.data.db.model.Habit
import io.reactivex.Observable

@Dao
interface HabitDao {
    @Query("Select * from Habit")
    fun getAll(): Observable<List<Habit>>

    @Query("Select * from Habit where habitId IN (:habitId)")
    fun getHabitById(habitId: String): Habit

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg habit: Habit)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(habit: Habit)

    @Delete
    fun delete(user: Habit)
}