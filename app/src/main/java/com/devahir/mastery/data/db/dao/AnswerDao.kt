package com.devahir.mastery.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.devahir.mastery.data.db.model.Answer
import io.reactivex.Observable

@Dao
interface AnswerDao : BaseDao<Answer> {
    @Query("Select * from Answer")
    fun getAll(): Observable<List<Answer>>

    @Query("Select * from Answer where answerId IN (:answerId)")
    fun getAnswerById(answerId: String): Answer

}