package com.vinay.jetpack_datastore_with_mvvm.dagger_hilt

import android.content.Context
import com.vinay.jetpack_datastore_with_mvvm.data_store.DSRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by vinaymishra on 27,March,2022
 */
@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Singleton
    @Provides
    fun provideDataStoreRepository(@ApplicationContext context: Context)= DSRepository(context)
}