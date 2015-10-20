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

public class OneFragment extends Fragment {

	private Handler mHandler;
	public WebView oneWebView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_one, container, false);
		return v;
	}
	
	@Override
	public void onStart() {
		super.onStart();
		oneWebView = (WebView) getActivity().findViewById(R.id.one_web_view);
		oneWebView.getSettings().setJavaScriptEnabled(true);
		oneWebView.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}
		});
		mHandler = new Handler(){
			public void handleMessage(android.os.Message msg) {
				oneWebView.loadUrl("http://m.wufazhuce.com");
			}
		};
		Message msg = new Message();
		mHandler.sendMessage(msg);
	}

}
