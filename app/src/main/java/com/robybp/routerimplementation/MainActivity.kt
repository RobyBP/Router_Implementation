package com.robybp.routerimplementation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.robybp.routerimplementation.fragments.FragmentOne
import com.robybp.routerimplementation.navigation.DeferredFragmentTransaction
import java.util.*

class MainActivity : AppCompatActivity() {
    private var isActive: Boolean? = null
    private val deferredFragmentTransactions = LinkedList<DeferredFragmentTransaction>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        isActive = true
        replaceFragment(FragmentOne())
    }

    override fun onPause() {
        super.onPause()
        Log.d("activity", "Entered paused state")
        isActive = false
    }

    fun replaceFragment(replacingFragment: Fragment){
        if (!isActive!!) {
            val deferredFragmentTransaction = object : DeferredFragmentTransaction(replacingFragment) {
                override fun commit() {
                    replaceFragmentInternal(replacingFragment)
                }
            }

            deferredFragmentTransactions.add(deferredFragmentTransaction)
            }else{
                replaceFragmentInternal(replacingFragment)
        }
    }

    private fun replaceFragmentInternal(replacingFragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_main, replacingFragment)
            commit()
        }
    }

    override fun onPostResume() {
        super.onPostResume()
        while(!deferredFragmentTransactions.isEmpty()){
            deferredFragmentTransactions.poll().commit()
        }
    }
}