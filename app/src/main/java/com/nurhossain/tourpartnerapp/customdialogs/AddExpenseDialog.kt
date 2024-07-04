package com.nurhossain.tourpartnerapp.customdialogs

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.nurhossain.tourpartnerapp.R
import com.nurhossain.tourpartnerapp.model.ExpenseModel

class AddExpenseDialog(val callback: (ExpenseModel) -> Unit) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val layout = requireActivity().layoutInflater.inflate(R.layout.add_expense_layout, null)
        val builder = AlertDialog.Builder(requireActivity())
            .setTitle("Add Expense")
            .setView(layout)
            .setPositiveButton("Save") { dialog, which ->
                val titleET: EditText = layout.findViewById(R.id.addExpenseTitleET)
                val amountET: EditText = layout.findViewById(R.id.addExpenseAmountET)
                //please validate fields
                val expenseModel = ExpenseModel(
                    title = titleET.text.toString(),
                    amount = amountET.text.toString().toInt()
                )
                callback(expenseModel)
            }
            .setNegativeButton("Cancel", null)
        return builder.create()
    }
}