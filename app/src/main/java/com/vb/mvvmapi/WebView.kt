package com.vb.mvvmapi

import android.app.ProgressDialog
import android.app.TaskStackBuilder
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NavUtils
import kotlinx.android.synthetic.main.activity_web_view.*

class WebView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)



         val LINK=intent.getStringExtra("LINK").toString()
        val UnivercityName=intent.getStringExtra("UNIVERCITY")
        supportActionBar?.title="$UnivercityName"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Loading please wait")
        progressDialog.setCancelable(false)
        //progressDialog.window?.setBackgroundDrawableResource(R.color.transferent)
        progressDialog.show()


       // LINK?.replaceAfter("0","")?.replaceAfter("$LINK-1","")

        val myPiece = LINK.drop(1).dropLast(1)

        web_view.webViewClient = WebViewClient()


        web_view.loadUrl("$myPiece")

        //Toast.makeText(applicationContext, "$myPiece", Toast.LENGTH_SHORT).show()

        web_view.settings.javaScriptEnabled = true


        web_view.settings.setSupportZoom(true)



        if (progressDialog.isShowing)progressDialog.dismiss()
    }

    override fun onSupportNavigateUp(): Boolean {

        NavUtils.PARENT_ACTIVITY
//        startActivity(Intent(this,MainActivity::class.java))
//        finish()
        return super.onSupportNavigateUp()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        
        menuInflater.inflate(R.menu.select_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        
        when(item.itemId){
            R.id.select_university_menu->{

                Toast.makeText(applicationContext, "You select this University", Toast.LENGTH_SHORT).show()
            }
        }
        
        return super.onOptionsItemSelected(item)
    }
}