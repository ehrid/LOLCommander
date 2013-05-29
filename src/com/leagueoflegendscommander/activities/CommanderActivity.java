package com.leagueoflegendscommander.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.leagueoflegendscommander.LOLCApplication;
import com.leagueoflegendscommander.R;
import com.leagueoflegendscommander.tools.JungleController;
import com.leagueoflegendscommander.tools.PlayerController;

public class CommanderActivity extends Activity{
	
	JungleController jc;
	PlayerController ally1;
	PlayerController ally2;
	PlayerController ally3;
	PlayerController ally4;
	PlayerController ally5;
	PlayerController enemy1;
	PlayerController enemy2;
	PlayerController enemy3;
	PlayerController enemy4;
	PlayerController enemy5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_commander);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		
		jc = new JungleController(this);
		jc.initJungle();
		
		ally1 = new PlayerController(this, findViewById(R.id.commanderAlly1));
		ally1.initPlayer(0);
		ally2 = new PlayerController(this, findViewById(R.id.commanderAlly2));
		ally2.initPlayer(1);
		ally3 = new PlayerController(this, findViewById(R.id.commanderAlly3));
		ally3.initPlayer(2);
		ally4 = new PlayerController(this, findViewById(R.id.commanderAlly4));
		ally4.initPlayer(3);
		ally5 = new PlayerController(this, findViewById(R.id.commanderAlly5));
		ally5.initPlayer(4);
		
		enemy1 = new PlayerController(this, findViewById(R.id.commanderEnemy1));
		enemy1.initPlayer(5);
		enemy2 = new PlayerController(this, findViewById(R.id.commanderEnemy2));
		enemy2.initPlayer(6);
		enemy3 = new PlayerController(this, findViewById(R.id.commanderEnemy3));
		enemy3.initPlayer(7);
		enemy4 = new PlayerController(this, findViewById(R.id.commanderEnemy4));
		enemy4.initPlayer(8);
		enemy5 = new PlayerController(this, findViewById(R.id.commanderEnemy5));
		enemy5.initPlayer(9);
	}
	
	int timeStep = 100;
	public CountDownTimer startCD(final CountDownTimer cd, final ImageView image, final TextView timer,
			final int time, final int onCD, final int noCD) {
		
		
		
		if(cd != null){
			cd.cancel();
		}
		timer.setTypeface(null, Typeface.NORMAL);
		timer.setTextColor(Color.WHITE);
		image.setImageDrawable(getResources().getDrawable(onCD));
		
		return new CountDownTimer(time, timeStep) {
			public void onTick(long millisUntilFinished) {
				double timeToFinish = millisUntilFinished / 100;
				timeToFinish /= 10;				
				timer.setText(timeToFinish + "");
				
				if(timeToFinish < 60){
					timer.setTextColor(Color.RED);
					timer.setTypeface(null, Typeface.BOLD);

				}
			}

			public void onFinish() {
				timer.setText("");
				
				image.setImageDrawable(getResources().getDrawable(noCD));
			}
		}.start();
	}
	
	public void startHeroSelection(int playerPosition){
		PlayerController pc = ally1;;
		switch (playerPosition) {
		case 0:
			pc = ally1;
			break;
		case 1:
			pc = ally2;
			break;
		case 2:
			pc = ally3;
			break;
		case 3:
			pc = ally4;
			break;
		case 4:
			pc = ally5;
			break;
		case 5:
			pc = enemy1;
			break;
		case 6:
			pc = enemy2;
			break;
		case 7:
			pc = enemy3;
			break;
		case 8:
			pc = enemy4;
			break;
		case 9:
			pc = enemy5;
			break;
		}
		((LOLCApplication) getApplication()).currentlyPicking = pc;
		
		CommanderActivity.this.startActivity(new Intent(
				CommanderActivity.this,
				HeroActivity.class));
	}
	
	private boolean pressed = false;
	@SuppressLint("ShowToast") 
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if(pressed) {
				return super.onKeyDown(keyCode, event);
			} else {
				pressed = true;
				Toast.makeText(getApplicationContext(), "Press again to close application.", Toast.LENGTH_SHORT).show();
				Handler handler = new Handler();
				handler.postDelayed(new Runnable() {

					public void run() {
						pressed = false;
					}

				}, 2000);
				return true;
			}
		} else {
			return super.onKeyDown(keyCode, event);
		}
	};
}
