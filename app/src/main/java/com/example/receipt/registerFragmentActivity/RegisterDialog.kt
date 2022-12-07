package com.example.receipt.registerFragmentActivity

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.content.res.AssetManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi

import com.example.receipt.R
import com.example.receipt.Register
import com.example.receipt.databinding.DialogRegisterBinding
import com.example.receipt.possetionList.MyListDb

import com.example.receipt.recycle.MyList
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.dialog_register.*
import org.json.JSONArray
import org.json.JSONObject

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

open class RegisterDialog(
    context: Context,
    name: String,
    image: Int,
    index: Int,
    category: String,
    private val okCallback: (String) -> Unit,
) : Dialog(context) { // 뷰를 띄워야하므로 Dialog 클래스는 context를 인자로 받는다.

    @RequiresApi(Build.VERSION_CODES.O)
    val today: LocalDate = LocalDate.now()
    @RequiresApi(Build.VERSION_CODES.O)
    val formatter = DateTimeFormatter.ofPattern("yyyy-M-d")
    private lateinit var binding: DialogRegisterBinding
    var name= name
    var image = image
    var index = index
    var category = category
    var storge = ""
    private var newitem = MyList()
    private var myListDb : MyListDb? =null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 만들어놓은 dialog_profile.xml 뷰를 띄운다.
        binding = DialogRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initViews() = with(binding) {
        // 뒤로가기 버튼, 빈 화면 터치를 통해 dialog가 사라지지 않도록
        setCancelable(true)

        // background를 투명하게 만듦
        // (중요) Dialog는 내부적으로 뒤에 흰 사각형 배경이 존재하므로, 배경을 투명하게 만들지 않으면
        // corner radius의 적용이 보이지 않는다.
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        newitem.item= this@RegisterDialog.image
        newitem.name = this@RegisterDialog.name
        newitem.category = this@RegisterDialog.category
        newitem.index = this@RegisterDialog.index
        newitem.startday = LocalDate.parse(today.toString(), formatter).toString()
        newitem.storage_info=jsonParsing(newitem.index)!!.getString("info")



        regi_title.setText(name)
        tv_registerstate.setText("보관상태 설정")

        tv_regi_dateTitle.setText("유통기한 설정")
        tv_regidateExplan.setText("소비기한은 유통기한 마지막날을 기준으로 계산됩니다.")

        val today: LocalDate = LocalDate.now()

        tv_regiDate.setText(today.toString())

        val rt = Runnable {
            myListDb = MyListDb.getInstance(context)
            myListDb?.myListDao()?.insert(newitem)
        }

        radioGroup_regi.setOnCheckedChangeListener{ group, checkedId->
            when(checkedId){
                R.id.regi_refri_btn -> {
                    newitem.storage = "냉장보관"
                    storge="Refri_Date"
                }
                R.id.regi_roomtem_btn ->{
                    newitem.storage = "상온보관"
                    storge="RoomTem_Date"

                }
                R.id.regi_ice_btn ->{
                    newitem.storage = "냉동보관"
                    storge="ice_Date"
                }
            }
        }
        regi_cal_btn.setOnClickListener{
            cal_setting()
        }

        // OK Button 클릭에 대한 Callback 처리. 이 부분은 상황에 따라 자유롭게!
        registerOk.setOnClickListener{
            if(newitem.storage=="" || newitem.dates==""){
                Toast.makeText(context, "보관방법과 날짜를 선택해주세요.", Toast.LENGTH_SHORT).show()
            }
            else{
                val thread = Thread(rt)
                thread.start()
                Toast.makeText(context, name+"가 추가되었습니다.", Toast.LENGTH_SHORT).show()
                dismiss()
            }

        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
   fun cal_setting(){

        val cal = Calendar.getInstance()    //캘린더뷰 만들기
        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            var daySelect = "${year}-${month+1}-${dayOfMonth}"

            newitem.dates = LocalDate.parse(daySelect, formatter).toString()
            val date = LocalDate.parse(newitem.dates, formatter)
            newitem.expridate = date.plusDays(jsonParsing(newitem.index)!!.getString(storge).toLong()).toString()
             // 유통기한 날짜
        }
        DatePickerDialog(context, dateSetListener, cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)).show()
    }

    fun jsonParsing(i: Int): JSONObject? {
        Log.d("제슨경로","json")
        val assetManager:AssetManager = context.resources.assets
        val inputStream=assetManager.open("json/data.json")
        val jsonString = inputStream.bufferedReader().use { it.readText() }
        val jsonArray = JSONArray(jsonString)
        return jsonArray.getJSONObject(i)

    }





}