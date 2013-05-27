package com.leagueoflegendscommander.tools;

import java.util.ArrayList;

import com.leagueoflegendscommander.R;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GridviewAdapter extends BaseAdapter {
	private ArrayList<String> listChampions;
	private ArrayList<Integer> listIcons;
	private Activity activity;

	public GridviewAdapter(Activity activity, ArrayList<String> listChampions,
			ArrayList<Integer> listIcons) {
		super();
		this.listChampions = listChampions;
		this.listIcons = listIcons;
		this.activity = activity;
	}

	@Override
	public int getCount() {
		return listChampions.size();
	}

	@Override
	public String getItem(int position) {
		return listChampions.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	public static class ViewHolder {
		public ImageView imgViewFlag;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder view;
		LayoutInflater inflator = activity.getLayoutInflater();

		if (convertView == null) {
			view = new ViewHolder();
			convertView = inflator.inflate(R.layout.item_champion, null);

			view.imgViewFlag = (ImageView) convertView
					.findViewById(R.id.item_champion_pic);

			convertView.setTag(view);
		} else {
			view = (ViewHolder) convertView.getTag();
		}

		view.imgViewFlag.setImageResource(listIcons.get(position));

		return convertView;
	}
}