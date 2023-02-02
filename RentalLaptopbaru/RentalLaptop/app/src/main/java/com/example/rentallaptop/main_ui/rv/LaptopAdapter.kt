package com.example.rentallaptop.main_ui.rv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rentallaptop.Product
import com.example.rentallaptop.R
import com.example.rentallaptop.databinding.ItemLaptopBinding

class LaptopAdapter(private val onClick: (Product) -> Unit, private val context: Context): RecyclerView.Adapter<LaptopAdapter.LaptopViewHolder>() {

    private val data = arrayListOf<Product>()

    fun setData(newData: List<Product>){
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    inner class LaptopViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        private val binding = ItemLaptopBinding.bind(itemView)
        fun bind(product: Product){
            with(binding){
                Glide.with(root)
                    .load(context.getDrawable(product.imgPath))
                    .into(picture)

                tvName.text = product.name
                ProductTipe.text = product.tipe
                tvLocation.text = product.location
                tvPrice.text = "Rp."+product.price
            }
        }

        init {
            binding.root.setOnClickListener {
                onClick.invoke(data[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaptopViewHolder =
        LaptopViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_laptop, parent, false))

    override fun onBindViewHolder(holder: LaptopViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}