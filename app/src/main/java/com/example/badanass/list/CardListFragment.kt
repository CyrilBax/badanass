package com.example.badanass.list

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.badanass.MainActivityContract
import com.example.badanass.R
import kotlinx.android.synthetic.main.fragment_card_list.*


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CardListFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [CardListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CardListFragment : Fragment() {

    private val viewModel by viewModels<CardListViewModel>()

    private var contract: MainActivityContract? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_card_list, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is MainActivityContract) {
            contract = context
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CardListAdapter(viewModel)

        card_list.adapter = adapter

        viewModel.cardList.observe(viewLifecycleOwner, Observer { adapter.data = it ?: listOf() })

        viewModel.clickDetected.observe(viewLifecycleOwner, Observer {
            it?.let {
                contract?.onItemSelected(it)
                viewModel.onNavigateEnd()
            }
        })


    }

    companion object {
        fun newInstance() = CardListFragment()
    }
}
