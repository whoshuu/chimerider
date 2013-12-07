package com.example.chimerider.information;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.chimerider.R;

public class CContactListActivity extends Activity {

	private static final int EDIT_EXISTING_CONTACT_REQUEST = 1;
	private static final int CREATE_NEW_CONTACT_REQUEST = 0;
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
				CUserManager.getUsers().add(newUser);
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
				return CUserManager.getUsers().size();
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
	
	public void createNewContact(View v) {
		Intent i = new Intent();
		startActivityForResult(i, CREATE_NEW_CONTACT_REQUEST);
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) { 
		super.onActivityResult(requestCode, resultCode, data); 
		switch(requestCode) {
		case CREATE_NEW_CONTACT_REQUEST:
			if(resultCode == RESULT_OK){  
				((BaseAdapter) mContactsList.getAdapter()).notifyDataSetChanged();
			}
			break; 
		case EDIT_EXISTING_CONTACT_REQUEST:
			if(resultCode == RESULT_OK){  
				((BaseAdapter) mContactsList.getAdapter()).notifyDataSetChanged();
			}
			break;
		}
	}
	
	
}
