package com.huynn109.chappiebothometest.view.account

import com.huynn109.chappiebothometest.BR
import com.huynn109.chappiebothometest.R
import com.huynn109.chappiebothometest.base.BaseFragment
import com.huynn109.chappiebothometest.databinding.FragmentAccountBinding

class AccountFragment : BaseFragment<AccountViewModel, FragmentAccountBinding>(AccountViewModel::class) {
  override fun getBindingVariable(): Int {
    return BR.viewModel
  }

  override fun getLayoutId(): Int = R.layout.fragment_account

  companion object {
    const val TAG: String = "AccountFragment"

    fun newInstance(): AccountFragment {
      return AccountFragment()
    }
  }

}
