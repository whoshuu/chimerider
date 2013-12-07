package com.example.chimerider.information;

import java.util.ArrayList;
import java.util.List;

import com.activeandroid.query.Select;

public class CUserManager {
	private static List<CUser> mUsers = new ArrayList<CUser>();
	
	public static CUser getUser(int idx) {
		if(mUsers == null || mUsers.size() <= 0) {
			return null;
		}
		
		return mUsers.get(idx);
	}
	
	public static List<CUser> getUsers() {
		if (mUsers.size() == 0) {
			mUsers = new Select().from(CUser.class).execute();
		}
		
		return mUsers;
	}
}
