package com.mspurwa.taskbook.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.mspurwa.taskbook.data.local.AppDatabase
import com.mspurwa.taskbook.data.local.UserDao
import com.mspurwa.taskbook.data.repository.AuthRepository
import com.mspurwa.taskbook.data.repository.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Owner : Mandeep Singh
 * Package Name: com.mspurwa.taskbook.di
 * Project Name: TaskBook
 * Created At: Fri, 07 Jun 2024
 **/

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app, AppDatabase::class.java, "Taskbook"
        ).build()
    }

    @Provides
    @Singleton
    fun provideUserDao(myDb: AppDatabase): UserDao = myDb.UserDao()

    @Provides
    @Singleton
    fun provideAuthRepository(userDao: UserDao): AuthRepository = AuthRepositoryImpl(userDao)

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

}