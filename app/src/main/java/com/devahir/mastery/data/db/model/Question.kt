package com.devahir.mastery.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Question(
    @PrimaryKey(autoGenerate = true) val questionId: Int,
    val isDeleted: Boolean,
    val question: String,
    val hint: String,
    val category: Boolean
)