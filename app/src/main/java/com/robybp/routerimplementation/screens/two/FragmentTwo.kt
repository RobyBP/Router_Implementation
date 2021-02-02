package com.robybp.routerimplementation.screens.two

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.robybp.routerimplementation.R
import org.koin.android.ext.android.inject

class FragmentTwo() : Fragment() {

    private lateinit var fragmentOneButton: Button
    private lateinit var fragmentThreeButton: Button

    private val model: FragmentTwoViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_two, container, false)
        fragmentOneButton = view.findViewById(R.id.f2_fragment_one_button)
        fragmentThreeButton = view.findViewById(R.id.f2_fragment_three_button)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentOneButton.setOnClickListener {
            model.goToFragmentOne()
        }

        fragmentThreeButton.setOnClickListener {
            model.goToFragmentThree()
        }

    }
}
