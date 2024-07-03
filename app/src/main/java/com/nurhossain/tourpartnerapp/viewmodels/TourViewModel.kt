package com.nurhossain.tourpartnerapp.viewmodels

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import com.nurhossain.tourpartnerapp.model.ExpenseModel
import com.nurhossain.tourpartnerapp.model.TourModel
import com.nurhossain.tourpartnerapp.repository.TourRepository

class TourViewModel : ViewModel() {

    private val repository = TourRepository()

    fun addTour(tourModel: TourModel) {
        repository.addTour(tourModel)
    }

    fun updateTourStatus(id: String, status: Boolean) {
        repository.updateTourStatus(id, status)
    }

    fun addExpense(expenseModel: ExpenseModel, tourId: String) {
        repository.addExpense(expenseModel, tourId)
    }

    fun getToursByUser(userId: String) = repository.getToursByUser(userId)

    fun getTourById(tourId: String) = repository.getTourById(tourId)

    fun getAllExpense(tourId: String) = repository.getExpenses(tourId)

    fun getAllMoments(tourId: String) = repository.getMoments(tourId)

    fun getTotalExpense(list: List<ExpenseModel>) : Int {
        return 0
    }

    fun uploadPhoto(bitmap: Bitmap, tourId: String, tourName: String) {

    }

}