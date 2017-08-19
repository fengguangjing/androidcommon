/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-4-12下午3:33:50
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.android.activity.common;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.open.android.R;
import com.open.android.activity.CommonFragmentActivity;
import com.open.android.utils.DownLoadAsyncTask;
 

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-4-12下午3:33:50
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class CommonWebViewActivity extends CommonFragmentActivity {
	public static final String TAG = CommonWebViewActivity.class.getSimpleName();
	public WebView webview;
	public String url = "";
//	public String url = "http://192.168.1.15:8080/index.html#/goods";
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_common_web);
		init();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.newsinfo.CommonActivity#findView()
	 */
	@SuppressLint("NewApi") protected void findView() {
		// TODO Auto-generated method stub
		webview = (WebView) findViewById(R.id.webview);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {   
            webview.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
		}
	}
	/* (non-Javadoc)
	 * @see com.open.enrz.activity.CommonFragmentActivity#bindEvent()
	 */
	@Override
	protected void bindEvent() {
		// TODO Auto-generated method stub
		super.bindEvent();
		webview.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
            	WebView.HitTestResult result = ((WebView) v).getHitTestResult();
            	int type = result.getType();
            	switch (type) {
				case WebView.HitTestResult.IMAGE_TYPE:
				case WebView.HitTestResult.IMAGE_ANCHOR_TYPE:
				case WebView.HitTestResult.SRC_ANCHOR_TYPE:
				case WebView.HitTestResult.SRC_IMAGE_ANCHOR_TYPE:
					final String imgurl = result.getExtra();
					AlertDialog.Builder builder = new AlertDialog.Builder(CommonWebViewActivity.this);  
		               builder.setItems(new String[]{CommonWebViewActivity.this.getResources().getString(R.string.save_picture)}, new DialogInterface.OnClickListener() {  
		                   @Override  
		                   public void onClick(DialogInterface dialog, int which) {  
		                       new DownLoadAsyncTask(CommonWebViewActivity.this,imgurl).execute();  
		                   }  
		               });  
		               builder.show();  
					break;
				default:
					break;
				}
				return false;
                }
            });
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.newsinfo.CommonActivity#initValue()
	 */
	protected void initValue() {
		// TODO Auto-generated method stub
		WebSettings webSettings = webview.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webSettings.setSupportZoom(true);
		webview.setWebViewClient(mWebViewClientBase);
		webview.setWebChromeClient(mWebChromeClientBase);
		// 设置出现缩放工具
		webSettings.setBuiltInZoomControls(true);
		// 扩大比例的缩放
		webSettings.setUseWideViewPort(true);
		webSettings.setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
		webSettings.setLoadWithOverviewMode(true);
		if (getIntent().getStringExtra("URL") != null) {
			url = getIntent().getStringExtra("URL");
		}
		Log.i("WebViewActivity", "url==" + url);
		loadUrl();
	}
	
	public void loadUrl(){
		webview.loadUrl(url);
	}

	public WebViewClientBase mWebViewClientBase = new WebViewClientBase();

	public class WebViewClientBase extends WebViewClient {

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// TODO Auto-generated method stub
			Log.i("WebViewClientBase", "url==" + url);
//			if(url.contains("ed2k://|file") ||
//					url.contains("thunder://") 
//					||url.contains("thunder://")
//					||url.contains("xfplay://")
//					||url.contains("qqdl://")
//					||url.contains("flashget://")
//					){
//				ClipboardManager copy = (ClipboardManager)  getSystemService(Context.CLIPBOARD_SERVICE);  
//                copy.setText(url);
////                DownLoadUtils.downLoad(EnrzWebViewActivity.this, url);
//				return true;
//			}
			return super.shouldOverrideUrlLoading(view, url);
		}

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			// TODO Auto-generated method stub
			super.onPageStarted(view, url, favicon);
		}

		@Override
		public void onPageFinished(WebView view, String url) {
			// TODO Auto-generated method stub
			super.onPageFinished(view, url);
		}

		@Override
		public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
			// TODO Auto-generated method stub
			super.onReceivedError(view, errorCode, description, failingUrl);
		}

		@Override
		public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
			// TODO Auto-generated method stub
			super.doUpdateVisitedHistory(view, url, isReload);
		}
	}

	public WebChromeClientBase mWebChromeClientBase = new WebChromeClientBase();

	private class WebChromeClientBase extends WebChromeClient {
		@Override
		public void onProgressChanged(WebView view, int newProgress) {
		}

		@Override
		public void onReceivedTitle(WebView view, String title) {
			// TODO Auto-generated method stub
			super.onReceivedTitle(view, title);
		}

		@Override
		public void onReceivedTouchIconUrl(WebView view, String url, boolean precomposed) {
			// TODO Auto-generated method stub
			super.onReceivedTouchIconUrl(view, url, precomposed);
		}

		@Override
		public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
			// TODO Auto-generated method stub
			return super.onCreateWindow(view, isDialog, isUserGesture, resultMsg);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onBackPressed()
	 */
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		if (webview.canGoBack()) {
			webview.goBack();
		} else {
			super.onBackPressed();
		}
	}

	public static void startCommonWebViewActivity(Context context, String url) {
		Intent intent = new Intent();
		intent.putExtra("URL", url);
		intent.setClass(context, CommonWebViewActivity.class);
		context.startActivity(intent);
	}
}
