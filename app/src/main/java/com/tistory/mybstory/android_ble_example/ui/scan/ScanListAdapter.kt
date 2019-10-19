package com.tistory.mybstory.android_ble_example.ui.scan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.polidea.rxandroidble2.scan.ScanResult
import com.tistory.mybstory.android_ble_example.R
import com.tistory.mybstory.android_ble_example.databinding.ViewholderScanResultBinding
import timber.log.Timber

class ScanListAdapter : RecyclerView.Adapter<ScanResultViewHolder>() {

    private var inflater: LayoutInflater? = null
    private var scanResults = mutableListOf<ScanResult>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScanResultViewHolder {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.context)
        }
        val binding = DataBindingUtil.inflate<ViewholderScanResultBinding>(
            inflater!!,
            R.layout.viewholder_scan_result,
            parent, false
        )

        val viewHolder = ScanResultViewHolder(binding)

        binding.root.setOnClickListener {
            val data = scanResults[viewHolder.adapterPosition]
            Timber.e("${data.bleDevice.macAddress}")
        }

        return viewHolder
    }

    override fun getItemCount(): Int =
        scanResults.size


    override fun onBindViewHolder(holder: ScanResultViewHolder, position: Int) {
        holder.bind(scanResults[position])
    }

    fun addData(result: ScanResult) {
        val contains = scanResults.firstOrNull {
            it.bleDevice.macAddress == result.bleDevice.macAddress
        }
        if (contains == null) {
            scanResults.add(result)
            notifyItemRangeInserted(itemCount,1)
        }
    }
}