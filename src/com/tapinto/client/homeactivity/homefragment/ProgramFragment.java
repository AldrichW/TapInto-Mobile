package com.tapinto.client.homeactivity.homefragment;

import com.tapinto.client.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ProgramFragment extends Fragment {
	
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_program, container, false);
		
		return rootView;
		
	}

}
