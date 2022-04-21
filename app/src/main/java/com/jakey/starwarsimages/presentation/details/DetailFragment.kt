package com.jakey.starwarsimages.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.jakey.starwarsimages.R
import com.jakey.starwarsimages.data.remote.CharacterDto
import com.jakey.starwarsimages.databinding.FragmentDetailBinding
import com.jakey.starwarsimages.presentation.web_view.WebViewFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val args: DetailFragmentArgs by navArgs()
    private lateinit var character: CharacterDto

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        character = args.charArgsDetails

        populateUi()
    }

    private fun populateUi() {
        binding.apply {
            tvBirthyearDetail.text = "Born: ${character.birth_year}"
            tvFilmsDetail.text = "Appearances: ${character.films}" //TODO fix later
            tvGenderDetail.text = "Gender: ${character.gender}"
            tvHeightDetail.text = "Height (cm): ${character.height}"
            tvHomeworldDetail.text = "Homeworld: ${character.homeworld}" //TODO fix later
            tvMassDetail.text = "Mass (kg): ${character.mass}"
            tvSpeciesDetail.text = "Species: ${character.species}" //TODO fix later
            tvNameDetail.text = "Name: ${character.name}"
            ivDetail.load(character.image)

            btnOpenWebView.setOnClickListener { mView ->
                val direction = DetailFragmentDirections
                    .actionDetailFragmentToWebViewFragment(character)
                mView.findNavController().navigate(direction)
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}