package com.tapinto.client.homeactivity;

import java.util.ArrayList;

import com.tapinto.client.R;
import com.tapinto.client.R.layout;
import com.tapinto.client.R.menu;
import com.tapinto.client.homeactivity.homefragment.HomeFragment;
import com.tapinto.client.homeactivity.homefragment.MapFragment;
import com.tapinto.client.homeactivity.homefragment.OptionsTabPagerAdapter;
import com.tapinto.client.homeactivity.homefragment.ProgramFragment;
import com.tapinto.client.homeactivity.homefragment.TapFragment;
import com.tapinto.client.utility.NFCAbstractReadActivity;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.view.Menu;

public class HomeActivity extends NFCAbstractReadActivity implements ActionBar.TabListener {
	
	ArrayList<Fragment> optionFragments = new ArrayList<Fragment> ();
	private ViewPager optionsViewPager;
	private ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		FragmentManager fm = getSupportFragmentManager();
		fm.beginTransaction().replace(R.id.content, new HomeFragment()).commit();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

	@Override
	protected void onTagRead(String tagMessage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction arg1) {
		if (optionsViewPager != null)
			optionsViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
	}
	
	public void setViewPager(ViewPager vp) {
		optionsViewPager = vp;
	}

}
