package com.example.twocold;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WeiboFragment extends Fragment {

	private Handler mHandler;
	public WebView weiboWebView;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_weibo, container, false);
		return v;
	}
	
	@Override
	public void onStart() {
		super.onStart();
		weiboWebView = (WebView) getActivity().findViewById(R.id.weibo_web_view);
		weiboWebView.getSettings().setJavaScriptEnabled(true);
		weiboWebView.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}
		});
		mHandler = new Handler(){
			public void handleMessage(Message msg) {
				weiboWebView.loadUrl("http://weibo.com/hanhan");
			}
		};
		Message msg = new Message();
		mHandler.sendMessage(msg);
	}
	
}
