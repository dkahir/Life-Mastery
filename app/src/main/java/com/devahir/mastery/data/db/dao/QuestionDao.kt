package com.devahir.mastery.data.db.dao

import androidx.room.*
import com.devahir.mastery.data.db.model.Question
import io.reactivex.Observable

@Dao
interface QuestionDao {
    @Query("Select * from Question")
    fun getAll(): Observable<List<Question>>

    @Query("Select * from Question where questionId IN (:questionId)")
    fun getQuestionById(questionId: String): Question

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg question: Question)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(question: Question)

    @Delete
    fun delete(user: Question)
}