package com.example.receipt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.receipt.databinding.ActivityRegisterBinding
import com.example.receipt.registerFragmentActivity.*
import kotlinx.android.synthetic.main.activity_register.*
import org.json.JSONArray
import org.json.JSONObject



class Register : AppCompatActivity() {

    lateinit var binding : ActivityRegisterBinding
    lateinit var fruit: fruit //프레그먼트1
    lateinit var vage: vegeFragment  //프레그먼트2
    lateinit var meat: meatkFragment
    lateinit var seafood: seafoodFragment
    lateinit var bread : BreadFragment
    lateinit var nut: NutFragment
    lateinit var dairy_product:dairyProductkFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_register)
        setSupportActionBar(toolbar_regi) // 상단바

        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        fruit = fruit()
        vage = vegeFragment()
        meat = meatkFragment()
        seafood = seafoodFragment()
        bread = BreadFragment()
        nut = NutFragment()
        dairy_product = dairyProductkFragment()


        //supportFragmentManager.beginTransaction().add(R.id.category_FL, fruit).commit()
        fruit_cg.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.category_FL, fruit()).addToBackStack(null).commit()
        }
        vage_cg.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.category_FL, vegeFragment()).addToBackStack(null).commit()
        }
        meat_cg.setOnClickListener{
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.category_FL, meatkFragment()).addToBackStack(null).commit()
        }
        seafood_cg.setOnClickListener{
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.category_FL, seafoodFragment()).addToBackStack(null).commit()
        }
        bread_cg.setOnClickListener{
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.category_FL, BreadFragment()).addToBackStack(null).commit()
        }
        nuts_cg.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.category_FL, NutFragment()).addToBackStack(null).commit()
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            android.R.id.home -> {
                if(supportFragmentManager.backStackEntryCount>0){
                    supportFragmentManager.beginTransaction().remove(Fragment()).commit()
                    supportFragmentManager.popBackStack()
                }
                else{
                    finish()
                }
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }



}