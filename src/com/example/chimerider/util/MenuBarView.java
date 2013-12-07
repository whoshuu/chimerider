package com.example.chimerider.util;

import com.example.chimerider.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MenuBarView extends LinearLayout {
	
	
	public MenuBarView(Context context) {
		super(context);
		initialize(context);
	}

	public MenuBarView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialize(context);
	}
	
	public MenuBarView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initialize(context);
	}

	public interface MenuBarViewListener {
		// Click listeners 
		public abstract void onMapClick();
		public abstract void onStatsClick();
		public abstract void onUserClick();
		
		// Enable Configuration
		public abstract boolean isMapActive();
		public abstract boolean isStatsActive();
		public abstract boolean isUserActive();
	}
	
	Button mMap;
	Button mStats;
	Button mUsers;
	
	void initialize(Context context) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = inflater.inflate(R.layout.system_menu_bar, this, true);
		
		mMap = (Button)v.findViewById(R.id.menubar_map);
		mStats = (Button)v.findViewById(R.id.menubar_stats);
		mUsers = (Button)v.findViewById(R.id.menubar_users);
	}
	
	public void setClickListener(final MenuBarViewListener listener) {
		mMap.setEnabled(listener.isMapActive());
		mMap.setClickable(listener.isMapActive());
		mMap.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				listener.onMapClick();
			}
		});
		
		mStats.setEnabled(listener.isStatsActive());
		mStats.setClickable(listener.isStatsActive());
		mStats.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				listener.onStatsClick();
			}
		});
		
		mUsers.setEnabled(listener.isUserActive());
		mUsers.setClickable(listener.isUserActive());
		mUsers.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				listener.onUserClick();
			}
		});
	}

}
