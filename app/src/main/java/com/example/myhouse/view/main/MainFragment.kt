package com.example.myhouse.view.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.myhouse.R
import com.example.myhouse.databinding.MainFragmentBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewPagerAdapter: MainViewPagerAdapter
    private lateinit var viewPager2: ViewPager2


    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewPagerAdapter = MainViewPagerAdapter(this)
        viewPager2 = binding.viewPager
        viewPager2.adapter = viewPagerAdapter
        val tabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout,viewPager2){tab,position->
            when(position){
                0->{  //TODO Переделать на ресурсы?
                    tab.text= "Камеры"
                }
                1->{
                    tab.text= "Двери"
                }
            }
        }.attach()
    }


//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

    companion object {

        fun newInstance() = MainFragment()
    }
}