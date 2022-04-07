package com.example.myhouse.view.fragments

import android.os.Bundle
import android.util.Log
import com.example.myhouse.R
import com.example.myhouse.base.view.BaseFragmentViewBindingViewModel
import com.example.myhouse.databinding.FragmentDoorsBinding
import com.example.myhouse.model.AppState
import com.example.myhouse.model.rest.rest_entites.DoorDTO
import com.example.myhouse.view.adapters.DoorsAdapter
import com.example.myhouse.view.clicklistners.DoorOnListItemClickListner
import com.example.myhouse.viewmodel.DoorsViewModel

class DoorsFragment
    : BaseFragmentViewBindingViewModel<FragmentDoorsBinding>(FragmentDoorsBinding::inflate, DoorsViewModel()) {

    private val adapter: DoorsAdapter =
        DoorsAdapter(object : DoorOnListItemClickListner {

            override fun onItemClickDoor(door: DoorDTO) {
                Log.d("NewFragment","Click"+door.name)
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.container, DoorDetailsFragment.newInstance(Bundle().apply {
                        putParcelable(DoorDetailsFragment.BUNDLE_EXTRA, door)
                    }))
                    ?.addToBackStack("")
                    ?.commitAllowingStateLoss()
            }
        })

    override fun renderData(appState: AppState) {
        when (appState) {
            is AppState.SuccessDoors -> {
                //adapter.setListener(this)
                adapter.setData(appState.doorsData)
                binding.doorsRecyclerView.adapter = adapter
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