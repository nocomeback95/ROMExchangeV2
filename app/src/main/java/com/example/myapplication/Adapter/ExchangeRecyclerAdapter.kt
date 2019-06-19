package com.example.myapplication.Adapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.myapplication.Model.ExchangeItem
import com.example.myapplication.R

class ExchangeRecyclerAdapter(private val list: List<ExchangeItem>) : RecyclerView.Adapter<ExchangeRecyclerAdapter.ExchangeViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ExchangeViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val view = layoutInflater.inflate(R.layout.exchange_item_view, p0, false)
        return ExchangeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(viewHolder: ExchangeViewHolder, position: Int) {
        val item: ExchangeItem = list[position]
        viewHolder.bind(item)
    }

    class ExchangeViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        private var globalPrice: TextView
        private var globalPercent: TextView
        private var seaPrice: TextView
        private var seaPercent: TextView
        private var itemName: TextView


        init {
            globalPrice = view.findViewById(R.id.global_price)
            globalPercent = view.findViewById(R.id.global_percent)

            seaPrice = view.findViewById(R.id.sea_price)
            seaPercent = view.findViewById(R.id.sea_percent)

            itemName = view.findViewById(R.id.name)
        }

        fun bind(item: ExchangeItem) {
            itemName.text = item.itemName

            globalPrice.text = item.globalItem?.latestPrice
            globalPercent.text = item.globalItem?.globalWeek?.priceChange

            seaPrice.text = item.seaItem?.latestPrice
            seaPercent.text = item.seaItem?.seaWeek?.priceChange
        }
    }
}

