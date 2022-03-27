package com.example.myhouse.view.doorDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myhouse.databinding.FragmentDoorDetailsBinding
import com.example.myhouse.model.rest.rest_entites.DoorDTO
import com.squareup.picasso.Picasso

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<DoorDTO>(BUNDLE_EXTRA)?.apply {
            doorBundle = this
        }
        renderData()
    }

    private fun renderData() = with(binding) {
        doorDetailsName.text = doorBundle?.name
        Picasso.get().load(doorBundle?.snapshot).into(doorDetailsSnapshot)
        doorDetailsBackButton.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    var doorBundle:DoorDTO? = null

    companion object {
        const val BUNDLE_EXTRA = "door"
        fun newInstance(bundle: Bundle): DoorDetailsFragment {
            val fragment = DoorDetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}