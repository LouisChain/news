package com.huynn109.chappiebothometest.view.notification

import com.huynn109.chappiebothometest.BR
import com.huynn109.chappiebothometest.R
import com.huynn109.chappiebothometest.base.BaseFragment
import com.huynn109.chappiebothometest.databinding.FragmentNotificationBinding

class NotificationFragment : BaseFragment<NotificationViewModel, FragmentNotificationBinding>(NotificationViewModel::class) {
  override fun getBindingVariable(): Int {
    return BR.viewModel
  }

  override fun getLayoutId(): Int = R.layout.fragment_notification

  companion object {
    const val TAG: String = "NotificationFragment"

    fun newInstance(): NotificationFragment {
      return NotificationFragment()
    }
  }

}
