package com.huynn109.chappiebothometest.view.home.life

import com.huynn109.chappiebothometest.BR
import com.huynn109.chappiebothometest.R
import com.huynn109.chappiebothometest.base.BaseFragment
import com.huynn109.chappiebothometest.databinding.FragmentLifeBinding

class LifeFragment : BaseFragment<LifeViewModel, FragmentLifeBinding>(LifeViewModel::class) {
  override fun getBindingVariable(): Int {
    return BR.viewModel
  }

  override fun getLayoutId(): Int = R.layout.fragment_life

  companion object {
    const val TAG: String = "FollowFragment"

    fun newInstance(): LifeFragment {
      return LifeFragment()
    }
  }

}
