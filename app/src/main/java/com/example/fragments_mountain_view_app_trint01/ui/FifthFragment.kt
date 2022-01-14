package com.example.fragments_mountain_view_app_trint01.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragments_mountain_view_app_trint01.databinding.FragmentFifthBinding

class FifthFragment : Fragment() {

    private var _binding : FragmentFifthBinding? = null
    private val binding : FragmentFifthBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFifthBinding.inflate(inflater, container, false  )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            firstNameOutputTv.text = arguments?.getString(FIRST_NAME_ARG) ?: "No First Name Input"
            lastNameOutputTv.text = arguments?.getString(LAST_NAME_ARG) ?: "No Last Name Input"
            emailOutputTv.text = arguments?.getString(EMAIL_ARG) ?: "No Email Input"
            passwordOutputTv.text = arguments?.getString(PASSWORD_ARG) ?: "No Password Input"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}