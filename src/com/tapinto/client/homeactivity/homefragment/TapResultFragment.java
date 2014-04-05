package com.tapinto.client.homeactivity.homefragment;

import java.util.ArrayList;

import com.tapinto.client.R;
import com.tapinto.client.utility.Backend;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class TapResultFragment extends Fragment {
	
	private String title;
	private ArrayList<View> contentPanels = new ArrayList<View>();
	private ScrollView sv;
	
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_tap_result, container, false);
		sv = (ScrollView) rootView.findViewById(R.id.content_scroll_view);
		
		return rootView;
	}
	
	public void initiate(String tagMessage) {
		
		sv.scrollTo(0, 0);
		title = Backend.getTitle(tagMessage);
		contentPanels = Backend.getContent(getActivity(), tagMessage);
		
		TextView titleView = (TextView)getActivity().findViewById(R.id.title_view);
		titleView.setText(title);
		
		LinearLayout holder = (LinearLayout) getActivity().findViewById(R.id.scroll_view_holder);
		holder.removeAllViews();
		for (int i = 0; i < contentPanels.size(); i ++) {
			holder.addView(contentPanels.get(i));
		}
		
		LinearLayout titleWrapper = (LinearLayout) getActivity().findViewById(R.id.title_wrapper);
		titleWrapper.setVisibility(LinearLayout.VISIBLE);
	}

}
