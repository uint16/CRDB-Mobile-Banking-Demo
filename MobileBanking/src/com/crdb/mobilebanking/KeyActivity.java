package com.crdb.mobilebanking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class KeyActivity extends ActionBarActivity {

	TextView key1, key2, key3, tvKeyDescription;
	Button btContinue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_key);

		key1 = (TextView) findViewById(R.id.key1);
		key2 = (TextView) findViewById(R.id.key2);
		key3 = (TextView) findViewById(R.id.key3);

		tvKeyDescription = (TextView) findViewById(R.id.tvKey);
		btContinue = (Button) findViewById(R.id.btContinue);

		getSupportActionBar().setBackgroundDrawable(
				getResources().getDrawable(R.color.crdb_green));

		int keyLength = 6; // get from database

		final int firstKey;
		int secondKey, thirdKey;

		firstKey = (int) (Math.random() * keyLength) + 1;
		secondKey = (int) (Math.random() * keyLength) + 1;
		thirdKey = (int) (Math.random() * keyLength) + 1;

		new Thread(){

			public void run(){
				CRDBApplication.user=CRDBApplication.db.getUser(firstKey);
				CRDBApplication.transactionList=CRDBApplication.db.getAllTransactions(firstKey);
			}

		}.start();
		
		tvKeyDescription
		.setText("To complete Login in please enter the requested numbers and or letters from your secret key. Enter the "
				+ firstKey
				+ ", "
				+ secondKey
				+ " "
				+ "and "
				+ thirdKey
				+ " from your secret key and press the validate button.");
		
		// key1.setHint(firstKey);
		// key2.setHint(secondKey);
		// key3.setHint(thirdKey);

		btContinue.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent main = new Intent(KeyActivity.this, MainActivity.class);
				startActivity(main);

			}
		});
	}

	@Override
	public boolean onCreatePanelMenu(int featureId, Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreatePanelMenu(featureId, menu);
	}

	public void onPause(){
		super.onPause();
		finish();
	}

}
