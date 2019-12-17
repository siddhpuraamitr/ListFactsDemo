package com.siddhpuraamitr.androiddemo.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.siddhpuraamitr.androiddemo.service.GetFactService
import com.siddhpuraamitr.androiddemo.service.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FactRepository {

    private val factService: GetFactService = RetrofitInstance.factService

    val factLiveData = MutableLiveData<Fact>()

    fun getMutableLiveData(): LiveData<Fact> {
        val call: Call<Fact> =
            factService.getFact()

        call.enqueue(object : Callback<Fact?> {
            override fun onResponse(
                call: Call<Fact?>,
                response: Response<Fact?>
            ) {

                val fact: Fact? = response.body()
                if (fact != null) {
                    factLiveData.value = fact
                }
            }

            override fun onFailure(
                call: Call<Fact?>,
                t: Throwable
            ) {
                //Empty
            }
        })
        return factLiveData
    }
}
