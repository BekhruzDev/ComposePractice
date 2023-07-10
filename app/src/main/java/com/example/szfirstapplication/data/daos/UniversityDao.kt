package com.example.szfirstapplication.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.szfirstapplication.data.entities.University
import kotlinx.coroutines.flow.Flow

/**DAO is just like an API*/
@Dao
interface UniversityDao {
    @Query("SELECT * FROM university")
    fun getUniversitiesList():Flow<List<University>>

    @Insert
    suspend fun addUniversity(university: University)
}