package com.vb.mvvmapi

import android.app.ProgressDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.*
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vb.mvvmapi.Adapter.MyAdapter
import com.vb.mvvmapi.Model.DataCountryItem
import com.vb.mvvmapi.Repository.Repository_Country
import com.vb.mvvmapi.Retrofit.RetrofitInstance
import com.vb.mvvmapi.ViewModel.MainViewModel
import com.vb.mvvmapi.ViewModel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.serarch_item.view.*


@Suppress("UNUSED_EXPRESSION")
class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var  retrofitInstance:RetrofitInstance
    lateinit var recyclerView: RecyclerView
    lateinit var clist:ArrayList<DataCountryItem>
    lateinit var myAdapter: MyAdapter
    private lateinit var builder: AlertDialog.Builder
    private lateinit var dialog: AlertDialog
    lateinit var name:EditText
    val name1="India"
    lateinit var link:String
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clist=ArrayList<DataCountryItem>()
myAdapter= MyAdapter(this,clist)
viewModel=ViewModelProvider(this,ViewModelFactory(Repository_Country())).get(MainViewModel::class.java)

recyclerView=findViewById(R.id.re_cycle)
recyclerView.apply {
    setHasFixedSize(true)
    layoutManager = LinearLayoutManager(this@MainActivity)
    adapter = myAdapter


    DisplayCountry(name1)
}
        supportActionBar?.title=("Top University and Institute")


        refresh.setOnClickListener {
            openDialog()
           // DisplayCountry(name1)
        }


    }


    private fun DisplayCountry(name:String) {

        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Loading please wait")
        progressDialog.setCancelable(false)
        //progressDialog.window?.setBackgroundDrawableResource(R.color.transferent)
        progressDialog.show()

        viewModel.countrylist.observe(this, Observer {

            Log.d("Hi","onCreate;$it")
            myAdapter.newlist(it)

            if (it.isEmpty()){
                Toast.makeText(applicationContext, "Data Not Found", Toast.LENGTH_SHORT).show()
            }
            if (progressDialog.isShowing)progressDialog.dismiss()
        })
        if (progressDialog.isShowing)progressDialog.dismiss()
        viewModel.error.observe(this, Observer {

        })
        viewModel.getcoungtryall(name)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.item_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.search_id->{
//                openDialog()
                DisplayCountry(name1)
//                Toast.makeText(applicationContext, "hi", Toast.LENGTH_SHORT).show()

            }
        }

        return super.onOptionsItemSelected(item)
    }


    private fun openDialog() {
        val mCities = arrayOf("India", "Afghanistan",
            "Albania",
            "Algeria",
            "American Samoa",
            "Andorra",
            "Angola",
            "Anguilla",
            "Antarctica",
            "Antigua and Barbuda",
            "Argentina",
            "Armenia",
            "Aruba",
            "Australia",
            "Austria",
            "Azerbaijan",
            "Bahamas (the)",
            "Bahrain",
            "Bangladesh",
            "Barbados",
            "Belarus",
            "Belgium",
            "Belize",
            "Benin",
            "Bermuda",
            "Bhutan",
            "Bolivia (Plurinational State of)",
            "Bonaire, Sint Eustatius and Saba",
            "Bosnia and Herzegovina",
            "Botswana",
            "Bouvet Island",
            "Brazil",
            "British Indian Ocean Territory (the)",
            "Brunei Darussalam",
            "Bulgaria",
            "Burkina Faso",
            "Burundi",
            "Cabo Verde",
            "Cambodia",
            "Cameroon",
            "Canada",
            "Cayman Islands (the)",
            "Central African Republic (the)",
            "Chad",
            "Chile",
            "China",
            "Christmas Island",
            "Cocos (Keeling) Islands (the)",
            "Colombia",
            "Comoros (the)",
            "Congo (the Democratic Republic of the)",
            "Congo (the)",
            "Cook Islands (the)",
            "Costa Rica",
            "Croatia",
            "Cuba",
            "Curaçao",
            "Cyprus",
            "Czechia",
            "Côte d'Ivoire",
            "Denmark",
            "Djibouti",
            "Dominica",
            "Dominican Republic (the)",
            "Ecuador",
            "Egypt",
            "El Salvador",
            "Equatorial Guinea",
            "Eritrea",
            "Estonia",
            "Eswatini",
            "Ethiopia",
            "Falkland Islands (the) [Malvinas]",
            "Faroe Islands (the)",
            "Fiji",
            "Finland",
            "France",
            "French Guiana",
            "French Polynesia",
            "French Southern Territories (the)",
            "Gabon",
            "Gambia (the)",
            "Georgia",
            "Germany",
            "Ghana",
            "Gibraltar",
            "Greece",
            "Greenland",
            "Grenada",
            "Guadeloupe",
            "Guam",
            "Guatemala",
            "Guernsey",
            "Guinea",
            "Guinea-Bissau",
            "Guyana",
            "Haiti",
            "Heard Island and McDonald Islands",
            "Holy See (the)",
            "Honduras",
            "Hong Kong",
            "Hungary",
            "Iceland",
            "India",
            "Indonesia",
            "Iran (Islamic Republic of)",
            "Iraq",
            "Ireland",
            "Isle of Man",
            "Israel",
            "Italy",
            "Jamaica",
            "Japan",
            "Jersey",
            "Jordan",
            "Kazakhstan",
            "Kenya",
            "Kiribati",
            "Korea (the Democratic People's Republic of)",
            "Korea (the Republic of)",
            "Kuwait",
            "Kyrgyzstan",
            "Lao People's Democratic Republic (the)",
            "Latvia",
            "Lebanon",
            "Lesotho",
            "Liberia",
            "Libya",
            "Liechtenstein",
            "Lithuania",
            "Luxembourg",
            "Macao",
            "Madagascar",
            "Malawi",
            "Malaysia",
            "Maldives",
            "Mali",
            "Malta",
            "Marshall Islands (the)",
            "Martinique",
            "Mauritania",
            "Mauritius",
            "Mayotte",
            "Mexico",
            "Micronesia (Federated States of)",
            "Moldova (the Republic of)",
            "Monaco",
            "Mongolia",
            "Montenegro",
            "Montserrat",
            "Morocco",
            "Mozambique",
            "Myanmar",
            "Namibia",
            "Nauru",
            "Nepal",
            "Netherlands (the)",
            "New Caledonia",
            "New Zealand",
            "Nicaragua",
            "Niger (the)",
            "Nigeria",
            "Niue",
            "Norfolk Island",
            "Northern Mariana Islands (the)",
            "Norway",
            "Oman",
            "Pakistan",
            "Palau",
            "Palestine, State of",
            "Panama",
            "Papua New Guinea",
            "Paraguay",
            "Peru",
            "Philippines (the)",
            "Pitcairn",
            "Poland",
            "Portugal",
            "Puerto Rico",
            "Qatar",
            "Republic of North Macedonia",
            "Romania",
            "Russian Federation (the)",
            "Rwanda",
            "Réunion",
            "Saint Barthélemy",
            "Saint Helena, Ascension and Tristan da Cunha",
            "Saint Kitts and Nevis",
            "Saint Lucia",
            "Saint Martin (French part)",
            "Saint Pierre and Miquelon",
            "Saint Vincent and the Grenadines",
            "Samoa",
            "San Marino",
            "Sao Tome and Principe",
            "Saudi Arabia",
            "Senegal",
            "Serbia",
            "Seychelles",
            "Sierra Leone",
            "Singapore",
            "Sint Maarten (Dutch part)",
            "Slovakia",
            "Slovenia",
            "Solomon Islands",
            "Somalia",
            "South Africa",
            "South Georgia and the South Sandwich Islands",
            "South Sudan",
            "Spain",
            "Sri Lanka",
            "Sudan (the)",
            "Suriname",
            "Svalbard and Jan Mayen",
            "Sweden",
            "Switzerland",
            "Syrian Arab Republic",
            "Taiwan",
            "Tajikistan",
            "Tanzania, United Republic of",
            "Thailand",
            "Timor-Leste",
            "Togo",
            "Tokelau",
            "Tonga",
            "Trinidad and Tobago",
            "Tunisia",
            "Turkey",
            "Turkmenistan",
            "Turks and Caicos Islands (the)",
            "Tuvalu",
            "Uganda",
            "Ukraine",
            "United Arab Emirates (the)",
            "United Kingdom of Great Britain and Northern Ireland (the)",
            "United States Minor Outlying Islands (the)",
            "United States of America (the)",
            "Uruguay",
            "Uzbekistan",
            "Vanuatu",
            "Venezuela (Bolivarian Republic of)",
            "Viet Nam",
            "Virgin Islands (British)",
            "Virgin Islands (U.S.)",
            "Wallis and Futuna",
            "Western Sahara",
            "Yemen",
            "Zambia",
            "Zimbabwe",
            "Åland Islands")
        val mArrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, mCities)


        builder=AlertDialog.Builder(this)
        var itemView: View = LayoutInflater.from(applicationContext).inflate(R.layout.serarch_item,null)

        dialog=builder.create()
        dialog.setView(itemView)
         name=itemView.et_search_country
        val listserch=itemView.list_search_item
        val  searchbtn=itemView.Serch_country_btn
        val closetab=itemView.close_btn

        listserch.visibility=View.VISIBLE
        listserch.adapter=mArrayAdapter

        val window: Window? = dialog.getWindow()
        val wlp: WindowManager.LayoutParams = window!!.getAttributes()

        wlp.gravity = Gravity.TOP
        wlp.flags = wlp.flags and WindowManager.LayoutParams.FLAG_DIM_BEHIND.inv()
        window.setAttributes(wlp)
        searchbtn.setOnClickListener {
            link=name.text.toString()
            DisplayCountry(link)
            dialog.dismiss()
        }

        closetab.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()

        listserch.onItemClickListener=object :OnItemClickListener{
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val itemValue = listserch.getItemAtPosition(id.toInt()) as String

                name.setText("$itemValue")
            }

        }
        
    name.addTextChangedListener(object: TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            // Do Nothing
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            mArrayAdapter.filter.filter(s)
        }

        override fun afterTextChanged(s: Editable?) {
            // Do Nothing
        }

    })
    }

   private fun selected_university(){
        val new:String

        new="All the best for your Futer university"

       Toast.makeText(applicationContext, "$new", Toast.LENGTH_SHORT).show()




    }
}