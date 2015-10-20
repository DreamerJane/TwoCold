package com.example.twocold;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;

public class HomeFragment extends Fragment implements OnPageChangeListener {

	private Activity aty;
	
	//viewpager
	private ViewPager viewPager;
	//存放图片的列表，用于和viewpager绑定的list
	private List<View> imgsList = new ArrayList<View>();
	//viewpager显示图片
	private final int []imgs = {R.drawable.xiaoye1,
								R.drawable.xiaoye2,
								R.drawable.xiaoye3,
								R.drawable.xiaoye4};
	//存放点的数组
	private ImageView dots[];
	private int curDotNo;
	
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_home, container, false);
		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		aty = getActivity();
		viewPager = (ViewPager) aty.findViewById(R.id.view_pager);
		initImgs();
	}

	@Override
	public void onStart() {
		super.onStart();
		ViewPagerAdapter adapter = new ViewPagerAdapter(imgsList);
		viewPager.setAdapter(adapter);
		viewPager.setOnPageChangeListener(this);
		initDots();
	}


	private void initDots() {
		LinearLayout dotsLayout = (LinearLayout) aty.findViewById(R.id.linear_layout);
		dots = new ImageView[imgs.length];
		for(int i = 0; i < imgs.length; i++) {
			dots[i] = (ImageView) dotsLayout.getChildAt(i);
			dots[i].setEnabled(true);
		}
		curDotNo = 0;
		dots[curDotNo].setEnabled(false);
		
	}

	private void initImgs() {
		LinearLayout.LayoutParams imgsParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		for(int i = 0; i < imgs.length; i++) {
			ImageView imageView = new ImageView(aty);
			imageView.setLayoutParams(imgsParams);
			imageView.setImageResource(imgs[i]);
			imageView.setScaleType(ScaleType.CENTER_CROP);
			imgsList.add(imageView);
		}
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int position) {
		if(position < 0 || position > imgsList.size()) {
			return;
		}
		dots[position].setEnabled(false);
		dots[curDotNo].setEnabled(true);
		curDotNo = position;
	}
	
}
