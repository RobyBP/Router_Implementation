package com.robybp.routerimplementation.screens.three

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
import com.robybp.routerimplementation.screens.one.FragmentOneViewModel
import com.robybp.routerimplementation.screens.two.FragmentTwoViewModel

class FragmentThree : Fragment() {

    private lateinit var fragmentOneButton: Button
    private lateinit var fragmentTwoButton: Button

    private val model: FragmentThreeViewModel by lazy {

        val factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                FragmentThreeViewModel(RoutingActionMediator) as T
        }

        ViewModelProvider(this, factory).get(FragmentThreeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_three, container, false)
        fragmentOneButton = view.findViewById(R.id.f3_fragment_one_button)
        fragmentTwoButton = view.findViewById(R.id.f3_fragment_two_button)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        fragmentOneButton.setOnClickListener {
            model.goToFragmentOne()
        }

        fragmentTwoButton.setOnClickListener {
            model.goToFragmentTwo()
        }
        super.onViewCreated(view, savedInstanceState)
    }
}
