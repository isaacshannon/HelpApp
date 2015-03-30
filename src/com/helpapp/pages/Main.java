package com.helpapp.pages;

import java.util.ArrayList;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.helpapp.R;
import com.helpapp.fragments.ContinuousDictationFragment;
import com.helpapp.fragments.DetailFrag;
import com.helpapp.fragments.ContinuousDictationFragment.ContinuousDictationFragmentResultsCallback;
import com.helpapp.helpers.*;

public class Main extends Activity implements com.helpapp.fragments.ContinuousDictationFragment.ContinuousDictationFragmentResultsCallback{

	private ThreatAssessment threatAssessment = new ThreatAssessment();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initEmergencyButton();
		initSettingsButton();
		initResponseTimeButton();
		initFrag();
	}
	
	@Override
	  public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main_activity_actions, menu);
	    return true;
	  }
	
	private void initEmergencyButton(){
		Button button =(Button) findViewById(R.id.emergency_button);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
 
				// Start NewActivity.class
				Intent myIntent = new Intent(Main.this,
						Emergency.class);
				startActivity(myIntent);
			}
		});
	}
	
	private void initSettingsButton(){
		ImageButton button =(ImageButton) findViewById(R.id.settings_button);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
 
				// Start NewActivity.class
				Intent myIntent = new Intent(Main.this,
						Settings.class);
				startActivity(myIntent);
			}
		});
	}
	
	private void initResponseTimeButton(){
		Button button =(Button) findViewById(R.id.response_button);
		button.setOnClickListener(new OnClickListener() {
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
			threatAssessment.keywordDetected(count);
			DetailFrag frag = (DetailFrag) getFragmentManager().findFragmentById(R.id.frag_msg1);
			if (frag != null && frag.isInLayout()) {
					frag.setText("keyword found");
			}
			else
				frag.setText(dictationResults.toString());	
			// Start NewActivity.class
			Intent myIntent = new Intent(Main.this,
					Emergency.class);
			startActivity(myIntent);
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
		if(dictationResults!=null && dictationResults.size()>0){
			for(int i=0;i<dictationResults.size();i++){
				String word = dictationResults.get(i);
				if(word.contains("help")){
					keyCount++;}
			}
		}
		return keyCount;
	}
	
	/**
	 *look at the results for the keyword
	 * @return
	 */
	private void initFrag(){
		DetailFrag frag = (DetailFrag) getFragmentManager().findFragmentById(R.id.frag_msg2);
		frag.setText("No results...");
	}
	
}