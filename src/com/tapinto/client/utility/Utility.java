package com.tapinto.client.utility;

import com.tapinto.client.R;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

public class Utility {
	
public static ActionBar initiateActionBar (ActionBarActivity activity, String title) {
		
		ActionBar actionBar = activity.getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeButtonEnabled(true);
		actionBar.setTitle(title);
//		actionBar.setSubtitle("The Cannon");
		actionBar.setIcon(R.drawable.logo);
		
		return actionBar;
	}

}
