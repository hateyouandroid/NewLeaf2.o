package com.example.newleaf2o

import addressData.MyData
import apiClient.ApiClient
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.newleaf2o.databinding.ActivityAddressBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddressActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAddressBinding
    private lateinit var db:ADDSQLiteHelper
    private lateinit var apiServices:ApiServices
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }
    private fun initView() {
        db= ADDSQLiteHelper (this)
          apiServices= ApiClient.getRetrofit().create(ApiServices::class.java)
          binding.btSave.setOnClickListener {
              val name=binding.etUsername.text.toString()
              val home=binding.etHomeNo.text.toString()
              val society=binding.etSociety.text.toString()
              val area=binding.etArea.text.toString()
              val landmark=binding.etLandmark.text.toString()
              val pin_code=binding.etPincode.text.toString()
              Data(name,home,society,area,landmark,pin_code)
             if(db.insertData(name, home,society, area, landmark, pin_code)){
                 Toast.makeText(this, "Record Stored", Toast.LENGTH_LONG).show()
             }
              else{
                 Toast.makeText(this, "Record does not Stored", Toast.LENGTH_LONG).show()

             }
          }
      }
      private fun Data(name: String,home: String,society:String,area:String,landmark:String,pin_code:String){
        val call=apiServices.addlist(name, home, society, area, landmark, pin_code)
        call.enqueue(object :Callback<MyData>
          {
              override fun onResponse(call: Call<MyData>, response: Response<MyData>) {
                  val loginData = response.body()
                  val status  = loginData?.status
                  if (status == "1")
                  {
                      Toast.makeText(this@AddressActivity, loginData?.message, Toast.LENGTH_SHORT).show()
                  }
                  else
                  {
                      Toast.makeText(this@AddressActivity, loginData?.message,Toast.LENGTH_SHORT).show()
                  }
              }
              override fun onFailure(call: Call<MyData>, t: Throwable) {
                  Toast.makeText(this@AddressActivity,"${t.message}",Toast.LENGTH_SHORT).show()
              }
          })
      }
}

private fun Unit.enqueue(callback: Callback<MyData>) {

}


