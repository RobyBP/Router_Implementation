package com.robybp.routerimplementation.navigation

import java.util.*

class RoutingActionMediator : RoutingActionSource {

    private var activeActionConsumer: RoutingActionConsumer? = null
    private val queuedActions = LinkedList<QueuedAction>()

    override fun registerActiveConsumer(consumer: RoutingActionConsumer) {
        this.activeActionConsumer = consumer
    }

    override fun deregisterActiveActionConsumer() {
        this.activeActionConsumer = null
    }

    override fun dispatch(routingAction: (Router) -> Unit) {
        if (activeActionConsumer == null) {
            queuedActions.add(QueuedAction(routingAction))
        } else {
            queuedActions.add(QueuedAction(routingAction))
            flushQueue()
        }
    }

    private fun flushQueue() {
        while (!queuedActions.isEmpty()) {
            activeActionConsumer!!.onRoutingAction(queuedActions.poll().routingAction)
        }
    }

    class QueuedAction(val routingAction: (Router) -> Unit)
}
