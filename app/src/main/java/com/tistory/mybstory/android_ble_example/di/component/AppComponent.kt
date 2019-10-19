package com.tistory.mybstory.android_ble_example.di.component

import android.app.Application
import com.tistory.mybstory.android_ble_example.App
import com.tistory.mybstory.android_ble_example.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ActivityBindingModule::class, FragmentBindingModule::class,
    ViewModelModule::class, BleModule::class, AndroidSupportInjectionModule::class])
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}