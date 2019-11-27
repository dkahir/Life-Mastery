package com.devahir.mastery.data.db.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = HabitCategory::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("categoryId")
    )]
)
data class Habit(
    @PrimaryKey val id: Int,
    val categoryId: Int,
    val index: Int,
    val name: String,
    val description: String,
    val isDeleted: Boolean,
    val promised: Boolean

)