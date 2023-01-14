package com.vb.mvvmapi.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vb.mvvmapi.Interface.ApiInterface
import com.vb.mvvmapi.Model.DataCountryItem
import com.vb.mvvmapi.Repository.Repository_Country
import com.vb.mvvmapi.Retrofit.RetrofitInstance
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainViewModel(val repositoryCountry: Repository_Country) :ViewModel() {

    val countrylist=MutableLiveData<List<DataCountryItem>>()
    val error=MutableLiveData<String>()



    fun getcoungtryall(name:String){

        repositoryCountry.getcountry().getdata(name).enqueue(object : Callback<List<DataCountryItem>?> {
            override fun onResponse(
                call: Call<List<DataCountryItem>?>,
                response: Response<List<DataCountryItem>?>
            ) {
                countrylist.postValue(response.body())
            }

            override fun onFailure(call: Call<List<DataCountryItem>?>, t: Throwable) {
                error.postValue(t.message)
            }
        })

    }





//
//    lateinit var coutrylist:List<DataCountryItem>
//
//
//    private var LiveData= MutableLiveData<List<DataCountryItem>>()
//
//    fun getCountry(){
//
//        RetrofitInstance.getRetroInstance().create(ApiInterface::class.java)
//            .getdata("India").enqueue(object : Callback<List<DataCountryItem>?> {
//                override fun onResponse(
//                    call: Call<List<DataCountryItem>?>,
//                    response: Response<List<DataCountryItem>?>
//                ) {
//                    if (response.body()!=null){
//                        coutrylist= response.body()!!
//                        //LiveData.value=response.body()!!
//                        LiveData.value=coutrylist
//
//
//
//                    }
//                }
//
//                override fun onFailure(call: Call<List<DataCountryItem>?>, t: Throwable) {
//                    Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show()
//
//                }
//            })
//    }
//
//    fun CountryLiveData():LiveData<List<DataCountryItem>>{
//        return LiveData
//    }
}