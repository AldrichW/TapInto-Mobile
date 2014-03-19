package com.tapinto.client;

import com.tapinto.client.homeactivity.HomeActivity;
import com.tapinto.client.utility.NFCAbstractReadActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends NFCAbstractReadActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Intent intent = new Intent(this, HomeActivity.class);
		startActivity(intent);
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onTagRead(String tagMessage) {
		// just a test to show what happens when user taps the phone against an NFC tag
		Toast.makeText(getApplicationContext(), tagMessage, Toast.LENGTH_SHORT).show();
	}

}
