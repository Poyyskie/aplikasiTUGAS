package com.example.rentallaptop.main_ui.history

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rentallaptop.Product
import com.example.rentallaptop.ProductDummy
import com.example.rentallaptop.databinding.FragmentHistoryBinding
import com.example.rentallaptop.main_ui.detail.DetailLaptopActivity
import com.example.rentallaptop.main_ui.rv.LaptopAdapter
import org.koin.android.ext.android.inject

class HistoryFragment : Fragment() {

    private val historyViewModel: HistoryViewModel by inject()
    private lateinit var adapter: LaptopAdapter
    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHistoryBinding.inflate(inflater, container, false)

        adapter  = LaptopAdapter({ product ->
            startActivity(Intent(requireContext(), DetailLaptopActivity::class.java).putExtra(DetailLaptopActivity.GET_PRODUCT, product))
        }, requireContext())

        historyViewModel.products.observe(requireActivity(), {
            val products = arrayListOf<Product>()
            it.forEach { laptop ->
                val product = ProductDummy.getAllProducts().find { product -> product.id.equals(laptop.idLaptop, true) }
                product?.let { product -> products.add(product) }
            }

            adapter.setData(products)
        })
        historyViewModel.getAllProducts()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.rvLaptop){
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = this@HistoryFragment.adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}