package com.example.healthcaresearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DataBinders.SearchResult;
import DataBinders.SearchResultSet;
import Query.Search;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class NearbySearch extends Activity {
	
	private String selectedLocation;
	private String lat;
	private String lng;
	private ArrayAdapter<SearchResult> adapter;
	private ListView listView;
	private EditText editText;
	private List<SearchResult> results;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nearby_search);
		
		selectedLocation = getIntent().getExtras().getString("selectedLocation");
		lat = Double.toString(getIntent().getExtras().getDouble("lat"));
		lng = Double.toString(getIntent().getExtras().getDouble("lng"));
		
		editText = (EditText) findViewById(R.id.editText1);
		editText.setText(selectedLocation);
		editText.setEnabled(false);
		
		listView = (ListView) findViewById(R.id.listView1);
		
		results = new ArrayList<SearchResult>();
		adapter = new ModifiedArrayAdapter(this, results);
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
		
		NearbySearchTask task = new NearbySearchTask();
		task.execute(selectedLocation);
	}
	
	private class NearbySearchTask extends AsyncTask<String, Void, List<SearchResult>> {

		@Override
		protected List<SearchResult> doInBackground(String... param) {
			HashMap<String, String> params = new HashMap<String, String>();
			params.put("location", lat + "," + lng);
			params.put("radius", "100000");
			params.put("sensor", "true");
			params.put("key", "AIzaSyC8j9ERqf-XwxMpATEfO063jkfhvTINNcw");
			params.put("types", "hospital|health");
						
			SearchResultSet resultSet = new SearchResultSet();
			try {
				resultSet = Search.search("nearbysearch", params);
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

}
