package com.jakey.starwarsimages.presentation.home

//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.navigation.findNavController
//import androidx.recyclerview.widget.AsyncListDiffer
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.RecyclerView
//import coil.load
//import com.jakey.starwarsimages.data.remote.CharacterDto
//import com.jakey.starwarsimages.databinding.FragmentHomeBinding
//import com.jakey.starwarsimages.databinding.HomeListLayoutAdapterBinding
//import com.jakey.starwarsimages.presentation.home.HomeListAdapter.HomeListViewHolder
//
//class HomeListAdapter : RecyclerView.Adapter<HomeListViewHolder>() {
//
//    inner class HomeListViewHolder(val binding: HomeListLayoutAdapterBinding) :
//        RecyclerView.ViewHolder(binding.root)
//
//    private val diffCallback = object : DiffUtil.ItemCallback<CharacterDto>() {
//        override fun areItemsTheSame(oldItem: CharacterDto, newItem: CharacterDto): Boolean {
//            return oldItem.url == newItem.url
//        }
//
//        override fun areContentsTheSame(oldItem: CharacterDto, newItem: CharacterDto): Boolean {
//            return oldItem == newItem
//        }
//    }
//
//    private val differ = AsyncListDiffer(this, diffCallback)
//    var characters: List<CharacterDto>
//        get() = differ.currentList
//        set(value) {
//            differ.submitList(value)
//        }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListViewHolder {
//        return HomeListViewHolder(
//            HomeListLayoutAdapterBinding.inflate(
//                LayoutInflater.from(parent.context), parent, false
//            )
//        )
//    }
//
//    override fun onBindViewHolder(holder: HomeListViewHolder, position: Int) {
//        val currentCharacter = characters[position]
//
//        holder.binding.apply {
//            tvName.text = currentCharacter.name
//            tvBirthYear.text = "Born: ${currentCharacter.birth_year}"
//            ivCharacter.load(currentCharacter.image) {
//                crossfade(true)
//                crossfade(500)
//            }
//        }
//        holder.itemView.setOnClickListener { mView ->
//            val direction = HomeFragmentDirections
//                .actionHomeFragmentToDetailFragment(currentCharacter)
//            mView.findNavController().navigate(direction)
//        }
//    }
//
//    override fun getItemCount() = characters.size
//
//}
//
