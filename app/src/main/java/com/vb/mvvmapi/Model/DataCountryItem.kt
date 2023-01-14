package com.vb.mvvmapi.Model

data class DataCountryItem(
    val alpha_two_code: String,
    val country: String,
    val domains: List<String>,
    val name: String,
    //val state-province:String,
    val web_pages: List<String>
)