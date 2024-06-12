package com.prempal.explore.ui.adpaters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.prempal.explore.data.DummyResponse
import com.prempal.explore.databinding.ItemsExplorePersonalRvBinding

class ExplorePersonalFragmentRvAdapter(private val items: List<DummyResponse>) :
    RecyclerView.Adapter<ExplorePersonalFragmentRvAdapter.ExplorePersonalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExplorePersonalViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemsExplorePersonalRvBinding.inflate(inflater, parent, false)
        return ExplorePersonalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExplorePersonalViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ExplorePersonalViewHolder(private val binding: ItemsExplorePersonalRvBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DummyResponse) {

            binding.response = item
            binding.executePendingBindings()

        }
    }
}