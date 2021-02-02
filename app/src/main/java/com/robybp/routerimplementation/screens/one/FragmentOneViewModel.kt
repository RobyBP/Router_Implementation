package com.robybp.routerimplementation.screens.one

import androidx.lifecycle.ViewModel
import com.robybp.routerimplementation.navigation.Router
import com.robybp.routerimplementation.navigation.RoutingActionSource

class FragmentOneViewModel(private val routingActionSource: RoutingActionSource) : ViewModel() {

    fun goToFragmentTwo() {
        routingActionSource.dispatch(Router::goToFragmentTwo)
    }

    fun goToFragmentThree() {
        routingActionSource.dispatch(Router::goToFragmentThree)
    }
}
