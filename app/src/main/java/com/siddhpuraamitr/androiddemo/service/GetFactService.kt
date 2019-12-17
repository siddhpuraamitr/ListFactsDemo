package com.siddhpuraamitr.androiddemo.service

import com.siddhpuraamitr.androiddemo.model.Fact
import retrofit2.Call
import retrofit2.http.GET

interface GetFactService {

    @GET("s/2iodh4vg0eortkl/facts.json")
    fun getFact(): Call<Fact>

}