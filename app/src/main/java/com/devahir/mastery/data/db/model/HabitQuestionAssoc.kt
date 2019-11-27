package com.devahir.mastery.data.db.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = Habit::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("habitId")
    ), ForeignKey(
        entity = Question::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("questionId")
    )]
)
data class HabitQuestionAssoc(
    @PrimaryKey val id: Int,
    val habitId: Int,
    val questionId: Int,
    val showOnAdd: Boolean

)