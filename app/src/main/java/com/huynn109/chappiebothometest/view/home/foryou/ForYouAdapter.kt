package com.huynn109.chappiebothometest.view.home.foryou

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IntDef
import androidx.annotation.StringDef
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.huynn109.chappiebothometest.BR
import com.huynn109.chappiebothometest.base.BaseViewHolder
import com.huynn109.chappiebothometest.data.entity.binding.NewsEmptyItemViewModel
import com.huynn109.chappiebothometest.data.entity.binding.NewsItemViewModel
import com.huynn109.chappiebothometest.databinding.*
import com.huynn109.chappiebothometest.view.home.foryou.ForYouAdapter.ContentType.Companion.CONTENT_ARTICLE
import com.huynn109.chappiebothometest.view.home.foryou.ForYouAdapter.ContentType.Companion.CONTENT_GALLERY
import com.huynn109.chappiebothometest.view.home.foryou.ForYouAdapter.ContentType.Companion.CONTENT_LONG_FORM
import com.huynn109.chappiebothometest.view.home.foryou.ForYouAdapter.ContentType.Companion.CONTENT_OVERVIEW
import com.huynn109.chappiebothometest.view.home.foryou.ForYouAdapter.ContentType.Companion.CONTENT_STORY
import com.huynn109.chappiebothometest.view.home.foryou.ForYouAdapter.ContentType.Companion.CONTENT_VIDEO

import com.huynn109.chappiebothometest.view.home.foryou.ForYouAdapter.ViewType.Companion.ARTICLE
import com.huynn109.chappiebothometest.view.home.foryou.ForYouAdapter.ViewType.Companion.EMPTY
import com.huynn109.chappiebothometest.view.home.foryou.ForYouAdapter.ViewType.Companion.GALLERY
import com.huynn109.chappiebothometest.view.home.foryou.ForYouAdapter.ViewType.Companion.LONG_FORM
import com.huynn109.chappiebothometest.view.home.foryou.ForYouAdapter.ViewType.Companion.OVERVIEW
import com.huynn109.chappiebothometest.view.home.foryou.ForYouAdapter.ViewType.Companion.STORY
import com.huynn109.chappiebothometest.view.home.foryou.ForYouAdapter.ViewType.Companion.VIDEO

/**
 * Created by huynn109 on 2019-05-26.
 */

class ForYouAdapter : RecyclerView.Adapter<BaseViewHolder>() {

    @StringDef(CONTENT_OVERVIEW, CONTENT_ARTICLE, CONTENT_STORY, CONTENT_GALLERY, CONTENT_VIDEO, CONTENT_LONG_FORM)
    @Retention(AnnotationRetention.SOURCE)
    annotation class ContentType {
        companion object {
            const val CONTENT_OVERVIEW = "overview"
            const val CONTENT_ARTICLE = "article"
            const val CONTENT_STORY = "story"
            const val CONTENT_GALLERY = "gallery"
            const val CONTENT_VIDEO = "video"
            const val CONTENT_LONG_FORM = "long_form"
        }
    }

    @IntDef(OVERVIEW, ARTICLE, STORY, GALLERY, VIDEO, LONG_FORM, EMPTY)
    @Retention(AnnotationRetention.SOURCE)
    annotation class ViewType {
        companion object {
            const val OVERVIEW = 0
            const val ARTICLE = 1
            const val STORY = 2
            const val GALLERY = 3
            const val VIDEO = 4
            const val LONG_FORM = 5
            const val EMPTY = 6
        }
    }

    private val mNewsItem: MutableList<NewsItemViewModel> = mutableListOf()

    private var mListener: ForYouAdapterListener? = null

    override fun getItemCount(): Int {
        return if (mNewsItem.isNotEmpty()) {
            mNewsItem.size
        } else {
            1
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            mNewsItem.isNotEmpty() -> {
                return when (mNewsItem[position].contentType.get()) {
                    CONTENT_OVERVIEW -> OVERVIEW
                    CONTENT_ARTICLE -> ARTICLE
                    CONTENT_GALLERY -> GALLERY
                    CONTENT_LONG_FORM -> LONG_FORM
                    CONTENT_STORY -> STORY
                    CONTENT_VIDEO -> VIDEO
                    else -> EMPTY
                }
            }
            else -> EMPTY
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            OVERVIEW -> {
                val itemStoryBinding = ItemOverviewBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
                OverviewItemViewHolder(itemStoryBinding)
            }
            ARTICLE -> {
                val itemStoryBinding = ItemArticleBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
                ArticleItemViewHolder(itemStoryBinding)
            }
            STORY -> {
                val itemStoryBinding = ItemStoryBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
                StoryItemViewHolder(itemStoryBinding)
            }
            GALLERY -> {
                val itemStoryBinding = ItemGalleryBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
                GalleryItemViewHolder(itemStoryBinding)
            }
            LONG_FORM -> {
                val itemLongFormBinding = ItemGalleryBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
                GalleryItemViewHolder(itemLongFormBinding)
            }
            VIDEO -> {
                val itemVideoBinding = ItemVideoBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
                VideoItemViewHolder(itemVideoBinding)
            }
            EMPTY -> {
                val emptyViewBinding = ItemNewsEmptyViewBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
                EmptyViewHolder(emptyViewBinding)
            }
            else -> {
                val emptyViewBinding = ItemNewsEmptyViewBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
                EmptyViewHolder(emptyViewBinding)
            }
        }
    }

    fun addItems(repoList: MutableList<NewsItemViewModel> = mutableListOf()) {
        mNewsItem.addAll(repoList)
        notifyDataSetChanged()
    }

    fun clearItems() {
        mNewsItem.clear()
    }

    fun setListener(listener: ForYouAdapterListener) {
        this.mListener = listener
    }

    interface ForYouAdapterListener {

        fun onRetryClick()
    }

    inner class EmptyViewHolder(private val mBinding: ItemNewsEmptyViewBinding) :
            BaseViewHolder(mBinding.root), NewsEmptyItemViewModel.OpenSourceEmptyItemViewModelListener {

        override fun onBind(position: Int) {
            val emptyItemViewModel = NewsEmptyItemViewModel(this)
            mBinding.viewModel = emptyItemViewModel
        }

        override fun onRetryClick() {
            mListener?.onRetryClick()
        }
    }

    inner class ArticleItemViewHolder(private val mBinding: ItemArticleBinding) :
            BaseViewHolder(mBinding.root), View.OnClickListener {

        override fun onBind(position: Int) {
            val mItemViewModel = mNewsItem[position]
            mBinding.viewModel = mItemViewModel
            mBinding.executePendingBindings()
        }

        override fun onClick(view: View) {

        }
    }

    inner class OverviewItemViewHolder(private val mBinding: ItemOverviewBinding) :
            BaseViewHolder(mBinding.root), View.OnClickListener {

        override fun onBind(position: Int) {
            val mItemViewModel = mNewsItem[position]
            mBinding.viewModel = mItemViewModel
            mBinding.executePendingBindings()
        }

        override fun onClick(view: View) {

        }
    }

    inner class StoryItemViewHolder(private val mBinding: ItemStoryBinding) :
            BaseViewHolder(mBinding.root), View.OnClickListener {

        override fun onBind(position: Int) {
            val mItemViewModel = mNewsItem[position]
            mBinding.viewModel = mItemViewModel
            val forYouNewsHorizontalAdapter = ForYouNewsHorizontalAdapter(mItemViewModel.contentType).apply {
                addItems(repoList = mNewsItem[position].images)
            }
            with(mBinding) {
                setVariable(BR.adapter, forYouNewsHorizontalAdapter)
            }
            mBinding.executePendingBindings()
        }

        override fun onClick(view: View) {

        }
    }

    inner class GalleryItemViewHolder(private val mBinding: ItemGalleryBinding) :
            BaseViewHolder(mBinding.root), View.OnClickListener {

        override fun onBind(position: Int) {
            val mItemViewModel = mNewsItem[position]
            mBinding.viewModel = mItemViewModel
            val forYouNewsHorizontalAdapter = ForYouNewsHorizontalAdapter(mItemViewModel.contentType).apply {
                addItems(repoList = mNewsItem[position].images)
            }
            with(mBinding) {
                mBinding.recyclerView.apply {
                    this.layoutManager = GridLayoutManager(this.context, if (mNewsItem[position].images.size < 5) mNewsItem[position].images.size else 4)
                }
                setVariable(BR.adapter, forYouNewsHorizontalAdapter)
            }
            mBinding.executePendingBindings()
        }

        override fun onClick(view: View) {

        }
    }

    inner class VideoItemViewHolder(private val mBinding: ItemVideoBinding) :
            BaseViewHolder(mBinding.root), View.OnClickListener {

        override fun onBind(position: Int) {
            val mItemViewModel = mNewsItem[position]
            mBinding.viewModel = mItemViewModel
            val forYouNewsHorizontalAdapter = ForYouNewsHorizontalAdapter(mItemViewModel.contentType).apply {
                addItems(repoList = mNewsItem[position].images)
            }
            with(mBinding) {
                mBinding.recyclerView.apply {
                    this.layoutManager = GridLayoutManager(this.context, if (mNewsItem[position].images.size < 5) mNewsItem[position].images.size else 4)
                }
                setVariable(BR.adapter, forYouNewsHorizontalAdapter)
            }
            mBinding.executePendingBindings()
        }

        override fun onClick(view: View) {

        }
    }
}