package com.tistory.mybstory.android_ble_example.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.navGraphViewModels
import com.tistory.mybstory.android_ble_example.R
import com.tistory.mybstory.android_ble_example.base.ui.BaseFragment
import com.tistory.mybstory.android_ble_example.base.ui.ViewModelFactory
import com.tistory.mybstory.android_ble_example.databinding.FragmentHomeBinding
import javax.inject.Inject

class HomeFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    val viewModel by navGraphViewModels<HomeViewModel>(R.id.nav_main) { viewModelFactory }
    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }




}