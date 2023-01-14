package com.vb.mvvmapi.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vb.mvvmapi.Model.DataCountry
import com.vb.mvvmapi.Model.DataCountryItem
import com.vb.mvvmapi.R
import com.vb.mvvmapi.WebView
import kotlinx.android.synthetic.main.item_list.view.*

class MyAdapter(val context: Context,val countrylist:ArrayList<DataCountryItem>):RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    var ct= mutableListOf<DataCountryItem>()
   fun newlist(ct:List<DataCountryItem>){
       countrylist.clear()
       countrylist.addAll(ct)
       notifyDataSetChanged()
   }


    inner class ViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){

        val alpha_two_code:TextView
        val country:TextView
        val domains:TextView
        val name:TextView
         val card:CardView


        init {

            alpha_two_code=itemview.tv_alpha_two_code
            country=itemview.tv_country
            domains=itemview.tv_domains
            name=itemview.tv_name
             card=itemview.card_view


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val rootview=LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)

        return ViewHolder(rootview)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.alpha_two_code.text=(countrylist.get(position).alpha_two_code)
        holder.country.text=(countrylist.get(position).country)
        holder.domains.text=(countrylist.get(position).domains).toString()
        holder.name.text=(countrylist.get(position).name)

        val imagelink=(countrylist.get(position).web_pages)

//        val myLInk = imagelink.drop(1).dropLast(1)
//
//        Glide.with(context).load("https://png.pngtree.com/png-clipart/20211121/original/pngtree-university-logo-png-image_6950962.png").into(holder.imageView)




        holder.card.setOnClickListener {

            val link=(countrylist.get(position).web_pages)
            val univercity=(countrylist.get(position).name)

            val intent=Intent(context,WebView::class.java)
            intent.putExtra("LINK",link.toString())
            intent.putExtra("UNIVERCITY",univercity)
            context.startActivity(intent)


        }

    }

    override fun getItemCount(): Int {

        return countrylist.size
    }
}