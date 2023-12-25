package com.saurabh.mynews.di

import android.app.Application
import com.saurabh.mynews.data.LocalUserManagerImpl
import com.saurabh.mynews.data.remote.dto.NewsApi
import com.saurabh.mynews.data.repository.NewsRepositoryImpl
import com.saurabh.mynews.domain.manager.LocalUserManager
import com.saurabh.mynews.domain.repository.NewsRepository
import com.saurabh.mynews.domain.usecases.app_entry.AppEntryUseCases
import com.saurabh.mynews.domain.usecases.app_entry.ReadAppEntry
import com.saurabh.mynews.domain.usecases.app_entry.SaveAppEntry
import com.saurabh.mynews.domain.usecases.news.GetNews
import com.saurabh.mynews.domain.usecases.news.NewsUseCases
import com.saurabh.mynews.domain.usecases.news.SearchNews
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application): LocalUserManager =
        LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(localUserManager: LocalUserManager) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository {
        return NewsRepositoryImpl(newsApi)
    }

    @Provides
    @Singleton
    fun provideNewsUseCase(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository)
        )
    }
}