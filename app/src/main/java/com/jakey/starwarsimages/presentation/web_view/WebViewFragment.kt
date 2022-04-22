package com.jakey.starwarsimages.presentation.web_view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.jakey.starwarsimages.R
import com.jakey.starwarsimages.databinding.FragmentWebViewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WebViewFragment : Fragment(R.layout.fragment_web_view) {
    private var _binding: FragmentWebViewBinding? = null
    private val binding get() = _binding!!
    private val wvArgs: WebViewFragmentArgs by navArgs()
    private var characterName: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWebViewBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)

        characterName = wvArgs.charArgsName

        setUpWebView()

    }

    private fun setUpWebView() {

        binding.webView.apply {
            webViewClient = WebViewClient()

            loadUrl("https://en.wikipedia.org/wiki/$characterName")
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}