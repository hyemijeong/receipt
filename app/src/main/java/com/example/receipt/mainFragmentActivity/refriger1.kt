package com.example.receipt.mainFragmentActivity

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.receipt.R
import com.example.receipt.possetionList.MyListDb
import com.example.receipt.recycle.MyList
import com.example.receipt.recycle.MyListAdapter
import kotlinx.android.synthetic.main.fragment_refriger1.*
import kotlin.collections.ArrayList


class refriger1 : Fragment() {


    private var mylistDb : MyListDb? =null
    var myList = listOf<MyList>()
    lateinit var recyclerView1 : RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_refriger1, container, false)
        val r = Runnable {
            try {
                val displayList = ArrayList<MyList>()
                mylistDb = MyListDb.getInstance(requireContext())
                myList= mylistDb?.myListDao()?.getRefri()!!// mylist에 있는 내용 다 들고옴
                //데이터 읽고 쓸 떄는 쓰레드 사용
                Log.d("myList", "${myList.size}")
                displayList.addAll(myList)
                recyclerView1 = rootView.findViewById(R.id.rvMylist_refri!!)as RecyclerView
                val mylistAdapter = MyListAdapter(requireContext(), displayList)

                rvMylist_refri.adapter = mylistAdapter
                rvMylist_refri.layoutManager = LinearLayoutManager(requireContext())

                mylistAdapter.setOnItemClickListener(object: MyListAdapter.OnItemClickListener {
                    override fun onItemClick(data: MyList, pos: Int) {
                        Log.d("여깅1",pos.toString())
                    }
                    override fun onItemEditClick(data: MyList, pos: Int) {
                    }
                    override fun onItemDeleteClick(data: MyList, position: Int) {
                    }
                })
                mylistAdapter.notifyDataSetChanged()

            }catch(e:Exception){
                Log.d("tag","Error - $e")
            }
        }

        val thread = Thread(r)
        thread.start()
        Log.d("thread_create","${r}")
        // Inflate the layout for this fragment
        return rootView

    }
}