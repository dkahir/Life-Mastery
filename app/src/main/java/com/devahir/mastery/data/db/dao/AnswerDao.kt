package com.devahir.mastery.data.db.dao

import androidx.room.*
import com.devahir.mastery.data.db.model.Answer
import io.reactivex.Observable

@Dao
interface AnswerDao {
    @Query("Select * from Answer")
    fun getAll(): Observable<List<Answer>>

    @Query("Select * from Answer where answerId IN (:answerId)")
    fun getAnswerById(answerId: String): Answer

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg answer: Answer)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(answer: Answer)

    @Delete
    fun delete(user: Answer)
}