package com.example.szfirstapplication.data.repositories

import com.example.szfirstapplication.data.daos.UniversityDao
import com.example.szfirstapplication.data.entities.University
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UniversityRepository @Inject constructor(
    private val dao: UniversityDao
) {
    fun getUniversitiesList():Flow<List<University>> = dao.getUniversitiesList()

    suspend fun addUniversity(university: University) {
        dao.addUniversity(university)
    }
}