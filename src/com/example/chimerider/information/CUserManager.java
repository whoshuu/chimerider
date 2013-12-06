package com.example.chimerider.information;

import java.util.ArrayList;
import java.util.List;

public class CUserManager {
	public static List<CUser> mUsers = new ArrayList<CUser>();
	
	public static CUser getUser(int idx) {
		if(mUsers == null || mUsers.size() <= 0) {
			return null;
		}
		
		return mUsers.get(idx);
	}
	
	// TODO Rolan populate the array from the DB
}
