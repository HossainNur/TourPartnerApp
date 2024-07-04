package com.nurhossain.tourpartnerapp.customdialogs

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nurhossain.tourpartnerapp.R
import com.nurhossain.tourpartnerapp.adapters.MomentAdapter
import com.nurhossain.tourpartnerapp.model.MomentModel


class ShowMomentListDialog(val list: List<MomentModel>) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val layout = requireActivity().layoutInflater.inflate(R.layout.view_expense_layout, null)
        val recyclerView = layout.findViewById<RecyclerView>(R.id.expenseRV)
        recyclerView.layoutManager = GridLayoutManager(requireActivity(), 2)
        val adapter = MomentAdapter().apply {
            submitList(list)
        }
        recyclerView.adapter = adapter
        val builder = AlertDialog.Builder(requireActivity())
            .setTitle("My Moments")
            .setView(layout)
            .setNegativeButton("Close", null)
        return builder.create()
    }
}