package com.example.mvvmwithcoroutinesandroom

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface QuotesDao {


    @Query("SELECT * from quote")
   fun getAllQuotes() : LiveData<List<Quote>> //no need to add suspend because already using Live data so will be executed on background thread

   @Insert
   suspend fun insertNewQuote(quote: Quote)
}