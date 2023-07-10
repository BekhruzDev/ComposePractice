package com.example.szfirstapplication.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "university")
data class University(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val ranking:Int
)
