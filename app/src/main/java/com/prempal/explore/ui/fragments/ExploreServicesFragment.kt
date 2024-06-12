package com.prempal.explore.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.prempal.explore.R
import com.prempal.explore.data.DummyResponse
import com.prempal.explore.databinding.FragmentExplorePersonalBinding
import com.prempal.explore.databinding.FragmentExploreServicesBinding
import com.prempal.explore.ui.adpaters.ExplorePersonalFragmentRvAdapter
import com.prempal.explore.ui.adpaters.ExploreServicesFragmentRvAdapter
import com.prempal.explore.ui.viewmodel.MainViewModel

class ExploreServicesFragment : Fragment() {

    private lateinit var binding: FragmentExploreServicesBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExploreServicesBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //region binding recycler view with adapter
        viewModel.servicesDummyResponse.observe(viewLifecycleOwner) { items ->
            val adapter = ExploreServicesFragmentRvAdapter(items)
            binding.exploreServicesRv.layoutManager = LinearLayoutManager(requireContext())
            binding.exploreServicesRv.adapter = adapter
        }
        //endregion

    }

}