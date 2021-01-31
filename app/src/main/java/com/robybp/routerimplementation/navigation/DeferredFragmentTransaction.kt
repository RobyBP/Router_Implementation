package com.robybp.routerimplementation.navigation

import androidx.fragment.app.Fragment
import com.robybp.routerimplementation.R

abstract class DeferredFragmentTransaction(val replacingFragment: Fragment) {

    val frameLayoutId: Int = R.id.fl_main
    abstract fun commit()
}