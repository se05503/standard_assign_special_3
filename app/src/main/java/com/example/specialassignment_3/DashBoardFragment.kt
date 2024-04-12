package com.example.specialassignment_3

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.specialassignment_3.databinding.FragmentDashBoardBinding
import kotlinx.coroutines.flow.flow
import java.util.concurrent.Flow

// TODO: Rename parameter arguments, choose names that match
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [DashBoardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@Suppress("DEPRECATION")
@RequiresApi(Build.VERSION_CODES.TIRAMISU)
class DashBoardFragment : Fragment() {
    private val binding by lazy { FragmentDashBoardBinding.inflate(layoutInflater) }
    private var flower: Flower? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        flower = arguments?.getParcelable<Parcelable>(ARG_PARAM1) as Flower? // 제일 중요한 코드 !!
        Log.d("debug3434", flower.toString())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         binding.transmittedTv.text = "꽃 이름: ${flower?.name ?:"-1"} \n설명: ${flower?.description ?:"-1"}"
    }

    companion object {
        @JvmStatic
        fun newInstance(data: Flower) =
            DashBoardFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, data)
                }
            }
    }
}