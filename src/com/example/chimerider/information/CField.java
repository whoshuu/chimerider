package com.example.chimerider.information;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "CField")
public class CField extends Model {
	
	@Column(name = "MName")
	public String mName;
	
	@Column(name = "MValue")
	public String mValue;

	@Column(name = "CUser")
	public CUser cuser;
	
	public CField() {
		super();
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmValue() {
		return mValue;
	}

	public void setmValue(String mValue) {
		this.mValue = mValue;
	}

	public CUser getCuser() {
		return cuser;
	}

	public void setCuser(CUser cuser) {
		this.cuser = cuser;
	}
	
	
}
