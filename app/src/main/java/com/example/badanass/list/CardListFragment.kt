package com.example.badanass.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.badanass.data.models.Card
import com.example.badanass.databinding.FragmentCardListBinding
import com.example.badanass.domain.profiles.DaggerListViewModule
import com.example.badanass.domain.usecases.GetCardUseCase
import com.example.badanass.domain.usecases.GetListUseCase
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CardListFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [CardListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CardListFragment : Fragment() {

    private val viewModel: CardListViewModel by lazy {
        ViewModelProviders.of(this).get(CardListViewModel::class.java)
    }

    @Inject lateinit var getCardUseCase: GetCardUseCase
    @Inject lateinit var getListCardUseCase: GetListUseCase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentCardListBinding.inflate(inflater)

        DaggerListViewModule
            .create()
            .inject(this)

        binding.setLifecycleOwner(this)

//        binding.info = getCardUseCase.execute(1).toString()
        getListCardUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                binding.info = it.toString()
            }, {
                binding.info = it.toString()
            })
        // binding.info = getListCardUseCase.execute().toString()

        return binding.root
    }
}
