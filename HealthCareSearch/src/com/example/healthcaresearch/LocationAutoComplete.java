package com.example.healthcaresearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DataBinders.PlaceAutoCompleteResultSet;
import LocationAutoCompleteTextView.LocationAutoCompleteTextView;
import Query.PlaceAutoComplete;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.SimpleAdapter;

public class LocationAutoComplete extends Activity {
	LocationAutoCompleteTextView textView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("Hello");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_location_auto_complete);
		
		textView = (LocationAutoCompleteTextView) findViewById(R.id.locationAuto);
		textView.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				LocationTask task = new LocationTask();
				task.execute(s.toString());
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}
			
			@Override
			public void afterTextChanged(Editable s) {
			}
		});
	}

	private class LocationTask extends AsyncTask<String, Void, List<HashMap<String, String>>> {

		@Override
		protected List<HashMap<String, String>> doInBackground(String... s) {
			HashMap<String, String> params = new HashMap<String, String>();
			params.put("sensor", "true");
			params.put("key", "AIzaSyC8j9ERqf-XwxMpATEfO063jkfhvTINNcw");
			params.put("input", s[0].toString());
						
			PlaceAutoCompleteResultSet results = new PlaceAutoCompleteResultSet();
			try {
				results = PlaceAutoComplete.autoComplete(params);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			List<HashMap<String, String>> finalResults = new ArrayList<HashMap<String, String>>();
			for(DataBinders.Prediction prediction : results.getPredictions()) {
				HashMap<String, String> finalResult = new HashMap<String, String>();
				finalResult.put("description", prediction.getDescription());
				finalResults.add(finalResult);
			}	
			return finalResults;
		}
		
		protected void onPostExecute(List<HashMap<String, String>> finalResults) {
			System.out.println(finalResults);
			SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), finalResults, R.layout.activity_location_auto_complete, new String[] {"description"}, new int[] {R.id.locationAuto});
			textView.setAdapter(adapter);
	    }
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.location_auto_complete, menu);
		return true;
	}

}