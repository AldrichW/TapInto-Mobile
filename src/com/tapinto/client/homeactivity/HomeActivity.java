package com.tapinto.client.homeactivity;

import java.util.ArrayList;

import com.tapinto.client.R;
import com.tapinto.client.R.layout;
import com.tapinto.client.R.menu;
import com.tapinto.client.homeactivity.homefragment.HomeFragment;
import com.tapinto.client.homeactivity.homefragment.OptionsTabPagerAdapter;
import com.tapinto.client.homeactivity.homefragment.TapFragment;
import com.tapinto.client.utility.NFCAbstractReadActivity;
import com.tapinto.client.utility.Utility;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class HomeActivity extends NFCAbstractReadActivity {

	public ViewPager optionsViewPager;
	private DrawerLayout leftDrawer;
	private ActionBarDrawerToggle drawerToggle;
	private Fragment currentFrag;
	private boolean canScan = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(null);

		setContentView(R.layout.activity_home);

		leftDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		Utility.initiateActionBar(this, "Tap");
		drawerToggle = new ActionBarDrawerToggle(this, leftDrawer,
				R.drawable.ic_navigation_drawer, R.string.drawer_open,
				R.string.drawer_close);
		leftDrawer.setDrawerListener(drawerToggle);

		HomeFragment hf = new HomeFragment();
		FragmentManager fm = getSupportFragmentManager();
		fm.beginTransaction().replace(R.id.content, hf)
				.commit();
		currentFrag = hf;

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
		Toast.makeText(getApplicationContext(), tagMessage, Toast.LENGTH_SHORT).show();
		if (canScan) {
			((HomeFragment)currentFrag).onTagRead(tagMessage);
		}
	}

	public void menuButtonClicked() {
		if (leftDrawer.isDrawerOpen(Gravity.LEFT)) {
			leftDrawer.closeDrawer(Gravity.LEFT);
		} else {
			leftDrawer.openDrawer(Gravity.LEFT);
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_MENU) {
			menuButtonClicked();
			return true;
		}

		// let the system handle all other key events
		return super.onKeyDown(keyCode, event);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		drawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		drawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (drawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		switch (item.getItemId()) {
		default:
			break;
		}
		return true;
	}

}
