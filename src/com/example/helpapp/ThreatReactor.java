package com.example.helpapp;

public class ThreatReactor {
	
	private SMSLauncher smsLauncher = new SMSLauncher();
	
	
	public ThreatReactor(){
		
	}
	
	/**
	 * Contacts the outside world in response to a threat detection
	 */
	public void startReaction(int threatLevel){
		if(threatLevel == 1)
			smsLauncher.sendSMSMessage("8193193915","***TEST*** A possible threat to this person has been detected, contact immediately ***TEST***");
		if(threatLevel > 1)
			smsLauncher.sendSMSMessage("8193193915","***TEST*** THIS PERSON IS IN DANGER, ASSIST IMMEDIATELY ***TEST***");
	}

}
