package com.example.mvvmwithcoroutinesandroom

import androidx.room.Entity
import androidx.room.PrimaryKey

//creates a table here with params of data class
@Entity( tableName = "quote")
data class Quote(
    @PrimaryKey (autoGenerate = true)
    val quoteno : Int,
    val title : String,
    val description : String
)