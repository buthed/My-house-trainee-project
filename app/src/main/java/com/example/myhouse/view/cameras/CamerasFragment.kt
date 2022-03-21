package com.example.myhouse.view.cameras

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myhouse.databinding.FragmentCamerasBinding
import com.example.myhouse.model.Camera

class CamerasFragment : Fragment() {

    private var _binding: FragmentCamerasBinding? = null
    val binding: FragmentCamerasBinding
        get() {
            return _binding!!
        }
   // private val viewModel: CamerasViewModel by viewModel()
   // private val adapter: CamerasAdapter by lazy { CamerasAdapter() }

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

        val data = listOf(
            Camera("Camera 1","https://serverspace.ru/wp-content/uploads/2019/06/backup-i-snapshot.png","a",1, favorites = true, rec = false),
            Camera("Camera 2","Earth","a",1, favorites = false, rec = true),
            Camera("Camera 3","https://catherineasquithgallery.com/uploads/posts/2021-02/1612768484_140-p-fon-golubogo-morya-184.jpg","a",1, favorites = true, rec = false),
            Camera("Camera 4","Earth","a",1, favorites = false, rec = true)
        )
        binding.cameraRecyclerView.adapter = CamerasAdapter(
            object : OnListItemClickListner {
                override fun onItemClick(camera: Camera) {
                    Log.d("AAA", "Click")
                }
            }, data)
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        viewModel.getLiveData().observe(viewLifecycleOwner, {renderData(it)})
//        viewModel.getCamerasFromLocalSource()
//    }

//    private fun renderData(appStateCamera: AppStateCamera) = with(binding) {
//        when(appStateCamera){
//            is AppStateCamera.Success -> {
//                camerasFragmentLoadingLayout.visibility = View.GONE
//                cameraRecyclerView.adapter = adapter
//                adapter?.setCameras(appStateCamera.cameraData)
//            }
//            is AppStateCamera.Loading -> {
//              //  camerasFragmentLoadingLayout.visibility = View.VISIBLE
//            }
//            is AppStateCamera.Error -> {
//                camerasFragmentLoadingLayout.visibility = View.GONE
//            }
//
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val BUNDLE_EXTRA = "camera"

        fun newInstance(): CamerasFragment {
            return CamerasFragment()
        }
    }
}