package com.example.viewmodel2.utils.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.viewmodel2.databinding.ItemRvBinding
import com.example.viewmodel2.utils.model.MainModel

class MainAdapter(
    private var list: ArrayList<MainModel> = ArrayList(),
    val onItemClick: (model: MainModel) -> Unit)
    : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    inner class MainViewHolder(private var binding: ItemRvBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(list[adapterPosition])
            }
        }

        fun onBind(s: MainModel) {
            binding.tvItem.text = s.title
            Glide.with(binding.imageItem.context).load(s.image).into(binding.imageItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
