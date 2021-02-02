package com.robybp.routerimplementation.navigation

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.robybp.routerimplementation.R
import com.robybp.routerimplementation.screens.one.FragmentOne
import com.robybp.routerimplementation.screens.three.FragmentThree
import com.robybp.routerimplementation.screens.two.FragmentTwo

private const val MAIN_CONTAINER = R.id.fl_main

class RouterImpl(
    private val activity: AppCompatActivity,
    private val fragmentManager: FragmentManager
) : Router {

    override fun goToFragmentOne() {
        fragmentManager.beginTransaction().apply {
            replace(MAIN_CONTAINER, FragmentOne())
            commit()
        }
    }

    override fun goToFragmentTwo() {
        fragmentManager.beginTransaction().apply {
            replace(MAIN_CONTAINER, FragmentTwo())
            commit()
        }
    }

    override fun goToFragmentThree() {
        fragmentManager.beginTransaction().apply {
            add(MAIN_CONTAINER, FragmentThree())
            commit()
        }
    }

}