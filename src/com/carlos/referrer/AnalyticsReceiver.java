package com.carlos.referrer;

import java.net.URLDecoder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

public class AnalyticsReceiver extends BroadcastReceiver {
	
	public static final String PREFS_NAME = "ReferrerPrefs";
	
	@Override
	public void onReceive(Context context, Intent intent) {			
		String referrer = URLDecoder.decode(intent.getStringExtra("referrer"));
		Log.d("Referrer", referrer);
		
		String[] refA = referrer.split("&");
		
		SharedPreferences ref_info = context.getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = ref_info.edit();
		
		Log.d("Referrer", "KEY DUMP");
		for(String k : refA) {
			String[] pair = k.split("=");
			Log.d("Referrer", pair[0] + " := " + pair[1]);			
			editor.putString(pair[0], pair[1]);
		}
		editor.commit();
	}
}
