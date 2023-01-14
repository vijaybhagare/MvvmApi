package com.vb.mvvmapi.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vb.mvvmapi.Model.DataCountry
import com.vb.mvvmapi.Model.DataCountryItem
import com.vb.mvvmapi.Repository.Repository_Country

class ViewModelFactory(private val repositoryCountry: Repository_Country):ViewModelProvider.Factory {
     override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            MainViewModel(this.repositoryCountry) as T
        }else
        {
            throw java.lang.IllegalArgumentException("View model not found")
        }
    }
}