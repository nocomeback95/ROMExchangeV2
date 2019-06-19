package com.example.myapplication.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.Adapter.ExchangeRecyclerAdapter
import com.example.myapplication.CustomView.GridSpacingItemDecoration
import com.example.myapplication.Model.ExchangeItem
import com.example.myapplication.R
import com.example.myapplication.Service.ExchangeService
import com.example.myapplication.Service.ServiceGenerator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ExchangeFragment : Fragment() {

    val TAG = ExchangeFragment::class.java.simpleName
    private lateinit var recyclerView : RecyclerView
    private var exchangeList : ArrayList<ExchangeItem>? = null
    private var compositeDisposable: CompositeDisposable? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_exchange, container, false)

        recyclerView = view.findViewById(R.id.exchange_recylerview)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.addItemDecoration(GridSpacingItemDecoration(10, 2, true))
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val service = ServiceGenerator.createService(ExchangeService::class.java)
        compositeDisposable = CompositeDisposable()
        compositeDisposable?.add(service
            .getExchangeListItem()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(this::handleRespone))
    }

    fun handleRespone(itemList : List<ExchangeItem>) {
        exchangeList = ArrayList(itemList)
        recyclerView.apply {
            adapter = ExchangeRecyclerAdapter(exchangeList!!)
            recyclerView.adapter = adapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable?.clear()
    }
}

