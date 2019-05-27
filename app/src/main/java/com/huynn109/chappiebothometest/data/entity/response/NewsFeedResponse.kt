package com.huynn109.chappiebothometest.data.entity.response


import com.google.gson.annotations.SerializedName

data class NewsFeedResponse(
        @SerializedName("items")
        val items: List<Item?>?
) {
    data class Item(
            @SerializedName("avatar")
            val avatar: Avatar?,
            @SerializedName("content")
            val content: Content?,
            @SerializedName("content_type")
            val contentType: String?,
            @SerializedName("description")
            val description: String?,
            @SerializedName("document_id")
            val documentId: String?,
            @SerializedName("images")
            val images: List<Image?>?,
            @SerializedName("origin_url")
            val originUrl: String?,
            @SerializedName("published_date")
            val publishedDate: String?,
            @SerializedName("publisher")
            val publisher: Publisher?,
            @SerializedName("title")
            val title: String?
    ) {
        data class Image(
                @SerializedName("height")
                val height: Double?,
                @SerializedName("href")
                val href: String?,
                @SerializedName("main_color")
                val mainColor: String?,
                @SerializedName("width")
                val width: Double?
        )

        data class Publisher(
                @SerializedName("icon")
                val icon: String?,
                @SerializedName("id")
                val id: String?,
                @SerializedName("name")
                val name: String?
        )

        data class Avatar(
                @SerializedName("href")
                val href: String?,
                @SerializedName("main_color")
                val mainColor: String?,
                @SerializedName("width")
                val width: Double?,
                @SerializedName("height")
                val height: String?
        )

        data class Content(
                @SerializedName("href")
                val href: String?,
                @SerializedName("duration")
                val duration: String?,
                @SerializedName("preview_image")
                val previewImage: PreviewImage?
        ) {
            data class PreviewImage(
                    @SerializedName("href")
                    val href: String?,
                    @SerializedName("main_color")
                    val mainColor: String?,
                    @SerializedName("width")
                    val width: Double?,
                    @SerializedName("height")
                    val height: Double?
            )
        }
    }
}