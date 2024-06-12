package com.prempal.explore.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.prempal.explore.R
import com.prempal.explore.databinding.FragmentStartUpBinding

class StartUpFragment : Fragment() {

    private lateinit var binding: FragmentStartUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartUpBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //this is a startup fragment containing buttons for explore fragment and refine fragment
        binding.exploreButton.setOnClickListener{
            findNavController().navigate(R.id.move_to_explore_fragment) // click to navigate to Explore fragment
        }

        binding.refineButton.setOnClickListener{
            findNavController().navigate(R.id.move_to_refine_fragment) // click to navigate to Refine fragment
        }

    }

}