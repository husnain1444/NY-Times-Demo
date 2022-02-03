package com.test.ny.viewmodel

import com.test.ny.network.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    suspend fun getAllSections() = retrofitService.getAllSections()

}