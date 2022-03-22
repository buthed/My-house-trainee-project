package com.example.myhouse.view.doors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myhouse.databinding.FragmentDoorsBinding
import com.example.myhouse.model.AppStateCameras
import com.example.myhouse.model.AppStateDoors
import com.example.myhouse.viewmodel.DoorsViewModel

class DoorsFragment : Fragment() {

    private var _binding: FragmentDoorsBinding? = null
    val binding: FragmentDoorsBinding
        get() {
            return _binding!!
        }
    lateinit var viewModel: DoorsViewModel
    private val adapter: DoorsAdapter by lazy { DoorsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDoorsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DoorsViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner, Observer { renderData(it) })
        viewModel.getDoorsFromLocalSource()
    }

    private fun renderData(appStateDoors: AppStateDoors) {
        when (appStateDoors) {
            is AppStateDoors.Success -> {
                //adapter.setListener(this)
                binding.doorsRecyclerView.adapter = adapter
                adapter.setData(appStateDoors.doorsData)
            }
            is AppStateDoors.Loading -> {
                //TODO добавить загрузку?
            }
            is AppStateDoors.Error -> {

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(): DoorsFragment {
            return DoorsFragment()
        }
    }
}