package com.nurhossain.tourpartnerapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.nurhossain.tourpartnerapp.R
import com.nurhossain.tourpartnerapp.databinding.FragmentTourBinding

class TourFragment : Fragment() {

    private lateinit var binding: FragmentTourBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTourBinding.inflate(inflater, container, false)
        binding.newTourFab.setOnClickListener {
            findNavController().navigate(R.id.newTourFragment)
        }
        return binding.root
    }
}