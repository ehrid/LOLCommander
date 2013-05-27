package com.leagueoflegendscommander.activities;

import java.util.ArrayList;

import com.leagueoflegendscommander.R;
import com.leagueoflegendscommander.objects.Player;
import com.leagueoflegendscommander.tools.GridviewAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

public class HeroActivity extends Activity implements OnClickListener {
	private GridviewAdapter mAdapter;
	private ArrayList<String> listChampions;
	private ArrayList<Integer> listIcons;

	private TextView title;
	private View spellView;
	private GridView gridView;

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
		mAdapter = new GridviewAdapter(this, listChampions, listIcons);

		// Set custom adapter to gridview
		gridView = (GridView) findViewById(R.id.hero_list);
		gridView.setAdapter(mAdapter);

		// Implement On Item click listener
		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				step++;
				Toast.makeText(HeroActivity.this, mAdapter.getItem(position),
						Toast.LENGTH_SHORT).show();
				gridView.setVisibility(View.GONE);
				spellView.setVisibility(View.VISIBLE);
				spellView.bringToFront();
				title.setText("Select 1st spell");
				initSpells();
				// TODO zapisywanie do postaci
			}
		});
	}

	private void saveToPlayer(String character) {
		switch (character) {
		case "champion_ahri":
			player.setPlayer("Ahri", R.drawable.champion_ahri, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_akali":
			player.setPlayer("Akali", R.drawable.champion_akali, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_alistar":
			player.setPlayer("Alistar", R.drawable.champion_alistar, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_amumu":
			player.setPlayer("Amumu", R.drawable.champion_amumu, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_anivia":
			player.setPlayer("Anivia", R.drawable.champion_anivia, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_annie":
			player.setPlayer("Annie", R.drawable.champion_annie, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_ashe":
			player.setPlayer("Ashe", R.drawable.champion_ashe, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;

		case "champion_blitzcrank":
			player.setPlayer("Blirzcrank", R.drawable.champion_blitzcrank, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_brand":
			player.setPlayer("Brand", R.drawable.champion_brand, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;

		case "champion_caitlyn":
			player.setPlayer("Caitlyn", R.drawable.champion_caitlyn, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_cassiopeia":
			player.setPlayer("Cassiopeia", R.drawable.champion_cassiopeia, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_cho_gath":
			player.setPlayer("Cho'Gath", R.drawable.champion_cho_gath, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_corki":
			player.setPlayer("Corki", R.drawable.champion_corki, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;

		case "champion_darius":
			player.setPlayer("Darius", R.drawable.champion_darius, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_diana":
			player.setPlayer("Diana", R.drawable.champion_diana, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_dr_mundo":
			player.setPlayer("Dr. Mundo", R.drawable.champion_dr_mundo, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_draven":
			player.setPlayer("Draven", R.drawable.champion_draven, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;

		case "champion_elise":
			player.setPlayer("Elise", R.drawable.champion_elise, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_evelynn":
			player.setPlayer("Evelynn", R.drawable.champion_evelynn, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_ezreal":
			player.setPlayer("Ezreal", R.drawable.champion_ezreal, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;

		case "champion_fiddlestick":
			player.setPlayer("Fiddlestick", R.drawable.champion_fiddlestick, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_fiora":
			player.setPlayer("Fiora", R.drawable.champion_fiora, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_fizz":
			player.setPlayer("Fizz", R.drawable.champion_fizz, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;

		case "champion_galio":
			player.setPlayer("Galio", R.drawable.champion_galio, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_gangplank":
			player.setPlayer("Gangplank", R.drawable.champion_gangplank, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_garen":
			player.setPlayer("Garen", R.drawable.champion_garen, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_gragas":
			player.setPlayer("Gragas", R.drawable.champion_gragas, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_graves":
			player.setPlayer("Graves", R.drawable.champion_graves, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;

		case "champion_hecarim":
			player.setPlayer("Hecarim", R.drawable.champion_hecarim, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_heimerdinger":
			player.setPlayer("Heimerdinger", R.drawable.champion_heimerdinger, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;

		case "champion_irelia":
			player.setPlayer("Irelia", R.drawable.champion_irelia, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;

		case "champion_janna":
			player.setPlayer("Janna", R.drawable.champion_janna, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_jarvan_iv":
			player.setPlayer("jarvan IV", R.drawable.champion_jarvan_iv, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_jax":
			player.setPlayer("Jax", R.drawable.champion_jax, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_jayce":
			player.setPlayer("jayce", R.drawable.champion_jayce, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;

		case "champion_karma":
			player.setPlayer("Karma", R.drawable.champion_karma, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_karthus":
			player.setPlayer("Karthus", R.drawable.champion_karthus, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_kassadin":
			player.setPlayer("Kassadin", R.drawable.champion_kassadin, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_katarina":
			player.setPlayer("Katarina", R.drawable.champion_katarina, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_kayle":
			player.setPlayer("Kayle", R.drawable.champion_kayle, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_kennen":
			player.setPlayer("Kennen", R.drawable.champion_kennen, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_kha_zix":
			player.setPlayer("Kha'Zix", R.drawable.champion_kha_zix, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_kog_maw":
			player.setPlayer("Kog'Maw", R.drawable.champion_kog_maw, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;

		case "champion_le_blanc":
			player.setPlayer("Le blanc", R.drawable.champion_le_blanc, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_lee_sin":
			player.setPlayer("Lee Sin", R.drawable.champion_lee_sin, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_leona":
			player.setPlayer("Leona", R.drawable.champion_leona, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_lissandra":
			player.setPlayer("Lissandra", R.drawable.champion_lissandra, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_lulu":
			player.setPlayer("Lulu", R.drawable.champion_lulu, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_lux":
			player.setPlayer("Lux", R.drawable.champion_lux, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;

		case "champion_malaphite":
			player.setPlayer("Malaphite", R.drawable.champion_malaphite, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_malzahar":
			player.setPlayer("Malzahar", R.drawable.champion_malzahar, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_maokai":
			player.setPlayer("Maokai", R.drawable.champion_maokai, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_master_yi":
			player.setPlayer("Master Yi", R.drawable.champion_master_yi, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_miss_fortune":
			player.setPlayer("Miss Fortune", R.drawable.champion_miss_fortune, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_mordekaiser":
			player.setPlayer("Mordekaiser", R.drawable.champion_mordekaiser, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_morgana":
			player.setPlayer("Morgana", R.drawable.champion_morgana, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;

		case "champion_nami":
			player.setPlayer("Nami", R.drawable.champion_nami, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_nasus":
			player.setPlayer("Nasus", R.drawable.champion_nasus, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_natalius":
			player.setPlayer("Natalius", R.drawable.champion_natalius, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_nidalee":
			player.setPlayer("Nidalee", R.drawable.champion_nidalee, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_nocturne":
			player.setPlayer("Nocturne", R.drawable.champion_nocturne, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_nunu":
			player.setPlayer("Nunu", R.drawable.champion_nunu, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;

		case "champion_olaf":
			player.setPlayer("Olaf", R.drawable.champion_olaf, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_orianna":
			player.setPlayer("Orianna", R.drawable.champion_orianna, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;

		case "champion_pantheon":
			player.setPlayer("Pantheon", R.drawable.champion_pantheon, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_poppy":
			player.setPlayer("Poppy", R.drawable.champion_poppy, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;

		case "champion_quinn":
			player.setPlayer("Quinn", R.drawable.champion_quinn, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;

		case "champion_rammus":
			player.setPlayer("Rammus", R.drawable.champion_rammus, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_renegar":
			player.setPlayer("Renegar", R.drawable.champion_renegar, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_renekton":
			player.setPlayer("Renekton", R.drawable.champion_renekton, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_riven":
			player.setPlayer("Riven", R.drawable.champion_riven, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_rumble":
			player.setPlayer("Rumble", R.drawable.champion_rumble, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_ryze":
			player.setPlayer("Ryze", R.drawable.champion_ryze, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;

		case "champion_sejuani":
			player.setPlayer("Sejuani", R.drawable.champion_sejuani, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_shaco":
			player.setPlayer("Shaco", R.drawable.champion_shaco, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_shen":
			player.setPlayer("Shen", R.drawable.champion_shen, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_shyvana":
			player.setPlayer("Shyvana", R.drawable.champion_shyvana, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_singed":
			player.setPlayer("Singed", R.drawable.champion_singed, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_sion":
			player.setPlayer("Sion", R.drawable.champion_sion, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_sivir":
			player.setPlayer("Sivir", R.drawable.champion_sivir, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_skarner":
			player.setPlayer("Skarner", R.drawable.champion_skarner, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_sona":
			player.setPlayer("Sona", R.drawable.champion_sona, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_soraka":
			player.setPlayer("Soraka", R.drawable.champion_soraka, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_swain":
			player.setPlayer("Swain", R.drawable.champion_swain, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_syndra":
			player.setPlayer("Syndra", R.drawable.champion_syndra, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;

		case "champion_talon":
			player.setPlayer("Talon", R.drawable.champion_talon, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_taric":
			player.setPlayer("Taric", R.drawable.champion_taric, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_teemo":
			player.setPlayer("Teemo", R.drawable.champion_teemo, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_thresh":
			player.setPlayer("Thresh", R.drawable.champion_thresh, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_tristana":
			player.setPlayer("Tristana", R.drawable.champion_tristana, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_trundle":
			player.setPlayer("Trunundle", R.drawable.champion_trundle, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_tryndamere":
			player.setPlayer("Tryndamere", R.drawable.champion_tryndamere, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_twisted_fate":
			player.setPlayer("Twisted Fate", R.drawable.champion_twisted_fate, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_twitch":
			player.setPlayer("Twitch", R.drawable.champion_twitch, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;

		case "champion_udyr":
			player.setPlayer("udyr",R.drawable.champion_udyr, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_urgot":
			player.setPlayer("Urgot", R.drawable.champion_urgot, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;

		case "champion_varus":
			player.setPlayer("Varus", R.drawable.champion_varus, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_vayne":
			player.setPlayer("Vaune", R.drawable.champion_varus, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_veigar":
			player.setPlayer("Veigar", R.drawable.champion_veigar, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_vi":
			player.setPlayer("Vi", R.drawable.champion_vi, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_viktor":
			player.setPlayer("Viktor", R.drawable.champion_viktor, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_vladimir":
			player.setPlayer("Vladimir", R.drawable.champion_vladimir, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_volibear":
			player.setPlayer("Volibear", R.drawable.champion_volibear, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;

		case "champion_warwick":
			player.setPlayer("Warwick", R.drawable.champion_warwick, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_wukong":
			player.setPlayer("Wukong", R.drawable.champion_wukong, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;

		case "champion_xerath":
			player.setPlayer("Xerath", R.drawable.champion_xerath, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_xin_zhao":
			player.setPlayer("Xin Zaho", R.drawable.champion_xin_zhao, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;

		case "champion_yorick":
			player.setPlayer("Yoric", R.drawable.champion_yorick, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;

		case "champion_zac":
			player.setPlayer("Zac", R.drawable.champion_zac, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_zed":
			player.setPlayer("Zed", R.drawable.champion_zed, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_ziggs":
			player.setPlayer("Ziggs", R.drawable.champion_ziggs, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_zilean":
			player.setPlayer("zilean", R.drawable.champion_zilean, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;
		case "champion_zyra":
			player.setPlayer("Zyra", R.drawable.champion_zyra, drawableUlti,
					drawableSkill1, drawableSkill2, drawableSkill3, cdUlti,
					cdSkill1, cdSkill2, cdSkill3);
			break;

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
				player.cdSpell1 = 1890000;
				title.setText("Select 2nd spell");
			} else {
				player.drawableSpell2 = R.drawable.spell_barier;
				player.cdSpell2 = 1890000;
				finish();
			}
			break;
		case R.id.spell_clairvoyance:
			step++;
			if (step == 2) {
				player.drawableSpell1 = R.drawable.spell_clairvoyance;
				player.cdSpell1 = 1890000;
				title.setText("Select 2nd spell");
			} else {
				player.drawableSpell2 = R.drawable.spell_clairvoyance;
				player.cdSpell2 = 455000;
				finish();
			}
			break;
		case R.id.spell_clarity:
			step++;
			if (step == 2) {
				player.drawableSpell1 = R.drawable.spell_clarity;
				player.cdSpell1 = 1215000;
				title.setText("Select 2nd spell");
			} else {
				player.drawableSpell2 = R.drawable.spell_clarity;
				player.cdSpell2 = 1215000;
				finish();
			}
			break;
		case R.id.spell_cleanse:
			step++;
			if (step == 2) {
				player.drawableSpell1 = R.drawable.spell_cleanse;
				player.cdSpell1 = 1890000;
				title.setText("Select 2nd spell");
			} else {
				player.drawableSpell2 = R.drawable.spell_cleanse;
				player.cdSpell2 = 1890000;
				finish();
			}
			break;
		case R.id.spell_exhaust:
			step++;
			if (step == 2) {
				player.drawableSpell1 = R.drawable.spell_exhaust;
				player.cdSpell1 = 1890000;
				title.setText("Select 2nd spell");
			} else {
				player.drawableSpell2 = R.drawable.spell_exhaust;
				player.cdSpell2 = 1890000;
				finish();
			}
			break;
		case R.id.spell_flash:
			step++;
			if (step == 2) {
				player.drawableSpell1 = R.drawable.spell_flash;
				player.cdSpell1 = 1875000;
				title.setText("Select 2nd spell");
			} else {
				player.drawableSpell2 = R.drawable.spell_flash;
				player.cdSpell2 = 1875000;
				finish();
			}
			break;
		case R.id.spell_garrison:
			step++;
			if (step == 2) {
				player.drawableSpell1 = R.drawable.spell_garrison;
				player.cdSpell1 = 1890000;
				title.setText("Select 2nd spell");
			} else {
				player.drawableSpell2 = R.drawable.spell_garrison;
				player.cdSpell2 = 1890000;
				finish();
			}
			break;
		case R.id.spell_ghost:
			step++;
			if (step == 2) {
				player.drawableSpell1 = R.drawable.spell_ghost;
				player.cdSpell1 = 1417500;
				title.setText("Select 2nd spell");
			} else {
				player.drawableSpell2 = R.drawable.spell_ghost;
				player.cdSpell2 = 1417500;
				finish();
			}
			break;
		case R.id.spell_heal:
			step++;
			if (step == 2) {
				player.drawableSpell1 = R.drawable.spell_heal;
				player.cdSpell1 = 2025000;
				title.setText("Select 2nd spell");
			} else {
				player.drawableSpell2 = R.drawable.spell_heal;
				player.cdSpell2 = 2025000;
				finish();
			}
			break;
		case R.id.spell_ignite:
			step++;
			if (step == 2) {
				player.drawableSpell1 = R.drawable.spell_ignite;
				player.cdSpell1 = 1890000;
				title.setText("Select 2nd spell");
			} else {
				player.drawableSpell2 = R.drawable.spell_ignite;
				player.cdSpell2 = 1890000;
				finish();
			}
			break;
		case R.id.spell_revive:
			step++;
			if (step == 2) {
				player.drawableSpell1 = R.drawable.spell_revive;
				player.cdSpell1 = 4860000;
				title.setText("Select 2nd spell");
			} else {
				player.drawableSpell2 = R.drawable.spell_revive;
				player.cdSpell2 = 4860000;
				finish();
			}
			break;
		case R.id.spell_smite:
			step++;
			if (step == 2) {
				player.drawableSpell1 = R.drawable.spell_smite;
				player.cdSpell1 = 504000;
				title.setText("Select 2nd spell");
			} else {
				player.drawableSpell2 = R.drawable.spell_smite;
				player.cdSpell2 = 504000;
				finish();
			}
			break;
		case R.id.spell_teleport:
			step++;
			if (step == 2) {
				player.drawableSpell1 = R.drawable.spell_teleport;
				player.cdSpell1 = 2025000;
				title.setText("Select 2nd spell");
			} else {
				player.drawableSpell2 = R.drawable.spell_teleport;
				player.cdSpell2 = 2025000;
				finish();
			}
			break;
		}
	}
}
