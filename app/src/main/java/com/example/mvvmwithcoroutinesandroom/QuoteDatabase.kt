package com.example.mvvmwithcoroutinesandroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


//link the datas
@Database(entities = [Quote::class] , version = 1)
abstract class QuoteDatabase : RoomDatabase() {

    //implementation of methods of quotes Dao will be done here
    abstract fun quoteDao() : QuotesDao

    companion object{
        private var INSTANCE : QuoteDatabase?= null
        fun getInstance(context: Context) : QuoteDatabase {
            if (INSTANCE == null) {

                //synchronized block for multi threaded app
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context, QuoteDatabase::class.java
                    ,"quote_database").build()
                }
            }
            return INSTANCE!!
        }
    }


}