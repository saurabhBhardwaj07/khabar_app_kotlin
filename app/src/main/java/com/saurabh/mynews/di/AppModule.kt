package com.saurabh.mynews.di

import android.app.Application
import androidx.room.Room
import com.saurabh.mynews.data.local.NewsDao
import com.saurabh.mynews.data.local.NewsDatabase
import com.saurabh.mynews.data.local.NewsTypeConverter
import com.saurabh.mynews.data.manager.LocalUserManagerImpl
import com.saurabh.mynews.data.remote.NewsApi
import com.saurabh.mynews.data.repository.NewsRepositoryImpl
import com.saurabh.mynews.domain.manager.LocalUserManager
import com.saurabh.mynews.domain.repository.NewsRepository
import com.saurabh.mynews.domain.usecases.app_entry.AppEntryUseCases
import com.saurabh.mynews.domain.usecases.app_entry.ReadAppEntry
import com.saurabh.mynews.domain.usecases.app_entry.SaveAppEntry
import com.saurabh.mynews.domain.usecases.news.DeleteArticle
import com.saurabh.mynews.domain.usecases.news.GetArticle
import com.saurabh.mynews.domain.usecases.news.GetNews
import com.saurabh.mynews.domain.usecases.news.GetNewsArticles
import com.saurabh.mynews.domain.usecases.news.NewsUseCases
import com.saurabh.mynews.domain.usecases.news.SearchNews
import com.saurabh.mynews.domain.usecases.news.UpsertArticle
import com.saurabh.mynews.util.Constants.BASE_URL
import com.saurabh.mynews.util.Constants.NEWS_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(NewsApi::class.java)
    }

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
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            getNewsArticles = GetNewsArticles(newsDao),
            getArticle = GetArticle(newsDao),
            upsertArticle = UpsertArticle(newsDao),
            deleteArticle = DeleteArticle(newsDao)
        )
    }

    @Provides
    @Singleton
    fun providedNewsDatabase(application: Application): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConverter()).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideNewsDao ( newsDatabase : NewsDatabase) : NewsDao = newsDatabase.newsDao
}


