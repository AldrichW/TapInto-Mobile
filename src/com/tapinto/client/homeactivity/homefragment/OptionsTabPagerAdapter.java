package com.tapinto.client.homeactivity.homefragment;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class OptionsTabPagerAdapter extends FragmentPagerAdapter {
	
	ArrayList<Fragment> fragments;

	public OptionsTabPagerAdapter(FragmentManager fm) {
		super(fm);
	}
	
	public void initiate(ArrayList<Fragment> _fragments) {
		fragments = (ArrayList<Fragment>) _fragments.clone();
	}
	
	public Fragment getItem(int index) {
		return fragments.get(index);
	}

	@Override
	public int getCount() {
		return fragments.size();
	}

}
