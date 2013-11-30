package LocationAutoCompleteTextView;

import java.util.HashMap;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

public class LocationAutoCompleteTextView extends AutoCompleteTextView{
	
	public LocationAutoCompleteTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	@Override
    protected CharSequence convertSelectionToString(Object selectedItem) {
        /** Each item in the autocompetetextview suggestion list is a hashmap object */
        @SuppressWarnings("unchecked")
		HashMap<String, String> hm = (HashMap<String, String>) selectedItem;
        return hm.get("description");
    }
	
	 @Override 
     protected void performFiltering(CharSequence text, int keyCode) 
     { 
		 	 String mSeparator = " ";
             String newText = text.toString(); 
             if (newText.indexOf(mSeparator) != -1) 
             { 
                     int lastIndex = newText.lastIndexOf(mSeparator); 
                     if (lastIndex != newText.length() - 1) 
                     { 
                             newText = newText.substring(lastIndex + 1).trim(); 
                             if (newText.length() >= getThreshold()) 
                             { 
                                     text = newText; 
                             } 
                     } 
             }
             
             mSeparator = ",";
             newText = text.toString(); 
             if (newText.indexOf(mSeparator) != -1) 
             { 
                     int lastIndex = newText.lastIndexOf(mSeparator); 
                     if (lastIndex != newText.length() - 1) 
                     { 
                             newText = newText.substring(lastIndex + 1).trim(); 
                             if (newText.length() >= getThreshold()) 
                             { 
                                     text = newText; 
                             } 
                     } 
             }
             
             super.performFiltering(text, keyCode); 
     } 
}
