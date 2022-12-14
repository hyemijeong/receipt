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
                showProfileDialog("??????", iconImage[0],1,"??????" )
            }
            R.id.fruit2 -> {
                Log.d(TAG, "Second Button")
                showProfileDialog("?????????", iconImage[1],2,"??????" )
            }
            R.id.fruit3 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("?????????", iconImage[2],3,"??????" )
            }
            R.id.fruit4 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("??????", iconImage[3],4,"??????" )
            }
            R.id.fruit5 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("?????????", iconImage[4],5,"??????" )
            }
            R.id.fruit6 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("??????", iconImage[5],6,"??????" )
            }
            R.id.fruit7 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("??????", iconImage[6],7,"??????" )
            }
            R.id.fruit8 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("????????????", iconImage[7],9,"??????" )
            }
            R.id.fruit9 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("??????", iconImage[8],11,"??????" )
            }
            R.id.fruit10 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("???", iconImage[9],12,"??????" )
            }
            R.id.fruit11 -> {
                Log.d(TAG, "First Button")
                showProfileDialog("??????", iconImage[10],13,"??????" )
            }
            R.id.fruit12 -> {
                Log.d(TAG, "Second Button")
                showProfileDialog("??????", iconImage[11],14,"??????" )
            }
            R.id.fruit13 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("??????", iconImage[12],15,"??????" )
            }
            R.id.fruit14 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("??????", iconImage[13],16,"??????" )
            }
            R.id.fruit15 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("??????", iconImage[14],17,"??????" )
            }
            R.id.fruit16 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("??????", iconImage[15],18,"??????" )
            }
            R.id.fruit17 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("??????", iconImage[16],19,"??????" )
            }
            R.id.fruit18 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("???", iconImage[17],20,"??????" )
            }
            R.id.fruit19 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("????????????", iconImage[18],21,"??????" )
            }
            R.id.fruit20 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("???????????????", iconImage[19],22,"??????" )
            }
            R.id.fruit21 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("???", iconImage[20],23,"??????" )
            }
            R.id.fruit22 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("??????", iconImage[21],24,"??????" )
            }
            R.id.fruit23 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("?????????", iconImage[21],24,"??????" )
            }
            R.id.fruit24 -> {
                Log.d(TAG, "Third Button")
                showProfileDialog("?????????", iconImage[22],25,"??????" )
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
