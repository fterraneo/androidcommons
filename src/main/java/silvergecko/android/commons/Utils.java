package silvergecko.android.commons;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build;

public class Utils {
	/**
	 * Gets the device model info from android platform.
	 * @return model description of the device
	 */
	public final static String getDeviceName() {
		String manufacturer = Build.MANUFACTURER;
		String model = Build.MODEL;
		if (model.startsWith(manufacturer)) {
			return capitalize(model);
		} else {
			return capitalize(manufacturer) + " " + model;
		}
	}
	
	/**
	 * Converts the first character of string to upper case
	 * @param s the string to capitalize
	 * @return the capitalized string
	 */
	public final static String capitalize(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		char first = s.charAt(0);
		if (Character.isUpperCase(first)) {
			return s;
		} else {
			return Character.toUpperCase(first) + s.substring(1);
		}
	}
	
	/**
	 * Gets the application version code from PackageManager
     * @return Application's version code from the {@code PackageManager}.
     */
    public static int getAppVersion(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (NameNotFoundException e) {
            // should never happen
            throw new RuntimeException("Could not get package name: " + e);
        }
    }
    
    /**
     * Check is an app is installed
     * @param packagename name of app package name
     * @param context application context
     * @return true if the app corresponding to packagename is installed
     */
    public static boolean isPackageInstalled(String packagename, Context context) {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(packagename, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
    
    /**
     * Launches install intent from Google Play
     * @param packagename app package name
     * @param context application context
     */
    public static void launchGooglePlayInstallIntent(String packagename, Context context) {
    	Intent intent = new Intent(Intent.ACTION_VIEW);
    	intent.setData(Uri.parse("market://details?id=" + packagename));
    	
		context.startActivity(intent);
    }

}
