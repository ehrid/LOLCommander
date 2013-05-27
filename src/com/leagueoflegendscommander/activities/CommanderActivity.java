package com.leagueoflegendscommander.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_commander);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		
		jc = new JungleController(this);
		jc.initJungle();
		
		ally1 = new PlayerController(this, findViewById(R.id.commanderAlly1));
		ally1.initPlayer();
		ally2 = new PlayerController(this, findViewById(R.id.commanderAlly2));
		ally2.initPlayer();
		ally3 = new PlayerController(this, findViewById(R.id.commanderAlly3));
		ally3.initPlayer();
		ally4 = new PlayerController(this, findViewById(R.id.commanderAlly4));
		ally4.initPlayer();
		ally5 = new PlayerController(this, findViewById(R.id.commanderAlly5));
		ally5.initPlayer();
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
	
	public void startHeroSelection(){
		CommanderActivity.this.startActivity(new Intent(
				CommanderActivity.this,
				HeroActivity.class));
	}
}
