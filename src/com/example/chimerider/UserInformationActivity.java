package com.example.chimerider;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.chimerider.information.CContactListActivity;
import com.example.chimerider.information.CField;
import com.example.chimerider.information.CUser;
import com.example.chimerider.information.CUserManager;
import com.example.chimerider.information.EditField;
import com.example.chimerider.information.EditField.EditFieldCallback;
import com.example.chimerider.util.ImageUtility;
import com.example.chimerider.util.ModifiableLinearLayout;

public class UserInformationActivity extends Activity {

	public static final String CONTACT_OBJECT_INDEX_KEY = "CONTACT_OBJECT_INDEX_KEY";
	private ImageView ivProfileImage;
	private CUser user;
	private EditText etName;
	private Spinner spGender;
	
	private ListView mDynamicFields;
	
	protected ViewGroup mMainLayout;
	private Activity mCurrent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_information);
		ivProfileImage = (ImageView) findViewById(R.id.ivProfilePicture);
		etName = (EditText) findViewById(R.id.etUserName);
		spGender = (Spinner) findViewById(R.id.spGender);
		
		int positionToWork = getIntent().getIntExtra(CONTACT_OBJECT_INDEX_KEY, 0);
		
		if (positionToWork >= CUserManager.getUsers().size()) {
			user = new CUser();
		} else {
			user =  CUserManager.getUsers().get(positionToWork);
		}
		
		etName.setText(user.name);
		spGender.setSelection(user.getGender());
		if(user.getUserProfileImageBitmapURI() != null) {
			ivProfileImage.setImageURI(Uri.parse(user.getUserProfileImageBitmapURI())); 
		}
		
		mCurrent = this;
		mDynamicFields = (ListView) findViewById(R.id.user_information_dynamic_fields_view);
		mMainLayout = (ViewGroup)findViewById(R.id.activity_user_information).getParent();
		mDynamicFields.setAdapter(new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				if(user == null)
					return null;
				
				final ModifiableLinearLayout v;
				
				if(position >= user.getmFields().size()) {
					LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					v = (ModifiableLinearLayout)inflater.inflate(R.layout.create_new_attribute_button, parent, false);
					v.mId = R.layout.create_new_attribute_button;
				} else {
					if(user.getmFields().get(position) == null)
						return null;
					
					if(convertView == null || ((ModifiableLinearLayout)convertView).mId != R.layout.contacts_list_adaptor) {
						LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
						v = (ModifiableLinearLayout)inflater.inflate(R.layout.dynamic_field_adapter, parent, false);
						v.mId = R.layout.dynamic_field_adapter;
					} else {
						v = (ModifiableLinearLayout)convertView;
					}
					
					// setup elements
					((TextView) v.findViewById(R.id.dynamic_field_label)).setText(user.getmFields().get(position).mName);
					((TextView) v.findViewById(R.id.dynamic_field_element)).setText(user.getmFields().get(position).mValue);
				}
				return v;
			}
			
			@Override
			public long getItemId(int position) {
				if(position >= user.getmFields().size()) 
					return -1;
				
				return user.getmFields().get(position).hashCode();
			}
			
			@Override
			public CField getItem(int position) {
				if(position >= user.getmFields().size()) 
					return null;
				
				return user.getmFields().get(position);
			}
			
			@Override
			public int getCount() {
				return user.getmFields().size() + 1;
			}
		});
		
		mDynamicFields.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				CField field = (CField)mDynamicFields.getAdapter().getItem(arg2);
				final boolean addField;
				if(field == null) {
					field = new CField();
					addField = true;
				} else {
					addField = false;
				}
				final CField finalF = field;
				EditField ef = new EditField(mCurrent, new EditFieldCallback() {
					
					@Override
					public void onSave(final View v, final String fieldName, final String fieldValue) {
						mDynamicFields.post(new Runnable() {
							
							@Override
							public void run() {
								mMainLayout.removeView(v);
								if(fieldName == null || fieldName == "" || fieldValue == null || fieldValue == "") {
									return;
								}
								finalF.mName = fieldName;
								finalF.mValue = fieldValue;
								finalF.cuser = user;
								
								if(addField) {
									//save it into a temporary field
									user.getmFields().add(finalF);
								}
								
								BaseAdapter a =(BaseAdapter)mDynamicFields.getAdapter();
								a.notifyDataSetChanged();
							}
						});
					}

					@Override
					public void onClose(View v) {
						mMainLayout.removeView(v);
					}
				}, finalF);
				mMainLayout.addView(ef);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_information, menu);
		return true;
	}
	
	public void changePicture(View v) {
		AlertDialog diaBox = AskChangePictureOption();
		diaBox.show();
	}
	
	private AlertDialog AskChangePictureOption() {
	    AlertDialog pictureSourceDialog = new AlertDialog.Builder(this)
	        //set message, title, and icon
	        .setTitle("Picture Source") 
	        .setMessage("Where is your picture?") 
	        .setPositiveButton("Camera", new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog, int whichButton) {
	        		Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	        		startActivityForResult(takePicture, 0);
	                dialog.dismiss();
	            }
	        })
	        .setNeutralButton("Gallery", new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog, int which) {
	            	Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
	            	startActivityForResult(pickPhoto , 1);
	                dialog.dismiss();
	            }
	        })
	        .setCancelable(true)
	        .create();
	        return pictureSourceDialog;
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) { 
		super.onActivityResult(requestCode, resultCode, imageReturnedIntent); 
		switch(requestCode) {
		case 0:
			if(resultCode == RESULT_OK){  
				Bundle extras = imageReturnedIntent.getExtras();
				Bitmap bitmap = (Bitmap) extras.get("data");
				ivProfileImage.setImageBitmap(bitmap);
				user.setUserProfileImageBitmapURI(ImageUtility.getRealPathFromURI(ImageUtility.getImageUri(this, bitmap), this));
			}

			break; 
		case 1:
			if(resultCode == RESULT_OK){  
				Uri selectedImage = imageReturnedIntent.getData();
				ivProfileImage.setImageURI(selectedImage);
				user.setUserProfileImageBitmapURI(ImageUtility.getRealPathFromURI(selectedImage, this));
			}
			break;
		}
	}

	public void saveData(View v) {
		user.name = etName.getText().toString();
		user.gender = spGender.getSelectedItemPosition();
		user.save();
		for (int i = 0; i < user.getmFields().size(); i++) {
			CField field = user.getmFields().get(i);
			field.save();
		}
		CUserManager.refreshUserList();
		Intent result = new Intent(this, CContactListActivity.class);
		setResult(RESULT_OK, result);
		finish();
	}
}
