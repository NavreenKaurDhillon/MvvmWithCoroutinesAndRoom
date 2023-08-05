package com.example.mvvmwithcoroutinesandroom

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class QuoteViewModel(val quoteRepository: QuoteRepository) : ViewModel() {

    private var quoteList = MutableLiveData<Quote>()
    val quotes : LiveData<Quote>
        get() = quoteList

    fun getQuotesList(): LiveData<List<Quote>> {
       val result = quoteRepository.getQuotes()
        return result
    }

     fun insertQuote(quote: Quote)
    {
        viewModelScope.launch {
            quoteRepository.insertNewQuote(quote)
        }
    }
}