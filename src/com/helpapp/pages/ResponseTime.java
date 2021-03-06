package com.helpapp.pages;

import java.util.ArrayList;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.helpapp.R;
import com.helpapp.helpers.*;


public class ResponseTime extends Activity {
	private SaveHandler saveHandler;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.safety);
		saveHandler = new SaveHandler(this);
		initRadios();
		initBackButton();
		initDoneButton();
	}
	
	private void initBackButton(){
		final Button button =(Button) findViewById(R.id.back_button);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
 
				// Start NewActivity.class
				Intent myIntent = new Intent(ResponseTime.this,
						Main.class);
				startActivity(myIntent);
			}
		});
	}
	
	private void initDoneButton(){
		final Button button =(Button) findViewById(R.id.done_button);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
 
				// Start NewActivity.class
				Intent myIntent = new Intent(ResponseTime.this,
						Main.class);
				startActivity(myIntent);
			}
		});
	}
	
	private void initRadios(){
		final RadioButton radioSafe =(RadioButton) findViewById(R.id.radio_safe);
		final RadioButton radioUnknown =(RadioButton) findViewById(R.id.radio_unknown);
		final RadioButton radioDanger =(RadioButton) findViewById(R.id.radio_danger);
		radioSafe.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
 
				saveHandler.saveDangerLevel("1");
				// Start NewActivity.class
				Intent myIntent = new Intent(ResponseTime.this,
						Main.class);
				startActivity(myIntent);
			}
		});
		radioUnknown.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
 
				saveHandler.saveDangerLevel("2");
				// Start NewActivity.class
				Intent myIntent = new Intent(ResponseTime.this,
						Main.class);
				startActivity(myIntent);
			}
		});
		
		radioDanger.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				saveHandler.saveDangerLevel("3");
				// Start NewActivity.class
				Intent myIntent = new Intent(ResponseTime.this,
						Main.class);
				startActivity(myIntent);
			}
		});
	}

	
	
	
	
	
}