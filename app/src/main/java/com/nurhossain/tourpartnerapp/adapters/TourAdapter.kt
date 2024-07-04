package com.nurhossain.tourpartnerapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nurhossain.tourpartnerapp.databinding.TourRowBinding
import com.nurhossain.tourpartnerapp.model.TourModel
import com.nurhossain.tourpartnerapp.utils.details_screen
import com.nurhossain.tourpartnerapp.utils.tour_status_update


class TourAdapter(val callback: (id: String, action: String, status: Boolean) -> Unit) : ListAdapter<TourModel, TourAdapter.TourViewHolder>(TourDiffCallback()){
    private lateinit var binding: TourRowBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourViewHolder {
        binding = TourRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TourViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TourViewHolder, position: Int) {
        holder.bind(getItem(position))
        binding.tourRowItem.setOnClickListener {
            callback(getItem(position).id!!, details_screen, false)
        }
        binding.rowTourComplete.setOnClickListener {
            callback(getItem(position).id!!, tour_status_update, !getItem(position).isCompleted)
        }
    }
    class TourViewHolder(val binding: TourRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tourModel: TourModel) {
            binding.tourModel = tourModel
        }
    }

    class TourDiffCallback : DiffUtil.ItemCallback<TourModel>() {
        override fun areItemsTheSame(oldItem: TourModel, newItem: TourModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TourModel, newItem: TourModel): Boolean {
            return oldItem == newItem
        }

    }


}