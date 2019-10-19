package com.tistory.mybstory.android_ble_example.di.module

import com.tistory.mybstory.android_ble_example.di.scope.FragmentScope
import com.tistory.mybstory.android_ble_example.ui.home.HomeFragment
import com.tistory.mybstory.android_ble_example.ui.scan.ScanFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @FragmentScope
    @ContributesAndroidInjector()
    abstract fun bindHomeFragment(): HomeFragment

    @FragmentScope
    @ContributesAndroidInjector()
    abstract fun bindScanFragment(): ScanFragment

}
