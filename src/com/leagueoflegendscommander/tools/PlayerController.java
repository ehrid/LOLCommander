package com.leagueoflegendscommander.tools;

import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.leagueoflegendscommander.R;
import com.leagueoflegendscommander.activities.CommanderActivity;
import com.leagueoflegendscommander.objects.Player;

public class PlayerController {
	CommanderActivity rootView;
	View player;

	public PlayerController(CommanderActivity rootView, View player) {
		this.rootView = rootView;
		this.player = player;
	}

	ImageView playerPicture;
	ImageView playerUlti;
	ImageView playerSpell1;
	ImageView playerSpell2;
	ImageView playerSkill1;
	ImageView playerSkill2;
	ImageView playerSkill3;
	ImageView playerSkill4;
	ImageView playerLevelUp;

	TextView playerUltiCD;
	TextView playerSpell1CD;
	TextView playerSpell2CD;
	TextView playerSkill1CD;
	TextView playerSkill2CD;
	TextView playerSkill3CD;
	TextView playerSkill4CD;
	TextView playerLevel;

	CountDownTimer playerUltiTimer;
	CountDownTimer playerSpell1Timer;
	CountDownTimer playerSpell2Timer;

	public void initPlayer() {
		playerPicture = (ImageView) player.findViewById(R.id.playerPicture);
		playerUlti = (ImageView) player.findViewById(R.id.playerUlti);
		playerSpell1 = (ImageView) player.findViewById(R.id.playerSpell1);
		playerSpell2 = (ImageView) player.findViewById(R.id.playerSpell2);
		playerSkill1 = (ImageView) player.findViewById(R.id.playerSkill1);
		playerSkill2 = (ImageView) player.findViewById(R.id.playerSkill2);
		playerSkill3 = (ImageView) player.findViewById(R.id.playerSkill3);
		playerSkill4 = (ImageView) player.findViewById(R.id.playerSkill4);
		playerLevelUp = (ImageView) player.findViewById(R.id.playerLevel);

		playerUltiCD = (TextView) player.findViewById(R.id.playerUltiTimer);
		playerSpell1CD = (TextView) player.findViewById(R.id.playerSpell1Timer);
		playerSpell2CD = (TextView) player.findViewById(R.id.playerSpell2Timer);
		playerSkill1CD = (TextView) player.findViewById(R.id.playerSkill1Timer);
		playerSkill2CD = (TextView) player.findViewById(R.id.playerSkill2Timer);
		playerSkill3CD = (TextView) player.findViewById(R.id.playerSkill3Timer);
		playerSkill4CD = (TextView) player.findViewById(R.id.playerSkill4Timer);
		playerLevel = (TextView) player.findViewById(R.id.playerLevelCount);

		playerPicture = (ImageView) player.findViewById(R.id.playerPicture);
		playerUlti = (ImageView) player.findViewById(R.id.playerUlti);
		playerSpell1 = (ImageView) player.findViewById(R.id.playerSpell1);
		playerSpell2 = (ImageView) player.findViewById(R.id.playerSpell2);
		playerSkill1 = (ImageView) player.findViewById(R.id.playerSkill1);
		playerSkill2 = (ImageView) player.findViewById(R.id.playerSkill2);
		playerSkill3 = (ImageView) player.findViewById(R.id.playerSkill3);
		playerSkill4 = (ImageView) player.findViewById(R.id.playerSkill4);

		playerPicture.setImageDrawable(rootView.getResources().getDrawable(
				R.drawable.no));
		playerUlti.setImageDrawable(rootView.getResources().getDrawable(
				R.drawable.no));
		playerSpell1.setImageDrawable(rootView.getResources().getDrawable(
				R.drawable.no));
		playerSpell2.setImageDrawable(rootView.getResources().getDrawable(
				R.drawable.no));
		playerSkill1.setImageDrawable(rootView.getResources().getDrawable(
				R.drawable.no));
		playerSkill2.setImageDrawable(rootView.getResources().getDrawable(
				R.drawable.no));
		playerSkill3.setImageDrawable(rootView.getResources().getDrawable(
				R.drawable.no));
		playerSkill4.setImageDrawable(rootView.getResources().getDrawable(
				R.drawable.no));

		playerPicture.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				rootView.startHeroSelection();

			}
		});
		
		addBehavior(null);
	}

	private void addBehavior(Player hero) {
		playerSkill1CD.setText("");
		playerSkill2CD.setText("");
		playerSkill3CD.setText("");
		playerSkill4CD.setText("");

		playerLevelUp.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				int level = Integer.parseInt(playerLevel.getText().toString());
				playerLevel.setText(Math.min(18, ++level) + "");
			}
		});

		playerUlti.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				playerUltiTimer = rootView.startCD(playerUltiTimer, playerUlti,
						playerUltiCD, 20000, R.drawable.no, R.drawable.no);
			}
		});
		playerSpell1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				playerSpell1Timer = rootView.startCD(playerSpell1Timer,
						playerSpell1, playerSpell1CD, 20000, R.drawable.no,
						R.drawable.no);
			}
		});
		playerSpell2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				playerSpell2Timer = rootView.startCD(playerSpell2Timer,
						playerSpell1, playerSpell2CD, 20000, R.drawable.no,
						R.drawable.no);
			}
		});
	}
}
