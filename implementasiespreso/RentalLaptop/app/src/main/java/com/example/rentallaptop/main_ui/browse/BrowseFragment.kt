package com.example.rentallaptop.main_ui.browse

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rentallaptop.databinding.FragmentBrowseBinding
import com.example.rentallaptop.main_ui.detail.DetailLaptopActivity
import com.example.rentallaptop.main_ui.rv.LaptopAdapter
import org.koin.android.ext.android.inject

class BrowseFragment : Fragment() {

    private val browseViewModel: BrowseViewModel by inject()
    private lateinit var adapter: LaptopAdapter
    private var _binding: FragmentBrowseBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBrowseBinding.inflate(inflater, container, false)

        adapter = LaptopAdapter({ product ->
            startActivity(
                Intent(requireContext(), DetailLaptopActivity::class.java).putExtra(
                    DetailLaptopActivity.GET_PRODUCT, product))
        }, requireContext())

        adapter.setData(browseViewModel.getAllProducts())

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            rvLaptop.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            rvLaptop.adapter = adapter

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    if (query.isNullOrEmpty()){
                        adapter.setData(browseViewModel.getAllProducts())
                    } else {
                        adapter.setData(browseViewModel.getAllProducts().filter { product ->
                            product.name.contains(query, true)
                        })
                    }

                    return true
                }

                override fun onQueryTextChange(query: String?): Boolean {
                    if (query.isNullOrEmpty()){
                        adapter.setData(browseViewModel.getAllProducts())
                    }
                    return true
                }

            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}