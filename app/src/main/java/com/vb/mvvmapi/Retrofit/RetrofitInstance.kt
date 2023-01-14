package com.vb.mvvmapi.Retrofit

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    val retrofitBuilder=Retrofit.Builder()

companion object{
    var gson=GsonBuilder()
        .setLenient()
        .create()

    fun getRetroInstance():Retrofit{

        val logging=HttpLoggingInterceptor()
        logging.level=HttpLoggingInterceptor.Level.BODY
        val client=OkHttpClient.Builder()
        client.addInterceptor(logging)

        return Retrofit.Builder()
            .baseUrl("http://universities.hipolabs.com/")
            .client(client.build())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    }
}
}