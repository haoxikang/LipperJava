package com.fallllllll.lipper.utils;

import android.databinding.BindingAdapter;
import android.net.Uri;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Administrator on 2017/4/28/028.
 */

public class BindingUtils {
    @BindingAdapter("frescoImageUri")
    public static void showImageByUrl(final SimpleDraweeView simpleDraweeView, String url) {
        FrescoUtils.displayWithResize(600, 600, Uri.parse(url), simpleDraweeView);
    }

    @BindingAdapter("frescoImageUriWithSmallSize")
    public static void showImageByUrlWithSmallSize(final SimpleDraweeView simpleDraweeView, String url) {
        FrescoUtils.displayWithResize(350, 350, Uri.parse(url), simpleDraweeView);
    }
    @BindingAdapter("frescoImageUriWithTinySize")
    public static void showImageByUrlWithTinySize(final SimpleDraweeView simpleDraweeView, String url) {
        FrescoUtils.displayWithResize(50, 50, Uri.parse(url), simpleDraweeView);
    }
}