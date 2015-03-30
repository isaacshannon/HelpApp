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

	private EditText[] fields = new EditText[5];

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings_keywords);

		saveHandler = new SaveHandler(this);
		fields = new EditText[]{ (EditText) findViewById(R.id.keyword_field1),
				(EditText) findViewById(R.id.keyword_field2),
				(EditText) findViewById(R.id.keyword_field3),
				(EditText) findViewById(R.id.keyword_field4),
				(EditText) findViewById(R.id.keyword_field5)};

		//get the saved keywords and set them in the fields
		String[] savedKeywords = saveHandler.getKeywords();
		for(int i=0;i<fields.length;i++){
			if(i<savedKeywords.length-1)
				fields[i].setText(savedKeywords[i]);
		}



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
	
	public void saveKeywords(){
		String keyString="";
		for(EditText field:fields){
			keyString+=field.getText().toString();
			keyString+=",";
		}

		//save the keywords
		saveHandler.saveKeywords(keyString);
		
	}

	private void initDoneButton(){
		final Button button =(Button) findViewById(R.id.done_button);

		button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				//get the values in the fields
				
				saveKeywords();
				// Start NewActivity.class
				Intent myIntent = new Intent(SettingsKeywords.this,
						Settings.class);
				startActivity(myIntent);
			}
		});
	}
}
