package id.co.maminfaruq.klinikhewan.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiClient {

    fun create() : ApiInterface{

        // TODO membuat object retrofit

        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://192.168.2.14/api_klinik/")
                .build()

        return retrofit.create(ApiInterface::class.java)
    }
}