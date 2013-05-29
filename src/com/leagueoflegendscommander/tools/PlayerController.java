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
	ImageView playerCDR;
	ImageView playerLevelUp;

	TextView playerUltiCD;
	TextView playerSpell1CD;
	TextView playerSpell2CD;
	TextView playerSkill1CD;
	TextView playerSkill2CD;
	TextView playerSkill3CD;
	TextView playerLevel;

	CountDownTimer playerUltiTimer;
	CountDownTimer playerSpell1Timer;
	CountDownTimer playerSpell2Timer;

	ImageView playerUltiCancel;
	ImageView playerSpell1Cancel;
	ImageView playerSpell2Cancel;

	public void initPlayer(final int playerPosition) {
		playerPicture = (ImageView) player.findViewById(R.id.playerPicture);
		playerUlti = (ImageView) player.findViewById(R.id.playerUlti);
		playerSpell1 = (ImageView) player.findViewById(R.id.playerSpell1);
		playerSpell2 = (ImageView) player.findViewById(R.id.playerSpell2);
		playerSkill1 = (ImageView) player.findViewById(R.id.playerSkill1);
		playerSkill2 = (ImageView) player.findViewById(R.id.playerSkill2);
		playerSkill3 = (ImageView) player.findViewById(R.id.playerSkill3);
		playerCDR = (ImageView) player.findViewById(R.id.playerCDR);
		playerLevelUp = (ImageView) player.findViewById(R.id.playerLevel);

		playerUltiCD = (TextView) player.findViewById(R.id.playerUltiTimer);
		playerSpell1CD = (TextView) player.findViewById(R.id.playerSpell1Timer);
		playerSpell2CD = (TextView) player.findViewById(R.id.playerSpell2Timer);
		playerSkill1CD = (TextView) player.findViewById(R.id.playerSkill1Timer);
		playerSkill2CD = (TextView) player.findViewById(R.id.playerSkill2Timer);
		playerSkill3CD = (TextView) player.findViewById(R.id.playerSkill3Timer);
		playerLevel = (TextView) player.findViewById(R.id.playerLevelCount);

		playerUltiCancel = (ImageView) player
				.findViewById(R.id.playerUltiCancel);
		playerSpell1Cancel = (ImageView) player
				.findViewById(R.id.playerSpell1Cancel);
		playerSpell2Cancel = (ImageView) player
				.findViewById(R.id.playerSpell2Cancel);

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
		playerCDR.setImageDrawable(rootView.getResources().getDrawable(
				R.drawable.no));

		playerPicture.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				rootView.startHeroSelection(playerPosition);
			}
		});

		playerUltiCancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (playerUltiTimer != null)
					playerUltiTimer.cancel();
				playerUltiCD.setText("");
			}
		});

		playerSpell1Cancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (playerSpell1Timer != null)
					playerSpell1Timer.cancel();
				playerSpell1CD.setText("");
			}
		});

		playerSpell2Cancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (playerSpell2Timer != null)
					playerSpell2Timer.cancel();
				playerSpell2CD.setText("");
			}
		});
		
		playerCDR.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(hero != null) {
					rootView.startCDRChange(playerPosition);
				}
			}
		});

	}

	public Player hero;
	public void addBehavior(final Player hero) {
		this.hero = hero;

		if (playerSpell1Timer != null) {
			playerSpell1Timer.cancel();
			playerSpell1CD.setText("");
		}
		if (playerSpell2Timer != null) {
			playerSpell2Timer.cancel();
			playerSpell2CD.setText("");
		}
		if (playerUltiTimer != null) {
			playerUltiTimer.cancel();
			playerUltiCD.setText("");
		}

		playerPicture.setImageResource(hero.drawablePlayer);
		playerSkill1.setImageResource(hero.drawableSkill1);
		playerSkill2.setImageResource(hero.drawableSkill2);
		playerSkill3.setImageResource(hero.drawableSkill3);
		playerUlti.setImageResource(hero.drawableUlti);
		playerSpell1.setImageResource(hero.drawableSpell1);
		playerSpell2.setImageResource(hero.drawableSpell2);
		playerCDR.setImageResource(R.drawable.cdr);

		playerSkill1CD.setText(hero.getCdSkill1() + "");
		playerSkill2CD.setText(hero.getCdSkill2() + "");
		playerSkill3CD.setText(hero.getCdSkill3() + "");
		playerLevel.setText(hero.level + "");

		playerLevelUp.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				hero.level++;
				hero.level = Math.min(18, hero.level);

				playerSkill1CD.setText(hero.getCdSkill1() + "");
				playerSkill2CD.setText(hero.getCdSkill2() + "");
				playerSkill3CD.setText(hero.getCdSkill3() + "");
				playerLevel.setText(hero.level + "");
			}
		});

		playerUlti.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				playerUltiTimer = rootView.startCD(playerUltiTimer, playerUlti,
						playerUltiCD, hero.getCdUlti() * 1000,
						hero.drawableUlti, hero.drawableUlti);
			}
		});

		playerSpell1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				playerSpell1Timer = rootView.startCD(playerSpell1Timer,
						playerSpell1, playerSpell1CD, hero.cdSpell1,
						hero.drawableSpell1, hero.drawableSpell1);
			}
		});
		playerSpell2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				playerSpell2Timer = rootView.startCD(playerSpell2Timer,
						playerSpell2, playerSpell2CD, hero.cdSpell2,
						hero.drawableSpell2, hero.drawableSpell2);
			}
		});
	}
}
