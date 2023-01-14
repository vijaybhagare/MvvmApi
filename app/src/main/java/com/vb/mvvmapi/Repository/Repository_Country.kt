package com.vb.mvvmapi.Repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vb.mvvmapi.Interface.ApiInterface
import com.vb.mvvmapi.Model.DataCountry
import com.vb.mvvmapi.Model.DataCountryItem
import com.vb.mvvmapi.Retrofit.RetrofitInstance
import kotlin.coroutines.CoroutineContext

class Repository_Country() {


    fun getcountry()=RetrofitInstance.getRetroInstance().create(ApiInterface::class.java)



}