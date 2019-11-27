package com.devahir.mastery.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.devahir.mastery.data.db.model.Question
import io.reactivex.Observable

@Dao
interface QuestionDao : BaseDao<Question> {
    @Query("Select * from Question")
    fun getAll(): List<Question>

    @Query("Select * from Question where id IN (:questionId)")
    fun getQuestionById(questionId: String): Question

}