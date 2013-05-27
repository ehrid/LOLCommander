package com.leagueoflegendscommander.tools;

import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.leagueoflegendscommander.R;
import com.leagueoflegendscommander.activities.CommanderActivity;

public class JungleController implements OnClickListener {
	CommanderActivity rootView;
	
	public JungleController(CommanderActivity rootView){
		this.rootView = rootView;
	}
	
	ImageView baron;
	ImageView dragon;
	ImageView red1;
	ImageView red2;
	ImageView blue1;
	ImageView blue2;
	ImageView inhibitor1;
	ImageView inhibitor2;
	ImageView inhibitor3;
	ImageView ward1;
	ImageView ward2;
	ImageView ward3;

	TextView baronTimer;
	TextView dragonTimer;
	TextView red1Timer;
	TextView red2Timer;
	TextView blue1Timer;
	TextView blue2Timer;
	TextView inhibitor1Timer;
	TextView inhibitor2Timer;
	TextView inhibitor3Timer;
	TextView ward1Timer;
	TextView ward2Timer;
	TextView ward3Timer;
	
	CountDownTimer baronCD;
	CountDownTimer dragonCD;
	CountDownTimer red1CD;
	CountDownTimer red2CD;
	CountDownTimer blue1CD;
	CountDownTimer blue2CD;
	CountDownTimer inhibitor1CD;
	CountDownTimer inhibitor2CD;
	CountDownTimer inhibitor3CD;
	CountDownTimer ward1CD;
	CountDownTimer ward2CD;
	CountDownTimer ward3CD;

	public void initJungle() {
		baron = (ImageView) rootView.findViewById(R.id.jungleBaron);
		dragon = (ImageView) rootView.findViewById(R.id.jungleDragon);
		red1 = (ImageView) rootView.findViewById(R.id.jungleRed1);
		red2 = (ImageView) rootView.findViewById(R.id.jungleRed2);
		blue1 = (ImageView) rootView.findViewById(R.id.jungleBlue1);
		blue2 = (ImageView) rootView.findViewById(R.id.jungleBlue2);
		inhibitor1 = (ImageView) rootView.findViewById(R.id.jungleInhibitor1);
		inhibitor2 = (ImageView) rootView.findViewById(R.id.jungleInhibitor2);
		inhibitor3 = (ImageView) rootView.findViewById(R.id.jungleInhibitor3);
		ward1 = (ImageView) rootView.findViewById(R.id.jungleWard1);
		ward2 = (ImageView) rootView.findViewById(R.id.jungleWard2);
		ward3 = (ImageView) rootView.findViewById(R.id.jungleWard3);

		baronTimer = (TextView) rootView.findViewById(R.id.jungleBaronTimer);
		dragonTimer = (TextView) rootView.findViewById(R.id.jungleDragonTimer);
		red1Timer = (TextView) rootView.findViewById(R.id.jungleRed1Timer);
		red2Timer = (TextView) rootView.findViewById(R.id.jungleRed2Timer);
		blue1Timer = (TextView) rootView.findViewById(R.id.jungleBlue1Timer);
		blue2Timer = (TextView) rootView.findViewById(R.id.jungleBlue2Timer);
		inhibitor1Timer = (TextView) rootView.findViewById(R.id.jungleInhibitor1Timer);
		inhibitor2Timer = (TextView) rootView.findViewById(R.id.jungleInhibitor2Timer);
		inhibitor3Timer = (TextView) rootView.findViewById(R.id.jungleInhibitor3Timer);
		ward1Timer = (TextView) rootView.findViewById(R.id.jungleWard1Timer);
		ward2Timer = (TextView) rootView.findViewById(R.id.jungleWard2Timer);
		ward3Timer = (TextView) rootView.findViewById(R.id.jungleWard3Timer);
		
		baron.setOnClickListener(this);
		dragon.setOnClickListener(this);
		red1.setOnClickListener(this);
		red2.setOnClickListener(this);
		blue1.setOnClickListener(this);
		blue2.setOnClickListener(this);;
		inhibitor1.setOnClickListener(this);
		inhibitor2.setOnClickListener(this);
		inhibitor3.setOnClickListener(this);
		ward1.setOnClickListener(this);
		ward2.setOnClickListener(this);
		ward3.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.jungleBaron:
			baronCD = rootView.startCD(baronCD, baron, baronTimer, 420000, R.drawable.jungle_baron_cd, R.drawable.jungle_baron);
			break;
		case R.id.jungleDragon:
			dragonCD = rootView.startCD(dragonCD, dragon,dragonTimer,360000, R.drawable.jungle_dragon_cd, R.drawable.jungle_dragon);
			break;
		case R.id.jungleRed1:
			red1CD = rootView.startCD(red1CD, red1,red1Timer,300000,R.drawable.jungle_red_cd, R.drawable.jungle_red);
			break;
		case R.id.jungleRed2:
			red2CD = rootView.startCD(red2CD, red2,red2Timer,300000,R.drawable.jungle_red_cd, R.drawable.jungle_red);
			break;
		case R.id.jungleBlue1:
			blue1CD = rootView.startCD(blue1CD, blue1,blue1Timer,300000,R.drawable.jungle_blue_cd, R.drawable.jungle_blue);
			break;
		case R.id.jungleBlue2:
			blue2CD = rootView.startCD(blue2CD, blue2,blue2Timer,300000,R.drawable.jungle_blue_cd, R.drawable.jungle_blue);
			break;
		case R.id.jungleWard1:
			ward1CD = rootView.startCD(ward1CD, ward1,ward1Timer,180000,R.drawable.jungle_ward_cd, R.drawable.jungle_ward);
			break;
		case R.id.jungleWard2:
			ward2CD = rootView.startCD(ward2CD, ward2,ward2Timer,180000,R.drawable.jungle_ward_cd, R.drawable.jungle_ward);
			break;
		case R.id.jungleWard3:
			ward3CD = rootView.startCD(ward3CD, ward3,ward3Timer,180000,R.drawable.jungle_ward_cd, R.drawable.jungle_ward);
			break;
		case R.id.jungleInhibitor1:
			inhibitor1CD = rootView.startCD(inhibitor1CD, inhibitor1,inhibitor1Timer,300000,R.drawable.jungle_inhibitor_cd, R.drawable.jungle_inhibitor);
			break;
		case R.id.jungleInhibitor2:
			inhibitor2CD = rootView.startCD(inhibitor2CD, inhibitor2,inhibitor2Timer,300000,R.drawable.jungle_inhibitor_cd, R.drawable.jungle_inhibitor);
			break;
		case R.id.jungleInhibitor3:
			inhibitor3CD = rootView.startCD(inhibitor3CD, inhibitor3,inhibitor3Timer,300000,R.drawable.jungle_inhibitor_cd, R.drawable.jungle_inhibitor);
			break;
		}

	}
}
