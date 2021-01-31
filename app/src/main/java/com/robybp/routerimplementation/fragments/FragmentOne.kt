package com.robybp.routerimplementation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.robybp.routerimplementation.MainActivity
import com.robybp.routerimplementation.R

class FragmentOne() : Fragment() {
    private lateinit var fragmentTwoButton: Button
    private lateinit var fragmentThreeButton: Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_one, container, false)
        fragmentTwoButton = view.findViewById(R.id.f1_fragment_two_button)
        fragmentThreeButton = view.findViewById(R.id.f1_fragment_three_button)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        fragmentTwoButton.setOnClickListener {

        }

        fragmentThreeButton.setOnClickListener {
        }

        super.onViewCreated(view, savedInstanceState)
    }
}
