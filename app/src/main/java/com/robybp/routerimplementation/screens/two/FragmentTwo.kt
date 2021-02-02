package com.robybp.routerimplementation.screens.two

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.robybp.routerimplementation.R
import com.robybp.routerimplementation.navigation.RoutingActionMediator

class FragmentTwo() : Fragment() {

    private lateinit var fragmentOneButton: Button
    private lateinit var fragmentThreeButton: Button

    private val model: FragmentTwoViewModel by lazy {

        val factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                FragmentTwoViewModel(RoutingActionMediator) as T
        }

        ViewModelProvider(this, factory).get(FragmentTwoViewModel::class.java)
    }

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
