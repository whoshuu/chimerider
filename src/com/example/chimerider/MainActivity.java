package com.example.chimerider;


import com.example.chimerider.information.CContactListActivity;
import com.example.chimerider.information.CUserManager;
import com.example.chimerider.information.UserInformationActivity;
import com.example.chimerider.util.MenuBarView;
import com.example.chimerider.util.MenuBarView.MenuBarViewListener;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends FragmentActivity {
	private static final int CREATE_EDIT_CONTACT_REQUEST = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		

	    MenuBarView mMenuBar = (MenuBarView) findViewById(R.id.contact_list_menu_bar); 
	    Button mNewButton = (Button)findViewById(R.id.contact_list_new_contact);

	    
	    mNewButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				selectUser(CUserManager.getUsers().size());
			}
		});
	    mMenuBar.setClickListener(new MenuBarViewListener() {
			
			@Override
			public void onUserClick() {
				Intent i = new Intent(getBaseContext(), CContactListActivity.class);
				startActivity(i);
				finish();
			}
			
			@Override
			public void onStatsClick() {
				Intent i = new Intent(getBaseContext(), StatsActivity.class);
				startActivity(i);
				finish();
			}
			
			@Override
			public void onMapClick() {
				return;
			}

			
			@Override
			public boolean isUserActive() {
				findViewById(R.id.rlUser).setBackgroundColor(Color.rgb(245, 244, 240));
				((Button)findViewById(R.id.menubar_user)).setPressed(false);
				return true;
			}
			
			@Override
			public boolean isStatsActive() {
				findViewById(R.id.rlStats).setBackgroundColor(Color.rgb(245, 244, 240));
				((Button)findViewById(R.id.menubar_stats)).setPressed(false);
				return true;
			}
			
			@Override
			public boolean isMapActive() {
				findViewById(R.id.rlMap).setBackgroundColor(Color.rgb(255, 255, 255));
				((Button)findViewById(R.id.menubar_map)).setPressed(true);
				return false;
			}
		});
	}

	public void selectUser(int userPosition) {
		Intent i = new Intent(getApplicationContext(), UserInformationActivity.class);
		i.putExtra(UserInformationActivity.CONTACT_OBJECT_INDEX_KEY, userPosition);
		startActivityForResult(i, CREATE_EDIT_CONTACT_REQUEST);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void showContactList(View v) {
		Intent i = new Intent(this, CContactListActivity.class);
		startActivity(i);
	}
	
	public void onStats(View v){
	    Intent i = new Intent(this, StatsActivity.class);
	    startActivity(i);
	}
}
