package com.nurhossain.tourpartnerapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel : ViewModel() {
    enum class AuthenticationStatus {
        AUTHENTICATED, UNAUTHENTICATED
    }

    private val auth = FirebaseAuth.getInstance()
    var user = auth.currentUser

    var errMsgLiveData: MutableLiveData<String> = MutableLiveData()
    val authStatusLiveData: MutableLiveData<AuthenticationStatus> = MutableLiveData()

    init {
        user?.let {
            authStatusLiveData.postValue(AuthenticationStatus.AUTHENTICATED)
        } ?: authStatusLiveData.postValue(AuthenticationStatus.UNAUTHENTICATED)

    }

    fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    authStatusLiveData.postValue(AuthenticationStatus.AUTHENTICATED)
                }
            }.addOnFailureListener {
                errMsgLiveData.value = it.localizedMessage
            }
    }

    fun register(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    authStatusLiveData.postValue(AuthenticationStatus.AUTHENTICATED)
                }
            }.addOnFailureListener {
                errMsgLiveData.value = it.localizedMessage
            }
    }

    fun isUserValid() = false

    fun sendVerificationMail() {

    }

    fun logout() {

    }
}