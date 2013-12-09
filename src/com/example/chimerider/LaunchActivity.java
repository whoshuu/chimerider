package com.example.chimerider;

import com.example.chimerider.information.CContactListActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

public class LaunchActivity extends Activity {

	public int DELTA_TIME = 2000; // 1s
	
	public LaunchActivity() {
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.launch_activity);
		
		new CountDownTimer(DELTA_TIME, 10) {
			
			 public void onTick(long millisUntilFinished) {
			  //here you can have your logic to set text to edittext
			 }
			
			 public void onFinish() {
				 Intent i = new Intent(getBaseContext(), TypeActivity.class);
				 startActivity(i);
				 finish();
			 }
		}.start();
	}

}
