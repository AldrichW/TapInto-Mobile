package com.tapinto.client.homeactivity.homefragment;

import java.util.ArrayList;

import com.tapinto.client.R;
import com.tapinto.client.homeactivity.HomeActivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost.OnTabChangeListener;

public class HomeFragment extends Fragment {
	
	FragmentTabHost fth;
	ArrayList<Fragment> optionFragments = new ArrayList<Fragment> ();
	private ViewPager optionsViewPager;
	private ActionBar actionBar;
	private HomeActivity activity;
	
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_home, container, false);
		
//		fth = (FragmentTabHost) rootView.findViewById(R.id.tab_options);
//		fth.setup(getActivity(), getActivity().getSupportFragmentManager(), R.id.options_tab_content);
//		fth.addTab(fth.newTabSpec("tap").setIndicator("Tap"), TapFragment.class, null);
//		fth.addTab(fth.newTabSpec("program").setIndicator("Program"), ProgramFragment.class, null);
//		fth.addTab(fth.newTabSpec("map").setIndicator("Map"), MapFragment.class, null);
//		
////		fth.setCurrentTab(index);
//		fth.setOnTabChangedListener(new OnTabChangeListener() {
//			@Override
//			public void onTabChanged(String arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
		activity = (HomeActivity) getActivity();
		
		optionFragments.add(new TapFragment());
		optionFragments.add(new ProgramFragment());
		optionFragments.add(new MapFragment());
		
		optionsViewPager = (ViewPager) rootView.findViewById(R.id.tab_content_viewpager);
		actionBar = activity.getSupportActionBar();
		OptionsTabPagerAdapter optionsTabPagerAdapter = new OptionsTabPagerAdapter(activity.getSupportFragmentManager());
		optionsTabPagerAdapter.initiate(optionFragments);
		optionsViewPager.setAdapter(optionsTabPagerAdapter);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.addTab(actionBar.newTab().setText("Tap").setTabListener(activity));
		actionBar.addTab(actionBar.newTab().setText("Program").setTabListener(activity));
		actionBar.addTab(actionBar.newTab().setText("Map").setTabListener(activity));
		optionsViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}
			@Override
			public void onPageSelected(int position) {
				actionBar.setSelectedNavigationItem(position);
			}
		});
		activity.setViewPager(optionsViewPager);
		
		return rootView;
		
	}

}
