package com.example.helpapp;

import java.util.ArrayList;


import android.app.Activity;
import android.os.Bundle;

import com.authorwjf.hello_fragments.*;

public class Main extends Activity implements com.example.helpapp.ContinuousDictationFragment.ContinuousDictationFragmentResultsCallback{

	private ThreatAssessment threatAssessment = new ThreatAssessment();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
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
				frag2.setText(dictationString(dictationResults));
		
		int count = countKeywords(dictationResults);
		if (count > 0){
			threatAssessment.keywordDetected(count);
			DetailFrag frag = (DetailFrag) getFragmentManager().findFragmentById(R.id.frag_msg1);
			if (frag != null && frag.isInLayout()) {
					frag.setText("keyword found");
			}
			else
				frag.setText(dictationResults.toString());	
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
	 * returns a string of the results for debugging purposes
	 */
	private String dictationString(ArrayList<String> dictationResults){
		String words ="";
		if(dictationResults!=null && dictationResults.size()>0){
			for(int i=0;i<dictationResults.size();i++){
				String word = dictationResults.get(i);
					words+=word+", ";
			}
		}
		return words;
	}
	
	
}