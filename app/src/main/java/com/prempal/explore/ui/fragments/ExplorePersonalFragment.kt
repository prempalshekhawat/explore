package com.prempal.explore.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.prempal.explore.data.DummyResponse
import com.prempal.explore.databinding.FragmentExplorePersonalBinding
import com.prempal.explore.ui.adpaters.ExplorePersonalFragmentRvAdapter
import com.prempal.explore.ui.viewmodel.MainViewModel

class ExplorePersonalFragment : Fragment() {

    private lateinit var binding: FragmentExplorePersonalBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExplorePersonalBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //region binding recycler view with adapter
        viewModel.personalDummyResponse.observe(viewLifecycleOwner) { items ->
            val adapter = ExplorePersonalFragmentRvAdapter(items)
            binding.explorePersonalRv.layoutManager = LinearLayoutManager(requireContext())
            binding.explorePersonalRv.adapter = adapter
        }
        //endregion

    }
}