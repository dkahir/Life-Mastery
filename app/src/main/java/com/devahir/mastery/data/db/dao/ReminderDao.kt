package com.devahir.mastery.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.devahir.mastery.data.db.model.Reminder
import io.reactivex.Observable

@Dao
interface ReminderDao : BaseDao<Reminder> {
    @Query("Select * from Reminder")
    fun getAll(): Observable<List<Reminder>>

    @Query("Select * from Reminder where reminderId IN (:reminderId)")
    fun getReminderById(reminderId: String): Reminder

}