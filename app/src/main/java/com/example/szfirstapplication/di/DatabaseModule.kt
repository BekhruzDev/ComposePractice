package com.example.szfirstapplication.di

import android.content.Context
import androidx.room.Room
import com.example.szfirstapplication.data.database.MyDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        MyDatabase::class.java,
        "my_database"
    ).createFromAsset("database/my_database.db").build()

    @Singleton
    @Provides
    fun provideDao(database: MyDatabase) = database.universityDao()


}