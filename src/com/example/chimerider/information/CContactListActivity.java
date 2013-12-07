package com.example.chimerider.information;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.chimerider.R;
import com.example.chimerider.UserInformationActivity;
import com.example.chimerider.R.id;
import com.example.chimerider.R.layout;
import com.example.chimerider.information.CUser.Gender;

public class CContactListActivity extends Activity {

	private static final int CREATE_EDIT_CONTACT_REQUEST = 0;
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
				selectUser(CUserManager.getUsers().size());
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
								
				CUser user = CUserManager.getUser(arg0);
				if (user != null) {
					((TextView)v.findViewById(R.id.contacts_list_adaptor_name)).setText(user.name);
					((TextView)v.findViewById(R.id.contacts_list_adaptor_sex)).setText(Gender.values()[user.gender].getDescription());
					if(user.getUserProfileImageBitmapURI() != null) {
						((ImageView)v.findViewById(R.id.ivUserImage)).setImageURI(Uri.parse(user.getUserProfileImageBitmapURI()));
					}
				}
				
				return v;
			}
			
			@Override
			public long getItemId(int arg0) {
				if(CUserManager.getUser(arg0) == null)
					return -1;
				return 0;
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
				selectUser(arg2);				
			}
		});
	}

	public void selectUser(int userPosition) {
		Intent i = new Intent(getApplicationContext(), UserInformationActivity.class);
		i.putExtra(UserInformationActivity.CONTACT_OBJECT_INDEX_KEY, userPosition);
		startActivityForResult(i, CREATE_EDIT_CONTACT_REQUEST);
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) { 
		super.onActivityResult(requestCode, resultCode, data); 
		switch(requestCode) {
		case CREATE_EDIT_CONTACT_REQUEST:
			if(resultCode == RESULT_OK){  
				((BaseAdapter) mContactsList.getAdapter()).notifyDataSetChanged();
			}
			break; 
		}
	}
	
	
}
