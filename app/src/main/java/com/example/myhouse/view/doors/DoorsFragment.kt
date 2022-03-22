package com.example.myhouse.view.doors

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myhouse.databinding.FragmentDoorsBinding
import com.example.myhouse.model.Door
import com.example.myhouse.viewmodel.DoorsViewModel

class DoorsFragment : Fragment() {

    private var _binding: FragmentDoorsBinding? = null
    val binding: FragmentDoorsBinding
        get() {
            return _binding!!
        }
    lateinit var viewModel: DoorsViewModel


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
        val data = viewModel.repository.getDoorsFromLocalStorage()
        binding.doorsRecyclerView.adapter = DoorsAdapter(
            object : OnListItemClickListner {
                override fun onItemClick(door: Door) {
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