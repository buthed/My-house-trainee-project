package com.example.myhouse.base.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.myhouse.base.viewmodel.BaseViewModel
import com.example.myhouse.model.AppState
import com.example.myhouse.view.fragments.DoorsFragment

abstract class BaseFragmentViewBindingViewModel<T : ViewBinding>(
    private val inflateBinding: (
        inflater: LayoutInflater, root: ViewGroup?, attachToRoot: Boolean
    ) -> T,
    private val viewModel1 : BaseViewModel
) : Fragment() {

    lateinit var viewModel: BaseViewModel
    private var _binding: T? = null

    protected val binding: T
        get() = _binding!!

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateBinding.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(viewModel1::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner, Observer { renderData(it) })
        viewModel.getDataFromServer()
    }

    abstract fun renderData(appState: AppState)

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