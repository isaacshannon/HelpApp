package com.helpapp.helpers;
import android.os.Bundle;
import android.app.Activity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SMSLauncher {
	
	public SMSLauncher(){
		
	}
	
	public void sendSMSMessage(String deviceNumber, String msg) {

	      String phoneNo = "8193193915";
	      String message = "test";

	      try {
	         SmsManager smsManager = SmsManager.getDefault();
	         smsManager.sendTextMessage(phoneNo, null, message, null, null);
	      } catch (Exception e) {
	      }
	   }

}
