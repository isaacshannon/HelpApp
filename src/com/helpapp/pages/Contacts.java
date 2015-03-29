package com.helpapp.pages;

import java.util.ArrayList;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.helpapp.R;
import com.helpapp.fragments.ContinuousDictationFragment.ContinuousDictationFragmentResultsCallback;
import com.helpapp.helpers.*;

public class Contacts extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contacts);
		initBackButton();
		initSMSButton();
		initPhoneButton();
		initEmailButton();
		
	}
	
	private void initBackButton(){
		Button button =(Button) findViewById(R.id.back_button);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
 
				// Start NewActivity.class
				Intent myIntent = new Intent(Contacts.this,
						Main.class);
				startActivity(myIntent);
			}
		});
	}
	
	private void initSMSButton(){
		Button button =(Button) findViewById(R.id.sms_button);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
 
				// Start NewActivity.class
				Intent myIntent = new Intent(Contacts.this,
						ContactsSMS.class);
				startActivity(myIntent);
			}
		});
	}
	
	private void initPhoneButton(){
		Button button =(Button) findViewById(R.id.phone_button);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
 
				// Start NewActivity.class
				Intent myIntent = new Intent(Contacts.this,
						ContactsPhone.class);
				startActivity(myIntent);
			}
		});
	}
	
	private void initEmailButton(){
		Button button =(Button) findViewById(R.id.email_button);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
 
				// Start NewActivity.class
				Intent myIntent = new Intent(Contacts.this,
						ContactsEmail.class);
				startActivity(myIntent);
			}
		});
	}
}