package com.tistory.mybstory.android_ble_example.di.module

import android.content.Context
import com.polidea.rxandroidble2.RxBleClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class BleModule {

    @Singleton
    @Provides
    fun provideBleClient(context: Context): RxBleClient = RxBleClient.create(context)


}