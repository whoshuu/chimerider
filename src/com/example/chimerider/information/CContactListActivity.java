package com.example.chimerider.information;

import com.example.chimerider.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class CContactListActivity extends Activity {

	ListView mContactsList;
	Button mNewButton;
	
	public CContactListActivity() {
						
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.contact_list);
	    
	    mContactsList = (ListView)findViewById(R.id.contact_list_contacts);
	    mNewButton = (Button)findViewById(R.id.contact_list_new_contact);
	    
	    mNewButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				CUser newUser = new CUser();
				CUserManager.mUsers.add(newUser);
				selectUser(newUser);	
			}
		});
	    
	    mContactsList.setAdapter(new BaseAdapter() {
			
			@Override
			public View getView(int arg0, View arg1, ViewGroup arg2) {
				
				if(CUserManager.getUser(arg0) == null)
					return null;
				
				final View v;
				if(arg1 == null) {
					LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					v = inflater.inflate(R.layout.contacts_list_adaptor, arg2, false);
				} else {
					v = arg1;
				}
								
				((TextView)v.findViewById(R.id.contacts_list_adaptor_name)).setText(CUserManager.getUser(arg0).mName);
				((TextView)v.findViewById(R.id.contacts_list_adaptor_sex)).setText(CUserManager.getUser(arg0).mGender.getDescription());
				
				return null;
			}
			
			@Override
			public long getItemId(int arg0) {
				if(CUserManager.getUser(arg0) == null)
					return -1;
				
				return CUserManager.getUser(arg0).mId;
			}
			
			@Override
			public CUser getItem(int arg0) {
				return CUserManager.getUser(arg0);
			}
			
			@Override
			public int getCount() {
				return CUserManager.mUsers.size();
			}
		});
	    
	    mContactsList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				selectUser(CUserManager.getUser(arg2));				
			}
		});
	}

	public void selectUser(CUser user) {
		if(user == null)
			return;
		
		// TODO Rolan call the new layout activity here
	}
}
