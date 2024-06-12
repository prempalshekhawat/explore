package com.prempal.explore.ui.adpaters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.prempal.explore.ui.fragments.ExploreBusinessesFragment
import com.prempal.explore.ui.fragments.ExplorePersonalFragment
import com.prempal.explore.ui.fragments.ExploreServicesFragment

class ExploreViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 3 // Number of tabs
    }

    override fun createFragment(position: Int): Fragment {
        // Return a new fragment instance for each position
        return when (position) {
            0 -> ExplorePersonalFragment()
            1 -> ExploreServicesFragment()
            2 -> ExploreBusinessesFragment()
            else -> ExplorePersonalFragment()
        }
    }
}