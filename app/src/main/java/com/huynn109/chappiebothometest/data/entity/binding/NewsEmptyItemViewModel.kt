package com.huynn109.chappiebothometest.data.entity.binding

/**
 * Created by huynn109 on 2019-05-26.
 */

class NewsEmptyItemViewModel(private val mListener: OpenSourceEmptyItemViewModelListener) {

    fun onRetryClick() {
        mListener.onRetryClick()
    }

    interface OpenSourceEmptyItemViewModelListener {

        fun onRetryClick()
    }
}
