package com.helpapp.pages;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.helpapp.R;
import com.helpapp.helpers.SaveHandler;

public class SettingsKeywords extends Activity {
	
	private SaveHandler saveHandler;
	
	private EditText field1;
	private EditText field2;
	private EditText field3;
	private EditText field4;
	private EditText field5;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings_keywords);
		
		saveHandler = new SaveHandler(this);
		
		field1 = (EditText) findViewById(R.id.keyword_field1);
		field2 = (EditText) findViewById(R.id.keyword_field2);
		field3 = (EditText) findViewById(R.id.keyword_field3);
		field4 = (EditText) findViewById(R.id.keyword_field4);
		field5 = (EditText) findViewById(R.id.keyword_field5);
		
		initBackButton();
		initDoneButton();
	}
	
	private void initBackButton(){
		final Button button =(Button) findViewById(R.id.back_button);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
 
				// Start NewActivity.class
				Intent myIntent = new Intent(SettingsKeywords.this,
						Settings.class);
				startActivity(myIntent);
			}
		});
	}
	
	private void initDoneButton(){
		final Button button =(Button) findViewById(R.id.done_button);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				//get the values in the fields
				ArrayList<String> keywords = new ArrayList<String>();
				keywords.add(field1.getText().toString());
				keywords.add(field2.getText().toString());
				keywords.add(field3.getText().toString());
				keywords.add(field4.getText().toString());
				keywords.add(field5.getText().toString());
				
				//A string of keywords to be saved
				String keyString="";
				
				for(int i=0;i<keywords.size();i++){
					keyString+=keywords.get(i);
					keyString+=",";
				}
				
				//save the keywords
				saveHandler.saveKeywords(keyString);
				
				// Start NewActivity.class
				Intent myIntent = new Intent(SettingsKeywords.this,
						Settings.class);
				startActivity(myIntent);
			}
		});
	}
}
