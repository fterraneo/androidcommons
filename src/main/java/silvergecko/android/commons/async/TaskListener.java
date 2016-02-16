package silvergecko.android.commons.async;

import android.util.Log;

import silvergecko.android.commons.Logger;

public class TaskListener implements ITaskListener{
	
	static final String TAG = "TaskListener";

	@Override
	public void onPreExecute() {
		Logger.log(TAG, "onPreExecute", "", Log.DEBUG);
		
	}

	@Override
	public void onProgressUpdate(int percent) {
		Logger.log(TAG, "onProgressUpdate", "percent: " + Integer.toString(percent), Log.DEBUG);
		
	}

	@Override
	public void onCancelled() {
		Logger.log(TAG, "onCancelled", "", Log.DEBUG);
		
	}

	@Override
	public void onPostExecute(Object result) {
		Logger.log(TAG, "onPostExecute", "message: " + result.toString(), Log.DEBUG);
		
	}

}
