package com.example.anshulapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.anshulapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding : ActivityMainBinding
    var name =""
    var number=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding= DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.submitbtn.setOnClickListener(this)
       binding.clearbtn.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
      when(view?.id) {
          R.id.submitbtn-> {
              name = binding.name.editableText.toString()
              number = binding.number.editableText.toString()
              binding.txtname.text = name
              binding.txtname.visibility = View.VISIBLE
              binding.txtnumber.visibility = View.VISIBLE
              binding.clearbtn.visibility = View.VISIBLE
             val grpid=binding.radiogrp.checkedRadioButtonId
              if(grpid!=-1){
                  val selectedbtn=findViewById<RadioButton>(grpid)
                  val mytext=selectedbtn.text.toString()
                  binding.txtnumber.text=number+" " + mytext
              }

          }
          R.id.clearbtn->{
              binding.name.editableText.clear()
              binding.number.editableText.clear()
              binding.txtname.visibility=View.GONE
              binding.txtnumber.visibility=View.GONE
              binding.clearbtn.visibility=View.GONE

              val intent=Intent(this,NewActivity::class.java)
              startActivity(intent)
          }
      }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.name->Toast.makeText(this,"user name",Toast.LENGTH_LONG).show()
            R.id.batch->Toast.makeText(this,"user Btach",Toast.LENGTH_LONG).show()
            R.id.branch->Toast.makeText(this,"user batch",Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }
}