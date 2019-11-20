package com.devahir.mastery.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.DayOfWeek
import java.util.*

@Entity
data class Reminder(
    @PrimaryKey(autoGenerate = true) val reminderId: Int,
    val time: Date
    //val frequency: List<DayOfWeek>

)