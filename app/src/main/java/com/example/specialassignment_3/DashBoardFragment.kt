package com.example.specialassignment_3

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.specialassignment_3.databinding.FragmentDashBoardBinding

// TODO: Rename parameter arguments, choose names that match
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [DashBoardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DashBoardFragment : Fragment() {
    private var param1: Flower? = null
    private val binding by lazy { FragmentDashBoardBinding.inflate(layoutInflater) }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getParcelable(ARG_PARAM1, Flower::class.java) // 튜터님 해당 코드 피드백 부탁드려요
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dash_board, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.transmittedTv.text = "꽃 이름: ${param1?.name ?:"-1"} \n설명: ${param1?.description ?:"-1"}"
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Flower) =
            DashBoardFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, param1)
                }
            }
    }
}