package com.huynn109.chappiebothometest.view

import android.os.Bundle
import android.os.PersistableBundle
import android.util.SparseArray
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.huynn109.chappiebothometest.BR
import com.huynn109.chappiebothometest.viewmodel.MainViewModel
import com.huynn109.chappiebothometest.R
import com.huynn109.chappiebothometest.base.BaseActivity
import com.huynn109.chappiebothometest.databinding.ActivityMainBinding
import com.huynn109.chappiebothometest.view.account.AccountFragment
import com.huynn109.chappiebothometest.view.home.HomeFragment
import com.huynn109.chappiebothometest.view.notification.NotificationFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(MainViewModel::class) {
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    companion object {
        const val SAVED_STATE_CONTAINER_KEY = "ContainerKey"
        const val SAVED_STATE_CURRENT_TAB_KEY = "CurrentTabKey"
    }

    private var savedStateSparseArray = SparseArray<Fragment.SavedState>()
    private var currentSelectItemId = R.id.navigation_home

    override val layoutResId: Int
        get() = R.layout.activity_main

    override fun observerViewModel() {
        getViewModel.test()
    }

    override fun initView(savedInstanceState: Bundle?) {
        setupFragment(savedInstanceState)
    }

    private fun setBottomView() {
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    swapFragments(item.itemId, "Home", "#FFFF00")
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_account -> {
                    swapFragments(item.itemId, "Account", "#FF00FF")
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_notification -> {
                    swapFragments(item.itemId, "Notification", "#00FFFF")
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
        swapFragments(currentSelectItemId, "Home", "#FFFF00")
    }

    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    private fun setupFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            savedStateSparseArray = savedInstanceState.getSparseParcelableArray(SAVED_STATE_CONTAINER_KEY)
            currentSelectItemId = savedInstanceState.getInt(SAVED_STATE_CURRENT_TAB_KEY)
        }
        setBottomView()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState)
        outState.putSparseParcelableArray(SAVED_STATE_CONTAINER_KEY, savedStateSparseArray)
        outState.putInt(SAVED_STATE_CURRENT_TAB_KEY, currentSelectItemId)
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach { fragment ->
            if (fragment != null && fragment.isVisible) {
                with(fragment.childFragmentManager) {
                    if (backStackEntryCount > 0) {
                        popBackStack()
                        return
                    }
                }
            }
        }
        super.onBackPressed()
    }

    private fun swapFragments(@IdRes actionId: Int, key: String, color: String) {
        if (supportFragmentManager.findFragmentByTag(key) == null) {
            savedFragmentState(actionId)
            color.createFragment(key, actionId)
        }
    }

    private fun String.createFragment(key: String, actionId: Int) {
        val fragment = when (key.toLowerCase()) {
            "home" -> HomeFragment.newInstance()
            "account" -> AccountFragment.newInstance()
            else -> NotificationFragment.newInstance()
        }
        fragment.setInitialSavedState(savedStateSparseArray[actionId])
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment, key)
                .commit()
    }

    private fun savedFragmentState(actionId: Int) {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.container)
        if (currentFragment != null) {
            savedStateSparseArray.put(currentSelectItemId,
                    supportFragmentManager.saveFragmentInstanceState(currentFragment)
            )
        }
        currentSelectItemId = actionId
    }

    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {

    }
}
