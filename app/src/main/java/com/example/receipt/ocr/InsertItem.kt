package com.example.receipt.ocr

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.receipt.R
import com.example.receipt.possetionList.MyListDb
import com.example.receipt.recycle.ListExtractView
import com.example.receipt.recycle.MyList
import org.json.JSONArray
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class InsertItem {

    private var myListDb: MyListDb? = null

    private val iconImage = listOf<Int>(
        R.drawable.fruit1, R.drawable.fruit2, R.drawable.fruit3,
        R.drawable.fruit4, R.drawable.fruit5, R.drawable.fruit6, R.drawable.fruit7,
        R.drawable.fruit8, R.drawable.fruit9, R.drawable.fruit10,R.drawable.fruit11,
        R.drawable.fruit12, R.drawable.fruit13, R.drawable.fruit14, R.drawable.fruit15,
        R.drawable.fruit16, R.drawable.fruit17,R.drawable.fruit18, R.drawable.fruit19,
        R.drawable.fruit20,R.drawable.fruit21,R.drawable.fruit22,R.drawable.fruit23, R.drawable.fruit24,
        R.drawable.vage1,R.drawable.vage2,R.drawable.vage3,R.drawable.vage4,R.drawable.vage5,
        R.drawable.vage6,R.drawable.vage7,R.drawable.vage8,R.drawable.vage9,R.drawable.vage10,
        R.drawable.vage11,R.drawable.vage12,R.drawable.vage13,R.drawable.vage14,R.drawable.vage15,
        R.drawable.vage16,R.drawable.vage17,R.drawable.vage18,R.drawable.vage19,R.drawable.vage20,
        R.drawable.vage21,R.drawable.vage22,R.drawable.vage23,R.drawable.vage24,R.drawable.vage25,
        R.drawable.vage26,R.drawable.vage27,R.drawable.vage28,R.drawable.vage29,R.drawable.vage30,

    )



    @RequiresApi(Build.VERSION_CODES.O)
    fun jsonParsing(extractIndex : ArrayList<Int>, jsonArray: JSONArray): ArrayList<ListExtractView> {
        val today: LocalDate = LocalDate.now()
        val ocrViewlist = ArrayList<ListExtractView>()
        for (i in extractIndex) {
            val jsonObject = jsonArray.getJSONObject(i)
            val name = jsonObject.getString("Food")
            val cate = jsonObject.getString("Category")
            val day = jsonObject.getString("data")
            val dates = today.plusDays(day.toLong())

            if (i<iconImage.size) {
                ocrViewlist.add(ListExtractView(iconImage[i], name, cate, dates))
            }
            else {
            }
        }
        return ocrViewlist
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun insertDB_item(extractIndex: ArrayList<Int>, jsonArray: JSONArray, context: Context){
        val today: LocalDate = LocalDate.now()
        val newitem = MyList()

        for (i in extractIndex) {
            val jsonObject = jsonArray.getJSONObject(i)
            if (i<iconImage.size) {
                newitem.item = iconImage[i]
            }
            else {
            }

            val day = jsonObject.getString("data")

            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")



            newitem.index =  jsonObject.getInt("Index")
            newitem.name = jsonObject.getString("Food")
            newitem.category = jsonObject.getString("Category")
            newitem.dates = today.plusDays(day.toLong()).toString()
            val date = LocalDate.parse(newitem.dates, formatter)
            newitem.expridate = date.plusDays(jsonObject.getString("Refri_Date").toLong()).toString()
            newitem.startday = today.toString()
            newitem.storage = "냉장보관"
            newitem.storage_info=jsonObject.getString("info")

            myListDb = MyListDb.getInstance(context)
            myListDb?.myListDao()?.insert(newitem)
        }
    }
}