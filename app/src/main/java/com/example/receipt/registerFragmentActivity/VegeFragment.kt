package com.example.receipt.registerFragmentActivity

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.children
import com.example.receipt.R
import com.example.receipt.databinding.FragmentVegeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [vegeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class vegeFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentVegeBinding? = null
    private val binding get() = _binding!!
    private val iconImage = listOf<Int>(
        R.drawable.vage1, R.drawable.vage2, R.drawable.vage3,
        R.drawable.vage4, R.drawable.vage5, R.drawable.vage6, R.drawable.vage7,
        R.drawable.vage8, R.drawable.vage9, R.drawable.vage10,R.drawable.vage11,
        R.drawable.vage12, R.drawable.vage13, R.drawable.vage14, R.drawable.vage15,
        R.drawable.vage16, R.drawable.vage17,
        R.drawable.vage18, R.drawable.vage19, R.drawable.vage20,R.drawable.vage21,
        R.drawable.vage22,R.drawable.vage23, R.drawable.vage24,
        R.drawable.vage25, R.drawable.vage26, R.drawable.vage27,R.drawable.vage28,
        R.drawable.vage29,R.drawable.vage30,
    )

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,

        ): View? {
        _binding = FragmentVegeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListener()
    }

    private fun setOnClickListener(){
        val fruitLine1 = binding.vageLine1.children
        fruitLine1.forEach { btn ->
            btn.setOnClickListener(this)
        }
        val fruitLine2 = binding.vageLine2.children
        fruitLine2.forEach { btn ->
            btn.setOnClickListener(this)
        }
        val fruitLine3 = binding.vageLine3.children
        fruitLine3.forEach { btn ->
            btn.setOnClickListener(this)
        }
        val fruitLine4 = binding.vageLine4.children
        fruitLine4.forEach { btn ->
            btn.setOnClickListener(this)
        }
        val fruitLine5 = binding.vageLine5.children
        fruitLine5.forEach { btn ->
            btn.setOnClickListener(this)
        }
        val fruitLine6 = binding.vageLine6.children
        fruitLine6.forEach { btn ->
            btn.setOnClickListener(this)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onClick(v: View) {

        when (v.id) {
            R.id.vage1 -> {
                showProfileDialog("단호박", iconImage[0],24,"채소" )
            }
            R.id.vage2 -> {
                showProfileDialog("호박", iconImage[1],25,"채소" )
            }
            R.id.vage3 -> {
                showProfileDialog("애호박", iconImage[2],26,"채소" )
            }
            R.id.vage4 -> {
                showProfileDialog("감자", iconImage[3],27,"채소" )
            }
            R.id.vage5 -> {
                showProfileDialog("고구마", iconImage[4],28,"채소" )
            }
            R.id.vage6 -> {
                showProfileDialog("고추", iconImage[5],29,"채소" )
            }
            R.id.vage7 -> {
                showProfileDialog("가지", iconImage[6],30,"채소" )
            }
            R.id.vage8 -> {
                showProfileDialog("당근", iconImage[7],31,"과일" )
            }
            R.id.vage9 -> {
                showProfileDialog("파", iconImage[8],32,"과일" )
            }
            R.id.vage10 -> {
                showProfileDialog("꺳잎", iconImage[9],33,"과일" )
            }
            R.id.vage11 -> {
                showProfileDialog("상추", iconImage[10],34,"채소" )
            }
            R.id.vage12 -> {
                showProfileDialog("느타리버섯", iconImage[11],35,"채소" )
            }
            R.id.vage13 -> {
                showProfileDialog("아스파라거스", iconImage[12],36,"채소" )
            }
            R.id.vage14 -> {
                showProfileDialog("부추", iconImage[13],37,"채소" )
            }
            R.id.vage15 -> {
                showProfileDialog("송이버섯", iconImage[14],38,"채소" )
            }
            R.id.vage16 -> {
                showProfileDialog("팽이버섯", iconImage[15],39,"채소" )
            }
            R.id.vage17 -> {
                showProfileDialog("양송이버섯", iconImage[16],40,"채소" )
            }
            R.id.vage18 -> {
                showProfileDialog("무", iconImage[17],41,"과일" )
            }
            R.id.vage19 -> {
                showProfileDialog("배추", iconImage[18],42,"과일" )
            }
            R.id.vage20 -> {
                showProfileDialog("표고버섯", iconImage[19],43,"과일" )
            }
            R.id.vage21 -> {
                showProfileDialog("브로콜리", iconImage[20],44,"채소" )
            }
            R.id.vage22 -> {
                showProfileDialog("양파", iconImage[21],45,"채소" )
            }
            R.id.vage23 -> {
                showProfileDialog("피망", iconImage[22],46,"채소" )
            }
            R.id.vage24 -> {
                showProfileDialog("파프리카", iconImage[23],47,"채소" )
            }
            R.id.vage25 -> {
                showProfileDialog("오이", iconImage[24],48,"채소" )
            }
            R.id.vage26 -> {
                showProfileDialog("옥수수", iconImage[25],49,"채소" )
            }
            R.id.vage27 -> {
                showProfileDialog("콩나물", iconImage[26],50,"채소" )
            }
            R.id.vage28 -> {
                showProfileDialog("숙주", iconImage[27],51,"과일" )
            }
            R.id.vage29 -> {
                showProfileDialog("시금치", iconImage[28],52,"과일" )
            }
            R.id.vage30 -> {
                showProfileDialog("알타리무", iconImage[29],53,"과일" )
            }

        }
    }

    companion object {
        private const val TAG = "fruit"

    }

    private fun showProfileDialog(name : String, image: Int, index: Int, category:String) {
        RegisterDialog(requireContext(),name,image,index,category) {
        }.show()
    }
}