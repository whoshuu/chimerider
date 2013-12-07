package com.example.chimerider.information;

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
		public void onMapClick();
		public void onStatsClick();
	}
	
	Button mMap;
	Button mStats;
	
	void initialize(Context context) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = inflater.inflate(R.layout.system_menu_bar, this, true);
		
		mMap = (Button)v.findViewById(R.id.menubar_map);
		mStats = (Button)v.findViewById(R.id.menubar_stats);
	}
	
	public void setClickListener(final MenuBarViewListener listener) {
		mMap.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				listener.onMapClick();
			}
		});
		
		mStats.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				listener.onStatsClick();
			}
		});
	}

}
