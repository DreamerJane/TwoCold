package com.example.twocold;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MoreFragment extends Fragment implements OnClickListener {

	private View view;
	private Button profileBtn, baikeBtn, musicBtn, pictureBtn, oneShopBtn, recommendationBtn, settingBtn, aboutInfoBtn;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_more, container, false);
		return v;
	}

	@Override
	public void onStart() {
		super.onStart();
		view = getView();
		initButton();
		
	}
	/* 
	 * 初始化Button，并设置监听事件
	 */
	private void initButton() {
		profileBtn = (Button) view.findViewById(R.id.profile_btn);
		baikeBtn = (Button) view.findViewById(R.id.baike_btn);
		musicBtn = (Button) view.findViewById(R.id.music_btn);
		pictureBtn = (Button) view.findViewById(R.id.picture_btn);
		oneShopBtn = (Button) view.findViewById(R.id.one_shop_btn);
		recommendationBtn = (Button) view.findViewById(R.id.recommendation_btn);
		settingBtn = (Button) view.findViewById(R.id.setting_btn);
		aboutInfoBtn = (Button) view.findViewById(R.id.about_info_btn);
		
		profileBtn.setOnClickListener(this);
		baikeBtn.setOnClickListener(this);
		musicBtn.setOnClickListener(this);
		pictureBtn.setOnClickListener(this);
		oneShopBtn.setOnClickListener(this);
		recommendationBtn.setOnClickListener(this);
		settingBtn.setOnClickListener(this);
		aboutInfoBtn.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.profile_btn:
			
			break;
		case R.id.baike_btn:
			
			break;
		case R.id.music_btn:
			
			break;
		case R.id.picture_btn:
			
			break;
		case R.id.one_shop_btn:
			
			break;
		case R.id.recommendation_btn:
	
				break;
		case R.id.setting_btn:
	
				break;
		case R.id.about_info_btn:
				
				break;
		default:
			break;
		}
	}
	
	

}
