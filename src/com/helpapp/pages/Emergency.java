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
import com.helpapp.fragments.ContinuousDictationFragment.ContinuousDictationFragmentResultsCallback;
import com.helpapp.helpers.*;

public class Emergency extends Activity {

	private SaveHandler saveHandler;
	EditText field;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.emergency);
		
		field = (EditText) findViewById(R.id.password_field);
		
		saveHandler = new SaveHandler(this);
		initBackButton();
		initDisarmButton();

	}

	private void initBackButton(){
		final Button button =(Button) findViewById(R.id.back_button);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {

				// Start NewActivity.class
				Intent myIntent = new Intent(Emergency.this,
						Main.class);
				startActivity(myIntent);
			}
		});
	}

	private void initDisarmButton(){
		final Button button =(Button) findViewById(R.id.disarm_button);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				String pw = saveHandler.getPassword();
				if(pw.equals("null")||pw.equals(field.getText().toString())){
					// Start NewActivity.class
					Intent myIntent = new Intent(Emergency.this,
							Main.class);
					startActivity(myIntent);
				}
			}
		});
	}
}