package com.robybp.routerimplementation.screens.two

import androidx.lifecycle.ViewModel
import com.robybp.routerimplementation.navigation.Router
import com.robybp.routerimplementation.navigation.RoutingActionSource

class FragmentTwoViewModel(private val routingActionSource: RoutingActionSource) : ViewModel() {

    private fun dispatch(routingAction: (Router) -> Unit) {
        routingActionSource.dispatch(routingAction)
    }

    fun goToFragmentThree() {
        dispatch(Router::goToFragmentThree)
    }

    fun goToFragmentOne() {
        dispatch(Router::goToFragmentOne)
    }
}
