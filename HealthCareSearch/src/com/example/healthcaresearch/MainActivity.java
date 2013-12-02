package com.example.healthcaresearch;

import java.util.HashMap;

import DataBinders.GeoCodeResultSet;
import Query.GeoCode;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	private String selectedLocation;
	private double lat;
	private double lng;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		selectedLocation = "";
		lat = 0.0;
		lng = 0.0;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void clickedSetLocation(View view) {
		Integer requestCode = 0;
		Intent i = new Intent(this, LocationAutoComplete.class);
		startActivityForResult(i, requestCode);
	}
	
	public void clickedNearbySearch(View view) {
		Intent i = new Intent(this, NearbySearch.class);
		i.putExtra("selectedLocation", selectedLocation);
		i.putExtra("lat", lat);
		i.putExtra("lng", lng);
		startActivity(i);
	}
	
	public void clickedTextSearch(View view) {
		Intent i = new Intent(this, TextSearch.class);
		i.putExtra("selectedLocation", selectedLocation);
		i.putExtra("lat", lat);
		i.putExtra("lng", lng);
		startActivity(i);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		TextView t;
		t = (TextView)findViewById(R.id.editText1);
		selectedLocation = data.getStringExtra("selectedLocation");
		t.setText(selectedLocation);
		t.setEnabled(false);
		
		GeoCodeTask task = new GeoCodeTask();
		task.execute(selectedLocation);
	}
	
	private class GeoCodeTask extends AsyncTask<String, Void, Void> {

		@Override
		protected Void doInBackground(String... param) {
			//Set selected location latlong
			HashMap<String, String> params = new HashMap<String, String>();
			params.put("sensor", "true");
			params.put("address", param[0].toString());
			GeoCodeResultSet result = null;
			try {
				result = GeoCode.getLatLong(params);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			lat = result.getResults().get(0).getGeometry().getLocation().getLat();
			lng = result.getResults().get(0).getGeometry().getLocation().getLng();
			return null;
		}
		
	}

}
