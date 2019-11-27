package com.devahir.mastery.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Habit(
    @PrimaryKey(autoGenerate = true) val habitId: Int,
    val categoryId: Int,
    val index: Int,
    val name: String,
    val description: String,
    val isDeleted: Boolean,
    val promised: Boolean

)