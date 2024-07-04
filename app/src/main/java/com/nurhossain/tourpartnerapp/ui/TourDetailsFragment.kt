package com.nurhossain.tourpartnerapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nurhossain.tourpartnerapp.R
import com.nurhossain.tourpartnerapp.databinding.FragmentTourDetailsragmentBinding

class TourDetailsFragment : Fragment() {
    private lateinit var binding: FragmentTourDetailsragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTourDetailsragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}