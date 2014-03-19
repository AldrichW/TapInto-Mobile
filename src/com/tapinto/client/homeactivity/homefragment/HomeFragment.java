package com.tapinto.client.homeactivity.homefragment;

import com.tapinto.client.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {
	
	FragmentTabHost fth;
	
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_home, container, false);
		
		fth = (FragmentTabHost) rootView.findViewById(R.id.tab_options);
		fth.setup(getActivity(), getActivity().getSupportFragmentManager(), R.id.options_tab_content);
		fth.addTab(fth.newTabSpec("tap").setIndicator("Tap"), TapFragment.class, null);
		fth.addTab(fth.newTabSpec("program").setIndicator("Program"), ProgramFragment.class, null);
		fth.addTab(fth.newTabSpec("map").setIndicator("Map"), MapFragment.class, null);
		
		return rootView;
		
	}

}
