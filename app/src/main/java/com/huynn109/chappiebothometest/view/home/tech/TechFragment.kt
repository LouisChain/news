package com.huynn109.chappiebothometest.view.home.tech

import com.huynn109.chappiebothometest.BR
import com.huynn109.chappiebothometest.R
import com.huynn109.chappiebothometest.base.BaseFragment
import com.huynn109.chappiebothometest.databinding.FragmentTechBinding

class TechFragment : BaseFragment<TechViewModel, FragmentTechBinding>(TechViewModel::class) {
  override fun getBindingVariable(): Int {
    return BR.viewModel
  }

  override fun getLayoutId(): Int = R.layout.fragment_tech

  companion object {
    const val TAG: String = "TechFragment"

    fun newInstance(): TechFragment {
      return TechFragment()
    }
  }

}
