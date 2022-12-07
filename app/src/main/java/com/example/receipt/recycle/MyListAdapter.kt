package com.example.receipt.recycle

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.mylist_item.view.*
import java.io.Serializable
import android.content.Intent
import android.graphics.Color
import android.widget.Toast
import com.example.receipt.*
import java.text.SimpleDateFormat
import java.util.*


class MyListAdapter(private val context: Context, private val displaylist: ArrayList<MyList>):
 RecyclerView.Adapter<MyListAdapter.Holder>() {

 private var delete = Delete()


 interface OnItemClickListener {
  fun onItemClick(data: MyList, pos: Int)
  fun onItemEditClick(data: MyList, position: Int)
  fun onItemDeleteClick(data: MyList, position: Int)
 }

 private var clickListener: OnItemClickListener? = null

 fun setOnItemClickListener(listener: OnItemClickListener) {
  this.clickListener = listener
 }

 override fun getItemCount(): Int {
  return displaylist.size
 }

 override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
  val view: View?
  view = LayoutInflater.from(parent.context).inflate(R.layout.mylist_item, parent, false)
  return Holder(view)
 }

 override fun onBindViewHolder(holder: Holder, position: Int) {
  holder.run {

   itemView.setOnClickListener{  //아이템 클릭했을 때
    clickListener?.onItemClick(displaylist[position], position)
    info(position)
   }

   itemView.del_btn?.setOnClickListener { //삭제 버튼 클릭했을 떄
    clickListener?.onItemDeleteClick(displaylist[position], position)
    deleteRecycle(position)
   }

   itemView.edit_btn?.setOnClickListener() {  // 수정버튼 클릭했을 때
    clickListener?.onItemEditClick(displaylist[position], position)
    editItem(position)
   }
  }
  holder.bind(displaylist[position])
 }

 inner class Holder(view: View) : RecyclerView.ViewHolder(view) {

  val itemview = itemView?.findViewById<ImageView>(R.id.iv_profile)         //item 사진 관련
  private var mview: View = view
  fun bind(mylist: MyList) {
   if (itemview != null) {
    Glide.with(itemView).load(mylist.item).into(itemview)
   }

   val dateFormat = SimpleDateFormat("yyyy-MM-d") //D-day 표시
   val endDate = dateFormat.parse(mylist.dates).time
   val today = Calendar.getInstance().apply {
    set(Calendar.HOUR_OF_DAY, 0)
    set(Calendar.MINUTE, 0)
    set(Calendar.SECOND, 0)
    set(Calendar.MILLISECOND, 0)
   }.time.time

   val d_day = (today - endDate) / (24 * 60 * 60 * 1000)

   mview.tv_name.text = mylist.name
   mview.tv_kategorie.text = mylist.category
   mview.tv_dates.text = mylist.dates

   if (d_day < 0) {
    mview.tv_d_day.setText("(D" + d_day + ")")
   } else if (d_day > 0) {
    mview.tv_d_day.setText("(D+" + d_day + ")")
    mview.tv_daycolor.setTextColor(Color.RED)
   } else {
    mview.tv_d_day.setText("(D-day)")
    mview.tv_daycolor.setTextColor(Color.RED)
   }

   if (d_day < -3) {
    mview.tv_daycolor.setTextColor(Color.parseColor("#FF4CAF50")) //초록
   }

   else if (-4 < d_day) {
    mview.tv_daycolor.setTextColor(Color.parseColor("#EADE02"))
    mview.tv_dates.setTextColor(Color.parseColor("#D68F00")) //노랑
   }

   if (-2 < d_day) {
    mview.tv_daycolor.setTextColor(Color.RED)
    mview.tv_dates.setTextColor(Color.parseColor("#FFA10000"))
   }
  }
 }

  fun deleteRecycle(pos: Int) {
   var builder = AlertDialog.Builder(context)
   builder.setMessage(displaylist[pos].name + "을 삭제 하시겠습니까?")
   //builder.setIcon(R.mipmap.ic_launcher)

   // 버튼 클릭시에 무슨 작업을 할 것인가!
   var listener = object : DialogInterface.OnClickListener {
    override fun onClick(p0: DialogInterface?, p1: Int) {
     when (p1) {
      DialogInterface.BUTTON_POSITIVE -> {
       delete.deleteItem(context, displaylist, pos)
       notifyItemRemoved(pos)
       notifyItemRangeChanged(pos, displaylist.size)
       Toast.makeText(
        context.applicationContext,
        displaylist[pos].name + "가 삭제되었습니다.",
        Toast.LENGTH_SHORT
       ).show()
      }

      DialogInterface.BUTTON_NEGATIVE -> {
       Toast.makeText(context.applicationContext, "삭제가 취소되었습니다.", Toast.LENGTH_SHORT).show()
      }
     }
    }
   }
   builder.setPositiveButton("확인", listener)
   builder.setNegativeButton("취소", listener)
   builder.show()

  }

  fun editItem(pos: Int) {
   val intent = Intent(context, EditActivity::class.java)
   intent.putExtra("item", displaylist[pos] as Serializable)
   context.startActivity(intent)
  }

  fun info(pos: Int) { //상세정보 확인 팝업창
   var builder = AlertDialog.Builder(context)
   builder.setTitle(displaylist[pos].name)
   var startday = displaylist[pos].startday // 등록날짜
   var dates = displaylist[pos].dates // 유통기한
   var expri_dates= displaylist[pos].expridate//소비기한
   var storageInfo = displaylist[pos].storage_info // 보관 방법

   builder.setMessage("\n등록 날짜 :"+startday+"\n\n유통 기한 :"+dates+"\n\n소비 기한 :"+expri_dates+"\n\n\n보관 방법 :"+storageInfo)
   builder.setIcon(displaylist[pos].item)
   var listener = object : DialogInterface.OnClickListener {
    override fun onClick(p0: DialogInterface?, p1: Int) {
     when (p1) {
      DialogInterface.BUTTON_POSITIVE -> {
      }
     }
    }
   }
   builder.setPositiveButton("OK", listener)
   builder.show()


  }
 }


