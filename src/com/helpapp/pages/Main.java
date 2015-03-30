package com.helpapp.pages;

import java.util.ArrayList;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.helpapp.R;
import com.helpapp.fragments.ContinuousDictationFragment;
import com.helpapp.fragments.DetailFrag;
import com.helpapp.fragments.ContinuousDictationFragment.ContinuousDictationFragmentResultsCallback;
import com.helpapp.helpers.*;

public class Main extends Activity implements com.helpapp.fragments.ContinuousDictationFragment.ContinuousDictationFragmentResultsCallback{

	private boolean isEmergency=false;
	private Button emergencyButton;
	private Button checkinButton;
	private ImageButton settingsButton;
	private Button safetyButton;
	private Button disarmButton;
	private EditText passwordField;
	private TextView emergencyTitle;
	private TextView emergencyInstruction;
	private TextView frag1Title;
	private TextView frag2Title;
	private ContinuousDictationFragment dictFrag;
	private LinearLayout fragLayout;
	private LinearLayout alertLayout;
	private SaveHandler saveHandler;
	private DetailFrag frag;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		saveHandler = new SaveHandler(this);
		
		passwordField=(EditText) findViewById(R.id.alert_password_field);
		emergencyTitle=(TextView) findViewById(R.id.alert_title);
		emergencyInstruction=(TextView) findViewById(R.id.alert_password);
		frag1Title=(TextView) findViewById(R.id.frag1_title);
		frag2Title=(TextView) findViewById(R.id.frag2_title);

		fragLayout=(LinearLayout) findViewById(R.id.frag_layout);
		//alertLayout=(LinearLayout) findViewById(R.id.alert_layout);

		checkinButton = (Button) findViewById(R.id.checkin_button);
		disarmButton = (Button) findViewById(R.id.disarm_button);
		dictFrag = (ContinuousDictationFragment) getFragmentManager().findFragmentById(R.id.frag_dict);
		
		initFrag();
		initEmergencyButton();
		initSettingsButton();
		initResponseTimeButton();
		initCheckinButton();
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_activity_actions, menu);
		return true;
	}

	private void initEmergencyButton(){
		emergencyButton =(Button) findViewById(R.id.emergency_button);
		emergencyButton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				if(!isEmergency)
					startEmergency();
				else
					stopEmergency();
			}
		});
	}

	private void initSettingsButton(){
		settingsButton =(ImageButton) findViewById(R.id.settings_button);
		settingsButton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {

				// Start NewActivity.class
				Intent myIntent = new Intent(Main.this,
						Settings.class);
				startActivity(myIntent);
			}
		});
	}

	private void initCheckinButton(){
		checkinButton =(Button) findViewById(R.id.checkin_button);
		if(saveHandler.getCheckin()){
			checkinButton.setText("Stop Check-In");
			checkinButton.setBackgroundResource(R.drawable.button_green);
		}
		else
			checkinButton.setBackgroundResource(R.drawable.button);
		checkinButton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {

				if(!saveHandler.getCheckin()){
					// Start NewActivity.class
					Intent myIntent = new Intent(Main.this,
							Checkin.class);
					startActivity(myIntent);}
				else{
					checkinButton.setText("Start Check-In");
					checkinButton.setBackgroundResource(R.drawable.button);
					saveHandler.setCheckin(false);
					frag2Title.setText("Voice recognition Results:");
					frag.setText("No Results...");
				}
			}
		});
	}

	private void initResponseTimeButton(){
		safetyButton =(Button) findViewById(R.id.response_button);
		safetyButton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {

				// Start NewActivity.class
				Intent myIntent = new Intent(Main.this,
						ResponseTime.class);
				startActivity(myIntent);
			}
		});
	}

	@Override
	public void onDictationStart() {
		// TODO Auto-generated method stub
	}

	@Override
	public void onResults(ContinuousDictationFragment delegate,
			ArrayList<String> dictationResults) {

		DetailFrag frag2 = (DetailFrag) getFragmentManager().findFragmentById(R.id.frag_msg2);
		if (frag2 != null && frag2.isInLayout()) 
			frag2.setText(dictationResults.get(0));

		int count = countKeywords(dictationResults);
		if (count > 0){
			DetailFrag frag = (DetailFrag) getFragmentManager().findFragmentById(R.id.frag_msg1);
			if (frag != null && frag.isInLayout()) {
				frag.setText("keyword found");
			}
			else
				frag.setText(dictationResults.toString());	

			startEmergency();
		}
	}

	@Override
	public void onDictationFinish() {
		// TODO Auto-generated method stub
	}

	/**
	 *look at the results for the keyword
	 * @return
	 */
	private int countKeywords(ArrayList<String> dictationResults){
		int keyCount = 0;

		//cycle through the result strings
		String[] keywords = saveHandler.getKeywords();
		for(int i=0;i<dictationResults.size();i++){
			String[] words = dictationResults.get(i).split(" ");
			for(String word:words)
				for(String keyword:keywords)
					if(keyword.equals(word))
						keyCount++;

		}
		return keyCount;
	}

	/**
	 *look at the results for the keyword
	 * @return
	 */
	private void initFrag(){
		frag = (DetailFrag) getFragmentManager().findFragmentById(R.id.frag_msg2);
		frag.setText("No results...");
		if(saveHandler.getCheckin()){
			frag2Title.setText("");
			frag.setText("Check-In in: 44:05");}
	}

	/**
	 * reacts to an emergency
	 */
	public void startListening(){
		//make the unnecessary elements invisible
		safetyButton.setVisibility(View.INVISIBLE);
		settingsButton.setVisibility(View.INVISIBLE);
	}

	/**
	 * reacts to an emergency
	 */
	public void stopListening(){
		//make the unnecessary elements visible
		safetyButton.setVisibility(View.VISIBLE);
		settingsButton.setVisibility(View.VISIBLE);
	}

	/**
	 * reacts to an emergency
	 */
	private void startEmergency(){
		isEmergency=true;

		//place a disarm warning
		frag.setText("The app will disarm automatically in: 40 minutes");

		//change the text of the emergency button
		emergencyButton.setText("Disarm");

		//make the emergency reaction elements visible
		emergencyTitle.setVisibility(View.VISIBLE);
		emergencyTitle.setPadding(0,30,0,0);
		emergencyInstruction.setVisibility(View.VISIBLE);
		passwordField.setVisibility(View.VISIBLE);


		//make the unnecessary elements invisible
		fragLayout.setVisibility(View.INVISIBLE);
		checkinButton.setVisibility(View.INVISIBLE);
		safetyButton.setVisibility(View.INVISIBLE);
		disarmButton.setVisibility(View.INVISIBLE);
		settingsButton.setVisibility(View.INVISIBLE);


	}

	/**
	 * reacts to an emergency
	 */
	private void stopEmergency(){
		isEmergency=false;

		frag.setText("No Results...");

		//change the text of the emergency button
		emergencyButton.setText("Emergency");

		//make the emergency reaction elements visible
		emergencyTitle.setVisibility(View.GONE);
		emergencyTitle.setPadding(0,0,0,0);
		emergencyInstruction.setVisibility(View.GONE);
		passwordField.setVisibility(View.GONE);

		//make the unecessary elements invisible
		frag2Title.setVisibility(View.VISIBLE);
		fragLayout.setVisibility(View.VISIBLE);
		checkinButton.setVisibility(View.VISIBLE);
		safetyButton.setVisibility(View.VISIBLE);
		disarmButton.setVisibility(View.VISIBLE);
		settingsButton.setVisibility(View.VISIBLE);
	}

}