package com.devahir.mastery.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Question(
    @PrimaryKey val id: Int,
    val question: String,
    val hint: String,
    val category: String, /// Reminder -- Time Place selection Every Category should have a component to draw.
    val explanation: String,
    val answerMaxLines: Int,
    val isRequired: Boolean,
    val isDeleted: Boolean
)