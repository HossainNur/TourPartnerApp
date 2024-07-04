package com.nurhossain.tourpartnerapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.nurhossain.tourpartnerapp.R
import com.nurhossain.tourpartnerapp.adapters.TourAdapter
import com.nurhossain.tourpartnerapp.databinding.FragmentTourBinding
import com.nurhossain.tourpartnerapp.viewmodels.LoginViewModel
import com.nurhossain.tourpartnerapp.viewmodels.TourViewModel

class TourFragment : Fragment() {

    private lateinit var binding: FragmentTourBinding
    private val loginViewModel: LoginViewModel by viewModels()
    private val tourViewModel: TourViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTourBinding.inflate(inflater, container, false)
        val adapter = TourAdapter{id, action,status ->


        }
        binding.tourRecyclerview.layoutManager = LinearLayoutManager(activity)
        binding.tourRecyclerview.adapter = adapter

        tourViewModel.getToursByUser(loginViewModel.user!!.uid)
            .observe(viewLifecycleOwner){
                adapter.submitList(it)

            }
        binding.newTourFab.setOnClickListener {
            findNavController().navigate(R.id.newTourFragment)
        }
        return binding.root
    }
}