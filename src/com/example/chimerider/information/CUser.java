package com.example.chimerider.information;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "CUser")
public class CUser extends Model implements Serializable {

	@Column(name = "UserProfileImageBitmapURI")
	public String userProfileImageBitmapURI;
	
	@Column(name = "Name")
	public String name;
	
	@Column(name = "UserId")
	public int userId;

	@Column(name = "Gender")
	public String gender;
	
	@Column(name = "MFields")
	public List<CField> mFields = new ArrayList<CField>();

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5615313632792984879L;

	public CUser() {
		super();
	}

	public String getUserProfileImageBitmapURI() {
		return userProfileImageBitmapURI;
	}

	public void setUserProfileImageBitmapURI(String userProfileImageBitmapURI) {
		this.userProfileImageBitmapURI = userProfileImageBitmapURI;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public CField cerateNewField() {
		CField field = new CField();
		mFields.add(field);
		return field;
	}
	
	//	public enum gender {
	//	femenine {
	//		@Override
	//		public String getDescription() {
	//			return "femenine";
	//		}
	//	},
	//	masculine {
	//		@Override
	//		public String getDescription() {
	//			return "masculine";
	//		}
	//	};		
	//	public abstract String getDescription();
	//};


}
