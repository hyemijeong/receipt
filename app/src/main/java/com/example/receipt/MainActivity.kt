package com.example.receipt

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.receipt.mainFragmentActivity.ice_2
import com.example.receipt.mainFragmentActivity.refriger1
import com.example.receipt.mainFragmentActivity.roomtemp_3
import com.example.receipt.ocr.ListExtratActivity

import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),PopupMenu.OnMenuItemClickListener {


    lateinit var tab1: refriger1 //프레그먼트1
    lateinit var tab2: ice_2 //프레그먼트2
    lateinit var tab3: roomtemp_3 //프레그먼트3


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_main)

        supportActionBar?.setDisplayShowTitleEnabled(true)

        tab1 = refriger1()
        tab2 = ice_2()
        tab3 = roomtemp_3()

        supportFragmentManager.beginTransaction().add(R.id.frameLayout, tab1).commit()

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener { //냉장 냉동 상온 프래그먼트로 이동
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position) {
                    0 -> {
                        replaceView(tab1)
                    }
                    1 -> {
                        replaceView(tab2)
                    }
                    2 -> {
                        replaceView(tab3)
                    }
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
        btn_add.setOnClickListener {
            //val intent = Intent(this, ListExtratActivity::class.java)
            //startActivity(intent)
            showPopup(btn_add)
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.action_search -> {
                //검색 이벤트 실행
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun replaceView(tab: Fragment) {
        //화면 변경
        var selectedFragment: Fragment? = null
        selectedFragment = tab
        selectedFragment?.let {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout,it).commit()
        }
    }

    private fun showPopup(v: View) {
        val popup = PopupMenu(this,v)
        popup.menuInflater.inflate(R.menu.add_menu,popup.menu)
        popup.setOnMenuItemClickListener(this)
        popup.show()

    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {

        when (item?.itemId) {
            R.id.receipt -> {
                val intent = Intent(this, ListExtratActivity::class.java)
                startActivity(intent)

            }

            R.id.register -> {
                val intent = Intent(this, Register::class.java)
                startActivity(intent)

            }
        }
        return item!=null
    }


}

