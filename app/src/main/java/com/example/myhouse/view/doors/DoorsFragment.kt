package com.example.myhouse.view.doors

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myhouse.R
import com.example.myhouse.databinding.FragmentDoorsBinding
import com.example.myhouse.model.DataDoors


class DoorsFragment : Fragment() {

    private var _binding: FragmentDoorsBinding? = null
    val binding: FragmentDoorsBinding
        get() {
            return _binding!!
        }



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

        val data = listOf(
            DataDoors("Door1","Earth",1,true, "2"),
            DataDoors("Door2","Earth",1,true, "2"),
            DataDoors("Door3","Earth",1,true, "2"),
            DataDoors("Door4","Earth",1,true, "2"),
        )
        binding.doorsRecyclerView.adapter = DoorsAdapter(
            object : OnListItemClickListner {
                override fun onItemClick(dataDoors: DataDoors) {
                    Log.d("AAA", "Click")
                }
            }, data)
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