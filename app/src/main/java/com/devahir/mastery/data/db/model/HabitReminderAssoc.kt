package com.devahir.mastery.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HabitReminderAssoc(
    @PrimaryKey(autoGenerate = true) val habitReminderAssocId: Int,
    val habitId: Int,
    val reminderId: Int

)