package com.example.chimerider.information;

import com.example.chimerider.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MenuBarView extends LinearLayout {
	
	// TODO Andres add the code here to go to the selected points?
	Button mMap;
	Button mStats;
	
	public MenuBarView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialize(context);
	}
	
	void initialize(Context context) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = inflater.inflate(R.layout.system_menu_bar, this, false);
		
		mMap = (Button)v.findViewById(R.id.menubar_map);
		mStats = (Button)v.findViewById(R.id.menubar_stats);
	}

}
