package com.example.chimerider.information;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "CUser")
public class CUser extends Model implements Serializable {

	public String getUserProfileImageBitmapURI() {
		return userProfileImageBitmapURI;
	}

	public void setUserProfileImageBitmapURI(String userProfileImageBitmapURI) {
		this.userProfileImageBitmapURI = userProfileImageBitmapURI;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -5615313632792984879L;

//	@Table(name = "CFielsds")
	public class CFielsd {
		
		public CFielsd() {}
		
		@Column(name = "MName")
		public String mName;
		
		@Column(name = "MValue")
		public String mValue;
	}
	
	public enum gender {
		femenine {
			@Override
			public String getDescription() {
				return "femenine";
			}
		},
		masculine {
			@Override
			public String getDescription() {
				return "masculine";
			}
		};		
		public abstract String getDescription();
	};
	
	@Column(name = "UserProfileImageBitmapURI")
	public String userProfileImageBitmapURI;
	
	@Column(name = "MName")
	public String mName;
	
	@Column(name = "MId")
	public int mId;
	
	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public gender getmGender() {
		return mGender;
	}

	public void setmGender(gender mGender) {
		this.mGender = mGender;
	}

	public List<CFielsd> getmFields() {
		return mFields;
	}

	public void setmFields(List<CFielsd> mFields) {
		this.mFields = mFields;
	}
	
	public CFielsd cerateNewField() {
		CFielsd field = new CFielsd();
		mFields.add(field);
		return field;
	}

	@Column(name = "MGender")
	public gender mGender;
	
	@Column(name = "MFields")
	public List<CFielsd> mFields = new ArrayList<CFielsd>();
	
}
