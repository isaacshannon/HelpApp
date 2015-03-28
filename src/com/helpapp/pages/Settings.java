package com.helpapp.pages;

import java.util.ArrayList;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.helpapp.R;
import com.helpapp.helpers.*;


public class Settings extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		initBackButton();
		initKeywordsButton();
		initContactsButton();
		initPasswordButton();
	}
	
	private void initBackButton(){
		Button button =(Button) findViewById(R.id.back_button);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
 
				// Start NewActivity.class
				Intent myIntent = new Intent(Settings.this,
						Main.class);
				startActivity(myIntent);
			}
		});
	}
	
	private void initKeywordsButton(){
		Button button =(Button) findViewById(R.id.keywords_button);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
 
				// Start NewActivity.class
				Intent myIntent = new Intent(Settings.this,
						SettingsKeywords.class);
				startActivity(myIntent);
			}
		});
	}
	
	private void initContactsButton(){
		Button button =(Button) findViewById(R.id.contacts_button);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
 
				// Start NewActivity.class
				Intent myIntent = new Intent(Settings.this,
						Contacts.class);
				startActivity(myIntent);
			}
		});
	}
	
	private void initPasswordButton(){
		Button button =(Button) findViewById(R.id.password_button);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
 
				// Start NewActivity.class
				Intent myIntent = new Intent(Settings.this,
						SettingsPassword.class);
				startActivity(myIntent);
			}
		});
	}

	
	
	
	
	
}