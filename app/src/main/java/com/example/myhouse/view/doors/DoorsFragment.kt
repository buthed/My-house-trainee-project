package com.example.myhouse.view.doors

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myhouse.R
import com.example.myhouse.databinding.FragmentDoorsBinding
import com.example.myhouse.model.AppStateDoors
import com.example.myhouse.model.rest.rest_entites.DoorDTO
import com.example.myhouse.view.doorDetails.DoorDetailsFragment
import com.example.myhouse.viewmodel.DoorsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DoorsFragment : Fragment() {

    private var _binding: FragmentDoorsBinding? = null
    val binding: FragmentDoorsBinding
        get() {
            return _binding!!
        }
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
        GlobalScope.launch(Dispatchers.IO) {         viewModel.getDoorsFromServer() }

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