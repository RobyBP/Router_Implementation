package com.robybp.routerimplementation.navigation

interface RoutingActionSource {

    fun registerActiveConsumer(consumer: RoutingActionConsumer)

    fun deregisterActiveActionConsumer()

    fun dispatch(routingAction: (Router) -> Unit)
}
