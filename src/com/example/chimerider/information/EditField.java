package com.example.chimerider.information;

import com.example.chimerider.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class EditField extends LinearLayout {

	public interface EditFieldCallback {
		public abstract void onSave(final View v, final String field, final String value);
		public abstract void onClose(View v);
	}
	
	View mMasterView;
	View mLayoutView;
	EditText mLabelView;
	EditText mValueView;
	
	public EditField(Context context, final EditFieldCallback callback, final CField fields) {
		super(context);
		
		LayoutInflater inflater = LayoutInflater.from(context);
		mLayoutView = this;
		mMasterView = inflater.inflate(R.layout.add_new_field, this);
		
		mLabelView = (EditText)findViewById(R.id.new_field_label);
		mValueView = (EditText)findViewById(R.id.new_field_value);
		
		if(fields != null) {
			mLabelView.setText(fields.mName);
			mValueView.setText(fields.mValue);
		}
		
		Button b = (Button)findViewById(R.id.save_new_field);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				callback.onSave(mLayoutView, mLabelView.getText().toString(), mValueView.getText().toString());
			}
		});
		
		((Button)(findViewById(R.id.close_add_new_field))).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				callback.onClose(mLayoutView);
			}
		});
		
		(findViewById(R.id.add_new_field_main)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				callback.onClose(mLayoutView);
			}
		});
	}	

}
