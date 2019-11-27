package com.devahir.mastery.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.devahir.mastery.data.db.model.Quote
import io.reactivex.Observable

@Dao
interface QuoteDao : BaseDao<Quote>{
    @Query("Select * from Quote")
    fun getAll(): Observable<List<Quote>>

    @Query("Select * from Quote where quoteId IN (:quoteId)")
    fun getQuoteById(quoteId: String): Quote

}