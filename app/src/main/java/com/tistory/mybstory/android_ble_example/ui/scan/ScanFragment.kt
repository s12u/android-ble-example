package com.tistory.mybstory.android_ble_example.ui.scan

import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tistory.mybstory.android_ble_example.R
import com.tistory.mybstory.android_ble_example.base.ui.BaseFragment
import com.tistory.mybstory.android_ble_example.base.ui.ViewModelFactory
import com.tistory.mybstory.android_ble_example.databinding.FragmentScanBinding
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.EasyPermissions
import timber.log.Timber
import javax.inject.Inject

class ScanFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by viewModels<ScanViewModel> { viewModelFactory }
    private lateinit var binding: FragmentScanBinding

    private val disposables = CompositeDisposable()
    private lateinit var adapter: ScanListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_scan, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = ScanListAdapter()

        with(binding) {
            viewModel = this@ScanFragment.viewModel
            rvScanResult.layoutManager =
                LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            rvScanResult.adapter = this@ScanFragment.adapter
        }

        requestPermissions()
    }

    override fun onStop() {
        disposables.clear()
        super.onStop()
    }

    @AfterPermissionGranted(RC_BLE_AND_LOCATION)
    fun requestPermissions() {
        if (EasyPermissions.hasPermissions(context!!, *perms)) {
            disposables += viewModel.scanDevices().subscribe(
                {
                    // on next
                    adapter.addData(it)
                }, {
                    // error
                    Timber.e("${it.message}")
                }
            )
        } else {
            Timber.e("Permissions are not granted.")
            EasyPermissions.requestPermissions(this, getString(R.string.permission_ble_location),
                RC_BLE_AND_LOCATION, *perms);
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }


    companion object {
        const val RC_BLE_AND_LOCATION = 1
        val perms = arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.BLUETOOTH
            )
    }

}