package com.huynn109.chappiebothometest.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView



/**
 * Created by huynn109 on 2019-05-26.
 */


abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun onBind(position: Int)
}