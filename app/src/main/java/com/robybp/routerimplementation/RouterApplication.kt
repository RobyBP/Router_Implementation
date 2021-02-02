package com.robybp.routerimplementation

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.robybp.routerimplementation.navigation.Router
import com.robybp.routerimplementation.navigation.RouterImpl
import com.robybp.routerimplementation.navigation.RoutingActionMediator
import com.robybp.routerimplementation.navigation.RoutingActionSource
import com.robybp.routerimplementation.screens.one.FragmentOneViewModel
import com.robybp.routerimplementation.screens.three.FragmentThreeViewModel
import com.robybp.routerimplementation.screens.two.FragmentTwoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class RouterApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(createModule())
        }
    }

    private fun createModule() =
        module {
            factory<Router> { (activity: AppCompatActivity) ->
                val fragmentManager = activity.supportFragmentManager
                RouterImpl(fragmentManager = fragmentManager)
            }

            single<RoutingActionSource> { RoutingActionMediator() }

            viewModel { FragmentOneViewModel(get()) }

            viewModel { FragmentTwoViewModel(get()) }

            viewModel { FragmentThreeViewModel(get()) }
        }
}
