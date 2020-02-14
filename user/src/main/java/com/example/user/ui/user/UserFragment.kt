package com.example.user.ui.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.user.R
import com.example.user.databinding.UserFragmentBinding

class UserFragment : Fragment() {

    private val viewModel by viewModels<UserViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = UserFragmentBinding.inflate(inflater, container, false).apply {
            userViewModel = this@UserFragment.viewModel
            lifecycleOwner = this@UserFragment
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    companion object {
        fun newInstance() = UserFragment()
    }
}
