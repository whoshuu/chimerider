package com.example.chimerider.information;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.chimerider.R;

public class EditField extends LinearLayout {

	public interface EditFieldCallback {
		public abstract void onSave(final View v, final String field, final String value);
	}
	
	View mMasterView;
	EditText mLabelView;
	EditText mValueView;
	
	public EditField(Context context, final EditFieldCallback callback, final CField fields) {
		super(context);
		
		LayoutInflater inflater = LayoutInflater.from(context);
		mMasterView = inflater.inflate(R.layout.add_new_field, this);
		
		mLabelView = (EditText)findViewById(R.id.new_field_label);
		mValueView = (EditText)findViewById(R.id.new_field_value);
		
		if(fields != null) {
			mLabelView.setText(fields.mName);
			mLabelView.setText(fields.mValue);
		}
		
		Button b = (Button)findViewById(R.id.save_new_field);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				callback.onSave(mMasterView, mLabelView.getText().toString(), mValueView.getText().toString());
			}
		});
	}	

}