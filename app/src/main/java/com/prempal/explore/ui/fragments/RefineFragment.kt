package com.prempal.explore.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.chip.Chip
import com.prempal.explore.R
import com.prempal.explore.databinding.FragmentExploreBusinessesBinding
import com.prempal.explore.databinding.FragmentRefineBinding
import com.prempal.explore.databinding.RefineChoiceChipBinding
import com.prempal.explore.ui.viewmodel.MainViewModel

class RefineFragment : Fragment() {

    private lateinit var binding: FragmentRefineBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRefineBinding.inflate(layoutInflater)

        binding.lifecycleOwner = this  //binding lifecycleOwner
        binding.viewModel = viewModel //binding MainViewModel with DataBinding viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupChip()

        //whenever user enters a character this piece of code counts the number of characters and updates the count in textview
        binding.statusEt.doOnTextChanged { text, _, _, _ ->
            viewModel.checkForStatus(text.toString())

        }

        //region Spinner to show and select status from available options
        val spinnerAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, viewModel.dummyAvailabilityOptionitems)
        spinnerAdapter.setDropDownViewResource(R.layout.items_refine_spinner)
        binding.refineSpinner.adapter = spinnerAdapter

        binding.refineSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                viewModel.onStatusOptionItemSelected(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }
        //endregion

        //region save button
        binding.saveButton.setOnClickListener{
            findNavController().navigate(R.id.move_to_startup_fragment)
        }
        //endregion

    }

    //region setting purpose options
    private fun setupChip() {
        viewModel.purposeList.observe(viewLifecycleOwner) { chipItems ->
            binding.chipGroup.removeAllViews()
            chipItems.forEach { item ->
                val chip = createChip(item)
                binding.chipGroup.addView(chip)
            }
        }
    }

    private fun createChip(label: String): Chip {
        val chip = RefineChoiceChipBinding.inflate(layoutInflater).root
        chip.text = label
        return chip
    }
    //endregion

}