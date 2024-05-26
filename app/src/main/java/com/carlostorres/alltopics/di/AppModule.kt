package com.carlostorres.alltopics.di

import com.carlostorres.alltopics.data.remote.ProductsRemoteDataSource
import com.carlostorres.alltopics.domain.ProductsRepository
import com.carlostorres.alltopics.domain.ProductsRepositoryImplementation
import com.carlostorres.alltopics.domain.ProductsService
import com.carlostorres.alltopics.utils.Constants.URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideProductService(
        retrofit : Retrofit
    ): ProductsService{

        return retrofit.create(ProductsService::class.java)

    }
    
    @Provides
    @Singleton
    fun provideProductRemoteDataSource(
        service : ProductsService
    ): ProductsRemoteDataSource{
        
        return ProductsRemoteDataSource(service = service)
        
    }

    @Provides
    @Singleton
    fun provideProductRepository(
        productRemoteDataSource : ProductsRemoteDataSource
    ): ProductsRepository{

        return ProductsRepositoryImplementation(remoteDataSource = productRemoteDataSource)

    }

}