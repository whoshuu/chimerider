package com.example.chimerider.util;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class ModifiableLinearLayout extends LinearLayout {

	public int mId;
	
	public ModifiableLinearLayout(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
	}

	public ModifiableLinearLayout(Context context) {
		super(context);
	}
	
	public ModifiableLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
}
