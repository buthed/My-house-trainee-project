package com.example.myhouse.view.cameras

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myhouse.databinding.FragmentCamerasBinding
import com.example.myhouse.model.Camera

class CamerasFragment : Fragment() {

    private var _binding: FragmentCamerasBinding? = null
    val binding: FragmentCamerasBinding
        get() {
            return _binding!!
        }

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

//        val data: MutableList<Camera> = ArrayList()
//        data.add(Camera("Camera 1","Earth","a",1, favorites = true, rec = true))
//        data.add(Camera("Camera 2","Earth","a",1, true,true))
//        data.add(Camera("Camera 3","Earth","a",1, true,true))
//        data.add(Camera("Camera 4","Earth","a",1, true,true))
//
//        val adapter = CamerasAdapter(
//            object : OnListItemClickListner {
//                override fun onItemClick(camera: Camera) {
//                    Log.d("AAA", "Click"+camera.name)
//                }
//            }, data)
//        binding.cameraRecyclerView.adapter = adapter
//        binding.cameraRecyclerView.setOnClickListener{
//            Log.d("AAA", "Click")
//        }

        val data = listOf(
            Camera("Camera 1","Earth","a",1, favorites = true, rec = true),
            Camera("Camera 2","Earth","a",1, favorites = true, rec = true),
            Camera("Camera 3","Earth","a",1, favorites = true, rec = true),
            Camera("Camera 4","Earth","a",1, favorites = true, rec = true)
        )
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