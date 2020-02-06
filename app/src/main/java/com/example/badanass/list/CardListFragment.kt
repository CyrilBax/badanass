package com.example.badanass.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.badanass.R
import com.example.badanass.databinding.FragmentCardListBinding


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CardListFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [CardListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CardListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentCardListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_card_list, container, false
        )

        val application = requireNotNull(this.activity).application

        // Get reference to the viewmodel associated with this fragment
        val viewModel by viewModels<CardListViewModel>()

        binding.cardListViewModel = viewModel

        binding.setLifecycleOwner(this)

        val adapter = CardListAdapter()

        binding.cardList.adapter = adapter

        viewModel.cardList.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })

//        binding.info = getCardUseCase.execute(1).toString()

        return binding.root
    }
}
