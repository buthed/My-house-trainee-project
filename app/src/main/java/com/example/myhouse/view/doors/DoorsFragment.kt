package com.example.myhouse.view.doors

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myhouse.R
import com.example.myhouse.databinding.FragmentDoorsBinding
import com.example.myhouse.model.AppStateDoors
import com.example.myhouse.model.rest.rest_entites.DoorDTO
import com.example.myhouse.utils.ViewBindingFragment
import com.example.myhouse.view.doorDetails.DoorDetailsFragment
import com.example.myhouse.viewmodel.DoorsViewModel

class DoorsFragment : ViewBindingFragment<FragmentDoorsBinding>(FragmentDoorsBinding::inflate) {

    lateinit var viewModel: DoorsViewModel
    private val adapter: DoorsAdapter =
        DoorsAdapter(object : OnListItemClickListner {

            override fun onItemClick(door: DoorDTO) {
                Log.d("NewFragment","CLicl"+door.name)
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.container, DoorDetailsFragment.newInstance(Bundle().apply {
                        putParcelable(DoorDetailsFragment.BUNDLE_EXTRA, door)
                    }))
                    ?.addToBackStack("")
                    ?.commitAllowingStateLoss()
            }
        })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DoorsViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner, Observer { renderData(it) })
        viewModel.getDoorsFromServer()
    }

    private fun renderData(appStateDoors: AppStateDoors) {
        when (appStateDoors) {
            is AppStateDoors.Success -> {
                //adapter.setListener(this)
                adapter.setData(appStateDoors.doorsData)
                binding.doorsRecyclerView.adapter = adapter
            }
            is AppStateDoors.Loading -> {
                //TODO добавить загрузку?
            }
            is AppStateDoors.Error -> {

            }
        }
    }

    companion object {
        fun newInstance(): DoorsFragment {
            return DoorsFragment()
        }
    }
}