package com.leagueoflegendscommander.activities;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.leagueoflegendscommander.LOLCApplication;
import com.leagueoflegendscommander.R;
import com.leagueoflegendscommander.objects.Player;
import com.leagueoflegendscommander.tools.GridviewAdapter;

public class HeroActivity extends Activity implements OnClickListener {
	private GridviewAdapter mAdapter;
	private ArrayList<String> listChampions;
	private ArrayList<Integer> listIcons;

	private Activity HeroActivity;
	private ArrayList<String> filteredListChampions;
	private ArrayList<Integer> filteredListIcons;

	private TextView title;
	private View spellView;
	private GridView gridView;

	private EditText searchText;
	private Button searchButton;

	Player player = new Player();

	int step = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hero);

		prepareList();

		title = (TextView) findViewById(R.id.spell_title);
		spellView = findViewById(R.id.hero_spell);

		// prepared arraylist and passed it to the Adapter class

		HeroActivity = this;
		mAdapter = new GridviewAdapter(HeroActivity, listChampions, listIcons);

		// Set custom adapter to gridview
		gridView = (GridView) findViewById(R.id.hero_list);
		gridView.setAdapter(mAdapter);

		// Implement On Item click listener
		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				step++;
				saveToPlayer(mAdapter.getItem(position));
				findViewById(R.id.hero_heroes).setVisibility(View.GONE);
				spellView.setVisibility(View.VISIBLE);
				spellView.bringToFront();
				title.setText("Select 1st spell");
				initSpells();
			}
		});

		searchText = (EditText) findViewById(R.id.hero_serch_text);
		searchButton = (Button) findViewById(R.id.hero_serch);
		searchButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				filteredListChampions = new ArrayList<String>();
				filteredListIcons = new ArrayList<Integer>();

				if (searchText.getText().toString().equals("")) {
					filteredListChampions = listChampions;
					filteredListIcons = listIcons;
				} else {
					for (int i = 0; i < listChampions.size(); i++) {
						if (listChampions.get(i).contains(
								searchText.getText().toString())) {
							filteredListChampions.add(listChampions.get(i));
							filteredListIcons.add(listIcons.get(i));
						}
					}
				}

				mAdapter = new GridviewAdapter(HeroActivity,
						filteredListChampions, filteredListIcons);
				gridView.setAdapter(mAdapter);
			}
		});
	}

	private void saveToPlayer(String character) {
		int[] cdUlti;
		int[] cdSkill1;
		int[] cdSkill2;
		int[] cdSkill3;

		if (character.equals("champion_ahri")) {
			cdSkill1 = new int[] { 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
					7, 7, 7 };
			cdSkill2 = new int[] { 9, 9, 8, 8, 7, 7, 6, 6, 5, 5, 5, 5, 5, 5, 5,
					5, 5, 5 };
			cdSkill3 = new int[] { 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12,
					12, 12, 12, 12, 12, 12, 12 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 110, 110, 110, 110, 110, 95,
					95, 95, 95, 95, 80, 80, 80, 80 };
			player.setPlayer("Ahri", R.drawable.champion_ahri,
					R.drawable.champion_skill_4_ahri,
					R.drawable.champion_skill_1_ahri,
					R.drawable.champion_skill_2_ahri,
					R.drawable.champion_skill_3_ahri, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_akali")) {
			cdSkill1 = new int[] { 6, 6, 5, 5, 5, 5, 4, 4, 4, 4, 4, 4, 4, 4, 4,
					4, 4, 4 };
			cdSkill2 = new int[] { 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20,
					20, 20, 20, 20, 20, 20, 20 };
			cdSkill3 = new int[] { 7, 7, 6, 6, 5, 5, 4, 4, 3, 3, 3, 3, 3, 3, 3,
					3, 3, 3 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1,
					1, 1, 1 };
			player.setPlayer("Akali", R.drawable.champion_akali,
					R.drawable.champion_skill_4_akali,
					R.drawable.champion_skill_1_akali,
					R.drawable.champion_skill_2_akali,
					R.drawable.champion_skill_3_akali, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_alistar")) {
			cdSkill1 = new int[] { 17, 17, 16, 16, 15, 15, 14, 14, 13, 13, 13,
					13, 13, 13, 13, 13, 13, 13 };
			cdSkill2 = new int[] { 14, 14, 13, 13, 12, 12, 11, 11, 10, 10, 10,
					10, 10, 10, 10, 10, 10 };
			cdSkill3 = new int[] { 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12,
					12, 12, 12, 12, 12, 12, 12 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 120, 120, 100, 100, 100, 100,
					100, 80, 80, 80, 80, 80, 80 };
			player.setPlayer("Alistar", R.drawable.champion_alistar,
					R.drawable.champion_skill_4_alistar,
					R.drawable.champion_skill_1_alistar,
					R.drawable.champion_skill_2_alistar,
					R.drawable.champion_skill_3_alistar, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_amumu")) {
			cdSkill1 = new int[] { 16, 16, 14, 14, 12, 12, 10, 10, 8, 8, 8, 8,
					8, 8, 8, 8, 8, 8 };
			cdSkill2 = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
					1, 1, 1 };
			cdSkill3 = new int[] { 10, 10, 9, 9, 8, 8, 7, 7, 6, 6, 6, 6, 6, 6,
					6, 6, 6, 6 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 150, 150, 130, 130, 130, 130,
					130, 110, 110, 110, 110, 110, 110 };
			player.setPlayer("Amumu", R.drawable.champion_amumu,
					R.drawable.champion_skill_4_amumu,
					R.drawable.champion_skill_1_amumu,
					R.drawable.champion_skill_2_amumu,
					R.drawable.champion_skill_3_amumu, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_anivia")) {
			cdSkill1 = new int[] { 12, 12, 11, 11, 10, 10, 9, 9, 8, 8, 8, 8, 8,
					8, 8, 8, 8, 8 };
			cdSkill2 = new int[] { 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25,
					25, 25, 25, 25, 25, 25, 25 };
			cdSkill3 = new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
					5, 5, 5 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,
					6, 6, 6 };
			player.setPlayer("Anivia", R.drawable.champion_anivia,
					R.drawable.champion_skill_4_anivia,
					R.drawable.champion_skill_1_anivia,
					R.drawable.champion_skill_2_anivia,
					R.drawable.champion_skill_3_anivia, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_annie")) {
			cdSkill1 = new int[] { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
					4, 4, 4 };
			cdSkill2 = new int[] { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,
					8, 8, 8 };
			cdSkill3 = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 120, 120, 120, 120, 120, 120,
					120, 120, 120, 120, 120, 120, 120 };
			player.setPlayer("Annie", R.drawable.champion_annie,
					R.drawable.champion_skill_4_annie,
					R.drawable.champion_skill_1_annie,
					R.drawable.champion_skill_2_annie,
					R.drawable.champion_skill_3_annie, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_ashe")) {
			cdSkill1 = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0 };
			cdSkill2 = new int[] { 16, 16, 13, 13, 10, 10, 7, 7, 4, 4, 4, 4, 4,
					4, 4, 4, 4, 4 };
			cdSkill3 = new int[] { 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60,
					60, 60, 60, 60, 60, 60, 60 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 100, 100, 100, 100, 100, 90,
					90, 90, 90, 90, 80, 80, 80 };
			player.setPlayer("Ashe", R.drawable.champion_ashe,
					R.drawable.champion_skill_4_ashe,
					R.drawable.champion_skill_1_ashe,
					R.drawable.champion_skill_2_ashe,
					R.drawable.champion_skill_3_ashe, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_blitzcrank")) {
			cdSkill1 = new int[] { 20, 20, 19, 19, 18, 18, 17, 17, 16, 16, 16,
					16, 16, 16, 16, 16, 16, 16 };
			cdSkill2 = new int[] { 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15,
					15, 15, 15, 15, 15, 15, 15 };
			cdSkill3 = new int[] { 9, 9, 8, 8, 7, 7, 6, 6, 5, 5, 5, 5, 5, 5, 5,
					5, 5, 5 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 30, 30, 30, 30, 30, 30, 30, 30,
					30, 30, 30, 30, 30 };
			player.setPlayer("Blirzcrank", R.drawable.champion_blitzcrank,
					R.drawable.champion_skill_4_blitzcrank,
					R.drawable.champion_skill_1_blitzcrank,
					R.drawable.champion_skill_2_blitzcrank,
					R.drawable.champion_skill_3_blitzcrank, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_brand")) {
			cdSkill1 = new int[] { 8, 8, 7, 7, 7, 7, 6, 6, 6, 6, 6, 6, 6, 6, 6,
					6, 6, 6 };
			cdSkill2 = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdSkill3 = new int[] { 12, 12, 11, 11, 10, 10, 9, 9, 8, 8, 8, 8, 8,
					8, 8, 8, 8, 8 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 105, 105, 105, 105, 105, 90,
					90, 90, 90, 90, 75, 75, 75 };
			player.setPlayer("Brand", R.drawable.champion_brand,
					R.drawable.champion_skill_4_brand,
					R.drawable.champion_skill_1_brand,
					R.drawable.champion_skill_2_brand,
					R.drawable.champion_skill_3_brand, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_caitlyn")) {
			cdSkill1 = new int[] { 10, 10, 9, 9, 8, 8, 7, 7, 6, 6, 6, 6, 6, 6,
					6, 6, 6, 6 };
			cdSkill2 = new int[] { 20, 20, 17, 17, 14, 14, 11, 11, 8, 8, 8, 8,
					8, 8, 8, 8, 8, 8 };
			cdSkill3 = new int[] { 18, 18, 16, 16, 14, 14, 12, 12, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 90, 90, 90, 90, 90, 75, 75, 75,
					75, 75, 60, 60, 60 };
			player.setPlayer("Caitlyn", R.drawable.champion_caitlyn,
					R.drawable.champion_skill_4_caitlyn,
					R.drawable.champion_skill_1_caitlyn,
					R.drawable.champion_skill_2_caitlyn,
					R.drawable.champion_skill_3_caitlyn, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_cassiopeia")) {
			cdSkill1 = new int[] { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
					3, 3, 3 };
			cdSkill2 = new int[] { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
					9, 9, 9 };
			cdSkill3 = new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
					5, 5, 5 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 130, 130, 130, 130, 130, 120,
					120, 120, 120, 120, 110, 110, 110 };
			player.setPlayer("Cassiopeia", R.drawable.champion_cassiopeia,
					R.drawable.champion_skill_4_cassiopeia,
					R.drawable.champion_skill_1_cassiopeia,
					R.drawable.champion_skill_2_cassiopeia,
					R.drawable.champion_skill_3_cassiopeia, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_cho_gath")) {
			cdSkill1 = new int[] { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
					9, 9, 9 };
			cdSkill2 = new int[] { 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13,
					13, 13, 13, 13, 13, 13, 13 };
			cdSkill3 = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 60, 60, 60, 60, 60, 60, 60, 60,
					60, 60, 60, 60, 60 };
			player.setPlayer("Cho'Gath", R.drawable.champion_cho_gath,
					R.drawable.champion_skill_4_cho_gath,
					R.drawable.champion_skill_1_cho_gath,
					R.drawable.champion_skill_2_cho_gath,
					R.drawable.champion_skill_3_cho_gath, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_corki")) {
			cdSkill1 = new int[] { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,
					8, 8, 8 };
			cdSkill2 = new int[] { 26, 26, 23, 23, 20, 20, 17, 17, 14, 14, 14,
					14, 14, 14, 14, 14, 14, 14 };
			cdSkill3 = new int[] { 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16,
					16, 16, 16, 16, 16, 16, 16 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
					1, 1, 1 };
			player.setPlayer("Corki", R.drawable.champion_corki,
					R.drawable.champion_skill_4_corki,
					R.drawable.champion_skill_1_corki,
					R.drawable.champion_skill_2_corki,
					R.drawable.champion_skill_3_corki, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_darius")) {
			cdSkill1 = new int[] { 9, 9, 8, 8, 7, 7, 6, 6, 5, 5, 5, 5, 5, 5, 5,
					5, 5, 5 };
			cdSkill2 = new int[] { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,
					8, 8, 8 };
			cdSkill3 = new int[] { 24, 24, 21, 21, 18, 18, 15, 15, 12, 12, 12,
					12, 12, 12, 12, 12, 12, 12 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 120, 120, 120, 120, 120, 100,
					100, 100, 100, 100, 80, 80, 80 };
			player.setPlayer("Darius", R.drawable.champion_darius,
					R.drawable.champion_skill_4_darius,
					R.drawable.champion_skill_1_darius,
					R.drawable.champion_skill_2_darius,
					R.drawable.champion_skill_3_darius, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_diana")) {
			cdSkill1 = new int[] { 10, 10, 9, 9, 8, 8, 7, 7, 6, 6, 6, 6, 6, 6,
					6, 6, 6, 6 };
			cdSkill2 = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdSkill3 = new int[] { 26, 26, 24, 24, 22, 22, 20, 20, 18, 18, 18,
					18, 18, 18, 18, 18, 18, 18 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 25, 25, 25, 25, 25, 20, 20, 20,
					20, 20, 15, 15, 15 };
			player.setPlayer("Diana", R.drawable.champion_diana,
					R.drawable.champion_skill_4_diana,
					R.drawable.champion_skill_1_diana,
					R.drawable.champion_skill_2_diana,
					R.drawable.champion_skill_3_diana, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_dr_mundo")) {
			cdSkill1 = new int[] { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
					4, 4, 4 };
			cdSkill2 = new int[] { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
					4, 4, 4 };
			cdSkill3 = new int[] { 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 77,
					7, 7, 7, 7 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 75, 75, 75, 75, 75, 75, 75, 75,
					75, 75, 75, 75, 75 };
			player.setPlayer("Dr. Mundo", R.drawable.champion_dr_mundo,
					R.drawable.champion_skill_4_dr_mundo,
					R.drawable.champion_skill_1_dr_mundo,
					R.drawable.champion_skill_2_dr_mundo,
					R.drawable.champion_skill_3_dr_mundo, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_draven")) {
			cdSkill1 = new int[] { 12, 12, 11, 11, 10, 10, 9, 9, 8, 8, 8, 8, 8,
					8, 8, 8, 8, 8 };
			cdSkill2 = new int[] { 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12,
					12, 12, 12, 12, 12, 12, 12 };
			cdSkill3 = new int[] { 18, 18, 17, 17, 16, 16, 15, 15, 14, 14, 14,
					14, 14, 14, 14, 14, 14, 14 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 110, 110, 110, 110, 110, 100,
					100, 100, 100, 100, 90, 90, 90 };
			player.setPlayer("Draven", R.drawable.champion_draven,
					R.drawable.champion_skill_4_draven,
					R.drawable.champion_skill_1_draven,
					R.drawable.champion_skill_2_draven,
					R.drawable.champion_skill_3_draven, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_elise")) {
			cdSkill1 = new int[] { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,
					6, 6, 6 };
			cdSkill2 = new int[] { 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12,
					12, 12, 12, 12, 12, 12, 12 };
			cdSkill3 = new int[] { 14, 14, 13, 13, 12, 12, 11, 11, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
					4, 4, 4 };
			player.setPlayer("Elise", R.drawable.champion_elise,
					R.drawable.champion_skill_4_elise,
					R.drawable.champion_skill_1_elise,
					R.drawable.champion_skill_2_elise,
					R.drawable.champion_skill_3_elise, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_evelynn")) {
			cdSkill1 = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
					1, 1, 1 };
			cdSkill2 = new int[] { 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15,
					15, 15, 15, 15, 15, 15, 15 };
			cdSkill3 = new int[] { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
					9, 9, 9 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 150, 150, 150, 150, 150, 120,
					120, 120, 120, 120, 90, 90, 90 };
			player.setPlayer("Evelynn", R.drawable.champion_evelynn,
					R.drawable.champion_skill_4_evelynn,
					R.drawable.champion_skill_1_evelynn,
					R.drawable.champion_skill_2_evelynn,
					R.drawable.champion_skill_3_evelynn, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_ezreal")) {
			cdSkill1 = new int[] { 6, 6, 5, 5, 5, 5, 4, 4, 4, 4, 4, 4, 4, 4, 4,
					4, 4, 4 };
			cdSkill2 = new int[] { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
					9, 9, 9 };
			cdSkill3 = new int[] { 19, 19, 17, 17, 15, 15, 13, 13, 11, 11, 11,
					11, 11, 11, 11, 11, 11, 11 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 80, 80, 80, 80, 80, 80, 80, 80,
					80, 80, 80, 80, 80 };
			player.setPlayer("Ezreal", R.drawable.champion_ezreal,
					R.drawable.champion_skill_4_ezreal,
					R.drawable.champion_skill_1_ezreal,
					R.drawable.champion_skill_2_ezreal,
					R.drawable.champion_skill_3_ezreal, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_fiddlestick")) {
			cdSkill1 = new int[] { 15, 15, 14, 14, 13, 13, 12, 12, 11, 11, 11,
					11, 11, 11, 11, 11, 11, 11 };
			cdSkill2 = new int[] { 10, 10, 9, 9, 8, 8, 7, 7, 6, 6, 6, 6, 6, 6,
					6, 6, 6, 6 };
			cdSkill3 = new int[] { 15, 15, 14, 14, 13, 13, 12, 12, 11, 11, 11,
					11, 11, 11, 11, 11, 11, 11 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 150, 150, 150, 150, 150, 140,
					140, 140, 140, 140, 130, 130, 130 };
			player.setPlayer("Fiddlestick", R.drawable.champion_fiddlestick,
					R.drawable.champion_skill_4_fiddlestick,
					R.drawable.champion_skill_1_fiddlestick,
					R.drawable.champion_skill_2_fiddlestick,
					R.drawable.champion_skill_3_fiddlestick, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_fiora")) {
			cdSkill1 = new int[] { 16, 16, 14, 14, 12, 12, 10, 10, 8, 8, 8, 8,
					8, 8, 8, 8, 8, 8 };
			cdSkill2 = new int[] { 10, 10, 9, 9, 8, 8, 7, 7, 6, 6, 6, 6, 6, 6,
					6, 6, 6, 6 };
			cdSkill3 = new int[] { 15, 15, 14, 14, 13, 13, 12, 12, 11, 11, 11,
					11, 11, 11, 11, 11, 11, 11 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 130, 130, 130, 130, 130, 120,
					120, 120, 120, 120, 110, 110, 110 };
			player.setPlayer("Fiora", R.drawable.champion_fiora,
					R.drawable.champion_skill_4_fiora,
					R.drawable.champion_skill_1_fiora,
					R.drawable.champion_skill_2_fiora,
					R.drawable.champion_skill_3_fiora, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_fizz")) {
			cdSkill1 = new int[] { 10, 10, 9, 9, 8, 8, 7, 7, 6, 6, 6, 6, 6, 6,
					6, 6, 6, 6 };
			cdSkill2 = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdSkill3 = new int[] { 16, 16, 14, 14, 12, 12, 10, 10, 8, 8, 8, 8,
					8, 8, 8, 8, 8, 8 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 100, 100, 100, 100, 100, 85,
					85, 85, 85, 85, 70, 70, 70 };
			player.setPlayer("Fizz", R.drawable.champion_fizz,
					R.drawable.champion_skill_4_fizz,
					R.drawable.champion_skill_1_fizz,
					R.drawable.champion_skill_2_fizz,
					R.drawable.champion_skill_3_fizz, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_galio")) {
			cdSkill1 = new int[] { 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
					7, 7, 7 };
			cdSkill2 = new int[] { 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13,
					13, 13, 13, 13, 13, 13, 13 };
			cdSkill3 = new int[] { 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12,
					12, 12, 12, 12, 12, 12, 12 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 170, 170, 170, 170, 170, 150,
					150, 150, 150, 150, 130, 130, 130 };
			player.setPlayer("Galio", R.drawable.champion_galio,
					R.drawable.champion_skill_4_galio,
					R.drawable.champion_skill_1_galio,
					R.drawable.champion_skill_2_galio,
					R.drawable.champion_skill_3_galio, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_gangplank")) {
			cdSkill1 = new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
					5, 5, 5 };
			cdSkill2 = new int[] { 21, 22, 21, 21, 20, 20, 19, 19, 18, 18, 18,
					18, 18, 18, 18, 18, 18, 18 };
			cdSkill3 = new int[] { 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20,
					20, 20, 20, 20, 20, 20, 20 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 120, 120, 120, 120, 120, 115,
					115, 155, 155, 155, 110, 110, 110 };
			player.setPlayer("Gangplank", R.drawable.champion_gangplank,
					R.drawable.champion_skill_4_gangplank,
					R.drawable.champion_skill_1_gangplank,
					R.drawable.champion_skill_2_gangplank,
					R.drawable.champion_skill_3_gangplank, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_garen")) {
			cdSkill1 = new int[] { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,
					8, 8, 8 };
			cdSkill2 = new int[] { 24, 24, 23, 23, 22, 22, 21, 21, 20, 20, 20,
					20, 20, 20, 20, 20, 20, 20 };
			cdSkill3 = new int[] { 13, 13, 12, 12, 11, 11, 10, 10, 9, 9, 9, 9,
					9, 9, 9, 9, 9, 9 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 160, 160, 160, 160, 160, 120,
					120, 120, 120, 120, 80, 80, 80 };
			player.setPlayer("Garen", R.drawable.champion_garen,
					R.drawable.champion_skill_4_garen,
					R.drawable.champion_skill_1_garen,
					R.drawable.champion_skill_2_garen,
					R.drawable.champion_skill_3_garen, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_gragas")) {
			cdSkill1 = new int[] { 11, 11, 10, 10, 9, 9, 8, 8, 7, 7, 7, 7, 7,
					7, 7, 7, 7, 7 };
			cdSkill2 = new int[] { 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25,
					25, 25, 25, 25, 25, 25, 25 };
			cdSkill3 = new int[] { 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
					7, 7, 7 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 100, 100, 100, 100, 100, 90,
					90, 90, 90, 90, 80, 80, 80 };
			player.setPlayer("Gragas", R.drawable.champion_gragas,
					R.drawable.champion_skill_4_gragas,
					R.drawable.champion_skill_1_gragas,
					R.drawable.champion_skill_2_gragas,
					R.drawable.champion_skill_3_gragas, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_graves")) {
			cdSkill1 = new int[] { 12, 12, 11, 11, 10, 10, 9, 9, 8, 8, 8, 8, 8,
					8, 8, 8, 8, 8 };
			cdSkill2 = new int[] { 20, 20, 19, 19, 18, 18, 17, 17, 16, 16, 16,
					16, 16, 16, 16, 16, 16, 16 };
			cdSkill3 = new int[] { 22, 22, 20, 20, 18, 18, 17, 17, 16, 16, 16,
					16, 16, 16, 16, 16, 16, 16 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 100, 100, 100, 100, 100, 90,
					90, 90, 90, 90, 80, 80, 80 };
			player.setPlayer("Graves", R.drawable.champion_graves,
					R.drawable.champion_skill_4_graves,
					R.drawable.champion_skill_1_graves,
					R.drawable.champion_skill_2_graves,
					R.drawable.champion_skill_3_graves, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_hecarim")) {
			cdSkill1 = new int[] { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
					4, 4, 4 };
			cdSkill2 = new int[] { 22, 22, 21, 21, 20, 20, 19, 19, 18, 18, 18,
					18, 18, 18, 18, 18, 18, 18 };
			cdSkill3 = new int[] { 24, 24, 22, 22, 20, 20, 18, 18, 16, 16, 16,
					16, 16, 16, 16, 16, 16, 16 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 140, 140, 140, 140, 140, 120,
					120, 120, 120, 120, 100, 100, 100 };
			player.setPlayer("Hecarim", R.drawable.champion_hecarim,
					R.drawable.champion_skill_4_hecarim,
					R.drawable.champion_skill_1_hecarim,
					R.drawable.champion_skill_2_hecarim,
					R.drawable.champion_skill_3_hecarim, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_heimerdinger")) {
			cdSkill1 = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
					1, 1, 1 };
			cdSkill2 = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdSkill3 = new int[] { 13, 13, 12, 12, 11, 11, 10, 10, 9, 9, 9, 9,
					9, 9, 9, 9, 9, 9 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 120, 120, 120, 120, 120, 105,
					105, 105, 105, 105, 90, 90, 90 };
			player.setPlayer("Heimerdinger", R.drawable.champion_heimerdinger,
					R.drawable.champion_skill_4_heimerdinger,
					R.drawable.champion_skill_1_heimerdinger,
					R.drawable.champion_skill_2_heimerdinger,
					R.drawable.champion_skill_3_heimerdinger, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_irelia")) {
			cdSkill1 = new int[] { 14, 14, 12, 12, 10, 10, 8, 8, 6, 6, 6, 6, 6,
					6, 6, 6, 6, 6 };
			cdSkill2 = new int[] { 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15,
					15, 15, 15, 15, 15, 15, 15 };
			cdSkill3 = new int[] { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,
					8, 8, 8 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 70, 70, 70, 70, 70, 60, 60, 60,
					60, 60, 50, 50, 50 };
			player.setPlayer("Irelia", R.drawable.champion_irelia,
					R.drawable.champion_skill_4_irelia,
					R.drawable.champion_skill_1_irelia,
					R.drawable.champion_skill_2_irelia,
					R.drawable.champion_skill_3_irelia, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_janna")) {
			cdSkill1 = new int[] { 14, 14, 13, 13, 12, 12, 11, 11, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdSkill2 = new int[] { 12, 12, 11, 11, 10, 10, 9, 9, 8, 8, 8, 8, 8,
					8, 8, 8, 8, 8 };
			cdSkill3 = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 150, 150, 150, 150, 150, 135,
					135, 135, 135, 135, 120, 120, 120 };
			player.setPlayer("Janna", R.drawable.champion_janna,
					R.drawable.champion_skill_4_janna,
					R.drawable.champion_skill_1_janna,
					R.drawable.champion_skill_2_janna,
					R.drawable.champion_skill_3_janna, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_jarvan_iv")) {
			cdSkill1 = new int[] { 10, 10, 9, 9, 8, 8, 7, 7, 6, 6, 6, 6, 6, 6,
					6, 6, 6, 6 };
			cdSkill2 = new int[] { 20, 20, 18, 18, 16, 16, 14, 14, 12, 12, 12,
					12, 12, 12, 12, 12, 12, 12 };
			cdSkill3 = new int[] { 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13,
					13, 13, 13, 13, 13, 13, 13 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 120, 120, 120, 120, 120, 105,
					105, 105, 105, 105, 90, 90, 90 };
			player.setPlayer("jarvan IV", R.drawable.champion_jarvan_iv,
					R.drawable.champion_skill_4_jarvan_iv,
					R.drawable.champion_skill_1_jarvan_iv,
					R.drawable.champion_skill_2_jarvan_iv,
					R.drawable.champion_skill_3_jarvan_iv, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_jax")) {
			cdSkill1 = new int[] { 10, 10, 9, 9, 8, 8, 7, 7, 6, 6, 6, 6, 6, 6,
					6, 6, 6, 6 };
			cdSkill2 = new int[] { 7, 7, 6, 6, 5, 5, 4, 4, 3, 3, 3, 3, 3, 3, 3,
					3, 3, 3 };
			cdSkill3 = new int[] { 18, 18, 16, 16, 14, 14, 12, 12, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 80, 80, 80, 80, 80, 80, 80, 80,
					80, 80, 80, 80, 80 };
			player.setPlayer("Jax", R.drawable.champion_jax,
					R.drawable.champion_skill_4_jax,
					R.drawable.champion_skill_1_jax,
					R.drawable.champion_skill_2_jax,
					R.drawable.champion_skill_3_jax, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_jayce")) {
			cdSkill1 = new int[] { 16, 16, 14, 14, 12, 8, 8, 8, 8, 8, 8, 8, 8,
					8, 8, 8, 8, 8 };
			cdSkill2 = new int[] { 10, 10, 10, 10, 10, 10, 8, 8, 6, 6, 6, 6, 6,
					6, 6, 6, 6, 6 };
			cdSkill3 = new int[] { 14, 14, 13, 13, 12, 12, 11, 11, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,
					6, 6, 6 };
			player.setPlayer("jayce", R.drawable.champion_jayce,
					R.drawable.champion_skill_4_jayce,
					R.drawable.champion_skill_1_jayce,
					R.drawable.champion_skill_2_jayce,
					R.drawable.champion_skill_3_jayce, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_karma")) {
			cdSkill1 = new int[] { 7, 7, 6, 6, 6, 6, 5, 5, 5, 5, 5, 5, 5, 5, 5,
					5, 5, 5 };
			cdSkill2 = new int[] { 16, 16, 15, 15, 14, 14, 13, 13, 12, 12, 12,
					12, 12, 12, 12, 12, 12, 12 };
			cdSkill3 = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdUlti = new int[] { 45, 45, 45, 45, 45, 42, 42, 42, 42, 42, 39,
					39, 39, 39, 39, 36, 36, 36 };
			player.setPlayer("Karma", R.drawable.champion_karma,
					R.drawable.champion_skill_4_karma,
					R.drawable.champion_skill_1_karma,
					R.drawable.champion_skill_2_karma,
					R.drawable.champion_skill_3_karma, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_karthus")) {
			cdSkill1 = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
					1, 1, 1 };
			cdSkill2 = new int[] { 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,
					18, 18, 18, 18, 18, 18, 18 };
			cdSkill3 = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 200, 200, 200, 200, 200, 180,
					180, 180, 180, 180, 160, 160, 160 };
			player.setPlayer("Karthus", R.drawable.champion_karthus,
					R.drawable.champion_skill_4_karthus,
					R.drawable.champion_skill_1_karthus,
					R.drawable.champion_skill_2_karthus,
					R.drawable.champion_skill_3_karthus, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_kassadin")) {
			cdSkill1 = new int[] { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
					9, 9, 9 };
			cdSkill2 = new int[] { 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12,
					12, 12, 12, 12, 12, 12, 12 };
			cdSkill3 = new int[] { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,
					6, 6, 6 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 7, 7, 7, 7, 7, 6, 6, 6, 6, 6,
					5, 5, 5 };
			player.setPlayer("Kassadin", R.drawable.champion_kassadin,
					R.drawable.champion_skill_4_kassadin,
					R.drawable.champion_skill_1_kassadin,
					R.drawable.champion_skill_2_kassadin,
					R.drawable.champion_skill_3_kassadin, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_katarina")) {
			cdSkill1 = new int[] { 10, 10, 9, 9, 9, 9, 8, 8, 8, 8, 8, 8, 8, 8,
					8, 8, 8, 8 };
			cdSkill2 = new int[] { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
					4, 4, 4 };
			cdSkill3 = new int[] { 12, 12, 10, 10, 9, 9, 7, 7, 6, 6, 6, 6, 6,
					6, 6, 6, 6, 6 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 60, 60, 60, 60, 60, 55, 55, 55,
					55, 55, 50, 50, 50 };
			player.setPlayer("Katarina", R.drawable.champion_katarina,
					R.drawable.champion_skill_4_katarina,
					R.drawable.champion_skill_1_katarina,
					R.drawable.champion_skill_2_katarina,
					R.drawable.champion_skill_3_katarina, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_kayle")) {
			cdSkill1 = new int[] { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,
					8, 8, 8 };
			cdSkill2 = new int[] { 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15,
					15, 15, 15, 15, 15, 15, 15 };
			cdSkill3 = new int[] { 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16,
					16, 16, 16, 16, 16, 16, 16 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 90, 90, 90, 90, 90, 75, 75, 75,
					75, 75, 60, 60, 60 };
			player.setPlayer("Kayle", R.drawable.champion_kayle,
					R.drawable.champion_skill_4_kayle,
					R.drawable.champion_skill_1_kayle,
					R.drawable.champion_skill_2_kayle,
					R.drawable.champion_skill_3_kayle, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_kennen")) {
			cdSkill1 = new int[] { 8, 8, 7, 7, 6, 6, 5, 5, 4, 4, 4, 4, 4, 4, 4,
					4, 4, 4 };
			cdSkill2 = new int[] { 14, 14, 12, 12, 10, 10, 8, 8, 6, 6, 6, 6, 6,
					6, 6, 6, 6, 6 };
			cdSkill3 = new int[] { 10, 10, 9, 9, 8, 8, 7, 7, 6, 6, 6, 6, 6, 6,
					6, 6, 6, 6 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 120, 120, 120, 120, 120, 120,
					120, 120, 120, 120, 120, 120, 120 };
			player.setPlayer("Kennen", R.drawable.champion_kennen,
					R.drawable.champion_skill_4_kennen,
					R.drawable.champion_skill_1_kennen,
					R.drawable.champion_skill_2_kennen,
					R.drawable.champion_skill_3_kennen, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_kha_zix")) {
			cdSkill1 = new int[] { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
					3, 3, 3 };
			cdSkill2 = new int[] { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,
					8, 8, 8 };
			cdSkill3 = new int[] { 22, 22, 20, 20, 18, 18, 16, 16, 14, 14, 14,
					14, 14, 14, 14, 14, 14, 14 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 100, 100, 100, 100, 100, 90,
					90, 90, 90, 90, 80, 80, 80 };
			player.setPlayer("Kha'Zix", R.drawable.champion_kha_zix,
					R.drawable.champion_skill_4_kha_zix,
					R.drawable.champion_skill_1_kha_zix,
					R.drawable.champion_skill_2_kha_zix,
					R.drawable.champion_skill_3_kha_zix, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_kog_maw")) {
			cdSkill1 = new int[] { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,
					8, 8, 8 };
			cdSkill2 = new int[] { 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17,
					17, 17, 17, 17, 17, 17, 17 };
			cdSkill3 = new int[] { 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12,
					12, 12, 12, 12, 12, 12, 12 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1,
					1, 1, 1 };
			player.setPlayer("Kog'Maw", R.drawable.champion_kog_maw,
					R.drawable.champion_skill_4_kog_maw,
					R.drawable.champion_skill_1_kog_maw,
					R.drawable.champion_skill_2_kog_maw,
					R.drawable.champion_skill_3_kog_maw, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_le_blanc")) {
			cdSkill1 = new int[] { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,
					6, 6, 6 };
			cdSkill2 = new int[] { 18, 18, 16, 16, 14, 14, 12, 12, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdSkill3 = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 40, 40, 40, 40, 40, 32, 32, 32,
					32, 32, 24, 24, 24 };
			player.setPlayer("Le blanc", R.drawable.champion_le_blanc,
					R.drawable.champion_skill_4_le_blanc,
					R.drawable.champion_skill_1_le_blanc,
					R.drawable.champion_skill_2_le_blanc,
					R.drawable.champion_skill_3_le_blanc, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_lee_sin")) {
			cdSkill1 = new int[] { 11, 11, 10, 10, 9, 9, 8, 8, 7, 7, 7, 7, 7,
					7, 7, 7, 7, 7 };
			cdSkill2 = new int[] { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
					9, 9, 9 };
			cdSkill3 = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 90, 90, 90, 90, 90, 75, 75, 75,
					75, 75, 60, 60, 60 };
			player.setPlayer("Lee Sin", R.drawable.champion_lee_sin,
					R.drawable.champion_skill_4_lee_sin,
					R.drawable.champion_skill_1_lee_sin,
					R.drawable.champion_skill_2_lee_sin,
					R.drawable.champion_skill_3_lee_sin, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_leona")) {
			cdSkill1 = new int[] { 11, 11, 10, 10, 9, 9, 8, 8, 7, 7, 7, 7, 7,
					7, 7, 7, 7, 7 };
			cdSkill2 = new int[] { 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14,
					14, 14, 14, 14, 14, 14, 14 };
			cdSkill3 = new int[] { 13, 13, 12, 12, 11, 11, 10, 10, 9, 9, 9, 9,
					9, 9, 9, 9, 9, 9 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 90, 90, 90, 90, 90, 75, 75, 75,
					75, 75, 60, 60, 60 };
			player.setPlayer("Leona", R.drawable.champion_leona,
					R.drawable.champion_skill_4_leona,
					R.drawable.champion_skill_1_leona,
					R.drawable.champion_skill_2_leona,
					R.drawable.champion_skill_3_leona, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_lissandra")) {
			cdSkill1 = new int[] { 6, 6, 5, 5, 5, 5, 4, 4, 4, 4, 4, 4, 4, 4, 4,
					4, 4, 4 };
			cdSkill2 = new int[] { 18, 18, 16, 16, 14, 14, 12, 12, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdSkill3 = new int[] { 24, 24, 21, 21, 18, 18, 15, 15, 12, 12, 12,
					12, 12, 12, 12, 12, 12, 12 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 130, 130, 130, 130, 130, 105,
					105, 105, 105, 105, 80, 80, 80 };
			player.setPlayer("Lissandra", R.drawable.champion_lissandra,
					R.drawable.champion_skill_4_lissandra,
					R.drawable.champion_skill_1_lissandra,
					R.drawable.champion_skill_2_lissandra,
					R.drawable.champion_skill_3_lissandra, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_lulu")) {
			cdSkill1 = new int[] { 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
					7, 7, 7 };
			cdSkill2 = new int[] { 18, 18, 16, 16, 15, 15, 13, 13, 12, 12, 12,
					12, 12, 12, 12, 12, 12, 12 };
			cdSkill3 = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 110, 110, 110, 110, 110, 95,
					95, 95, 95, 95, 80, 80, 80 };
			player.setPlayer("Lulu", R.drawable.champion_lulu,
					R.drawable.champion_skill_4_lulu,
					R.drawable.champion_skill_1_lulu,
					R.drawable.champion_skill_2_lulu,
					R.drawable.champion_skill_3_lulu, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_lux")) {
			cdSkill1 = new int[] { 15, 15, 14, 14, 13, 13, 12, 12, 11, 11, 11,
					11, 11, 11, 11, 11, 11, 11 };
			cdSkill2 = new int[] { 14, 14, 13, 13, 12, 12, 11, 11, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdSkill3 = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 80, 80, 80, 80, 80, 65, 65, 65,
					65, 65, 50, 50, 50 };
			player.setPlayer("Lux", R.drawable.champion_lux,
					R.drawable.champion_skill_4_lux,
					R.drawable.champion_skill_1_lux,
					R.drawable.champion_skill_2_lux,
					R.drawable.champion_skill_3_lux, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_malaphite")) {
			cdSkill1 = new int[] { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,
					8, 8, 8 };
			cdSkill2 = new int[] { 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14,
					14, 14, 14, 14, 14, 14, 14 };
			cdSkill3 = new int[] { 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
					7, 7, 7 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 130, 130, 130, 130, 130, 115,
					115, 115, 115, 115, 100, 100, 100 };
			player.setPlayer("Malaphite", R.drawable.champion_malaphite,
					R.drawable.champion_skill_4_malaphite,
					R.drawable.champion_skill_1_malaphite,
					R.drawable.champion_skill_2_malaphite,
					R.drawable.champion_skill_3_malaphite, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_malzahar")) {
			cdSkill1 = new int[] { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
					9, 9, 9 };
			cdSkill2 = new int[] { 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14,
					14, 14, 14, 14, 14, 14, 14 };
			cdSkill3 = new int[] { 15, 15, 13, 13, 11, 11, 9, 9, 7, 7, 7, 7, 7,
					7, 7, 7, 7, 7 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 120, 120, 120, 120, 120, 100,
					100, 100, 100, 100, 80, 80, 80 };
			player.setPlayer("Malzahar", R.drawable.champion_malzahar,
					R.drawable.champion_skill_4_malzahar,
					R.drawable.champion_skill_1_malzahar,
					R.drawable.champion_skill_2_malzahar,
					R.drawable.champion_skill_3_malzahar, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_maokai")) {
			cdSkill1 = new int[] { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,
					6, 6, 6 };
			cdSkill2 = new int[] { 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13,
					13, 13, 13, 13, 13, 13, 13 };
			cdSkill3 = new int[] { 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12,
					12, 12, 12, 12, 12, 12, 12 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 40, 40, 40, 40, 40, 30, 30, 30,
					30, 30, 20, 20, 20 };
			player.setPlayer("Maokai", R.drawable.champion_maokai,
					R.drawable.champion_skill_4_maokai,
					R.drawable.champion_skill_1_maokai,
					R.drawable.champion_skill_2_maokai,
					R.drawable.champion_skill_3_maokai, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_master_yi")) {
			cdUlti = new int[] { 18, 18, 16, 16, 14, 14, 12, 12, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdSkill1 = new int[] { 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35,
					35, 35, 35, 35, 35, 35, 35 };
			cdSkill2 = new int[] { 25, 25, 23, 23, 21, 21, 19, 19, 17, 17, 17,
					17, 17, 17, 17, 17, 17, 17 };
			cdSkill3 = new int[] { 0, 0, 0, 0, 0, 75, 75, 75, 75, 75, 75, 75,
					75, 75, 75, 75, 75, 75 };
			player.setPlayer("Master Yi", R.drawable.champion_master_yi,
					R.drawable.champion_skill_4_master_yi,
					R.drawable.champion_skill_1_master_yi,
					R.drawable.champion_skill_2_master_yi,
					R.drawable.champion_skill_3_master_yi, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_miss_fortune")) {
			cdSkill1 = new int[] { 9, 9, 8, 8, 7, 7, 6, 6, 5, 5, 5, 5, 5, 5, 5,
					5, 5, 5 };
			cdSkill2 = new int[] { 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16,
					16, 16, 16, 16, 16, 16, 16 };
			cdSkill3 = new int[] { 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15,
					15, 15, 15, 15, 15, 15, 15 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 120, 120, 120, 120, 120, 110,
					110, 110, 110, 110, 100, 100, 100 };
			player.setPlayer("Miss Fortune", R.drawable.champion_miss_fortune,
					R.drawable.champion_skill_4_miss_fortune,
					R.drawable.champion_skill_1_miss_fortune,
					R.drawable.champion_skill_2_miss_fortune,
					R.drawable.champion_skill_3_miss_fortune, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_mordekaiser")) {
			cdSkill1 = new int[] { 8, 8, 7, 7, 6, 6, 5, 5, 4, 4, 4, 4, 4, 4, 4,
					4, 4, 4 };
			cdSkill2 = new int[] { 20, 20, 18, 18, 16, 16, 14, 14, 12, 12, 12,
					12, 12, 12, 12, 12, 12, 12 };
			cdSkill3 = new int[] { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,
					6, 6, 6 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 120, 120, 120, 120, 120, 105,
					105, 105, 105, 105, 90, 90, 90 };
			player.setPlayer("Mordekaiser", R.drawable.champion_mordekaiser,
					R.drawable.champion_skill_4_mordekaiser,
					R.drawable.champion_skill_1_mordekaiser,
					R.drawable.champion_skill_2_mordekaiser,
					R.drawable.champion_skill_3_mordekaiser, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_morgana")) {
			cdSkill1 = new int[] { 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11,
					11, 11, 11, 11, 11, 11, };
			cdSkill2 = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
					10, 10, 10, 10, 00, 10, 10 };
			cdSkill3 = new int[] { 23, 23, 21, 21, 19, 19, 17, 17, 15, 15, 15,
					15, 15, 15, 15, 15, 15, 15 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 120, 120, 120, 120, 120, 110,
					110, 110, 110, 110, 100, 100, 100 };
			player.setPlayer("Morgana", R.drawable.champion_morgana,
					R.drawable.champion_skill_4_morgana,
					R.drawable.champion_skill_1_morgana,
					R.drawable.champion_skill_2_morgana,
					R.drawable.champion_skill_3_morgana, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_nami")) {
			cdSkill1 = new int[] { 14, 14, 13, 13, 12, 12, 11, 11, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdSkill2 = new int[] { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
					9, 9, 9 };
			cdSkill3 = new int[] { 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11,
					11, 11, 11, 11, 11, 11, 11 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 120, 120, 120, 120, 120, 110,
					110, 110, 110, 110, 100, 100, 100 };
			player.setPlayer("Nami", R.drawable.champion_nami,
					R.drawable.champion_skill_4_nami,
					R.drawable.champion_skill_1_nami,
					R.drawable.champion_skill_2_nami,
					R.drawable.champion_skill_3_nami, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_nasus")) {
			cdSkill1 = new int[] { 8, 8, 7, 7, 6, 6, 5, 5, 4, 4, 4, 4, 4, 4, 4,
					4, 4, 4 };
			cdSkill2 = new int[] { 15, 15, 14, 14, 13, 13, 12, 12, 11, 11, 11,
					11, 11, 11, 11, 11, 11, 11 };
			cdSkill3 = new int[] { 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12,
					12, 12, 12, 12, 12, 12, 12 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 120, 120, 120, 120, 120, 120,
					120, 120, 120, 120, 120, 120, 120 };
			player.setPlayer("Nasus", R.drawable.champion_nasus,
					R.drawable.champion_skill_4_nasus,
					R.drawable.champion_skill_1_nasus,
					R.drawable.champion_skill_2_nasus,
					R.drawable.champion_skill_3_nasus, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_natalius")) {
			cdSkill1 = new int[] { 18, 18, 16, 16, 14, 14, 12, 12, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdSkill2 = new int[] { 22, 22, 21, 21, 20, 20, 19, 19, 18, 18, 18,
					18, 18, 18, 18, 18, 18, 18 };
			cdSkill3 = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 140, 140, 140, 140, 140, 110,
					110, 110, 110, 110, 80, 80, 80 };
			player.setPlayer("Natalius", R.drawable.champion_natalius,
					R.drawable.champion_skill_4_natalius,
					R.drawable.champion_skill_1_natalius,
					R.drawable.champion_skill_2_natalius,
					R.drawable.champion_skill_3_natalius, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_nidalee")) {
			cdSkill1 = new int[] { 6, 6, 6, 6, 6, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
					5, 5, 5 };
			cdSkill2 = new int[] { 18, 18, 18, 18, 18, 3, 3, 3, 3, 3, 3, 3, 3,
					3, 3, 3, 3, 3 };
			cdSkill3 = new int[] { 10, 10, 10, 10, 10, 6, 6, 6, 6, 6, 6, 6, 6,
					6, 6, 6, 6, 6 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
					4, 4, 4 };
			player.setPlayer("Nidalee", R.drawable.champion_nidalee,
					R.drawable.champion_skill_4_nidalee,
					R.drawable.champion_skill_1_nidalee,
					R.drawable.champion_skill_2_nidalee,
					R.drawable.champion_skill_3_nidalee, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_nocturne")) {
			cdSkill1 = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdSkill2 = new int[] { 20, 20, 18, 18, 16, 16, 14, 14, 12, 12, 12,
					12, 12, 12, 12, 12, 12, 12 };
			cdSkill3 = new int[] { 15, 15, 14, 14, 13, 13, 12, 12, 11, 11, 11,
					11, 11, 11, 11, 11, 11, 11 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 180, 180, 180, 180, 180, 140,
					140, 140, 140, 140, 100, 100, 100 };
			player.setPlayer("Nocturne", R.drawable.champion_nocturne,
					R.drawable.champion_skill_4_nocturne,
					R.drawable.champion_skill_1_nocturne,
					R.drawable.champion_skill_2_nocturne,
					R.drawable.champion_skill_3_nocturne, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_nunu")) {
			cdSkill1 = new int[] { 17, 17, 15, 15, 13, 13, 11, 11, 9, 9, 9, 9,
					9, 9, 9, 9, 9, 9 };
			cdSkill2 = new int[] { 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15,
					15, 15, 15, 15, 15, 15, 15 };
			cdSkill3 = new int[] { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,
					6, 6, 6 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 110, 110, 110, 110, 110, 100,
					100, 100, 100, 100, 90, 90, 90 };
			player.setPlayer("Nunu", R.drawable.champion_nunu,
					R.drawable.champion_skill_4_nunu,
					R.drawable.champion_skill_1_nunu,
					R.drawable.champion_skill_2_nunu,
					R.drawable.champion_skill_3_nunu, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_olaf")) {
			cdSkill1 = new int[] { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,
					8, 8, 8 };
			cdSkill2 = new int[] { 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16,
					16, 16, 16, 16, 16, 16, 16 };
			cdSkill3 = new int[] { 9, 9, 8, 8, 7, 7, 6, 6, 5, 5, 5, 5, 5, 5, 5,
					5, 5, 5 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 100, 100, 100, 100, 100, 75,
					75, 75, 75, 75, 50, 50, 50 };
			player.setPlayer("Olaf", R.drawable.champion_olaf,
					R.drawable.champion_skill_4_olaf,
					R.drawable.champion_skill_1_olaf,
					R.drawable.champion_skill_2_olaf,
					R.drawable.champion_skill_3_olaf, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_orianna")) {
			cdSkill1 = new int[] { 6, 6, 5, 5, 4, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3,
					3, 3, 3 };
			cdSkill2 = new int[] { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
					9, 9, 9 };
			cdSkill3 = new int[] { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
					9, 9, 9 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 120, 120, 120, 120, 120, 105,
					105, 105, 105, 105, 90, 90, 90 };
			player.setPlayer("Orianna", R.drawable.champion_orianna,
					R.drawable.champion_skill_4_orianna,
					R.drawable.champion_skill_1_orianna,
					R.drawable.champion_skill_2_orianna,
					R.drawable.champion_skill_3_orianna, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_pantheon")) {
			cdSkill1 = new int[] { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
					4, 4, 4 };
			cdSkill2 = new int[] { 13, 13, 12, 12, 11, 11, 10, 10, 9, 9, 9, 9,
					9, 9, 9, 9, 9, 9 };
			cdSkill3 = new int[] { 10, 10, 9, 9, 8, 8, 7, 7, 6, 6, 6, 6, 6, 6,
					6, 6, 6, 6 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 150, 150, 150, 150, 150, 135,
					135, 135, 135, 135, 120, 120, 120 };
			player.setPlayer("Pantheon", R.drawable.champion_pantheon,
					R.drawable.champion_skill_4_pantheon,
					R.drawable.champion_skill_1_pantheon,
					R.drawable.champion_skill_2_pantheon,
					R.drawable.champion_skill_3_pantheon, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_poppy")) {
			cdSkill1 = new int[] { 8, 8, 7, 7, 6, 6, 5, 5, 4, 4, 4, 4, 4, 4, 4,
					4, 4, 4 };
			cdSkill2 = new int[] { 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12,
					12, 12, 12, 12, 12, 12, 12 };
			cdSkill3 = new int[] { 12, 12, 11, 11, 10, 10, 9, 9, 8, 8, 8, 8, 8,
					8, 8, 8, 8, 8 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 140, 140, 140, 140, 140, 120,
					120, 120, 120, 120, 100, 100, 100 };
			player.setPlayer("Poppy", R.drawable.champion_poppy,
					R.drawable.champion_skill_4_poppy,
					R.drawable.champion_skill_1_poppy,
					R.drawable.champion_skill_2_poppy,
					R.drawable.champion_skill_3_poppy, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_quinn")) {
			cdSkill1 = new int[] { 11, 11, 10, 10, 9, 9, 8, 8, 7, 7, 7, 7, 7,
					7, 7, 7, 7, 7 };
			cdSkill2 = new int[] { 50, 50, 45, 45, 40, 40, 35, 35, 30, 30, 30,
					30, 30, 30, 30, 30, 30, 30 };
			cdSkill3 = new int[] { 12, 12, 11, 11, 10, 10, 9, 9, 8, 8, 8, 8, 8,
					8, 8, 8, 8, 8 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 140, 140, 140, 140, 140, 110,
					110, 110, 110, 110, 80, 80, 80 };
			player.setPlayer("Quinn", R.drawable.champion_quinn,
					R.drawable.champion_skill_4_quinn,
					R.drawable.champion_skill_1_quinn,
					R.drawable.champion_skill_2_quinn,
					R.drawable.champion_skill_3_quinn, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_rammus")) {
			cdSkill1 = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdSkill2 = new int[] { 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14,
					14, 14, 14, 14, 14, 14, 14 };
			cdSkill3 = new int[] { 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12,
					12, 12, 12, 12, 12, 12, 12 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 60, 60, 60, 60, 60, 60, 60, 60,
					60, 60, 60, 60, 60 };
			player.setPlayer("Rammus", R.drawable.champion_rammus,
					R.drawable.champion_skill_4_rammus,
					R.drawable.champion_skill_1_rammus,
					R.drawable.champion_skill_2_rammus,
					R.drawable.champion_skill_3_rammus, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_renegar")) {
			cdSkill1 = new int[] { 8, 8, 7, 7, 7, 7, 6, 6, 6, 6, 6, 6, 6, 6, 6,
					6, 6, 6 };
			cdSkill2 = new int[] { 15, 15, 14, 14, 13, 13, 12, 12, 11, 11, 11,
					11, 11, 11, 11, 11, 11, 11 };
			cdSkill3 = new int[] { 12, 12, 11, 11, 10, 10, 9, 9, 8, 8, 8, 8, 8,
					8, 8, 8, 8, 8 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 140, 140, 140, 140, 140, 105,
					105, 105, 105, 105, 70, 70, 70 };
			player.setPlayer("Renegar", R.drawable.champion_renegar,
					R.drawable.champion_skill_4_renegar,
					R.drawable.champion_skill_1_renegar,
					R.drawable.champion_skill_2_renegar,
					R.drawable.champion_skill_3_renegar, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_renekton")) {
			cdSkill1 = new int[] { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,
					8, 8, 8 };
			cdSkill2 = new int[] { 13, 13, 12, 12, 11, 11, 10, 10, 9, 9, 9, 9,
					9, 9, 9, 9, 9, 9 };
			cdSkill3 = new int[] { 18, 18, 17, 17, 16, 16, 15, 15, 14, 14, 14,
					14, 14, 14, 14, 14, 14, 14 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 120, 120, 120, 120, 120, 120,
					120, 120, 120, 120, 120, 120, 120 };
			player.setPlayer("Renekton", R.drawable.champion_renekton,
					R.drawable.champion_skill_4_renekton,
					R.drawable.champion_skill_1_renekton,
					R.drawable.champion_skill_2_renekton,
					R.drawable.champion_skill_3_renekton, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_riven")) {
			cdSkill1 = new int[] { 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13,
					13, 13, 13, 13, 13, 13, 13 };
			cdSkill2 = new int[] { 11, 11, 10, 10, 9, 9, 8, 8, 7, 7, 7, 7, 7,
					7, 7, 7, 7, 7 };
			cdSkill3 = new int[] { 10, 10, 9, 9, 8, 8, 7, 7, 6, 6, 6, 6, 6, 6,
					6, 6, 6, 6 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 110, 110, 110, 110, 110, 80,
					80, 80, 80, 80, 50, 50, 50 };
			player.setPlayer("Riven", R.drawable.champion_riven,
					R.drawable.champion_skill_4_riven,
					R.drawable.champion_skill_1_riven,
					R.drawable.champion_skill_2_riven,
					R.drawable.champion_skill_3_riven, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_rumble")) {
			cdSkill1 = new int[] { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,
					6, 6, 6 };
			cdSkill2 = new int[] { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,
					6, 6, 6 };
			cdSkill3 = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 105, 105, 105, 105, 105, 90,
					90, 90, 90, 90, 75, 75, 75 };
			player.setPlayer("Rumble", R.drawable.champion_rumble,
					R.drawable.champion_skill_4_rumble,
					R.drawable.champion_skill_1_rumble,
					R.drawable.champion_skill_2_rumble,
					R.drawable.champion_skill_3_rumble, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_ryze")) {
			cdSkill1 = new int[] { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
					3, 3, 3 };
			cdSkill2 = new int[] { 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14,
					14, 14, 14, 14, 14, 14, 14 };
			cdSkill3 = new int[] { 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14,
					14, 14, 14, 14, 14, 14, 14 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 70, 70, 70, 70, 70, 60, 60, 60,
					60, 60, 50, 50, 50 };
			player.setPlayer("Ryze", R.drawable.champion_ryze,
					R.drawable.champion_skill_4_ryze,
					R.drawable.champion_skill_1_ryze,
					R.drawable.champion_skill_2_ryze,
					R.drawable.champion_skill_3_ryze, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_sejuani")) {
			cdSkill1 = new int[] { 15, 15, 14, 14, 13, 13, 12, 12, 11, 11, 11,
					11, 11, 11, 11, 11, 11, 11 };
			cdSkill2 = new int[] { 11, 11, 10, 10, 9, 9, 8, 8, 7, 7, 7, 7, 7,
					7, 7, 7, 7, 7 };
			cdSkill3 = new int[] { 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11,
					11, 11, 11, 11, 11, 11, 11 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 130, 130, 130, 130, 130, 115,
					115, 115, 115, 115, 100, 100, 100 };
			player.setPlayer("Sejuani", R.drawable.champion_sejuani,
					R.drawable.champion_skill_4_sejuani,
					R.drawable.champion_skill_1_sejuani,
					R.drawable.champion_skill_2_sejuani,
					R.drawable.champion_skill_3_sejuani, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_shaco")) {
			cdSkill1 = new int[] { 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11,
					11, 11, 11, 11, 11, 11, 11 };
			cdSkill2 = new int[] { 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16,
					16, 16, 16, 16, 16, 16, 16 };
			cdSkill3 = new int[] { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,
					8, 8, 8 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 100, 100, 100, 100, 100, 90,
					90, 90, 90, 92, 80, 80, 80 };
			player.setPlayer("Shaco", R.drawable.champion_shaco,
					R.drawable.champion_skill_4_shaco,
					R.drawable.champion_skill_1_shaco,
					R.drawable.champion_skill_2_shaco,
					R.drawable.champion_skill_3_shaco, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_shen")) {
			cdSkill1 = new int[] { 6, 6, 5, 5, 5, 5, 4, 4, 4, 4, 4, 4, 4, 4, 4,
					4, 4, 4 };
			cdSkill2 = new int[] { 9, 9, 8, 8, 7, 7, 6, 6, 5, 5, 5, 5, 5, 5, 5,
					5, 5, 5 };
			cdSkill3 = new int[] { 16, 16, 14, 14, 12, 12, 10, 10, 8, 8, 8, 8,
					8, 8, 8, 8, 8, 8 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 200, 200, 200, 200, 200, 180,
					180, 180, 180, 180, 160, 160, 160 };
			player.setPlayer("Shen", R.drawable.champion_shen,
					R.drawable.champion_skill_4_shen,
					R.drawable.champion_skill_1_shen,
					R.drawable.champion_skill_2_shen,
					R.drawable.champion_skill_3_shen, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_shyvana")) {
			cdSkill1 = new int[] { 10, 10, 9, 9, 8, 8, 7, 7, 6, 6, 6, 6, 6, 6,
					6, 6, 6, 6 };
			cdSkill2 = new int[] { 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12,
					12, 12, 12, 12, 12, 12, 12 };
			cdSkill3 = new int[] { 12, 12, 11, 11, 10, 10, 9, 9, 8, 8, 8, 8, 8,
					8, 8, 8, 8, 8 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0 };
			player.setPlayer("Shyvana", R.drawable.champion_shyvana,
					R.drawable.champion_skill_4_shyvana,
					R.drawable.champion_skill_1_shyvana,
					R.drawable.champion_skill_2_shyvana,
					R.drawable.champion_skill_3_shyvana, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_singed")) {
			cdSkill1 = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0 };
			cdSkill2 = new int[] { 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14,
					14, 14, 14, 14, 14, 14, 14 };
			cdSkill3 = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 100, 100, 100, 100, 100, 100,
					100, 100, 100, 100, 100, 100, 100 };
			player.setPlayer("Singed", R.drawable.champion_singed,
					R.drawable.champion_skill_4_singed,
					R.drawable.champion_skill_1_singed,
					R.drawable.champion_skill_2_singed,
					R.drawable.champion_skill_3_singed, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_sion")) {
			cdSkill1 = new int[] { 12, 12, 11, 11, 10, 10, 9, 9, 8, 8, 8, 8, 8,
					8, 8, 8, 8, 8 };
			cdSkill2 = new int[] { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,
					8, 8, 8 };
			cdSkill3 = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 90, 90, 90, 90, 90, 90, 90, 90,
					90, 90, 90, 90, 90 };
			player.setPlayer("Sion", R.drawable.champion_sion,
					R.drawable.champion_skill_4_sion,
					R.drawable.champion_skill_1_sion,
					R.drawable.champion_skill_2_sion,
					R.drawable.champion_skill_3_sion, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_sivir")) {
			cdSkill1 = new int[] { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
					9, 9, 9 };
			cdSkill2 = new int[] { 7, 7, 6, 6, 5, 5, 4, 4, 3, 3, 3, 3, 3, 3, 3,
					3, 3, 3 };
			cdSkill3 = new int[] { 22, 22, 19, 19, 16, 16, 13, 13, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 100, 100, 100, 100, 100, 90,
					90, 90, 90, 90, 80, 80, 80 };
			player.setPlayer("Sivir", R.drawable.champion_sivir,
					R.drawable.champion_skill_4_sivir,
					R.drawable.champion_skill_1_sivir,
					R.drawable.champion_skill_2_sivir,
					R.drawable.champion_skill_3_sivir, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_skarner")) {
			cdSkill1 = new int[] { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
					3, 3, 3 };
			cdSkill2 = new int[] { 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,
					18, 18, 18, 18, 18, 18, 18 };
			cdSkill3 = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 130, 130, 130, 130, 130, 120,
					120, 120, 120, 120, 110, 110, 110 };
			player.setPlayer("Skarner", R.drawable.champion_skarner,
					R.drawable.champion_skill_4_skarner,
					R.drawable.champion_skill_1_skarner,
					R.drawable.champion_skill_2_skarner,
					R.drawable.champion_skill_3_skarner, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_sona")) {
			cdSkill1 = new int[] { 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
					7, 7, 7 };
			cdSkill2 = new int[] { 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
					7, 7, 7 };
			cdSkill3 = new int[] { 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
					7, 7, 7 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 140, 140, 140, 140, 140, 120,
					120, 120, 120, 120, 100, 100, 100 };
			player.setPlayer("Sona", R.drawable.champion_sona,
					R.drawable.champion_skill_4_sona,
					R.drawable.champion_skill_1_sona,
					R.drawable.champion_skill_2_sona,
					R.drawable.champion_skill_3_sona, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_soraka")) {
			cdSkill1 = new int[] { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
					2, 2, 2 };
			cdSkill2 = new int[] { 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20,
					20, 20, 20, 20, 20, 20, 20 };
			cdSkill3 = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 160, 160, 160, 160, 160, 145,
					145, 145, 145, 145, 130, 130, 130 };
			player.setPlayer("Soraka", R.drawable.champion_soraka,
					R.drawable.champion_skill_4_soraka,
					R.drawable.champion_skill_1_soraka,
					R.drawable.champion_skill_2_soraka,
					R.drawable.champion_skill_3_soraka, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_swain")) {
			cdSkill1 = new int[] { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,
					8, 8, 8 };
			cdSkill2 = new int[] { 18, 18, 16, 16, 14, 14, 12, 12, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdSkill3 = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,
					8, 8, 8 };
			player.setPlayer("Swain", R.drawable.champion_swain,
					R.drawable.champion_skill_4_swain,
					R.drawable.champion_skill_1_swain,
					R.drawable.champion_skill_2_swain,
					R.drawable.champion_skill_3_swain, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_syndra")) {
			cdSkill1 = new int[] { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
					4, 4, 4 };
			cdSkill2 = new int[] { 12, 12, 11, 11, 10, 10, 9, 9, 8, 8, 8, 8, 8,
					8, 8, 8, 8, 8 };
			cdSkill3 = new int[] { 18, 18, 16, 16, 15, 15, 13, 13, 12, 12, 12,
					12, 12, 12, 12, 12, 12, 12 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 100, 100, 100, 100, 100, 90,
					90, 90, 90, 90, 80, 80, 80 };
			player.setPlayer("Syndra", R.drawable.champion_syndra,
					R.drawable.champion_skill_4_syndra,
					R.drawable.champion_skill_1_syndra,
					R.drawable.champion_skill_2_syndra,
					R.drawable.champion_skill_3_syndra, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_talon")) {
			cdSkill1 = new int[] { 8, 8, 7, 7, 6, 6, 5, 5, 4, 4, 4, 4, 4, 4, 4,
					4, 4, 4 };
			cdSkill2 = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdSkill3 = new int[] { 18, 18, 16, 16, 14, 14, 12, 12, 10, 10,
					1010, 10, 10, 10, 10, 10, 10, 10 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 75, 75, 75, 75, 75, 65, 65, 65,
					65, 65, 55, 55, 55 };
			player.setPlayer("Talon", R.drawable.champion_talon,
					R.drawable.champion_skill_4_talon,
					R.drawable.champion_skill_1_talon,
					R.drawable.champion_skill_2_talon,
					R.drawable.champion_skill_3_talon, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_taric")) {
			cdSkill1 = new int[] { 20, 20, 19, 19, 18, 18, 17, 17, 16, 16, 16,
					16, 16, 16, 16, 16, 16, 16 };
			cdSkill2 = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdSkill3 = new int[] { 14, 14, 13, 13, 12, 12, 11, 11, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 60, 60, 60, 60, 60, 60, 60, 60,
					60, 60, 60, 60, 60 };
			player.setPlayer("Taric", R.drawable.champion_taric,
					R.drawable.champion_skill_4_taric,
					R.drawable.champion_skill_1_taric,
					R.drawable.champion_skill_2_taric,
					R.drawable.champion_skill_3_taric, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_teemo")) {
			cdSkill1 = new int[] { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,
					8, 8, 8 };
			cdSkill2 = new int[] { 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17,
					17, 17, 17, 17, 17, 17, 17 };
			cdSkill3 = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
					1, 1, 1 };
			player.setPlayer("Teemo", R.drawable.champion_teemo,
					R.drawable.champion_skill_4_teemo,
					R.drawable.champion_skill_1_teemo,
					R.drawable.champion_skill_2_teemo,
					R.drawable.champion_skill_3_teemo, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_thresh")) {
			cdSkill1 = new int[] { 18, 18, 16, 16, 15, 15, 13, 13, 12, 12, 12,
					12, 12, 12, 12, 12, 12, 12 };
			cdSkill2 = new int[] { 22, 22, 20, 20, 19, 19, 17, 17, 16, 16, 16,
					16, 16, 16, 16, 16, 16, 16 };
			cdSkill3 = new int[] { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
					9, 9, 9 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 150, 150, 150, 150, 150, 140,
					140, 140, 140, 140, 130, 130, 130 };
			player.setPlayer("Thresh", R.drawable.champion_thresh,
					R.drawable.champion_skill_4_thresh,
					R.drawable.champion_skill_1_thresh,
					R.drawable.champion_skill_2_thresh,
					R.drawable.champion_skill_3_thresh, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_tristana")) {
			cdSkill1 = new int[] { 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20,
					20, 20, 20, 20, 20, 20, 20 };
			cdSkill2 = new int[] { 22, 22, 20, 20, 18, 18, 16, 16, 14, 14, 14,
					14, 14, 14, 14, 14, 14, 14 };
			cdSkill3 = new int[] { 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16,
					16, 16, 16, 16, 16, 16, 16 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 60, 60, 60, 60, 60, 60, 60, 60,
					60, 60, 60, 60, 60 };
			player.setPlayer("Tristana", R.drawable.champion_tristana,
					R.drawable.champion_skill_4_tristana,
					R.drawable.champion_skill_1_tristana,
					R.drawable.champion_skill_2_tristana,
					R.drawable.champion_skill_3_tristana, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_trundle")) {
			cdSkill1 = new int[] { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
					4, 4, 4 };
			cdSkill2 = new int[] { 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15,
					15, 15, 15, 15, 15, 15, 15 };
			cdSkill3 = new int[] { 23, 23, 20, 20, 17, 17, 14, 14, 11, 11, 11,
					11, 11, 11, 11, 11, 11, 11 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 80, 80, 80, 80, 80, 70, 70, 70,
					70, 70, 60, 60, 60 };
			player.setPlayer("Trunundle", R.drawable.champion_trundle,
					R.drawable.champion_skill_4_trundle,
					R.drawable.champion_skill_1_trundle,
					R.drawable.champion_skill_2_trundle,
					R.drawable.champion_skill_3_trundle, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_tryndamere")) {
			cdSkill1 = new int[] { 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12,
					12, 12, 12, 12, 12, 12, 12 };
			cdSkill2 = new int[] { 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14,
					14, 14, 14, 14, 14, 14, 14 };
			cdSkill3 = new int[] { 13, 13, 12, 12, 11, 11, 10, 10, 9, 9, 9, 9,
					9, 9, 9, 9, 9, 9 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 110, 110, 110, 110, 110, 100,
					100, 100, 100, 100, 90, 90, 90 };
			player.setPlayer("Tryndamere", R.drawable.champion_tryndamere,
					R.drawable.champion_skill_4_tryndamere,
					R.drawable.champion_skill_1_tryndamere,
					R.drawable.champion_skill_2_tryndamere,
					R.drawable.champion_skill_3_tryndamere, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_twisted_fate")) {
			cdSkill1 = new int[] { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,
					6, 6, 6 };
			cdSkill2 = new int[] { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,
					6, 6, 6 };
			cdSkill3 = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 180, 180, 180, 180, 180, 150,
					150, 150, 150, 150, 120, 120, 120 };
			player.setPlayer("Twisted Fate", R.drawable.champion_twisted_fate,
					R.drawable.champion_skill_4_twisted_fate,
					R.drawable.champion_skill_1_twisted_fate,
					R.drawable.champion_skill_2_twisted_fate,
					R.drawable.champion_skill_3_twisted_fate, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_twitch")) {
			cdSkill1 = new int[] { 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16,
					16, 16, 16, 16, 16, 16, 16 };
			cdSkill2 = new int[] { 13, 13, 12, 12, 11, 11, 10, 10, 9, 9, 9, 9,
					9, 9, 9, 9, 9, 9 };
			cdSkill3 = new int[] { 12, 12, 11, 11, 10, 10, 9, 9, 8, 8, 8, 8, 8,
					8, 8, 8, 8, 8 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 120, 120, 120, 120, 120, 110,
					110, 110, 100, 100, 100, 100, 100 };
			player.setPlayer("Twitch", R.drawable.champion_twitch,
					R.drawable.champion_skill_4_twitch,
					R.drawable.champion_skill_1_twitch,
					R.drawable.champion_skill_2_twitch,
					R.drawable.champion_skill_3_twitch, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_udyr")) {
			cdSkill1 = new int[] { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,
					6, 6, 6 };
			cdSkill2 = new int[] { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,
					6, 6, 6 };
			cdSkill3 = new int[] { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,
					6, 6, 6 };
			cdUlti = new int[] { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,
					6, 6, 6 };
			player.setPlayer("udyr", R.drawable.champion_udyr,
					R.drawable.champion_skill_4_udyr,
					R.drawable.champion_skill_1_udyr,
					R.drawable.champion_skill_2_udyr,
					R.drawable.champion_skill_3_udyr, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_urgot")) {
			cdSkill1 = new int[] { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
					2, 2, 2 };
			cdSkill2 = new int[] { 16, 16, 15, 15, 14, 14, 13, 13, 12, 12, 12,
					12, 12, 12, 12, 12, 12, 12 };
			cdSkill3 = new int[] { 15, 15, 14, 14, 13, 13, 12, 12, 11, 11, 11,
					11, 11, 11, 11, 11, 11, 11 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 120, 120, 120, 120, 120, 120,
					120, 120, 120, 120, 120, 120, 120 };
			player.setPlayer("Urgot", R.drawable.champion_urgot,
					R.drawable.champion_skill_4_urgot,
					R.drawable.champion_skill_1_urgot,
					R.drawable.champion_skill_2_urgot,
					R.drawable.champion_skill_3_urgot, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_varus")) {
			cdSkill1 = new int[] { 16, 16, 14, 14, 12, 12, 10, 10, 8, 8, 8, 8,
					8, 8, 8, 8, 8, 8 };
			cdSkill2 = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0 };
			cdSkill3 = new int[] { 18, 18, 16, 16, 14, 14, 12, 12, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 120, 120, 120, 120, 120, 105,
					105, 105, 105, 105, 90, 90, 90 };
			player.setPlayer("Varus", R.drawable.champion_varus,
					R.drawable.champion_skill_4_varus,
					R.drawable.champion_skill_1_varus,
					R.drawable.champion_skill_2_varus,
					R.drawable.champion_skill_3_varus, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_vayne")) {
			cdSkill1 = new int[] { 6, 6, 5, 5, 4, 4, 3, 3, 2, 2, 2, 2, 2, 2, 2,
					2, 2, 2 };
			cdSkill2 = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0 };
			cdSkill3 = new int[] { 20, 20, 18, 18, 16, 16, 14, 14, 12, 12, 12,
					12, 12, 12, 12, 12, 12, 12 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 70, 70, 70, 70, 70, 70, 70, 70,
					70, 70, 70, 70, 70 };
			player.setPlayer("Vaune", R.drawable.champion_varus,
					R.drawable.champion_skill_4_vayne,
					R.drawable.champion_skill_1_vayne,
					R.drawable.champion_skill_2_vayne,
					R.drawable.champion_skill_3_vayne, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_veigar")) {
			cdSkill1 = new int[] { 8, 8, 7, 7, 6, 6, 5, 5, 4, 4, 4, 4, 4, 4, 4,
					4, 4, 4 };
			cdSkill2 = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdSkill3 = new int[] { 20, 20, 19, 19, 18, 18, 17, 17, 16, 16, 16,
					16, 16, 16, 16, 16, 16, 16 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 130, 130, 130, 130, 130, 110,
					110, 110, 110, 110, 90, 90, 90 };
			player.setPlayer("Veigar", R.drawable.champion_veigar,
					R.drawable.champion_skill_4_veigar,
					R.drawable.champion_skill_1_veigar,
					R.drawable.champion_skill_2_veigar,
					R.drawable.champion_skill_3_veigar, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_vi")) {
			cdSkill1 = new int[] { 18, 18, 15, 15, 13, 13, 10, 10, 8, 8, 8, 8,
					8, 8, 8, 8, 8, 8 };
			cdSkill2 = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0 };
			cdSkill3 = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
					1, 1, 1 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 130, 130, 130, 130, 130, 105,
					105, 105, 105, 105, 80, 80, 80 };
			player.setPlayer("Vi", R.drawable.champion_vi,
					R.drawable.champion_skill_4_vi,
					R.drawable.champion_skill_1_vi,
					R.drawable.champion_skill_2_vi,
					R.drawable.champion_skill_3_vi, cdUlti, cdSkill1, cdSkill2,
					cdSkill3);
		} else if (character.equals("champion_viktor")) {
			cdSkill1 = new int[] { 9, 9, 8, 8, 7, 7, 6, 6, 5, 5, 5, 5, 5, 5, 5,
					5, 5, 5 };
			cdSkill2 = new int[] { 17, 17, 16, 16, 15, 15, 14, 14, 13, 13, 13,
					13, 13, 13, 13, 13, 13, 13 };
			cdSkill3 = new int[] { 13, 13, 12, 12, 11, 11, 10, 10, 9, 9, 9, 9,
					9, 9, 9, 9, 9, 9 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 120, 120, 120, 120, 120, 120,
					120, 120, 120, 120, 120, 120, 120 };
			player.setPlayer("Viktor", R.drawable.champion_viktor,
					R.drawable.champion_skill_4_viktor,
					R.drawable.champion_skill_1_viktor,
					R.drawable.champion_skill_2_viktor,
					R.drawable.champion_skill_3_viktor, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_vladimir")) {
			cdSkill1 = new int[] { 10, 10, 8, 8, 7, 7, 5, 5, 4, 4, 4, 4, 4, 4,
					4, 4, 4, 4 };
			cdSkill2 = new int[] { 26, 26, 23, 23, 20, 20, 17, 17, 14, 14, 14,
					14, 14, 14, 14, 14, 14, 14 };
			cdSkill3 = new int[] { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
					4, 4, 4 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 150, 150, 150, 150, 150, 135,
					135, 135, 135, 135, 120, 120, 120 };
			player.setPlayer("Vladimir", R.drawable.champion_vladimir,
					R.drawable.champion_skill_4_vladimir,
					R.drawable.champion_skill_1_vladimir,
					R.drawable.champion_skill_2_vladimir,
					R.drawable.champion_skill_3_vladimir, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_volibear")) {
			cdSkill1 = new int[] { 12, 12, 11, 10, 10, 9, 9, 8, 8, 8, 8, 8, 8,
					8, 8, 8, 8, 8 };
			cdSkill2 = new int[] { 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18,
					18, 18, 18, 18, 18, 18, 18 };
			cdSkill3 = new int[] { 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11,
					11, 11, 11, 11, 11, 11, 11 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 100, 100, 100, 100, 100, 90,
					90, 90, 90, 90, 80, 80, 80 };
			player.setPlayer("Volibear", R.drawable.champion_volibear,
					R.drawable.champion_skill_4_volibear,
					R.drawable.champion_skill_1_volibear,
					R.drawable.champion_skill_2_volibear,
					R.drawable.champion_skill_3_volibear, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_warwick")) {
			cdSkill1 = new int[] { 10, 10, 9, 9, 8, 8, 7, 7, 6, 6, 6, 6, 6, 6,
					6, 6, 6, 6 };
			cdSkill2 = new int[] { 24, 24, 22, 22, 20, 20, 18, 18, 16, 16, 16,
					16, 16, 16, 16, 16, 16, 16 };
			cdSkill3 = new int[] { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
					4, 4, 4 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 90, 90, 90, 90, 90, 80, 80, 80,
					80, 80, 70, 70, 70 };
			player.setPlayer("Warwick", R.drawable.champion_warwick,
					R.drawable.champion_skill_4_warwick,
					R.drawable.champion_skill_1_warwick,
					R.drawable.champion_skill_2_warwick,
					R.drawable.champion_skill_3_warwick, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_wukong")) {
			cdSkill1 = new int[] { 9, 9, 8, 8, 7, 7, 6, 6, 5, 5, 5, 5, 5, 5, 5,
					5, 5, 5 };
			cdSkill2 = new int[] { 18, 18, 16, 16, 14, 14, 12, 12, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdSkill3 = new int[] { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,
					8, 8, 8 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 120, 120, 120, 120, 120, 105,
					105, 105, 105, 105, 90, 90, 90 };
			player.setPlayer("Wukong", R.drawable.champion_wukong,
					R.drawable.champion_skill_4_wukong,
					R.drawable.champion_skill_1_wukong,
					R.drawable.champion_skill_2_wukong,
					R.drawable.champion_skill_3_wukong, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_xerath")) {
			cdSkill1 = new int[] { 7, 7, 6, 6, 6, 6, 5, 5, 5, 5, 5, 5, 5, 5, 5,
					5, 5, 5 };
			cdSkill2 = new int[] { 20, 20, 16, 16, 12, 12, 8, 8, 4, 4, 4, 4, 4,
					4, 4, 4, 4, 4 };
			cdSkill3 = new int[] { 12, 12, 11, 11, 10, 10, 9, 9, 8, 8, 8, 8, 8,
					8, 8, 8, 8, 8 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 80, 80, 80, 80, 80, 70, 70, 70,
					70, 70, 60, 60, 60 };
			player.setPlayer("Xerath", R.drawable.champion_xerath,
					R.drawable.champion_skill_4_xerath,
					R.drawable.champion_skill_1_xerath,
					R.drawable.champion_skill_2_xerath,
					R.drawable.champion_skill_3_xerath, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_xin_zhao")) {
			cdSkill1 = new int[] { 9, 9, 8, 8, 7, 7, 6, 6, 5, 5, 5, 5, 5, 5, 5,
					5, 5, 5 };
			cdSkill2 = new int[] { 16, 16, 15, 15, 14, 14, 13, 13, 12, 12, 12,
					12, 12, 12, 12, 12, 12, 12 };
			cdSkill3 = new int[] { 14, 14, 13, 13, 12, 12, 11, 11, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 120, 120, 120, 120, 120, 110,
					110, 110, 110, 110, 100, 100, 100 };
			player.setPlayer("Xin Zaho", R.drawable.champion_xin_zhao,
					R.drawable.champion_skill_4_xin_zhao,
					R.drawable.champion_skill_1_xin_zhao,
					R.drawable.champion_skill_2_xin_zhao,
					R.drawable.champion_skill_3_xin_zhao, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_yorick")) {
			cdSkill1 = new int[] { 9, 9, 8, 8, 7, 7, 6, 6, 5, 5, 5, 5, 5, 5, 5,
					5, 5, 5 };
			cdSkill2 = new int[] { 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12,
					12, 12, 12, 12, 12, 12, 12 };
			cdSkill3 = new int[] { 10, 10, 9, 9, 8, 8, 7, 7, 6, 6, 6, 6, 6, 6,
					6, 6, 6, 6 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 120, 120, 120, 120, 120, 105,
					105, 105, 105, 105, 90, 90, 90 };
			player.setPlayer("Yoric", R.drawable.champion_yorick,
					R.drawable.champion_skill_4_yorick,
					R.drawable.champion_skill_1_yorick,
					R.drawable.champion_skill_2_yorick,
					R.drawable.champion_skill_3_yorick, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_zac")) {
			cdSkill1 = new int[] { 9, 9, 8, 8, 8, 8, 7, 7, 7, 7, 7, 7, 7, 7, 7,
					7, 7, 7 };
			cdSkill2 = new int[] { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
					4, 4, 4 };
			cdSkill3 = new int[] { 24, 24, 21, 21, 18, 18, 15, 15, 12, 12, 12,
					12, 12, 12, 12, 12, 12, 12 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 130, 130, 130, 130, 130, 115,
					115, 115, 115, 115, 100, 100, 100 };
			player.setPlayer("Zac", R.drawable.champion_zac,
					R.drawable.champion_skill_4_zac,
					R.drawable.champion_skill_1_zac,
					R.drawable.champion_skill_2_zac,
					R.drawable.champion_skill_3_zac, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_zed")) {
			cdSkill1 = new int[] { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,
					6, 6, 6 };
			cdSkill2 = new int[] { 18, 18, 17, 17, 16, 16, 15, 15, 14, 14, 14,
					14, 14, 14, 14, 14, 14, 14 };
			cdSkill3 = new int[] { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
					4, 4, 4 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 120, 120, 120, 120, 120, 100,
					100, 100, 100, 100, 80, 80, 80 };
			player.setPlayer("Zed", R.drawable.champion_zed,
					R.drawable.champion_skill_4_zed,
					R.drawable.champion_skill_1_zed,
					R.drawable.champion_skill_2_zed,
					R.drawable.champion_skill_3_zed, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_ziggs")) {
			cdSkill1 = new int[] { 6, 6, 5, 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
					4, 4, 4 };
			cdSkill2 = new int[] { 26, 26, 24, 24, 22, 22, 20, 20, 18, 18, 18,
					18, 18, 18, 18, 18, 18, 18 };
			cdSkill3 = new int[] { 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16,
					16, 16, 16, 16, 16, 16, 16 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 120, 120, 120, 120, 120, 105,
					105, 105, 105, 105, 90, 90, 90 };
			player.setPlayer("Ziggs", R.drawable.champion_ziggs,
					R.drawable.champion_skill_4_ziggs,
					R.drawable.champion_skill_1_ziggs,
					R.drawable.champion_skill_2_ziggs,
					R.drawable.champion_skill_3_ziggs, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_zilean")) {
			cdSkill1 = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
					10, 10, 10, 10, 10, 10, 10 };
			cdSkill2 = new int[] { 18, 18, 15, 15, 12, 12, 9, 9, 6, 6, 6, 6, 6,
					6, 6, 6, 6, 6 };
			cdSkill3 = new int[] { 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20,
					20, 20, 20, 20, 20, 20, 20 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 180, 180, 180, 180, 180, 180,
					180, 180, 180, 180, 180, 180, 180 };
			player.setPlayer("zilean", R.drawable.champion_zilean,
					R.drawable.champion_skill_4_zilean,
					R.drawable.champion_skill_1_zilean,
					R.drawable.champion_skill_2_zilean,
					R.drawable.champion_skill_3_zilean, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		} else if (character.equals("champion_zyra")) {
			cdSkill1 = new int[] { 7, 7, 6, 6, 6, 6, 5, 5, 5, 5, 5, 5, 5, 5, 5,
					5, 5, 5 };
			cdSkill2 = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0 };
			cdSkill3 = new int[] { 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12,
					12, 12, 12, 12, 12, 12, 12 };
			cdUlti = new int[] { 0, 0, 0, 0, 0, 130, 130, 130, 130, 130, 120,
					120, 120, 120, 120, 110, 110, 110 };
			player.setPlayer("Zyra", R.drawable.champion_zyra,
					R.drawable.champion_skill_4_zyra,
					R.drawable.champion_skill_1_zyra,
					R.drawable.champion_skill_2_zyra,
					R.drawable.champion_skill_3_zyra, cdUlti, cdSkill1,
					cdSkill2, cdSkill3);
		}
	}

	private void prepareList() {
		listChampions = new ArrayList<String>();

		listChampions.add("champion_ahri");
		listChampions.add("champion_akali");
		listChampions.add("champion_alistar");
		listChampions.add("champion_amumu");
		listChampions.add("champion_anivia");
		listChampions.add("champion_annie");
		listChampions.add("champion_ashe");

		listChampions.add("champion_blitzcrank");
		listChampions.add("champion_brand");

		listChampions.add("champion_caitlyn");
		listChampions.add("champion_cassiopeia");
		listChampions.add("champion_cho_gath");
		listChampions.add("champion_corki");

		listChampions.add("champion_darius");
		listChampions.add("champion_diana");
		listChampions.add("champion_dr_mundo");
		listChampions.add("champion_draven");

		listChampions.add("champion_elise");
		listChampions.add("champion_evelynn");
		listChampions.add("champion_ezreal");

		listChampions.add("champion_fiddlestick");
		listChampions.add("champion_fiora");
		listChampions.add("champion_fizz");

		listChampions.add("champion_galio");
		listChampions.add("champion_gangplank");
		listChampions.add("champion_garen");
		listChampions.add("champion_gragas");
		listChampions.add("champion_graves");

		listChampions.add("champion_hecarim");
		listChampions.add("champion_heimerdinger");

		listChampions.add("champion_irelia");

		listChampions.add("champion_janna");
		listChampions.add("champion_jarvan_iv");
		listChampions.add("champion_jax");
		listChampions.add("champion_jayce");

		listChampions.add("champion_karma");
		listChampions.add("champion_karthus");
		listChampions.add("champion_kassadin");
		listChampions.add("champion_katarina");
		listChampions.add("champion_kayle");
		listChampions.add("champion_kennen");
		listChampions.add("champion_kha_zix");
		listChampions.add("champion_kog_maw");

		listChampions.add("champion_le_blanc");
		listChampions.add("champion_lee_sin");
		listChampions.add("champion_leona");
		listChampions.add("champion_lissandra");
		listChampions.add("champion_lulu");
		listChampions.add("champion_lux");

		listChampions.add("champion_malaphite");
		listChampions.add("champion_malzahar");
		listChampions.add("champion_maokai");
		listChampions.add("champion_master_yi");
		listChampions.add("champion_miss_fortune");
		listChampions.add("champion_mordekaiser");
		listChampions.add("champion_morgana");

		listChampions.add("champion_nami");
		listChampions.add("champion_nasus");
		listChampions.add("champion_natalius");
		listChampions.add("champion_nidalee");
		listChampions.add("champion_nocturne");
		listChampions.add("champion_nunu");

		listChampions.add("champion_olaf");
		listChampions.add("champion_orianna");

		listChampions.add("champion_pantheon");
		listChampions.add("champion_poppy");

		listChampions.add("champion_quinn");

		listChampions.add("champion_rammus");
		listChampions.add("champion_renegar");
		listChampions.add("champion_renekton");
		listChampions.add("champion_riven");
		listChampions.add("champion_rumble");
		listChampions.add("champion_ryze");

		listChampions.add("champion_sejuani");
		listChampions.add("champion_shaco");
		listChampions.add("champion_shen");
		listChampions.add("champion_shyvana");
		listChampions.add("champion_singed");
		listChampions.add("champion_sion");
		listChampions.add("champion_sivir");
		listChampions.add("champion_skarner");
		listChampions.add("champion_sona");
		listChampions.add("champion_soraka");
		listChampions.add("champion_swain");
		listChampions.add("champion_syndra");

		listChampions.add("champion_talon");
		listChampions.add("champion_taric");
		listChampions.add("champion_teemo");
		listChampions.add("champion_thresh");
		listChampions.add("champion_tristana");
		listChampions.add("champion_trundle");
		listChampions.add("champion_tryndamere");
		listChampions.add("champion_twisted_fate");
		listChampions.add("champion_twitch");

		listChampions.add("champion_udyr");
		listChampions.add("champion_urgot");

		listChampions.add("champion_varus");
		listChampions.add("champion_vayne");
		listChampions.add("champion_veigar");
		listChampions.add("champion_vi");
		listChampions.add("champion_viktor");
		listChampions.add("champion_vladimir");
		listChampions.add("champion_volibear");

		listChampions.add("champion_warwick");
		listChampions.add("champion_wukong");

		listChampions.add("champion_xerath");
		listChampions.add("champion_xin_zhao");

		listChampions.add("champion_yorick");

		listChampions.add("champion_zac");
		listChampions.add("champion_zed");
		listChampions.add("champion_ziggs");
		listChampions.add("champion_zilean");
		listChampions.add("champion_zyra");

		listIcons = new ArrayList<Integer>();

		listIcons.add(R.drawable.champion_ahri);
		listIcons.add(R.drawable.champion_akali);
		listIcons.add(R.drawable.champion_alistar);
		listIcons.add(R.drawable.champion_amumu);
		listIcons.add(R.drawable.champion_anivia);
		listIcons.add(R.drawable.champion_annie);
		listIcons.add(R.drawable.champion_ashe);

		listIcons.add(R.drawable.champion_blitzcrank);
		listIcons.add(R.drawable.champion_brand);

		listIcons.add(R.drawable.champion_caitlyn);
		listIcons.add(R.drawable.champion_cassiopeia);
		listIcons.add(R.drawable.champion_cho_gath);
		listIcons.add(R.drawable.champion_corki);

		listIcons.add(R.drawable.champion_darius);
		listIcons.add(R.drawable.champion_diana);
		listIcons.add(R.drawable.champion_dr_mundo);
		listIcons.add(R.drawable.champion_draven);

		listIcons.add(R.drawable.champion_elise);
		listIcons.add(R.drawable.champion_evelynn);
		listIcons.add(R.drawable.champion_ezreal);

		listIcons.add(R.drawable.champion_fiddlestick);
		listIcons.add(R.drawable.champion_fiora);
		listIcons.add(R.drawable.champion_fizz);

		listIcons.add(R.drawable.champion_galio);
		listIcons.add(R.drawable.champion_gangplank);
		listIcons.add(R.drawable.champion_garen);
		listIcons.add(R.drawable.champion_gragas);
		listIcons.add(R.drawable.champion_graves);

		listIcons.add(R.drawable.champion_hecarim);
		listIcons.add(R.drawable.champion_heimerdinger);

		listIcons.add(R.drawable.champion_irelia);

		listIcons.add(R.drawable.champion_janna);
		listIcons.add(R.drawable.champion_jarvan_iv);
		listIcons.add(R.drawable.champion_jax);
		listIcons.add(R.drawable.champion_jayce);

		listIcons.add(R.drawable.champion_karma);
		listIcons.add(R.drawable.champion_karthus);
		listIcons.add(R.drawable.champion_kassadin);
		listIcons.add(R.drawable.champion_katarina);
		listIcons.add(R.drawable.champion_kayle);
		listIcons.add(R.drawable.champion_kennen);
		listIcons.add(R.drawable.champion_kha_zix);
		listIcons.add(R.drawable.champion_kog_maw);

		listIcons.add(R.drawable.champion_le_blanc);
		listIcons.add(R.drawable.champion_lee_sin);
		listIcons.add(R.drawable.champion_leona);
		listIcons.add(R.drawable.champion_lissandra);
		listIcons.add(R.drawable.champion_lulu);
		listIcons.add(R.drawable.champion_lux);

		listIcons.add(R.drawable.champion_malaphite);
		listIcons.add(R.drawable.champion_malzahar);
		listIcons.add(R.drawable.champion_maokai);
		listIcons.add(R.drawable.champion_master_yi);
		listIcons.add(R.drawable.champion_miss_fortune);
		listIcons.add(R.drawable.champion_mordekaiser);
		listIcons.add(R.drawable.champion_morgana);

		listIcons.add(R.drawable.champion_nami);
		listIcons.add(R.drawable.champion_nasus);
		listIcons.add(R.drawable.champion_natalius);
		listIcons.add(R.drawable.champion_nidalee);
		listIcons.add(R.drawable.champion_nocturne);
		listIcons.add(R.drawable.champion_nunu);

		listIcons.add(R.drawable.champion_olaf);
		listIcons.add(R.drawable.champion_orianna);

		listIcons.add(R.drawable.champion_pantheon);
		listIcons.add(R.drawable.champion_poppy);

		listIcons.add(R.drawable.champion_quinn);

		listIcons.add(R.drawable.champion_rammus);
		listIcons.add(R.drawable.champion_renegar);
		listIcons.add(R.drawable.champion_renekton);
		listIcons.add(R.drawable.champion_riven);
		listIcons.add(R.drawable.champion_rumble);
		listIcons.add(R.drawable.champion_ryze);

		listIcons.add(R.drawable.champion_sejuani);
		listIcons.add(R.drawable.champion_shaco);
		listIcons.add(R.drawable.champion_shen);
		listIcons.add(R.drawable.champion_shyvana);
		listIcons.add(R.drawable.champion_singed);
		listIcons.add(R.drawable.champion_sion);
		listIcons.add(R.drawable.champion_sivir);
		listIcons.add(R.drawable.champion_skarner);
		listIcons.add(R.drawable.champion_sona);
		listIcons.add(R.drawable.champion_soraka);
		listIcons.add(R.drawable.champion_swain);
		listIcons.add(R.drawable.champion_syndra);

		listIcons.add(R.drawable.champion_talon);
		listIcons.add(R.drawable.champion_taric);
		listIcons.add(R.drawable.champion_teemo);
		listIcons.add(R.drawable.champion_thresh);
		listIcons.add(R.drawable.champion_tristana);
		listIcons.add(R.drawable.champion_trundle);
		listIcons.add(R.drawable.champion_tryndamere);
		listIcons.add(R.drawable.champion_twisted_fate);
		listIcons.add(R.drawable.champion_twitch);

		listIcons.add(R.drawable.champion_udyr);
		listIcons.add(R.drawable.champion_urgot);

		listIcons.add(R.drawable.champion_varus);
		listIcons.add(R.drawable.champion_vayne);
		listIcons.add(R.drawable.champion_veigar);
		listIcons.add(R.drawable.champion_vi);
		listIcons.add(R.drawable.champion_viktor);
		listIcons.add(R.drawable.champion_vladimir);
		listIcons.add(R.drawable.champion_volibear);

		listIcons.add(R.drawable.champion_warwick);
		listIcons.add(R.drawable.champion_wukong);

		listIcons.add(R.drawable.champion_xerath);
		listIcons.add(R.drawable.champion_xin_zhao);

		listIcons.add(R.drawable.champion_yorick);

		listIcons.add(R.drawable.champion_zac);
		listIcons.add(R.drawable.champion_zed);
		listIcons.add(R.drawable.champion_ziggs);
		listIcons.add(R.drawable.champion_zilean);
		listIcons.add(R.drawable.champion_zyra);
	}

	ImageView barier;
	ImageView clairvoyance;
	ImageView clarity;
	ImageView cleanse;
	ImageView exhaust;
	ImageView flash;
	ImageView garrison;
	ImageView ghost;
	ImageView heal;
	ImageView ignite;
	ImageView revive;
	ImageView smite;
	ImageView teleport;

	private void initSpells() {
		barier = (ImageView) findViewById(R.id.spell_barier);
		clairvoyance = (ImageView) findViewById(R.id.spell_clairvoyance);
		clarity = (ImageView) findViewById(R.id.spell_clarity);
		cleanse = (ImageView) findViewById(R.id.spell_cleanse);
		exhaust = (ImageView) findViewById(R.id.spell_exhaust);
		flash = (ImageView) findViewById(R.id.spell_flash);
		garrison = (ImageView) findViewById(R.id.spell_garrison);
		ghost = (ImageView) findViewById(R.id.spell_ghost);
		heal = (ImageView) findViewById(R.id.spell_heal);
		ignite = (ImageView) findViewById(R.id.spell_ignite);
		revive = (ImageView) findViewById(R.id.spell_revive);
		smite = (ImageView) findViewById(R.id.spell_smite);
		teleport = (ImageView) findViewById(R.id.spell_teleport);

		barier.setOnClickListener(this);
		clairvoyance.setOnClickListener(this);
		clarity.setOnClickListener(this);
		cleanse.setOnClickListener(this);
		exhaust.setOnClickListener(this);
		flash.setOnClickListener(this);
		garrison.setOnClickListener(this);
		ghost.setOnClickListener(this);
		heal.setOnClickListener(this);
		ignite.setOnClickListener(this);
		revive.setOnClickListener(this);
		smite.setOnClickListener(this);
		teleport.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.spell_barier:
			step++;
			if (step == 2) {
				player.drawableSpell1 = R.drawable.spell_barier;
				player.cdSpell1 = 189000;
				title.setText("Select 2nd spell");
			} else {
				player.drawableSpell2 = R.drawable.spell_barier;
				player.cdSpell2 = 189000;
				saveResult();
			}
			break;
		case R.id.spell_clairvoyance:
			step++;
			if (step == 2) {
				player.drawableSpell1 = R.drawable.spell_clairvoyance;
				player.cdSpell1 = 45500;
				title.setText("Select 2nd spell");
			} else {
				player.drawableSpell2 = R.drawable.spell_clairvoyance;
				player.cdSpell2 = 45500;
				saveResult();
			}
			break;
		case R.id.spell_clarity:
			step++;
			if (step == 2) {
				player.drawableSpell1 = R.drawable.spell_clarity;
				player.cdSpell1 = 121500;
				title.setText("Select 2nd spell");
			} else {
				player.drawableSpell2 = R.drawable.spell_clarity;
				player.cdSpell2 = 121500;
				saveResult();
			}
			break;
		case R.id.spell_cleanse:
			step++;
			if (step == 2) {
				player.drawableSpell1 = R.drawable.spell_cleanse;
				player.cdSpell1 = 189000;
				title.setText("Select 2nd spell");
			} else {
				player.drawableSpell2 = R.drawable.spell_cleanse;
				player.cdSpell2 = 189000;
				saveResult();
			}
			break;
		case R.id.spell_exhaust:
			step++;
			if (step == 2) {
				player.drawableSpell1 = R.drawable.spell_exhaust;
				player.cdSpell1 = 189000;
				title.setText("Select 2nd spell");
			} else {
				player.drawableSpell2 = R.drawable.spell_exhaust;
				player.cdSpell2 = 189000;
				saveResult();
			}
			break;
		case R.id.spell_flash:
			step++;
			if (step == 2) {
				player.drawableSpell1 = R.drawable.spell_flash;
				player.cdSpell1 = 187500;
				title.setText("Select 2nd spell");
			} else {
				player.drawableSpell2 = R.drawable.spell_flash;
				player.cdSpell2 = 187500;
				saveResult();
			}
			break;
		case R.id.spell_garrison:
			step++;
			if (step == 2) {
				player.drawableSpell1 = R.drawable.spell_garrison;
				player.cdSpell1 = 189000;
				title.setText("Select 2nd spell");
			} else {
				player.drawableSpell2 = R.drawable.spell_garrison;
				player.cdSpell2 = 189000;
				saveResult();
			}
			break;
		case R.id.spell_ghost:
			step++;
			if (step == 2) {
				player.drawableSpell1 = R.drawable.spell_ghost;
				player.cdSpell1 = 141750;
				title.setText("Select 2nd spell");
			} else {
				player.drawableSpell2 = R.drawable.spell_ghost;
				player.cdSpell2 = 141750;
				saveResult();
			}
			break;
		case R.id.spell_heal:
			step++;
			if (step == 2) {
				player.drawableSpell1 = R.drawable.spell_heal;
				player.cdSpell1 = 202500;
				title.setText("Select 2nd spell");
			} else {
				player.drawableSpell2 = R.drawable.spell_heal;
				player.cdSpell2 = 202500;
				saveResult();
			}
			break;
		case R.id.spell_ignite:
			step++;
			if (step == 2) {
				player.drawableSpell1 = R.drawable.spell_ignite;
				player.cdSpell1 = 189000;
				title.setText("Select 2nd spell");
			} else {
				player.drawableSpell2 = R.drawable.spell_ignite;
				player.cdSpell2 = 189000;
				saveResult();
			}
			break;
		case R.id.spell_revive:
			step++;
			if (step == 2) {
				player.drawableSpell1 = R.drawable.spell_revive;
				player.cdSpell1 = 486000;
				title.setText("Select 2nd spell");
			} else {
				player.drawableSpell2 = R.drawable.spell_revive;
				player.cdSpell2 = 486000;
				saveResult();
			}
			break;
		case R.id.spell_smite:
			step++;
			if (step == 2) {
				player.drawableSpell1 = R.drawable.spell_smite;
				player.cdSpell1 = 50400;
				title.setText("Select 2nd spell");
			} else {
				player.drawableSpell2 = R.drawable.spell_smite;
				player.cdSpell2 = 50400;
				saveResult();
			}
			break;
		case R.id.spell_teleport:
			step++;
			if (step == 2) {
				player.drawableSpell1 = R.drawable.spell_teleport;
				player.cdSpell1 = 20250;
				title.setText("Select 2nd spell");
			} else {
				player.drawableSpell2 = R.drawable.spell_teleport;
				player.cdSpell2 = 20250;
				saveResult();
			}
			break;
		}
	}

	private void saveResult() {
		finish();
		((LOLCApplication) getApplication()).currentlyPicking
				.addBehavior(player);
	}
}
