package com.robybp.routerimplementation.screens.one

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.robybp.routerimplementation.R
import org.koin.android.ext.android.inject

class FragmentOne() : Fragment() {
    private lateinit var fragmentTwoButton: Button
    private lateinit var fragmentThreeButton: Button

    private val model: FragmentOneViewModel by inject()

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
            model.goToFragmentTwo()
        }

        fragmentThreeButton.setOnClickListener {
            model.goToFragmentThree()
        }

        super.onViewCreated(view, savedInstanceState)
    }
}
