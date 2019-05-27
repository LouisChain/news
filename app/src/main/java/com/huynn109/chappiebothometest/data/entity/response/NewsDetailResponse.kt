package com.huynn109.chappiebothometest.data.entity.response


import com.google.gson.annotations.SerializedName

data class NewsDetailResponse(
    @SerializedName("description")
    val description: String?,
    @SerializedName("document_id")
    val documentId: String?,
    @SerializedName("origin_url")
    val originUrl: String?,
    @SerializedName("published_date")
    val publishedDate: String?,
    @SerializedName("publisher")
    val publisher: Publisher?,
    @SerializedName("sections")
    val sections: List<Section?>?,
    @SerializedName("template_type")
    val templateType: String?,
    @SerializedName("title")
    val title: String?
) {
    data class Publisher(
        @SerializedName("icon") // data:image/jpeg;base64
        val icon: String?,
        @SerializedName("id")
        val id: String?,
        @SerializedName("name")
        val name: String?
    )

    data class Section(
        @SerializedName("content")
        val content: Content?,
        @SerializedName("section_type")
        val sectionType: Int?
    ) {
        data class Content(
            @SerializedName("markups")
            val markups: List<Markup?>?,
            @SerializedName("text")
            val text: String?
        ) {
            data class Markup(
                @SerializedName("end")
                val end: Int?,
                @SerializedName("markup_type")
                val markupType: Int?,
                @SerializedName("start")
                val start: Int?
            )
        }
    }
}