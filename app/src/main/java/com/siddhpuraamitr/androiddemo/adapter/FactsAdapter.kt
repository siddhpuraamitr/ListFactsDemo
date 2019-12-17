package com.siddhpuraamitr.androiddemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import com.siddhpuraamitr.androiddemo.R
import com.siddhpuraamitr.androiddemo.databinding.FactItemBinding
import com.siddhpuraamitr.androiddemo.model.Rows


class FactsAdapter(private var context: Context, private var rows: ArrayList<Rows>) :
    BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        lateinit var factItemBinding: FactItemBinding
        var rowView: View? = convertView
        if (rowView == null) {
            rowView = LayoutInflater.from(context)
                .inflate(
                    R.layout.fact_item,
                    null
                )
            factItemBinding = DataBindingUtil.bind(rowView)!!
            rowView.tag = factItemBinding
        } else {
            factItemBinding = rowView.tag as FactItemBinding
        }

        factItemBinding.row = rows[position]
        return factItemBinding.root
    }

    override fun getItem(position: Int): Rows {
        return rows[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return rows.size
    }

}