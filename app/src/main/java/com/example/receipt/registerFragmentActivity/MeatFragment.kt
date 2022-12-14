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
import androidx.core.view.forEach
import com.example.receipt.R
import com.example.receipt.databinding.FragmentMeatkBinding
import kotlinx.android.synthetic.main.fragment_meatk.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [meatkFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class meatkFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentMeatkBinding? = null
    private val binding get() = _binding!!
    private val iconImage = listOf<Int>(
        R.drawable.meat1, R.drawable.meat2, R.drawable.meat3,
        R.drawable.meat4, R.drawable.meat5, R.drawable.meat6, R.drawable.meat7,
        R.drawable.meat8, R.drawable.meat9, R.drawable.meat10, R.drawable.meat11,
        R.drawable.meat12, R.drawable.meat13, R.drawable.meat14, R.drawable.meat15,
        R.drawable.meat16,
    )

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,

        ): View? {
        _binding = FragmentMeatkBinding.inflate(inflater, container, false)
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

    private fun setOnClickListener() {
        val meatLine1 = binding.meatLine1.children
        meatLine1.forEach { btn ->
            btn.setOnClickListener(this)
        }
        meatLine2.forEach { btn ->
            btn.setOnClickListener(this)
        }
        meatLine3.forEach { btn ->
            btn.setOnClickListener(this)
        }
        meatLine4.forEach { btn ->
            btn.setOnClickListener(this)
        }

    }


    override fun onClick(v: View) {
        when (v.id) {
            R.id.meat1 -> {
                showProfileDialog("?????????", iconImage[0], 1, "??????")
            }
            R.id.meat2 -> {
                showProfileDialog("???", iconImage[1], 1, "??????")
            }
            R.id.meat3 -> {
                showProfileDialog("????????????", iconImage[2], 1, "??????")
            }
            R.id.meat4 -> {
                showProfileDialog("??????", iconImage[3], 1, "??????")
            }
            R.id.meat5 -> {
                showProfileDialog("?????????", iconImage[4], 1, "??????")
            }
            R.id.meat6 -> {
                showProfileDialog("?????????", iconImage[5], 1, "??????")
            }
            R.id.meat7 -> {
                showProfileDialog("?????????", iconImage[6], 1, "??????")
            }
            R.id.meat8 -> {
                showProfileDialog("????????????", iconImage[7], 1, "??????")
            }
            R.id.meat9 -> {
                showProfileDialog("?????????", iconImage[8], 1, "??????")
            }
            R.id.meat10 -> {
                showProfileDialog("????????????", iconImage[9], 1, "??????")
            }
            R.id.meat11 -> {
                showProfileDialog("??????", iconImage[10], 1, "??????")
            }
            R.id.meat12 -> {
                showProfileDialog("?????????", iconImage[11], 1, "??????")
            }
            R.id.meat13 -> {
                showProfileDialog("?????????", iconImage[12], 1, "??????")
            }
            R.id.meat14 -> {
                showProfileDialog("?????????", iconImage[13], 1, "??????")
            }
            R.id.meat15 -> {
                showProfileDialog("??????", iconImage[14], 1, "??????")
            }
            R.id.meat16 -> {
                showProfileDialog("????????????", iconImage[15], 1, "??????")
            }

        }
    }

    companion object {
        private const val TAG = "fruit"

    }

    private fun showProfileDialog(name: String, image: Int, index: Int, category: String) {
        RegisterDialog(requireContext(), name, image, index, category) {
        }.show()
    }
}