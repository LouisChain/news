package com.huynn109.chappiebothometest.view.home.foryou

import android.os.Bundle
import android.view.View
import com.huynn109.chappiebothometest.BR
import com.huynn109.chappiebothometest.R
import com.huynn109.chappiebothometest.base.BaseFragment
import com.huynn109.chappiebothometest.databinding.FragmentForYouBinding
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ForYouFragment : BaseFragment<ForYouViewModel, FragmentForYouBinding>(ForYouViewModel::class) {
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int = R.layout.fragment_for_you

    companion object {
        const val TAG: String = "FollowFragment"

        fun newInstance(): ForYouFragment {
            return ForYouFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    private fun setUp() {
        viewDataBinding?.recyclerView?.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        viewDataBinding?.recyclerView?.itemAnimator = DefaultItemAnimator()
        viewDataBinding?.recyclerView?.adapter = ForYouAdapter()
    }

}
