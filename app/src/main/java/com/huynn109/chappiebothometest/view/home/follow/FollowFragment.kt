package com.huynn109.chappiebothometest.view.home.follow

import com.huynn109.chappiebothometest.BR
import com.huynn109.chappiebothometest.R
import com.huynn109.chappiebothometest.base.BaseFragment
import com.huynn109.chappiebothometest.databinding.FragmentFollowBinding

class FollowFragment : BaseFragment<FollowViewModel, FragmentFollowBinding>(FollowViewModel::class) {
  override fun getBindingVariable(): Int {
    return BR.viewModel
  }

  override fun getLayoutId(): Int = R.layout.fragment_follow

  companion object {
    const val TAG: String = "FollowFragment"

    fun newInstance(): FollowFragment {
      return FollowFragment()
    }
  }

}
