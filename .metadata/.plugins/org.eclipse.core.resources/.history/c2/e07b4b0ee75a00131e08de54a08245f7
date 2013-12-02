package com.example.healthcaresearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DataBinders.PlaceAutoCompleteResultSet;
import Query.PlaceAutoComplete;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class LocationAutoComplete extends Activity {
	AutoCompleteTextView textView;
	ArrayAdapter<String> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_location_auto_complete);
		
		adapter= new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, new ArrayList<String>());	
		
		textView = (AutoCompleteTextView) findViewById(R.id.locationAuto);
		textView.setThreshold(1);
		textView.setAdapter(adapter);
		
		textView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				String selectedItem = textView.getText().toString();
				Toast.makeText(getApplicationContext(), "Selected " + '"' + selectedItem + '"', Toast.LENGTH_LONG).show();
				
				Intent resultIntent = new Intent();
				// TODO Add extras or a data URI to this intent as appropriate.
				resultIntent.putExtra("SelectedLocation", selectedItem);
				setResult(Activity.RESULT_OK, resultIntent);
				finish();
			}
	
		});
		
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

	private class LocationTask extends AsyncTask<String, Void, List<String>> {

		@Override
		protected List<String> doInBackground(String... s) {
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
					
			List<String> finalResults = new ArrayList<String>();
			for(DataBinders.Prediction prediction : results.getPredictions()) {
				finalResults.add(prediction.getDescription());
			}

			return finalResults;
		}
		
		protected void onPostExecute(List<String> finalResults) {
			adapter.clear();
			adapter.addAll(finalResults);
	    }
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.location_auto_complete, menu);
		return true;
	}
}
