package com.devahir.mastery.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
//Health Finance Default -- default will have common question,
//in future we can add more specific questions when category selected
data class HabitCategory(
    @PrimaryKey(autoGenerate = true) val categoryId: Int,
    val name: String,
    val description: String
)