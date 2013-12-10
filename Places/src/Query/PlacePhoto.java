package Query;

/**
 * Class that constructs google's places image url
 * @author arun
 *
 */
public class PlacePhoto {
	public static String getPhotoUrl(String key, String photoreference, String sensor, String dimension, String maxQuantity) {
		String url = "https://maps.googleapis.com/maps/api/place/photo?";
		url = url + "key=" + key;
		url = url + "&photoreference=" + photoreference;
		url = url + "&sensor=" + sensor;
		url = url + "&" + dimension + "=" + maxQuantity;
		return url;
	}
}
