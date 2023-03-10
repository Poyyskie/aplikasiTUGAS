package com.example.rentallaptop.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.rentallaptop.R
import com.smarteist.autoimageslider.SliderViewAdapter

class SliderAdapter(private val context: Context): SliderViewAdapter<SliderAdapter.VH>() {
    private var mSliderItems = ArrayList<Int>()
    fun renewItems(sliderItems: ArrayList<Int>) {
        mSliderItems = sliderItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup): VH {
        val inflate: View = LayoutInflater.from(parent.context).inflate(R.layout.image_holder, parent, false)
        return VH(inflate)
    }

    override fun onBindViewHolder(viewHolder: VH, position: Int) {
        Glide.with(viewHolder.itemView)
            .load(context.getDrawable(mSliderItems[position]))
            .centerCrop()
            .into(viewHolder.imageView)
    }

    override fun getCount(): Int {
        return mSliderItems.size
    }

    inner class VH(itemView: View) : SliderViewAdapter.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.image_slider)
    }
}