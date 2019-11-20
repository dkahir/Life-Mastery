package com.devahir.mastery.data.db.dao

import androidx.room.*
import com.devahir.mastery.data.db.model.Reminder
import io.reactivex.Observable

@Dao
interface ReminderDao {
    @Query("Select * from Reminder")
    fun getAll(): Observable<List<Reminder>>

    @Query("Select * from Reminder where reminderId IN (:reminderId)")
    fun getReminderById(reminderId: String): Reminder

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg reminder: Reminder)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(reminder: Reminder)

    @Delete
    fun delete(user: Reminder)
}