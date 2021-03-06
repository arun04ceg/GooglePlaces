package com.example.healthcaresearch;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import DataBinders.Photo;
import DataBinders.SearchResult;
import Query.PlacePhoto;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Modified Array adapter which sets the result image, title and reviews.
 * @author arun
 *
 */
public class ModifiedArrayAdapter extends ArrayAdapter<SearchResult>{
	private final Context context;
	private final List<SearchResult> values;
	TextView textView;
	List<ImageView> imageViews;
	Integer imgViewCnt;
	
	public ModifiedArrayAdapter(Context context, List<SearchResult> values) {
	    super(context, R.layout.result_in_list, values);
	    this.context = context;
	    this.values = values;
	    imgViewCnt = 0;
	    imageViews = new ArrayList<ImageView>();
	  }
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
		        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.result_in_list, parent, false);
		
		textView = (TextView) rowView.findViewById(R.id.thirdLine);
		textView.setText(values.get(position).getName());
		
		Integer priceRange = values.get(position).getPrice_level();
		String dollars = " ";
		if(priceRange != null) {
			for(int i=0; i<priceRange+1; i++) {
				dollars = dollars + "$";
			}
		}
		
		textView = (TextView) rowView.findViewById(R.id.secondLine);
		Double rating = values.get(position).getRating();
		if (rating != null) 
			textView.setText(Double.toString(rating) + "    " + dollars);
		
	    imageViews.add((ImageView) rowView.findViewById(R.id.icon));
                		    	    
        DownloadImageTask task = new DownloadImageTask();
        List<Photo> photos = values.get(position).getPhotos();
        String url;
        if (photos != null)
        	url = PlacePhoto.getPhotoUrl("AIzaSyC8j9ERqf-XwxMpATEfO063jkfhvTINNcw", photos.get(0).getPhoto_reference(), "true", "maxwidth", "250");
        else
        	url = "https://cdn2.iconfinder.com/data/icons/picons-essentials/71/unable-512.png";
        task.execute(url, Integer.toString(imgViewCnt));
        imgViewCnt++;
		return rowView;
	}
	
	/**
	 * AsyncTask that downloads the image
	 * @author arun
	 *
	 */
	private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

		private Integer index;
		
	    protected Bitmap doInBackground(String... urls) {
	        String urldisplay = urls[0];
	        index = Integer.parseInt(urls[1]);
	        Bitmap mIcon11 = null;
	        try {
	            InputStream in = new java.net.URL(urldisplay).openStream();
	            mIcon11 = BitmapFactory.decodeStream(in);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return mIcon11;
	    }

	    protected void onPostExecute(Bitmap result) {
	    	imageViews.get(index).setImageBitmap(result);
	    }
	}

}
