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
                showProfileDialog("?????????", iconImage[0],24,"??????" )
            }
            R.id.vage2 -> {
                showProfileDialog("??????", iconImage[1],25,"??????" )
            }
            R.id.vage3 -> {
                showProfileDialog("?????????", iconImage[2],26,"??????" )
            }
            R.id.vage4 -> {
                showProfileDialog("??????", iconImage[3],27,"??????" )
            }
            R.id.vage5 -> {
                showProfileDialog("?????????", iconImage[4],28,"??????" )
            }
            R.id.vage6 -> {
                showProfileDialog("??????", iconImage[5],29,"??????" )
            }
            R.id.vage7 -> {
                showProfileDialog("??????", iconImage[6],30,"??????" )
            }
            R.id.vage8 -> {
                showProfileDialog("??????", iconImage[7],31,"??????" )
            }
            R.id.vage9 -> {
                showProfileDialog("???", iconImage[8],32,"??????" )
            }
            R.id.vage10 -> {
                showProfileDialog("??????", iconImage[9],33,"??????" )
            }
            R.id.vage11 -> {
                showProfileDialog("??????", iconImage[10],34,"??????" )
            }
            R.id.vage12 -> {
                showProfileDialog("???????????????", iconImage[11],35,"??????" )
            }
            R.id.vage13 -> {
                showProfileDialog("??????????????????", iconImage[12],36,"??????" )
            }
            R.id.vage14 -> {
                showProfileDialog("??????", iconImage[13],37,"??????" )
            }
            R.id.vage15 -> {
                showProfileDialog("????????????", iconImage[14],38,"??????" )
            }
            R.id.vage16 -> {
                showProfileDialog("????????????", iconImage[15],39,"??????" )
            }
            R.id.vage17 -> {
                showProfileDialog("???????????????", iconImage[16],40,"??????" )
            }
            R.id.vage18 -> {
                showProfileDialog("???", iconImage[17],41,"??????" )
            }
            R.id.vage19 -> {
                showProfileDialog("??????", iconImage[18],42,"??????" )
            }
            R.id.vage20 -> {
                showProfileDialog("????????????", iconImage[19],43,"??????" )
            }
            R.id.vage21 -> {
                showProfileDialog("????????????", iconImage[20],44,"??????" )
            }
            R.id.vage22 -> {
                showProfileDialog("??????", iconImage[21],45,"??????" )
            }
            R.id.vage23 -> {
                showProfileDialog("??????", iconImage[22],46,"??????" )
            }
            R.id.vage24 -> {
                showProfileDialog("????????????", iconImage[23],47,"??????" )
            }
            R.id.vage25 -> {
                showProfileDialog("??????", iconImage[24],48,"??????" )
            }
            R.id.vage26 -> {
                showProfileDialog("?????????", iconImage[25],49,"??????" )
            }
            R.id.vage27 -> {
                showProfileDialog("?????????", iconImage[26],50,"??????" )
            }
            R.id.vage28 -> {
                showProfileDialog("??????", iconImage[27],51,"??????" )
            }
            R.id.vage29 -> {
                showProfileDialog("?????????", iconImage[28],52,"??????" )
            }
            R.id.vage30 -> {
                showProfileDialog("????????????", iconImage[29],53,"??????" )
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