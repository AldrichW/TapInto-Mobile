package com.tapinto.client.homeactivity.homefragment;

import java.util.ArrayList;

import com.tapinto.client.R;
import com.tapinto.client.homeactivity.HomeActivity;

import android.app.Activity;
import android.content.Context;
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
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;

public class HomeFragment extends Fragment {
	
	private TabHost fth;
	private ArrayList<Fragment> optionFragments = new ArrayList<Fragment> ();
	private ViewPager optionsViewPager;
	
	final private static int TAB_TAP = 0;
	final private static int TAB_TAP_RESULT = 1;
	
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_home, container, false);
		
		fth = (TabHost) rootView.findViewById(R.id.tab_options);
		fth.setup();
		addTab(getActivity(), fth, fth.newTabSpec("tap").setIndicator("Tap"));
		addTab(getActivity(), fth, fth.newTabSpec("tap_result").setIndicator("Content"));
		
		fth.setOnTabChangedListener(new OnTabChangeListener() {
			@Override
			public void onTabChanged(String arg0) {
				optionsViewPager.setCurrentItem(fth.getCurrentTab());
			}
		});
		
		optionFragments.add(new TapFragment());
		optionFragments.add(new TapResultFragment());
//		
		optionsViewPager = (ViewPager) rootView.findViewById(R.id.tab_content_viewpager);
		OptionsTabPagerAdapter optionsTabPagerAdapter = new OptionsTabPagerAdapter(getActivity().getSupportFragmentManager());
		optionsTabPagerAdapter.initiate(optionFragments);
		optionsViewPager.setAdapter(optionsTabPagerAdapter);
		optionsViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}
			@Override
			public void onPageSelected(int position) {
				fth.setCurrentTab(position);
			}
		});
		
		return rootView;
		
	}
	
	public void onTagRead(String tagMessage) {
		if (fth.getCurrentTab() == TAB_TAP) {
			((TapResultFragment)optionFragments.get(TAB_TAP_RESULT)).initiate(tagMessage);
			fth.setCurrentTab(TAB_TAP_RESULT);
			optionsViewPager.setCurrentItem(TAB_TAP_RESULT);
		}
	}
	
	private void addTab(Activity activity, TabHost tabHost, TabHost.TabSpec tabSpec) {
		TabFactory tf = this.new TabFactory(activity);
		tabSpec.setContent(tf);
		tabHost.addTab(tabSpec);
	}
	
	class TabFactory implements TabContentFactory {
		private final Context context;
		public TabFactory (Context _context) {
			context = _context;
		}
		@Override
		public View createTabContent(String tag) {
			View v = new View(context);
			v.setMinimumHeight(0);
			v.setMinimumWidth(0);
			return v;
		}
	}

}
