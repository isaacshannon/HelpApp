package com.helpapp.helpers;

import java.util.ArrayList;

import com.example.helpapp.R;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SaveHandler {
	Activity context;
	SharedPreferences sharedPref;
	SharedPreferences.Editor editor;

	public SaveHandler(Activity activity){
		context = activity;
		sharedPref = 
				context.getSharedPreferences(String.valueOf(R.string.preference_file_key),Context.MODE_PRIVATE);
		editor = sharedPref.edit();
	}

	public void savePassword(String password){
		editor.putString("password",password);
		editor.commit();
	}

	public String getPassword(){
		String password = sharedPref.getString("password","null");
		return password;
	}

	public void saveDangerLevel(String level){
		editor.putString("danger",level);
		editor.commit();
	}

	public String getDangerLevel(){
		String password = sharedPref.getString("danger","null");
		return password;
	}

	public void saveKeywords(String keywords){
		editor.putString("keywords",keywords);
		editor.commit();
	}

	public String[] getKeywords(){
		String keywordString = "";
		keywordString+=sharedPref.getString("keywords","null");

		return keywordString.split(",");
	}

	public void saveSMSContacts(ArrayList<String> contacts){

	}

	public void setCheckin(boolean checkin){
		editor.putBoolean("checkin",checkin);
		editor.commit();
	}
	
	public boolean getCheckin(){
		boolean checkin = sharedPref.getBoolean("checkin",false);
		return checkin;
	}

}
