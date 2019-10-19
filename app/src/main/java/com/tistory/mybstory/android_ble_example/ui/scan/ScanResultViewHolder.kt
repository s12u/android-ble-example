package com.tistory.mybstory.android_ble_example.ui.scan

import androidx.recyclerview.widget.RecyclerView
import com.polidea.rxandroidble2.scan.ScanResult
import com.tistory.mybstory.android_ble_example.databinding.ViewholderScanResultBinding

class ScanResultViewHolder (val binding: ViewholderScanResultBinding)
    : RecyclerView.ViewHolder(binding.root) {

    fun bind(result: ScanResult) {
        binding.result = result
    }

}