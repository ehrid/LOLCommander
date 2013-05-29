package com.leagueoflegendscommander.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.leagueoflegendscommander.R;
import com.leagueoflegendscommander.activities.CommanderActivity;

public class CDRChangeDialog extends Dialog implements
		android.view.View.OnClickListener {
	CommanderActivity rootView;
	Context context;
	int possition;
	
	TextView cdr;
	Button minus10;
	Button minus5;
	Button plus5;
	Button plus10;
	Button cancel;
	
	double cdr_change;

	public CDRChangeDialog(Context context, double currentCDR) {
		super(context);
		rootView = (CommanderActivity) context;
		cdr_change = currentCDR;
	}

	ImageView poster;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_cdr);

		cdr = (TextView) findViewById(R.id.dialog_cdr_value);
		minus10 = (Button) findViewById(R.id.dialog_cdr_minus10);
		minus5 = (Button) findViewById(R.id.dialog_cdr_minus5);
		plus5 = (Button) findViewById(R.id.dialog_cdr_plus5);
		plus10 = (Button) findViewById(R.id.dialog_cdr_plus10);
		cancel = (Button) findViewById(R.id.dialog_close);
		
		minus10.setOnClickListener(this);
		minus5.setOnClickListener(this);
		plus5.setOnClickListener(this);
		plus10.setOnClickListener(this); 
		cancel.setOnClickListener(this);
		
		cdr.setText("Current CDR - " +(int)(cdr_change*100)+"%");

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.dialog_cdr_minus10:
			cdr_change -= 0.1;
			cdr_change = Math.max(0,cdr_change);
			cdr.setText("Current CDR - " +(int)(cdr_change*100)+"%");
			break;
		case R.id.dialog_cdr_minus5:
			cdr_change -= 0.05;
			cdr_change = Math.max(0,cdr_change);
			cdr.setText("Current CDR - " +(int)(cdr_change*100)+"%");
			break;
		case R.id.dialog_cdr_plus5:
			cdr_change += 0.05;
			cdr_change = Math.min(0.4,cdr_change);
			cdr.setText("Current CDR - " +(int)(cdr_change*100)+"%");
			break;
		case R.id.dialog_cdr_plus10:
			cdr_change += 0.1;
			cdr_change = Math.min(0.4,cdr_change);
			cdr.setText("Current CDR - " +(int)(cdr_change*100)+"%");
			break;
		case R.id.dialog_close:
			rootView.changeCDR(cdr_change);
			dismiss();
			break;

		}
	}
}
