package com.devahir.mastery.data.db.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = HabitCategory::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("categoryId")
    ), ForeignKey(
        entity = Question::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("questionId")
    )]
)
data class HabitCategoryQuestionAssoc(
    @PrimaryKey val id: Int,
    val categoryId: Int,
    val questionId: Int,
    val showOnAdd: Boolean

)