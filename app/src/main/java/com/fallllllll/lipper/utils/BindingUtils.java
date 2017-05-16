package com.fallllllll.lipper.utils;

import android.databinding.BindingAdapter;
import android.net.Uri;
import android.widget.Switch;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.fallllllll.lipper.core.constants.AppConstants;
import com.fallllllll.lipper.ui.view.widget.MultiLineRadioGroup;

/**
 * Created by Administrator on 2017/4/28/028.
 */

public class BindingUtils {
    @BindingAdapter("frescoImageUri")
    public static void showImageByUrl(final SimpleDraweeView simpleDraweeView, String url) {
        FrescoUtils.display( simpleDraweeView,url,false);
    }

    @BindingAdapter("frescoImageWithGif")
    public static void showImageByUrlWithGif(final SimpleDraweeView simpleDraweeView, String url) {
        FrescoUtils.display( simpleDraweeView,url,true);
    }

    @BindingAdapter("frescoImageUriWithTinySize")
    public static void showImageByUrlWithTinySize(final SimpleDraweeView simpleDraweeView, String url) {
        FrescoUtils.displayWithResize(50, 50, Uri.parse(url), simpleDraweeView);
    }

    @BindingAdapter("setTextNumber")
    public static void showTextNumber(final TextView textView, String number) {
        textView.setText(StringUtils.numberToK(number));
    }

}
