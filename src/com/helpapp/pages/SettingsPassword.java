package com.helpapp.pages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.helpapp.R;

public class SettingsPassword extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings_password);
		initBackButton();
		initDoneButton();
	}
	
	private void initBackButton(){
		final Button button =(Button) findViewById(R.id.back_button);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
 
				// Start NewActivity.class
				Intent myIntent = new Intent(SettingsPassword.this,
						Settings.class);
				startActivity(myIntent);
			}
		});
	}
	
	private void initDoneButton(){
		final Button button =(Button) findViewById(R.id.done_button);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
 
				// Start NewActivity.class
				Intent myIntent = new Intent(SettingsPassword.this,
						Settings.class);
				startActivity(myIntent);
			}
		});
	}
}
