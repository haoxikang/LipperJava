package com.example.dribbble.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.dribbble.R;
import com.example.dribbble.core.activity.BaseActivity;
import com.example.dribbble.core.constants.BaseUrl;
import com.example.dribbble.core.constants.DribbbleID;
import com.example.dribbble.databinding.ActivityLoginWebBinding;
import com.example.dribbble.utils.MDStatusBarCompat;
import com.example.dribbble.utils.RandomUtils;

/**
 * Created by 康颢曦 on 2017/3/11.
 */

public class LoginWebActivity extends BaseActivity {
    private ActivityLoginWebBinding mActivityLoginWebBinding;
    private WebView mWebView;
    private ProgressBar mProgressBar;
    private Toolbar mToolbar;


    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        mActivityLoginWebBinding = DataBindingUtil.setContentView(this, R.layout.activity_login_web);
        MDStatusBarCompat.setOrdinaryToolBar(this);
        mToolbar = mActivityLoginWebBinding.toolbar;
        mToolbar.setTitle(R.string.login);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mWebView = mActivityLoginWebBinding.webView;
        mProgressBar = mActivityLoginWebBinding.progressbar;

        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setAppCacheEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setSupportZoom(true);
        mWebView.setWebChromeClient(new ChromeClient());
        mWebView.setWebViewClient(new WebClient());
        mWebView.loadUrl(getURl());
    }

    private String getURl() {
        String url = BaseUrl.LOGIN_URL;

        url = url + "?client_id=" + DribbbleID.CLIENT_ID + "&redirect_uri=" + DribbbleID.CALLBACK_URL + "&state=" + RandomUtils.getRandomString(6)+"&scope=public+write+comment+upload";
        Log.d("tag", url);
        return url;
    }

    @Override
    protected void initListeners() {
        mToolbar.setNavigationOnClickListener(v -> {
            finish();
        });
    }

    @Override
    protected void inject() {

    }

    private class ChromeClient extends WebChromeClient {

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            mProgressBar.setProgress(newProgress);
        }

    }

    private class WebClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            String url = request.getUrl().toString();
            Log.d("aa", url);

            if (!url.contains(DribbbleID.CALLBACK_URL+"/?code")) {
                view.loadUrl(url);
            } else {
                Intent intent = new Intent();
                intent.putExtra(LoginActivity.LOGIN_CODE_KEY, url);
                setResult(RESULT_OK, intent);
                finish();
            }
            return true;
        }

    }

}
