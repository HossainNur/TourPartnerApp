package com.nurhossain.tourpartnerapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nurhossain.tourpartnerapp.databinding.MomentRowBinding
import com.nurhossain.tourpartnerapp.model.MomentModel

class MomentAdapter : ListAdapter<MomentModel, MomentAdapter.MomentViewHolder>(MomentDiffCallback()){

    class MomentViewHolder(val binding: MomentRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(momentModel: MomentModel) {
            Glide.with(binding.root.context).load(momentModel.imageUrl)
                .into(binding.momentRowImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MomentViewHolder {
        val binding = MomentRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MomentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MomentViewHolder, position: Int) {
        val model = getItem(position)
        holder.bind(model)
    }
}

class MomentDiffCallback : DiffUtil.ItemCallback<MomentModel>() {
    override fun areItemsTheSame(oldItem: MomentModel, newItem: MomentModel): Boolean {
        return oldItem.momentId == newItem.momentId
    }

    override fun areContentsTheSame(oldItem: MomentModel, newItem: MomentModel): Boolean {
        return oldItem == newItem
    }

}