package com.huynn109.chappiebothometest.view.home.football

import com.huynn109.chappiebothometest.BR
import com.huynn109.chappiebothometest.R
import com.huynn109.chappiebothometest.base.BaseFragment
import com.huynn109.chappiebothometest.databinding.FragmentFootballBinding

class FootballFragment : BaseFragment<FootballViewModel, FragmentFootballBinding>(FootballViewModel::class) {
  override fun getBindingVariable(): Int {
    return BR.viewModel
  }

  override fun getLayoutId(): Int = R.layout.fragment_football

  companion object {
    const val TAG: String = "FollowFragment"

    fun newInstance(): FootballFragment {
      return FootballFragment()
    }
  }

}
