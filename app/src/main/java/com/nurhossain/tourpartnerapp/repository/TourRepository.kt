package com.nurhossain.tourpartnerapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.nurhossain.tourpartnerapp.model.ExpenseModel
import com.nurhossain.tourpartnerapp.model.MomentModel
import com.nurhossain.tourpartnerapp.model.TourModel

class TourRepository {
    val db = Firebase.firestore

    fun addTour(tourModel: TourModel) {
        val docRef = db.collection(collection_tour).document()
        tourModel.id = docRef.id
        docRef.set(tourModel)
            .addOnSuccessListener {

            }.addOnFailureListener {

            }

    }

    fun updateTourStatus(id: String, status: Boolean) {

    }

    fun addExpense(expenseModel: ExpenseModel, tourId: String) {

    }

    fun addMoment(momentModel: MomentModel, tourId: String) {

    }

    fun getToursByUser(userId: String) : LiveData<List<TourModel>> {
        val tourListLiveData = MutableLiveData<List<TourModel>>()

        db.collection(collection_tour)
            .whereEqualTo("UserId",userId)
            .addSnapshotListener { value, error ->
                if (error != null){
                    return@addSnapshotListener
                }
                val  temp = ArrayList<TourModel>()
                for (doc in value!!){
                    temp.add(doc.toObject(TourModel::class.java))
                }
                tourListLiveData.postValue(temp)
            }

        return tourListLiveData
    }

    fun getTourById(tourId: String) : LiveData<TourModel> {
        val tourLiveData = MutableLiveData<TourModel>()

        return tourLiveData
    }

    fun getExpenses(tourId: String) : LiveData<List<ExpenseModel>> {
        val tourListLiveData = MutableLiveData<List<ExpenseModel>>()

        return tourListLiveData
    }

    fun getMoments(tourId: String) : LiveData<List<MomentModel>> {
        val tourListLiveData = MutableLiveData<List<MomentModel>>()

        return tourListLiveData
    }

    companion object {
        const val TAG = "db_error"
        const val collection_tour = "My Tours"
        const val collection_expense = "My Expenses"
        const val collection_photos = "My Photos"
    }
}