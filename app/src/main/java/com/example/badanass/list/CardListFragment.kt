package com.example.badanass.list

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.badanass.MainActivityContract
import com.example.badanass.R
import com.example.badanass.databinding.FragmentCardListBinding
import kotlinx.android.synthetic.main.fragment_card_list.*
import kotlinx.android.synthetic.main.fragment_card_list.view.*


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

        val binding = FragmentCardListBinding.inflate(inflater,container,false).apply {
            cardListViewModel=this@CardListFragment.viewModel
            lifecycleOwner=this@CardListFragment
        }

        return binding.root
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

        val manager = GridLayoutManager(context, 1)

        card_list.layoutManager = manager

        viewModel.cardList.observe(viewLifecycleOwner, Observer {
            it?.let {
                view.progress_bar.visibility = View.GONE
                adapter.data = it
                viewModel.onRefreshEnd()
            }
        })

        viewModel.errorList.observe(viewLifecycleOwner, Observer {
            it?.let {
                Toast.makeText(context, "erreur lors du chargement des données", Toast.LENGTH_LONG).show()
            }
        })

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
