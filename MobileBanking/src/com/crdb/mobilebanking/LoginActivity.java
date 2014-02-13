package com.crdb.mobilebanking;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends ActionBarActivity {

	TextView terms;
	Button signIn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		signIn = (Button) findViewById(R.id.btSignIn);
		terms = (TextView) findViewById(R.id.tvTC);

		getSupportActionBar().setBackgroundDrawable(
				getResources().getDrawable(R.color.crdb_green));

		signIn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent key = new Intent(LoginActivity.this, KeyActivity.class);
				startActivity(key);

			}
		});

		ConnectivityManager conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		if (conMgr.getActiveNetworkInfo() == null) {

			// No connectivity & Feed file doesn't exist: Show alert to exit
			// & check for connectivity
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage(
					"Unable to reach server, please check your connectivity, or use *150*03# to get all banking services without data connection.")
					.setTitle("CRDB Mobile Banking")
					.setCancelable(false)
					.setPositiveButton("Exit",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int id) {
									finish();
								}
							});

			AlertDialog alert = builder.create();
			alert.show();
		}
	}

	@Override
	public boolean onCreatePanelMenu(int featureId, Menu menu) {
		
		getSupportActionBar();
		// TODO Auto-generated method stub
		return super.onCreatePanelMenu(featureId, menu);
	}
	
	public void onPause(){
		super.onPause();
		finish();
	}

}
