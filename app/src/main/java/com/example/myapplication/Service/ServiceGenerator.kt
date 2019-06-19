package com.example.myapplication.Service

import com.example.myapplication.Contants
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class ServiceGenerator {
    companion object {
        fun getRetrofit(): Retrofit {
            val retrofit = Retrofit.Builder()
                .baseUrl(Contants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

            return retrofit
        }

        fun <T> createService(serviceClass: Class<T>): T {
            val retrofit = getRetrofit()
            return retrofit.create(serviceClass)
        }
    }
}