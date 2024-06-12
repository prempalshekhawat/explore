package com.prempal.explore.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.prempal.explore.R
import com.prempal.explore.databinding.FragmentExploreBinding
import com.prempal.explore.ui.adpaters.ExploreViewPagerAdapter

class ExploreFragment : Fragment() {

    private lateinit var binding: FragmentExploreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentExploreBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //region setting up Tab Layout & ViewPager 2
        binding.exploreViewPager.adapter = ExploreViewPagerAdapter(this)
        TabLayoutMediator(binding.expploreTabLayout, binding.exploreViewPager) { tab, position ->

            when (position) {
                0 -> tab.text = "Personal"
                1 -> tab.text = "Services"
                2 -> tab.text = "Businesses"
            }

        }.attach()
        //endregion

    }

}