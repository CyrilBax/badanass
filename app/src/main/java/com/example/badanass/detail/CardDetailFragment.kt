package com.example.badanass.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.badanass.R
import com.example.badanass.databinding.FragmentCardDetailBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class CardDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentCardDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_card_detail, container, false
        )

        val cardId = arguments?.getString(ARG_CARD_ID)

        val viewModelFactory = CardDetailViewModelFactory(cardId ?: "")

        val viewModel by viewModels<CardDetailViewModel>({ this }, { viewModelFactory })

        binding.cardDetailViewModel = viewModel

        binding.lifecycleOwner = this

        viewModel.card.observe(viewLifecycleOwner, Observer {
            it?.img?.let {
                Picasso.get().load(it)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(binding.cardImg, object : Callback {
                        override fun onSuccess() {
                            Log.i("success detail", "img load")
                        }

                        override fun onError(e: Exception?) {
                            Log.i("error detail", e.toString())
                        }
                    })
            }
        })

        return binding.root
    }

    companion object {

        const val ARG_CARD_ID = "ARG_CARD_ID"

        fun newInstance(cardId: String): CardDetailFragment {
            val bundle = Bundle().apply {
                putString(ARG_CARD_ID, cardId)
            }
            return CardDetailFragment().apply {
                arguments = bundle
            }
        }
    }
}