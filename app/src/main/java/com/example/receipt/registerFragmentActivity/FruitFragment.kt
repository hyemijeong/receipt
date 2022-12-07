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
import com.example.receipt.databinding.FragmentFruitBinding

class fruit : Fragment(), View.OnClickListener{

    private var _binding: FragmentFruitBinding? = null
    private val binding get() = _binding!!
    private val iconImage = listOf<Int>(
        R.drawable.fruit1, R.drawable.fruit2, R.drawable.fruit3,
        R.drawable.fruit4, R.drawable.fruit5, R.drawable.fruit6, R.drawable.fruit7,
        R.drawable.fruit8, R.drawable.fruit9, R.drawable.fruit10,R.drawable.fruit11,
        R.drawable.fruit12, R.drawable.fruit13, R.drawable.fruit14, R.drawable.fruit15,
        R.drawable.fruit16, R.drawable.fruit17,
        R.drawable.fruit18, R.drawable.fruit19, R.drawable.fruit20,R.drawable.fruit21,
        R.drawable.fruit22,R.drawable.fruit23, R.drawable.fruit24
    )

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,

        ): View? {
        _binding = FragmentFruitBinding.inflate(inflater, container, false)
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
        val fruitLine1 = binding.fruitLine1.children
        fruitLine1.forEach { btn ->
            btn.setOnClickListener(this)
        }
        val fruitLine2 = binding.fruitLine2.children
        fruitLine2.forEach { btn ->
            btn.setOnClickListener(this)
        }
        val fruitLine3 = binding.fruitLine3.children
        fruitLine3.forEach { btn ->
            btn.setOnClickListener(this)
        }
        val fruitLine4 = binding.fruitLine4.children
        fruitLine4.forEach { btn ->
            btn.setOnClickListener(this)
        }
        val fruitLine5 = binding.fruitLine5.children
        fruitLine5.forEach { btn ->
            btn.setOnClickListener(this)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onClick(v: View) {
        when (v.id) {
            R.id.fruit1 -> {
                Log.d(TAG, "First Button")
                showProfileDialog("사과", iconImage[0],1,"과일" )
            }
            R.id.fruit2 -> {
                Log.d(TAG, "Second Button")
                showProfileDialog("오렌지", iconImage[1],2,"과일" )
            }
            R.id.fruit3 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("바나나", iconImage[2],3,"과일" )
            }
            R.id.fruit4 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("포도", iconImage[3],4,"과일" )
            }
            R.id.fruit5 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("복숭아", iconImage[4],5,"과일" )
            }
            R.id.fruit6 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("수박", iconImage[5],6,"과일" )
            }
            R.id.fruit7 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("딸기", iconImage[6],7,"과일" )
            }
            R.id.fruit8 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("파인애플", iconImage[7],9,"과일" )
            }
            R.id.fruit9 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("참외", iconImage[8],11,"과일" )
            }
            R.id.fruit10 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("감", iconImage[9],12,"과일" )
            }
            R.id.fruit11 -> {
                Log.d(TAG, "First Button")
                showProfileDialog("멜론", iconImage[10],13,"과일" )
            }
            R.id.fruit12 -> {
                Log.d(TAG, "Second Button")
                showProfileDialog("자두", iconImage[11],14,"과일" )
            }
            R.id.fruit13 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("레몬", iconImage[12],15,"과일" )
            }
            R.id.fruit14 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("키위", iconImage[13],16,"과일" )
            }
            R.id.fruit15 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("체리", iconImage[14],17,"과일" )
            }
            R.id.fruit16 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("라임", iconImage[15],18,"과일" )
            }
            R.id.fruit17 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("자몽", iconImage[16],19,"과일" )
            }
            R.id.fruit18 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("귤", iconImage[17],20,"과일" )
            }
            R.id.fruit19 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("블루베리", iconImage[18],21,"과일" )
            }
            R.id.fruit20 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("방울토마토", iconImage[19],22,"과일" )
            }
            R.id.fruit21 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("배", iconImage[20],23,"과일" )
            }
            R.id.fruit22 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("망고", iconImage[21],24,"과일" )
            }
            R.id.fruit23 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("토마토", iconImage[21],24,"과일" )
            }
            R.id.fruit24 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("산딸기", iconImage[22],25,"과일" )
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
