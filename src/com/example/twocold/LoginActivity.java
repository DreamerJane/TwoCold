package com.example.twocold;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity implements OnClickListener {
	private EditText userName;
	private EditText password;
	private Button backBtn;
	private Button registerBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);
		userName = (EditText) findViewById(R.id.user_name);
		password = (EditText) findViewById(R.id.password);
		backBtn = (Button) findViewById(R.id.back_btn);
		registerBtn = (Button) findViewById(R.id.register_btn);
		backBtn.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.back_btn :
			finish();
			break;
		case R.id.register_btn :
			break;
		default:
			break;
		}
	}
	
}
