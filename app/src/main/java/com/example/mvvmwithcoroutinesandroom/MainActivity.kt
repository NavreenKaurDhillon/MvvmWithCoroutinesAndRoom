package com.example.mvvmwithcoroutinesandroom

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.coroutineScope

class MainActivity : AppCompatActivity() {
    lateinit var quoteViewModel: QuoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dao = QuoteDatabase.getInstance(applicationContext).quoteDao()
        val quoteRepository = QuoteRepository(dao)
        val factory = MainViewModelFactory(quoteRepository)
        quoteViewModel = ViewModelProvider(this, factory).get(QuoteViewModel::class.java)
        val quote1 = Quote(0, "Saturday", " next day to weekend")
        val quote2 = Quote(0, "sunday", " last day to weekend")
        quoteViewModel.insertQuote(quote1)
        quoteViewModel.insertQuote(quote2)
        quoteViewModel.getQuotesList().observe(this, Observer {
            Log.d(TAG, "onCreate: /// got list = " + it)
        })
    }
}