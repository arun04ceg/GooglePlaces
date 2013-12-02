package com.example.healthcaresearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DataBinders.QueryAutocompleteResultSet;
import DataBinders.SearchResult;
import DataBinders.SearchResultSet;
import Query.QueryAutoComplete;
import Query.Search;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class TextSearch extends Activity {
	
	//private String selectedLocation;
	private String lat;
	private String lng;
	private AutoCompleteTextView textView;
	private ArrayAdapter<String> autoAdapter;
	private ModifiedArrayAdapter adapter;
	private ListView listView;
	private List<SearchResult> results;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_text_search);
		
		//selectedLocation = getIntent().getExtras().getString("selectedLocation");
		lat = Double.toString(getIntent().getExtras().getDouble("lat"));
		lng = Double.toString(getIntent().getExtras().getDouble("lng"));
		
		autoAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, new ArrayList<String>());
		textView = (AutoCompleteTextView) findViewById(R.id.textAuto);
		textView.setThreshold(1);
		textView.setAdapter(autoAdapter);
		
		textView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				String selectedItem = textView.getText().toString();
				listView = (ListView) findViewById(R.id.listView2);
				
				results = new ArrayList<SearchResult>();
				adapter = new ModifiedArrayAdapter(getApplicationContext(), results);
				listView.setAdapter(adapter);
				
				listView.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1, int position,
							long arg3) {
						Double lat = results.get(position).getGeometry().getLocation().getLat();
						Double lng = results.get(position).getGeometry().getLocation().getLng();
						String label = results.get(position).getName();
						String uriBegin = "geo:" + lat + "," + lng;
						String query = lat + "," + lng + "(" + label + ")";
						String encodedQuery = Uri.encode(query);
						String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
						Uri uri = Uri.parse(uriString);
						Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
						startActivity(intent);	
					}
				});
				
				TextSearchTask task = new TextSearchTask();
				task.execute(selectedItem);
			}
		});
		
		textView.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				TextAutoTask task = new TextAutoTask();
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
	
	private class TextAutoTask extends AsyncTask<String, Void, List<String>> {

		@Override
		protected List<String> doInBackground(String... s) {
			HashMap<String, String> params = new HashMap<String, String>();
			params.put("sensor", "true");
            params.put("key", "AIzaSyC8j9ERqf-XwxMpATEfO063jkfhvTINNcw");
            params.put("input", s[0].toString());
            params.put("location", lat + "," + lng);
						
			QueryAutocompleteResultSet results = new QueryAutocompleteResultSet();
			try {
				results = QueryAutoComplete.autoComplete(params);
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
			autoAdapter.clear();
			autoAdapter.addAll(finalResults);
	    }
		
	}
	
	private class TextSearchTask extends AsyncTask<String, Void, List<SearchResult>> {

		@Override
		protected List<SearchResult> doInBackground(String... param) {
			HashMap<String, String> params = new HashMap<String, String>();
			params.put("location", lat + "," + lng);
			params.put("radius", "100000");
			params.put("sensor", "true");
			params.put("key", "AIzaSyC8j9ERqf-XwxMpATEfO063jkfhvTINNcw");
			params.put("types", "hospital|health");
			params.put("query", param[0]);
			
						
			SearchResultSet resultSet = new SearchResultSet();
			try {
				resultSet = Search.search("textsearch", params);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			results = resultSet.getResults();
			return results;
		}
		
		protected void onPostExecute(List<SearchResult> finalResults) {
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
