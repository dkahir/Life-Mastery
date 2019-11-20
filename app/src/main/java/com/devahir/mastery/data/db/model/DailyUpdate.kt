package com.devahir.mastery.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class DailyUpdate(
    @PrimaryKey(autoGenerate = true) val updateId: Int,
    val isDone: Boolean,
    val isNotDone: Boolean,
    val date: Date

)