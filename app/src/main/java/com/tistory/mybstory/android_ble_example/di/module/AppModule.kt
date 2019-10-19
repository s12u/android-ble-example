package com.tistory.mybstory.android_ble_example.di.module

import android.app.Application
import com.tistory.mybstory.android_ble_example.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideApplication(application: App): Application = application
}