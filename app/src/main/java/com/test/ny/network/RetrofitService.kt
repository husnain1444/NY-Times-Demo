package com.test.ny.network

import com.test.ny.model.ReceiverModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("7.json?api-key=ZOuA7mZDpoIqZJY1jWcIieIDQ5L0CmKL")
    suspend fun getAllSections() : Response<ReceiverModel>
//    suspend fun getAllSections() : Response<List<Section>>

    companion object {
        var retrofitService: RetrofitService? = null
        fun getInstance() : RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }

    }
}