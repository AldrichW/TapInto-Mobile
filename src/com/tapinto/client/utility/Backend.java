package com.tapinto.client.utility;

import java.util.ArrayList;

import com.tapinto.client.R;

import android.app.Activity;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Backend {
	
	public static String getTitle(String tagMessage) {
		
		if (tagMessage.equals("hello world!")) {
			return "TapInto";
		}
		
		return "Testing";
		
	}
	
	public static ArrayList<View> getContent(Activity a, String tagMessage) {
		ArrayList<View> contentPanels = new ArrayList<View>();
		
		TextView titleView = new TextView(a);
		titleView.setText(getTitle(tagMessage));
		titleView.setGravity(Gravity.CENTER);
		titleView.setPadding(0, 0, 0, Utility.getPixelsFromDP(a.getApplicationContext(), 5));
		titleView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
		titleView.setTypeface(Typeface.DEFAULT_BOLD);
		contentPanels.add(titleView);
		
		ImageView iv = new ImageView(a);
		iv.setImageResource(R.drawable.logo);
		contentPanels.add(iv);
		
		TextView tv = new TextView(a);
		tv.setText("TapInto is a University of Toronto startup aimed at improving the flow of information to mobile devices through intuitive taps with your smartphone against a tag");
		contentPanels.add(tv);
		
		return contentPanels;
	}

}
