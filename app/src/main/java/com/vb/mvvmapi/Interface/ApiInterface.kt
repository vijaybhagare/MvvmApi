package com.vb.mvvmapi.Interface

import com.vb.mvvmapi.Model.DataCountry
import com.vb.mvvmapi.Model.DataCountryItem
import okhttp3.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("search")

    fun getdata(@Query("country") country:String):retrofit2.Call<List<DataCountryItem>>
}