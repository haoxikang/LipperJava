package com.fallllllll.lipper.ui.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.support.v7.widget.Toolbar;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.fallllllll.lipper.R;
import com.fallllllll.lipper.core.activity.BaseActivity;
import com.fallllllll.lipper.core.constants.BaseUrl;
import com.fallllllll.lipper.core.constants.DribbbleID;
import com.fallllllll.lipper.databinding.ActivityLoginWebBinding;
import com.fallllllll.lipper.utils.MDStatusBarCompat;
import com.fallllllll.lipper.utils.RandomUtils;

/**
 * Created by fallllllll on 2017/3/11.
 * GitHub :  https://github.com/348476129/Lipper
 */

public class LoginWebActivity extends BaseActivity {
    private ProgressBar mProgressBar;
    private Toolbar mToolbar;
    private boolean isLoadUrl = false;


    @Override
    protected void initViewAndData() {
        ActivityLoginWebBinding mActivityLoginWebBinding = DataBindingUtil.setContentView(this, R.layout.activity_login_web);
        MDStatusBarCompat.setOrdinaryToolBar(this);
        mToolbar = mActivityLoginWebBinding.toolbar;
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        WebView mWebView = mActivityLoginWebBinding.webView;
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
        url = url + "authorize?client_id=" + DribbbleID.CLIENT_ID + "&redirect_uri=" + DribbbleID.CALLBACK_URL + "&state=" + RandomUtils.getRandomString(6) + "&scope=public+write+comment+upload";
        return url;
    }

    @Override
    protected void initListeners() {
        mToolbar.setNavigationOnClickListener(v -> finish());
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
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            loadingUrl(view,url);
            return false;
        }
    }

    private void loadingUrl(WebView webView,String url){
        if (!isLoadUrl) {
            if (!url.contains(DribbbleID.CALLBACK_URL + "/?code")) {
                webView.loadUrl(url);
            } else {
                isLoadUrl = true;
                Intent intent = new Intent();
                intent.putExtra(LoginActivity.LOGIN_CODE_KEY, url);
                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }

}
