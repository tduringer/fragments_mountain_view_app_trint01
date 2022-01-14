package com.example.fragments_mountain_view_app_trint01.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragments_mountain_view_app_trint01.R
import com.example.fragments_mountain_view_app_trint01.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    companion object {
        val TAG = SecondFragment::class.java.name
    }

    private var _binding : FragmentFirstBinding? = null
    private val binding : FragmentFirstBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            createAccountBtn.setOnClickListener{
                Log.d(TAG, "createAccountBtn clicked")
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, SecondFragment::class.java, null)
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