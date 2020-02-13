package com.example.badanass.detail

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.badanass.R
import com.example.badanass.databinding.FragmentCardDetailBinding
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import java.lang.Exception

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
            it?.let {
                Picasso.get()
                    .load(it.img)
                    .placeholder(R.drawable.loading_animation)
                    .into(object : Target {
                        override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                            binding.cardImg.setImageResource(R.drawable.ic_broken_image)
                        }

                        override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                            binding.cardImg.setImageBitmap(bitmap)
                        }

                        override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
                            if (it.img === null) {
                                binding.cardImg.setImageResource(R.drawable.ic_broken_image)
                            } else {
                                binding.cardImg.setImageResource(R.drawable.loading_animation)
                            }
                        }
                    })
            }
        })

        return binding.root
    }

    companion object {

        const val ARG_CARD_ID = "ARG_CARD_ID"

        fun newInstance(name: String): CardDetailFragment {
            val bundle = Bundle().apply {
                putString(ARG_CARD_ID, name)
            }
            return CardDetailFragment().apply {
                arguments = bundle
            }
        }
    }
}