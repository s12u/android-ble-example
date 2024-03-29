package com.tistory.mybstory.android_ble_example.ui.scan

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.polidea.rxandroidble2.RxBleClient
import com.polidea.rxandroidble2.scan.ScanResult
import com.polidea.rxandroidble2.scan.ScanSettings
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ScanViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var bleClient: RxBleClient
    val scanStatus: ObservableBoolean = ObservableBoolean(false)

    fun scanDevices(): Observable<ScanResult> =
        bleClient.scanBleDevices(
            ScanSettings.Builder()
                .setScanMode(ScanSettings.SCAN_MODE_LOW_POWER)
                .setCallbackType(ScanSettings.CALLBACK_TYPE_ALL_MATCHES)
                .build()
//            , ScanFilter.Builder().build()
        ).takeUntil(Observable.timer(10, TimeUnit.SECONDS))
            .doOnSubscribe {
                scanStatus.set(true)
            }
            .doOnComplete {
                scanStatus.set(false)
            }

    fun test() {

    }
}