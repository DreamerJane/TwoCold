package com.example.twocold;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class BaseActivity extends Activity implements OnClickListener{
	//FrameLayout������fragment
	private HomeFragment homeFragment;
	private WeiboFragment weiboFragment;
	private OneFragment oneFragment;
	private MoreFragment moreFragment;
	private FragmentManager fragManager;
	//�������ϵĵ�¼��ť�������ı�������ť
	public Button login;
	public TextView title;
	public Button share;
	//�ײ�tab���ĸ���ť
	public Button item0_home, item1_weibo, item2_one, item3_more;
	//����listview
	private ListView listView;
	//��ŷ����ַ����б�
	private List<String> list = new ArrayList<String>();
	//����webview������ҳ��WebClient
	public StartClient webViewClient = new StartClient();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_base);
		
		initViews();
		fragManager = getFragmentManager();
		setTabSelection(0);
		
	}
	

	private void setTabSelection(int i) {
		FragmentTransaction fragmentTransaction = fragManager.beginTransaction();
		hideFragments(fragmentTransaction);
		
		switch(i) {
		case 0:
			title.setText("��ҳ");
			if(homeFragment == null) {
				homeFragment = new HomeFragment();
				fragmentTransaction.add(R.id.content, homeFragment);
			}else {
				fragmentTransaction.show(homeFragment);
			}
			break;
		case 1:
			title.setText("΢��");
			if(weiboFragment == null) {
				weiboFragment = new WeiboFragment();
				fragmentTransaction.add(R.id.content, weiboFragment);
			} else {
				fragmentTransaction.show(weiboFragment);
			}
			break;
		case 2:
			title.setText("ONE��һ����");
			if(oneFragment == null) {
				oneFragment = new OneFragment();
				fragmentTransaction.add(R.id.content, oneFragment);
			} else {
				fragmentTransaction.show(oneFragment);
			}
			break;
		case 3:
			title.setText("����");
			if(moreFragment == null) {
				moreFragment = new MoreFragment();
				fragmentTransaction.add(R.id.content, moreFragment);
			} else {
				fragmentTransaction.show(moreFragment);
			}
			break;
		}
		fragmentTransaction.commit();
	}

	private void hideFragments(FragmentTransaction transaction) {
		if(homeFragment != null) {
			transaction.hide(homeFragment);
		}
		if(weiboFragment != null) {
			transaction.hide(weiboFragment);
		}
		if(oneFragment != null) {
			transaction.hide(oneFragment);
		}
		if(moreFragment != null) {
			transaction.hide(moreFragment);
		}
	}

	private void initViews() {
		login = (Button) findViewById(R.id.login);
		title = (TextView) findViewById(R.id.title);
		share = (Button) findViewById(R.id.share);
		item0_home = (Button) findViewById(R.id.item0_home);
		item1_weibo = (Button) findViewById(R.id.item1_weibo);
		item2_one = (Button) findViewById(R.id.item2_one);
		item3_more = (Button) findViewById(R.id.item3_more);
		
		login.setOnClickListener(this);
		share.setOnClickListener(this);
		item0_home.setOnClickListener(this);
		item1_weibo.setOnClickListener(this);
		item2_one.setOnClickListener(this);
		item3_more.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.login:
			startActivity(new Intent(BaseActivity.this, LoginActivity.class));
			break;
		case R.id.share:
			new ShareDialogFragment().show(getFragmentManager(), "share_dialog");
			break;
		case R.id.item0_home:
			setTabSelection(0);
			break;
		case R.id.item1_weibo:
			setTabSelection(1);
			break;
		case R.id.item2_one:
			setTabSelection(2);
			break;
		case R.id.item3_more:
			setTabSelection(3);
			break;
		default:	
			break;
		}
	}

	private void initList() {
		list.add("����΢��");
		list.add("QQ����");
		list.add("QQ�ռ�");
		list.add("΢�ź���");
		list.add("����Ȧ");
	}
	
	class StartClient extends WebViewClient {

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
		}
		
	}
	
	long lastClickTime = 0;
	@Override
	public void onBackPressed() {
		if(lastClickTime <= 0) {
			Toast.makeText(BaseActivity.this, "�ٰ�һ���˳�", Toast.LENGTH_SHORT).show();
			lastClickTime = System.currentTimeMillis();
		}else {
			long currentClickTime = System.currentTimeMillis();
			if((currentClickTime - lastClickTime) <1000) {
				finish();
			}else {
				Toast.makeText(BaseActivity.this, "�ٰ�һ���˳�", Toast.LENGTH_SHORT).show();
				lastClickTime = currentClickTime;
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case R.id.log_out_menuitem:
			ExitDialogFragment dialog = new ExitDialogFragment();
			dialog.show(getFragmentManager(), "exit_dialog");
			break;
		default:
			break;
		}
		return true;
		}

	}

