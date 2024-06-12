package com.prempal.explore.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.prempal.explore.R
import com.prempal.explore.data.DummyResponse
import com.prempal.explore.databinding.FragmentExploreBusinessesBinding
import com.prempal.explore.databinding.FragmentExploreServicesBinding
import com.prempal.explore.ui.adpaters.ExploreBusinessesFragmentRvAdapter
import com.prempal.explore.ui.adpaters.ExplorePersonalFragmentRvAdapter
import com.prempal.explore.ui.viewmodel.MainViewModel

class ExploreBusinessesFragment : Fragment() {

    private lateinit var binding: FragmentExploreBusinessesBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExploreBusinessesBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //region binding recycler view with adapter
        viewModel.businessesDummyResponse.observe(viewLifecycleOwner) { items ->
            val adapter = ExploreBusinessesFragmentRvAdapter(items)
            binding.exploreBusinessesRv.layoutManager = LinearLayoutManager(requireContext())
            binding.exploreBusinessesRv.adapter = adapter
        }
        //endregion

    }


}