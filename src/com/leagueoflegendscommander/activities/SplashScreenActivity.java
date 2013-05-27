package com.leagueoflegendscommander.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.leagueoflegendscommander.R;

public class SplashScreenActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splashscreen);
		startCommander();
		
	}
	
	private void startCommander() {

		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {

			public void run() {
				finish();
				SplashScreenActivity.this.startActivity(new Intent(
						SplashScreenActivity.this,
						CommanderActivity.class));
			}

		}, 2000);
	}

}
