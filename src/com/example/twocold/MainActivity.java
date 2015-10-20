package com.example.twocold;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends Activity {

	private static final int COUNT_NUMBER = 2000;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        WelcomPageTimer welcomPageTimer = new WelcomPageTimer(COUNT_NUMBER, 1000);
        welcomPageTimer.start();

    }
    
    class WelcomPageTimer extends CountDownTimer {
    	
    	public WelcomPageTimer(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
		}

		@Override
    	public void onTick(long millisUntilFinished) {
    		//countDown.setText(millisUntilFinished / 1000 + "√Î");
    	}
    	
    	@Override
    	public void onFinish() {
    		finish();
    		startActivity(new Intent(MainActivity.this, BaseActivity.class));
		
    	}

    }
    
}
