package com.example.chimerider.information;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "CUser")
public class CUser extends Model implements Serializable {

	public enum Gender {

		notavailable {

			@Override
			public String getDescription() {
				return "Not Available";
			}

			@Override
			public int getPosition() {
				return 0;
			}
		},
		femenine {
			@Override
			public String getDescription() {
				return "Female";
			}

			@Override
			public int getPosition() {
				return 1;
			}
		},
		masculine {
			@Override
			public String getDescription() {
				return "Male";
			}

			@Override
			public int getPosition() {
				return 2;
			}
		};		
		public abstract String getDescription();
		public abstract int getPosition();
	};

	@Column(name = "UserProfileImageBitmapURI")
	public String userProfileImageBitmapURI;

	@Column(name = "Name")
	public String name;

	@Column(name = "UserId")
	public int userId;

	@Column(name = "Gender")
	public Gender gender = Gender.notavailable;

	@Column(name = "MFields")
	public List<CField> mFields = new ArrayList<CField>();


	public List<CField> getmFields() {
		return mFields;
	}

	public void setmFields(List<CField> mFields) {
		this.mFields = mFields;
	}

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


	public int getGender() {
		return gender.getPosition();
	}

	@SuppressWarnings("static-access")
	public void setGender(int _gender) {
		this.gender = gender.values()[_gender];
	}

	public CField cerateNewField() {
		CField field = new CField();
		mFields.add(field);
		return field;
	}
}
