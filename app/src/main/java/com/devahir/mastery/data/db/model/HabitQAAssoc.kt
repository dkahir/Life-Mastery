package com.devahir.mastery.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HabitQAAssoc(
    @PrimaryKey(autoGenerate = true) val habitQAAssocId: Int,
    val habitId: Int,
    val qaAssocId: Int
)