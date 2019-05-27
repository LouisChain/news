package com.huynn109.chappiebothometest.util;

import android.content.Context;
import android.widget.ImageView;

import androidx.core.util.TimeUtils;
import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.github.curioustechizen.ago.RelativeTimeTextView;
import com.huynn109.chappiebothometest.R;
import com.huynn109.chappiebothometest.data.entity.binding.NewsImagesItemViewModel;
import com.huynn109.chappiebothometest.data.entity.binding.NewsItemViewModel;
import com.huynn109.chappiebothometest.util.extension.DateExtKt;
import com.huynn109.chappiebothometest.view.home.foryou.ForYouAdapter;
import com.huynn109.chappiebothometest.view.home.foryou.ForYouNewsHorizontalAdapter;


import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Timer;

import de.hdodenhof.circleimageview.CircleImageView;
import timber.log.Timber;

public final class BindingUtils {

    private BindingUtils() {
        // This class is not publicly instantiable
    }

    @BindingAdapter({"adapter"})
    public static void addNewsItems(RecyclerView recyclerView, List<NewsItemViewModel> newsItemViewModelList) {
        ForYouAdapter adapter = (ForYouAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(newsItemViewModelList);
        }
    }

    @BindingAdapter({"adapter"})
    public static void addNewsImagesItem(RecyclerView recyclerView, List<NewsImagesItemViewModel> itemViewModel) {
        ForYouNewsHorizontalAdapter adapter = (ForYouNewsHorizontalAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(itemViewModel);
        }
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Timber.d(url);
        Glide.with(context).load(url).into(imageView);
    }

    @BindingAdapter("imageIcon")
    public static void setImageIcon(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Timber.d(url);
        Glide.with(context).load(url).placeholder(R.drawable.ic_account_circle_black_18dp).override(15, 15).into(imageView);
    }
}


