package com.nurhossain.tourpartnerapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nurhossain.tourpartnerapp.R
import com.nurhossain.tourpartnerapp.databinding.FragmentNewTourBinding
import com.nurhossain.tourpartnerapp.model.TourModel
import com.nurhossain.tourpartnerapp.viewmodels.LoginViewModel
import com.nurhossain.tourpartnerapp.viewmodels.TourViewModel


class NewTourFragment : Fragment() {
    private lateinit var binding: FragmentNewTourBinding
    private val loginViewModel: LoginViewModel by viewModels()
    private val tourViewModel: TourViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewTourBinding.inflate(inflater, container, false)
        binding.createTourBtn.setOnClickListener {
            val title = binding.titleET.text.toString()
            val destination = binding.destinationET.text.toString()
            val budget = binding.budgetET.text.toString().toInt()

            val tourModel = TourModel(
                title = title,
                destination = destination,
                budget = budget,
                userId = loginViewModel.user?.uid
            )
            tourViewModel.addTour(tourModel)
            findNavController().popBackStack()
        }
        return binding.root
    }
}