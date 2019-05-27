package com.huynn109.chappiebothometest.view.home.foryou

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView
import com.huynn109.chappiebothometest.base.BaseViewHolder
import com.huynn109.chappiebothometest.data.entity.binding.NewsImagesItemViewModel
import com.huynn109.chappiebothometest.databinding.ItemGalleryHorizontalBinding
import com.huynn109.chappiebothometest.databinding.ItemNewsHorizontalBinding
import timber.log.Timber

/**
 * Created by huynn109 on 2019-05-26.
 */
class ForYouNewsHorizontalAdapter(private val contentType: ObservableField<String>) : RecyclerView.Adapter<BaseViewHolder>() {
    private val mNewsImageItems: MutableList<NewsImagesItemViewModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (contentType.get()) {
            ForYouAdapter.ContentType.CONTENT_STORY ->
                NewsImagesItemViewHolder(ItemNewsHorizontalBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false))
            else -> GalleryImagesItemViewHolder(ItemGalleryHorizontalBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun getItemCount(): Int {
        return if (mNewsImageItems.isNotEmpty()) {
            mNewsImageItems.size
        } else {
            1
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    fun addItems(repoList: MutableList<NewsImagesItemViewModel> = mutableListOf()) {
        Timber.d(" Size  ${repoList.size}")
        mNewsImageItems.addAll(repoList)
        notifyDataSetChanged()
    }

    fun clearItems() {
        mNewsImageItems.clear()
    }

    inner class NewsImagesItemViewHolder(private val mBinding: ItemNewsHorizontalBinding) : BaseViewHolder(mBinding.root) {
        override fun onBind(position: Int) {
            val mItemViewModel = mNewsImageItems[position]
            mBinding.viewModel = mItemViewModel
            mBinding.executePendingBindings()
        }

    }

    inner class GalleryImagesItemViewHolder(private val mBinding: ItemGalleryHorizontalBinding) : BaseViewHolder(mBinding.root) {
        override fun onBind(position: Int) {
            val mItemViewModel = mNewsImageItems[position]
            mBinding.viewModel = mItemViewModel
            mBinding.executePendingBindings()
        }

    }
}


