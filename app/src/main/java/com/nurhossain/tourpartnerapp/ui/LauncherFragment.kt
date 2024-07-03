package com.nurhossain.tourpartnerapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nurhossain.tourpartnerapp.R
import com.nurhossain.tourpartnerapp.viewmodels.LoginViewModel

class LauncherFragment : Fragment() {
    private val loginViewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginViewModel.authStatusLiveData.observe(viewLifecycleOwner){
            if (it == LoginViewModel.AuthenticationStatus.AUTHENTICATED){
                findNavController().navigate(R.id.tour_list_action)
            }else{
                findNavController().navigate(R.id.login_action)
            }

        }
        return inflater.inflate(R.layout.fragment_launcher, container, false)
    }
}