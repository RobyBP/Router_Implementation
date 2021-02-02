package com.robybp.routerimplementation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.robybp.routerimplementation.navigation.Router
import com.robybp.routerimplementation.navigation.RouterImpl
import com.robybp.routerimplementation.navigation.RoutingActionConsumer
import com.robybp.routerimplementation.navigation.RoutingActionMediator

class MainActivity : AppCompatActivity(), RoutingActionConsumer {

    private val router = RouterImpl(this, supportFragmentManager)
    private val routingActionMediator = RoutingActionMediator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        routingActionMediator.registerActiveConsumer(this)
        routingActionMediator.dispatch(Router::goToFragmentOne)
    }

    override fun onStop() {
        super.onStop()
        routingActionMediator.deregisterActiveActionConsumer()
    }

    override fun onRoutingAction(routingAction: (Router) -> Unit) = routingAction(router)

}
