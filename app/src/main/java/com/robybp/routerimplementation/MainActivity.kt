package com.robybp.routerimplementation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.robybp.routerimplementation.navigation.Router
import com.robybp.routerimplementation.navigation.RoutingActionConsumer
import com.robybp.routerimplementation.navigation.RoutingActionSource
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity(), RoutingActionConsumer {

    private val router: Router by inject(parameters = { parametersOf(this) })

    private val routingActionMediator by inject<RoutingActionSource>()

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
