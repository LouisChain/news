package com.huynn109.chappiebothometest.util;

import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;

import com.github.curioustechizen.ago.RelativeTimeTextView;
import com.huynn109.chappiebothometest.util.extension.DateExtKt;

import java.util.Objects;


/**
 * Created by huynn109 on 2019-05-26.
 */
@BindingMethods({
        @BindingMethod(type = RelativeTimeTextView.class, attribute = "app:relative_time_prefix", method = "setPrefix"),
        @BindingMethod(type = RelativeTimeTextView.class, attribute = "app:relative_time_suffix", method = "setSuffix"),
})
public class RelativeTimeTextViewBindingAdapter {
    @BindingAdapter("app:reference_time")
    public static void setReferenceTime(RelativeTimeTextView view, String time) {
        view.setReferenceTime(Objects.requireNonNull(DateExtKt.getDateWithServerTimeStamp(time)).getTime());
    }
}
