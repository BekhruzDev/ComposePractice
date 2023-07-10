package com.example.szfirstapplication.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.szfirstapplication.data.daos.UniversityDao
import com.example.szfirstapplication.data.entities.University


@Database(entities = [University::class], version = 1, exportSchema = true)
abstract class MyDatabase:RoomDatabase()  {
    abstract fun universityDao():UniversityDao
}