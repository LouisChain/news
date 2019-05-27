package com.huynn109.chappiebothometest.data.entity.binding

import androidx.databinding.ObservableField

/**
 * Created by huynn109 on 2019-05-26.
 */
open class NewsImagesItemViewModel(contentType: String?, href: String?) {
    val href = ObservableField<String>()
    val contentType = ObservableField<String>()

    init {
        this.href.set(href)
        this.contentType.set(contentType)
    }
}