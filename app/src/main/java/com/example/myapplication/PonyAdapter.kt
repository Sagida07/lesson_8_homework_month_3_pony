package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemPonyBinding

class PonyAdapter(
    val onClick: (ponyModel: PonyModel) -> Unit,
    private var list: ArrayList<PonyModel>
) :
    RecyclerView.Adapter<PonyAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPonyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }


    inner class ViewHolder(private var binding: ItemPonyBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PonyModel) {
            binding.run {
                item.run {
                    tvDesc.text = desc
                    tvName.text = name
                    imgPony.loadImage(image)
                }
            }
            itemView.setOnClickListener {
                onClick.invoke(item)
            }
        }
    }
}