package com.robybp.routerimplementation.navigation

interface RoutingActionConsumer {

    fun onRoutingAction(routingAction: (Router) -> Unit)
}
