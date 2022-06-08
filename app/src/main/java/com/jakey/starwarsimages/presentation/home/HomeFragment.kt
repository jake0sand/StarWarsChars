package com.jakey.starwarsimages.presentation.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.jakey.starwarsimages.R
import com.jakey.starwarsimages.databinding.FragmentDetailBinding
import com.jakey.starwarsimages.databinding.FragmentHomeBinding
import com.jakey.starwarsimages.databinding.FragmentWebViewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var homeAdapter: StarWarsPagedAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRv()
        loadingData()
    }

    private fun loadingData() {
        lifecycleScope.launch {
            viewModel.listData.collect { pagingData ->
                homeAdapter.submitData(pagingData)
            }
        }
    }


    private fun setupRv() {
        binding.recyclerView.apply {
            homeAdapter = StarWarsPagedAdapter()

            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = homeAdapter
        }
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}