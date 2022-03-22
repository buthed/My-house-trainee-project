package com.example.myhouse.view.cameras

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myhouse.databinding.FragmentCamerasBinding
import com.example.myhouse.model.Camera
import com.example.myhouse.viewmodel.CamerasViewModel

class CamerasFragment : Fragment() {

    private var _binding: FragmentCamerasBinding? = null
    val binding: FragmentCamerasBinding
        get() {
            return _binding!!
        }
    lateinit var viewModel: CamerasViewModel


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
        val data = viewModel.repository.getCamerasFromLocalStorage()
        binding.cameraRecyclerView.adapter = CamerasAdapter(
            object : OnListItemClickListner {
                override fun onItemClick(camera: Camera) {
                    Log.d("AAA", "Click")
                }
            }, data)
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