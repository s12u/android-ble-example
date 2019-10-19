package com.tistory.mybstory.android_ble_example.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tistory.mybstory.android_ble_example.base.ui.ViewModelFactory
import com.tistory.mybstory.android_ble_example.di.scope.ViewModelKey
import com.tistory.mybstory.android_ble_example.ui.home.HomeViewModel
import com.tistory.mybstory.android_ble_example.ui.scan.ScanViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ScanViewModel::class)
    abstract fun bindScanViewModel(viewModel: ScanViewModel): ViewModel

}