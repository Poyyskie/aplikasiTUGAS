package com.example.rentallaptop.main_ui.home

import android.accounts.Account
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rentallaptop.R
import com.example.rentallaptop.Transfer
import com.example.rentallaptop.adapter.SliderAdapter
import com.example.rentallaptop.databinding.FragmentHomeBinding
import com.example.rentallaptop.main_ui.maintance.MaintanceActivity
import com.example.rentallaptop.main_ui.payment.PaymentActivity
import com.example.rentallaptop.Topup
import com.example.rentallaptop.main_ui.history.HistoryFragment
import com.smarteist.autoimageslider.SliderView
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by inject()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cvMethod.setOnClickListener {
            startActivity(Intent(requireActivity(), PaymentActivity::class.java))
        }

        binding.cvMaintance.setOnClickListener {
            startActivity(Intent(requireActivity(), MaintanceActivity::class.java))
        }

        binding.transfer.setOnClickListener {
            startActivity(Intent(requireActivity(), Transfer::class.java))
        }
        binding.topup.setOnClickListener {
            startActivity(Intent(requireActivity(), Topup::class.java))
        }
        binding.history.setOnClickListener {
            startActivity(Intent(requireActivity(), HistoryFragment::class.java))
        }


        homeViewModel.user.observe(requireActivity(), { user ->
            with(binding){
                tvName.text = user.name
                tvSaldo.text = "Rp.${user.saldo}"
            }
        })
        binding.imageSlider.apply {
            setImageInSlider(arrayListOf(R.drawable.iklan_transmart, R.drawable.iklan_belanja), this)
        }

        homeViewModel.getDataUser()
    }

    private fun setImageInSlider(images: ArrayList<Int>, imageSlider: SliderView) {
        val adapter = SliderAdapter(requireContext())
        adapter.renewItems(images)
        imageSlider.setSliderAdapter(adapter)
        imageSlider.isAutoCycle = true
        imageSlider.startAutoCycle()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}