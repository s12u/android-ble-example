package com.tistory.mybstory.android_ble_example.di.module

import com.tistory.mybstory.android_ble_example.di.scope.ActivityScope
import com.tistory.mybstory.android_ble_example.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [FragmentBindingModule::class])
    abstract fun bindMainActivity(): MainActivity
}