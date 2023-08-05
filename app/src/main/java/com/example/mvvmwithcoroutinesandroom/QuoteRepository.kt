package com.example.mvvmwithcoroutinesandroom

import androidx.lifecycle.LiveData

//repo talks with dao for operations
//call methods of dao from repo
//repo interacts with database for all operations
class QuoteRepository(val quotesDao: QuotesDao) {

    fun getQuotes() : LiveData<List<Quote>>{
        return quotesDao.getAllQuotes()
    }

    suspend fun insertNewQuote(quote: Quote)
    {
        quotesDao.insertNewQuote(quote)
    }
}