package com.example.myhouse.view.cameras

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myhouse.databinding.FragmentCamerasBinding
import com.example.myhouse.model.AppStateCameras
import com.example.myhouse.viewmodel.CamerasViewModel

class CamerasFragment : Fragment() {

    private var _binding: FragmentCamerasBinding? = null
    val binding: FragmentCamerasBinding
        get() {
            return _binding!!
        }
    lateinit var viewModel: CamerasViewModel
    private val adapter: CamerasAdapter by lazy { CamerasAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCamerasBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(CamerasViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner, Observer { renderData(it) })
        viewModel.getCamerasFromLocalSource()
    }

    private fun renderData(appStateCameras: AppStateCameras) {
        when (appStateCameras) {
            is AppStateCameras.Success -> {
                //adapter.setListener(this)
                binding.cameraRecyclerView.adapter = adapter
                adapter.setData(appStateCameras.camerasData)
            }
            is AppStateCameras.Loading -> {
                //TODO добавить загрузку?
            }
            is AppStateCameras.Error -> {

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(): CamerasFragment {
            return CamerasFragment()
        }
    }
}