package com.example.chimerider.information;

import java.text.DateFormat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
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

import com.example.chimerider.MainActivity;
import com.example.chimerider.R;
import com.example.chimerider.StatsActivity;
import com.example.chimerider.util.MenuBarView;
import com.example.chimerider.util.MenuBarView.MenuBarViewListener;

public class CContactListActivity extends Activity {

	private static final int CREATE_EDIT_CONTACT_REQUEST = 0;
	ListView mContactsList;
	Button mNewButton;
	MenuBarView mMenuBar;
	TextView tvContactListTitle;
	
	public CContactListActivity() {
						
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.contact_list);
	    
	    
	    mContactsList = (ListView)findViewById(R.id.contact_list_contacts);
	    mNewButton = (Button)findViewById(R.id.contact_list_new_contact);
	    mMenuBar = (MenuBarView)findViewById(R.id.contact_list_menu_bar); 
	    
	    tvContactListTitle = (TextView)findViewById(R.id.tvContactListTitle);
	    tvContactListTitle.setTextColor(Color.parseColor("#CCCCCC"));
	    
	    mMenuBar.setClickListener(new MenuBarViewListener() {
			
			@Override
			public void onUserClick() {
				return;
			}
			
			@Override
			public void onStatsClick() {
				Intent i = new Intent(getBaseContext(), StatsActivity.class);
				startActivity(i);
				finish();
			}
			
			@Override
			public void onMapClick() {
				Intent i = new Intent(getBaseContext(), MainActivity.class);
				startActivity(i);
				finish();
			}
			
			@Override
			public boolean isUserActive() {
				findViewById(R.id.rlUser).setBackgroundColor(Color.rgb(255, 255, 255));
				((Button)findViewById(R.id.menubar_user)).setPressed(true);
				return false;
			}
			
			@Override
			public boolean isStatsActive() {
				findViewById(R.id.rlStats).setBackgroundColor(Color.rgb(245, 244, 240));
				((Button)findViewById(R.id.menubar_stats)).setPressed(false);
				return true;
			}
			
			@Override
			public boolean isMapActive() {
				findViewById(R.id.rlMap).setBackgroundColor(Color.rgb(245, 244, 240));
				((Button)findViewById(R.id.menubar_map)).setPressed(false);
				return true;
			}
		});
	    
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
					TextView contactListName = ((TextView)v.findViewById(R.id.contacts_list_adaptor_name));
					contactListName.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
					contactListName.setText(user.name);
					contactListName.setTextColor(Color.parseColor("#333333"));
					
					if (user.createdDate != null) {
						DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getApplicationContext());
						TextView dateCreated = ((TextView)v.findViewById(R.id.contacts_list_adaptor_date_created));
						dateCreated.setText(dateFormat.format(user.createdDate));
						dateCreated.setTextColor(Color.parseColor("#FF6600"));
					}
					
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
