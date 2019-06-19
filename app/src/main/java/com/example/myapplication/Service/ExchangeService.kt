package com.example.myapplication.Service

import com.example.myapplication.Model.ExchangeItem
import io.reactivex.Observable
import retrofit2.http.GET


interface ExchangeService {

    @GET("api")
    fun getExchangeListItem(): Observable<List<ExchangeItem>>
}