package com.jakey.starwarsimages.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.jakey.starwarsimages.data.remote.CharacterDto
import com.jakey.starwarsimages.databinding.HomeListLayoutAdapterBinding
import com.jakey.starwarsimages.domain.model.CharacterLite
import com.jakey.starwarsimages.presentation.home.StarWarsPagedAdapter.*

class StarWarsPagedAdapter: PagingDataAdapter<CharacterLite, MyViewHolder>(diffCallback) {

    inner class MyViewHolder(val binding: HomeListLayoutAdapterBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<CharacterLite>() {
            override fun areItemsTheSame(oldItem: CharacterLite, newItem: CharacterLite): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: CharacterLite, newItem: CharacterLite): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentCharacter = getItem(position)

        holder.binding.apply {
            tvName.text = currentCharacter?.name ?: ""
            tvBirthYear.text = "Born: ${currentCharacter?.birthYear}"
            ivCharacter.load(currentCharacter?.imageUrl) {
                crossfade(true)
                crossfade(500)
            }
        }
        holder.itemView.setOnClickListener { mView ->
            val direction = currentCharacter?.let {
                HomeFragmentDirections
                    .actionHomeFragmentToDetailFragment(it.id)
            }
            direction?.let { mView.findNavController().navigate(it) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            HomeListLayoutAdapterBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }
}