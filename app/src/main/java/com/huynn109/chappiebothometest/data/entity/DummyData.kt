package com.huynn109.chappiebothometest.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by huynn109 on 2019-04-19.
 */

@Parcelize
data class DummyData(
    val image: Int? = -1,
    var title: String? = null,
    var subtitle: String? = null
) : Parcelable
