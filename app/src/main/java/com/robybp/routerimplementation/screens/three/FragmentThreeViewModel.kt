package com.robybp.routerimplementation.screens.three

import androidx.lifecycle.ViewModel
import com.robybp.routerimplementation.navigation.Router
import com.robybp.routerimplementation.navigation.RoutingActionSource

class FragmentThreeViewModel(private val routingActionSource: RoutingActionSource) : ViewModel() {

    fun goToFragmentOne() {
        routingActionSource.dispatch(Router::goToFragmentOne)
    }

    fun goToFragmentTwo() {
        routingActionSource.dispatch(Router::goToFragmentTwo)
    }
}
