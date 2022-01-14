package com.example.fragments_mountain_view_app_trint01.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.fragments_mountain_view_app_trint01.R
import com.example.fragments_mountain_view_app_trint01.databinding.FragmentThirdBinding
import com.example.fragments_mountain_view_app_trint01.ui.FirstFragment.Companion.TAG

class ThirdFragment : Fragment() {

    private var _binding : FragmentThirdBinding? = null
    private val binding : FragmentThirdBinding get() = _binding!!

    private var firstName = ""
    private var lastName = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false  )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            emailEt.editText?.addTextChangedListener { text ->
                Log.d(TAG, text.toString())
                firstName = (arguments?.get(FIRST_NAME_ARG) ?: "No First Name Input").toString()
                lastName = (arguments?.get(LAST_NAME_ARG) ?: "No Last Name Input").toString()

                nextBtn.isEnabled = text.toString().length > 4
            }

            nextBtn.setOnClickListener{
                Log.d(TAG, "nextBtn Clicked")

                val email = emailEt.editText?.text.toString()
                val bundle = Bundle()
                bundle.putString(FIRST_NAME_ARG, firstName)
                bundle.putString(LAST_NAME_ARG, lastName)
                bundle.putString(EMAIL_ARG, email)

                Log.d(TAG, "email is $email")

                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, FourthFragment::class.java, bundle)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}