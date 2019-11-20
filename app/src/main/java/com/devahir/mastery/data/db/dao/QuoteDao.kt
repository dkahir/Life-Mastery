package com.devahir.mastery.data.db.dao

import androidx.room.*
import com.devahir.mastery.data.db.model.Quote
import io.reactivex.Observable

@Dao
interface QuoteDao {
    @Query("Select * from Quote")
    fun getAll(): Observable<List<Quote>>

    @Query("Select * from Quote where quoteId IN (:quoteId)")
    fun getQuoteById(quoteId: String): Quote

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg quote: Quote)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(quote: Quote)

    @Delete
    fun delete(user: Quote)    
}