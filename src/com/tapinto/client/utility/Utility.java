package com.tapinto.client.utility;

import com.tapinto.client.R;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.TypedValue;

public class Utility {
	
	public static ActionBar initiateActionBar (ActionBarActivity activity, String title) {
		
		ActionBar actionBar = activity.getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeButtonEnabled(true);
		actionBar.setTitle(title);
		actionBar.setIcon(R.drawable.logo);
		
		return actionBar;
	}
	
	public static int getPixelsFromDP (Context context, int dpValue) {
		Resources r = context.getResources();
		int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, r.getDisplayMetrics());
		return px;
	}

}
