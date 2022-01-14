package com.example.fragments_mountain_view_app_trint01.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.fragments_mountain_view_app_trint01.R
import com.example.fragments_mountain_view_app_trint01.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    companion object {
        val TAG = SecondFragment::class.java.name
    }

    private var _binding : FragmentSecondBinding? = null
    private val binding : FragmentSecondBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            firstNameEt.editText?.addTextChangedListener { text ->
                Log.d(TAG, text.toString())

                nextBtn.isEnabled = text.toString().length > 8
            }
            nextBtn.setOnClickListener{
                Log.d(TAG, "nextBtn Clicked")
                val firstName = firstNameEt.editText?.text.toString()
                val lastName = lastNameEt.editText?.text.toString()
                val bundle = Bundle()
                bundle.putString(FIRST_NAME_ARG, firstName)
                bundle.putString(LAST_NAME_ARG, lastName)

                Log.d(TAG, "firstName is $firstName, lastName is $lastName")

                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, ThirdFragment::class.java, bundle)
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