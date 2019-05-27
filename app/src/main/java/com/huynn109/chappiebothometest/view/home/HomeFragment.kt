package com.huynn109.chappiebothometest.view.home

import android.os.Bundle
import android.view.View
import com.huynn109.chappiebothometest.BR
import com.huynn109.chappiebothometest.R
import com.huynn109.chappiebothometest.base.BaseFragment
import com.huynn109.chappiebothometest.base.BasePagerAdapter
import com.huynn109.chappiebothometest.util.widget.TabLayoutMediator
import com.huynn109.chappiebothometest.view.home.follow.FollowFragment
import com.huynn109.chappiebothometest.view.home.football.FootballFragment
import com.huynn109.chappiebothometest.view.home.foryou.ForYouFragment
import com.huynn109.chappiebothometest.view.home.life.LifeFragment
import com.huynn109.chappiebothometest.view.home.tech.TechFragment
import com.huynn109.chappiebothometest.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(HomeViewModel::class) {

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int = R.layout.fragment_home

    companion object {
        const val TAG: String = "HomeFragment"

        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        // TODO: add observer view model
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewpager(savedInstanceState)
    }

    private fun setupViewpager(savedInstanceState: Bundle?) {
        childFragmentManager.let {
            currentActivity?.lifecycle?.let { it1 ->
                BasePagerAdapter(it, it1)
            }?.apply {
                addFrag(FollowFragment.newInstance(), getString(R.string.text_follow))
                addFrag(ForYouFragment.newInstance(), getString(R.string.text_for_you))
                addFrag(FootballFragment.newInstance(), getString(R.string.text_football))
                addFrag(TechFragment.newInstance(), getString(R.string.text_tech))
                addFrag(LifeFragment.newInstance(), getString(R.string.text_life))
                viewPager.adapter = this
                TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                    tab.text = this.getTitle(position)
                }.attach()
            }
        }
        viewPager.isUserInputEnabled = false
    }

}
