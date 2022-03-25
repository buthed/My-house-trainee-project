package com.example.myhouse.view.doorDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myhouse.R
import com.example.myhouse.databinding.FragmentDoorDetailsBinding
import com.example.myhouse.databinding.FragmentDoorsBinding
import com.example.myhouse.view.doors.DoorsFragment

class DoorDetailsFragment : Fragment() {

    private var _binding: FragmentDoorDetailsBinding? = null
    val binding: FragmentDoorDetailsBinding
        get() {
            return _binding!!
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDoorDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(): DoorDetailsFragment {
            return DoorDetailsFragment()
        }
    }
}