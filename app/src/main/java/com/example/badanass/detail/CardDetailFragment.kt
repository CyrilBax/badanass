package com.example.badanass.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.badanass.R
import com.example.badanass.databinding.FragmentCardDetailBinding

class CardDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentCardDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_card_detail, container, false
        )

        val viewModel by viewModels<CardDetailViewModel>()

        binding.cardDetailViewModel = viewModel

        // sub

        binding.lifecycleOwner = this

         return binding.root
    }

    companion object {

        const val ARG_CARD_ID = "ARG_CARD_ID"

        fun newInstance(cardId: String): CardDetailFragment {
            val bundle = Bundle().apply {
                putString(ARG_CARD_ID, cardId)
            }
            CardDetailFragment().apply {
                arguments = bundle
            }
            return CardDetailFragment()
        }
    }
}