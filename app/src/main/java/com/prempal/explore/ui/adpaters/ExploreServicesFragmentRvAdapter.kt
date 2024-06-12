package com.prempal.explore.ui.adpaters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.prempal.explore.data.DummyResponse
import com.prempal.explore.databinding.ItemsExploreServicesBusinessesRvBinding

class ExploreServicesFragmentRvAdapter(private val items: List<DummyResponse>) :
    RecyclerView.Adapter<ExploreServicesFragmentRvAdapter.ExplorePersonalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExplorePersonalViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemsExploreServicesBusinessesRvBinding.inflate(inflater, parent, false)
        return ExplorePersonalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExplorePersonalViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ExplorePersonalViewHolder(private val binding: ItemsExploreServicesBusinessesRvBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DummyResponse) {
            binding.locationIv.visibility = View.INVISIBLE
            binding.occupationTv.visibility = View.GONE

            binding.response = item
            binding.executePendingBindings()
        }
    }
}