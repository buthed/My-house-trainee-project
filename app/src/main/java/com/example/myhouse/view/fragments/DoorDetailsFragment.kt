package com.example.myhouse.view.fragments

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.myhouse.R
import com.example.myhouse.app.App
import com.example.myhouse.base.view.BaseFragmentViewBinding
import com.example.myhouse.databinding.FragmentDoorDetailsBinding
import com.example.myhouse.model.rest.rest_entites.DoorDTO

class DoorDetailsFragment :
    BaseFragmentViewBinding<FragmentDoorDetailsBinding>(FragmentDoorDetailsBinding::inflate){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<DoorDTO>(BUNDLE_EXTRA)?.apply {
            doorBundle = this
        }
        renderData()
    }

    private fun renderData() = with(binding) {
        doorDetailsName.text = doorBundle?.name
        Glide
            .with(App.applicationContext())
            .load(doorBundle?.snapshot)
            .placeholder(R.drawable.photo_unavailable)
            .error(R.drawable.photo_unavailable)
            .into(doorDetailsSnapshot)
        doorDetailsBackButton.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }
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