package com.example.helpapp;

public class ThreatAssessment {
	//THREAT LEVEL
	//0 = no threat
	//1 = possibility of threat
	//2 = threat	
	private int threatLevel=0;
	private int keywordCount=0;
	
	private final int THRESHOLD1 = 1;
	private final int THRESHOLD2 = 3;
	
	private ThreatReactor threatReactor = new ThreatReactor();
	
	
	public ThreatAssessment(){
		
	}
	
	/**
	 * handles a detected keyword event
	 */
	public void keywordDetected(int count){
		keywordCount+=count;
		threatLevel = evaluateThreatLevel();
		threatReactor.startReaction(threatLevel);
	}
	
	/**
	 * Cancels a threat
	 */
	public void cancelThreat(){
		threatLevel = 0;
		keywordCount=0;
	}
	
	/**
	 * Evaluates the threat level from the keyword count
	 */
	private int evaluateThreatLevel(){
		int level = 0; 
		if(keywordCount >= THRESHOLD1)
			level=1;
		if(keywordCount >= THRESHOLD2)
			level=2;
		return level;	
	}
	
	
	/**
	 * decrements the keyword count at intervals
	 */
	private void decrementKeywordCount(){
		//to do
	}
	
	

}
