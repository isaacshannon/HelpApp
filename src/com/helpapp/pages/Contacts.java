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
import com.helpapp.helpers.ContinuousDictationFragment.ContinuousDictationFragmentResultsCallback;

public class Contacts extends Activity {

	private ThreatAssessment threatAssessment = new ThreatAssessment();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.emergency);
		
	}	
}