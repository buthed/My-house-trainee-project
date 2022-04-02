package com.example.myhouse.view.fragments

import com.example.myhouse.base.view.BaseFragmentViewBindingViewModel
import com.example.myhouse.databinding.FragmentCamerasBinding
import com.example.myhouse.model.AppState
import com.example.myhouse.view.adapters.CamerasAdapter
import com.example.myhouse.viewmodel.CamerasViewModel

class CamerasFragment
    : BaseFragmentViewBindingViewModel<FragmentCamerasBinding>(FragmentCamerasBinding::inflate, CamerasViewModel()) {

    private val adapter: CamerasAdapter by lazy { CamerasAdapter() }

    override fun renderData(appState: AppState) {
        when (appState) {
            is AppState.SuccessCameras -> {
                binding.cameraRecyclerView.adapter = adapter
                adapter.setData(appState.camerasData)
            }
            is AppState.Loading -> {
                //TODO добавить загрузку?
            }
            is AppState.Error -> {
                //TODO Обработку ошибок
            }
        }
    }
}