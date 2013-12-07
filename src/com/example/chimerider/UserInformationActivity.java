package com.example.chimerider;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.chimerider.information.CContactListActivity;
import com.example.chimerider.information.CUser;
import com.example.chimerider.util.ImageUtility;

public class UserInformationActivity extends Activity {

	public static final String CONTACT_OBJECT_KEY = "CONTACT_OBJECT_KEY";
	private ImageView ivProfileImage;
	private CUser user;
	private EditText etName;
	private Spinner spGender;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_information);
		ivProfileImage = (ImageView) findViewById(R.id.ivProfilePicture);
		etName = (EditText) findViewById(R.id.etUserName);
		spGender = (Spinner) findViewById(R.id.spGender);
		
		user = (CUser) getIntent().getSerializableExtra("user");
		if (user == null) {
			user = new CUser();
		}
		
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
	
	protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) { 
		super.onActivityResult(requestCode, resultCode, imageReturnedIntent); 
		switch(requestCode) {
		case 0:
			if(resultCode == RESULT_OK){  
				Bundle extras = imageReturnedIntent.getExtras();
				Bitmap bitmap = (Bitmap) extras.get("data");
				ivProfileImage.setImageBitmap(bitmap);
				user.setUserProfileImageBitmapURI(ImageUtility.getRealPathFromURI(ImageUtility.getImageUri(this, bitmap), this));
				user.save();
			}

			break; 
		case 1:
			if(resultCode == RESULT_OK){  
				Uri selectedImage = imageReturnedIntent.getData();
				ivProfileImage.setImageURI(selectedImage);
				user.setUserProfileImageBitmapURI(ImageUtility.getRealPathFromURI(selectedImage, this));
				user.save();
			}
			break;
		}
	}

	public void saveData(View v) {
		user.name = etName.getText().toString();
		user.gender = spGender.getSelectedItem().toString();
		user.save();
		
		Intent result = new Intent(this, CContactListActivity.class);
		result.putExtra(CONTACT_OBJECT_KEY, user);
		setResult(RESULT_OK, result);
		finish();
	}
}
