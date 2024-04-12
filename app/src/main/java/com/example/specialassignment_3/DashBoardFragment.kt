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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                param1 = it.getParcelable(ARG_PARAM1, Flower::class.java)
                /*
                에뮬레이터 버전이 티라미수 버전이 아니다
                버전에 따라 데이터 받아오는 방식이 다르다
                버전 분기를 해줘야한다. → 매번 분기하기는 힘드니 내 애뮬레이터 버전을 티라미수로 바꿔보자!
                 */
            } else {
                param1 = it.getParcelable(ARG_PARAM1)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
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