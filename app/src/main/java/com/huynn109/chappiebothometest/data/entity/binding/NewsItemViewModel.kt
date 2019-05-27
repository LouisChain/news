package com.huynn109.chappiebothometest.data.entity.binding

import android.view.View
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import com.huynn109.chappiebothometest.data.entity.response.NewsFeedResponse
import com.huynn109.chappiebothometest.view.home.foryou.ForYouAdapter
import timber.log.Timber


/**
 * Created by huynn109 on 2019-05-26.
 */
open class NewsItemViewModel(contentType: String?,
                             title: String?,
                             content: NewsFeedResponse.Item.Content?,
                             description: String?,
                             publishedDate: String? = "",
                             avatar: NewsFeedResponse.Item.Avatar?,
                             publisher: NewsFeedResponse.Item.Publisher?,
                             images: List<NewsFeedResponse.Item.Image?>?) {
    val contentType = ObservableField<String>()
    val description = ObservableField<String>()
    val title = ObservableField<String>()
    val imageUrl = ObservableField<String>()
    val content = ObservableField<NewsFeedResponse.Item.Content>()
    val avatar = ObservableField<NewsFeedResponse.Item.Avatar>()
    val publisher = ObservableField<NewsFeedResponse.Item.Publisher>()
    val publishedDate = ObservableField<String>()
    val images = ObservableArrayList<NewsImagesItemViewModel>()
    val imagePreview = ObservableField<String>()

    init {
        this.contentType.set(contentType)
        this.title.set(title)
        this.content.set(content)
        this.description.set(description)
        this.avatar.set(avatar)
        if (contentType == ForYouAdapter.ContentType.CONTENT_OVERVIEW) {
            this.imageUrl.set("https://www.ingredientsnetwork.com/47/pdcnewsitem/07/34/66/natural.jpeg")
        }
        this.publisher.set(publisher)
        this.publishedDate.set(publishedDate)
        images?.let { image -> this.images.addAll(image.map { NewsImagesItemViewModel(href = it?.href, contentType = contentType) }) }
        Timber.d("Testing ${content?.previewImage?.href}")
        content?.previewImage?.href?.let { this.imagePreview.set("https://image.24h.com.vn/upload/1-2019/images/2019-03-07/1551953361-748-untitled-1-1551945142-width640height480.jpg") }
    }

    fun showDescription(): Int {
        return if (description.get().isNullOrEmpty()) View.GONE else View.VISIBLE
    }

}