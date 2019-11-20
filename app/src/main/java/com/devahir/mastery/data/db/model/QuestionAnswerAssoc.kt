package com.devahir.mastery.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class QuestionAnswerAssoc(
    @PrimaryKey(autoGenerate = true) val questionAnswerId: Int,
    val questionId: Int,
    val answerId: Int
)