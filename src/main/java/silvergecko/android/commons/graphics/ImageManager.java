package silvergecko.android.commons.graphics;

import java.io.ByteArrayOutputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import silvergecko.android.commons.Logger;

public class ImageManager {
	
	static final String TAG = "ImageManager";
	
	public static String base64Encode(Bitmap image) {
		String base64Image = null;
		
		Logger.log(TAG, "base64Encode", "Encoding ... - image size: " + Integer.toString(image.getWidth()) + "x" + Integer.toString(image.getHeight()), Log.INFO);
		try {
			byte [] buff = null;
			
			ByteArrayOutputStream baos=new  ByteArrayOutputStream();
			image.compress(Bitmap.CompressFormat.JPEG, 60, baos);
	        buff = baos.toByteArray();
	        
			System.gc();
			base64Image = Base64.encodeToString(buff, Base64.DEFAULT);
		} catch(Exception e) {
			Logger.log(TAG, "base64Encode", "An error occurred during base64 encoding", Log.ERROR);
			Logger.log(TAG, "base64Encode", Log.getStackTraceString(e), Log.DEBUG);
		}
		
		Logger.log(TAG, "base64Encode", "... encode successiful - base64 string size: " + base64Image.length(), Log.INFO);
		
		return base64Image;
	}
	
	public static Bitmap base64Decode(String base64Image) {
		Bitmap image = null;
		Logger.log(TAG, "base64Decode", "Decoding ... - base64 string size: " + base64Image.length(), Log.INFO);
		
		try {
			byte [] buff = null;
			
			buff = Base64.decode(base64Image, Base64.DEFAULT);
			image = BitmapFactory.decodeByteArray(buff, 0, buff.length);
			
			System.gc();
			
			
		} catch(Exception e) {
			Logger.log(TAG, "base64Decode", "An error occurred during base64 decoding", Log.ERROR);
			Logger.log(TAG, "base64Decode", Log.getStackTraceString(e), Log.DEBUG);
		}
		
		Logger.log(TAG, "base64Decode", "... decode successiful - image size: " + Integer.toString(image.getWidth()) + "x" + Integer.toString(image.getHeight()), Log.INFO);
		
		return image;
	}
	
}
