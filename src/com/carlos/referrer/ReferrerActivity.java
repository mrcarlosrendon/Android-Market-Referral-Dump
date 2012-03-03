package com.carlos.referrer;

import java.util.Map;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ReferrerActivity extends Activity {
    /** Called when the activity is first created. */
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        
        setContentView(R.layout.main);
                
        SharedPreferences prefs = getSharedPreferences(AnalyticsReceiver.PREFS_NAME, 0);
        Map<String, ?> all = prefs.getAll();
        
        StringBuilder build = new StringBuilder();
        for(String k : all.keySet()) {
        	build.append(k + " = " + all.get(k).toString() + "\n");
        }                
        TextView view = (TextView)findViewById(R.id.ref_info);
        view.setText(build.toString());
    }
    
    @Override
    protected void onDestroy() {
    	super.onDestroy();
    }
}