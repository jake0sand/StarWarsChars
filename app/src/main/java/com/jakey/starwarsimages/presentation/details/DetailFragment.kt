package com.jakey.starwarsimages.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.jakey.starwarsimages.R
import com.jakey.starwarsimages.databinding.FragmentDetailBinding
import com.jakey.starwarsimages.domain.model.Character
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DetailsViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val argsId = args.charArgsId



        viewModel.characterById.observe(viewLifecycleOwner) { character ->

            if (character != null) {
                populateUi(character)
            }


        }

        viewModel.fetchCharacter(characterId = argsId)

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    private fun populateUi(characterDetails: Character) {
        binding.apply {
            tvBirthyearDetail.text = "Born: ${characterDetails.birth_year}"
            tvGenderDetail.text = "Gender: ${characterDetails.gender}"
            tvHeightDetail.text = "Height (cm): ${characterDetails.height}"
            tvMassDetail.text = "Mass (kg): ${characterDetails.mass}"
            tvNameDetail.text = "Name: ${characterDetails.name}"
            ivDetail.load(characterDetails.image)

            btnOpenWebView.setOnClickListener { mView ->
                val direction = DetailFragmentDirections
                    .actionDetailFragmentToWebViewFragment(characterDetails.name)
                mView.findNavController().navigate(direction)
            }
        }
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}