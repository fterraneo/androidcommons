package silvergecko.android.commons.async;

import silvergecko.android.commons.Logger;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

public abstract class Task  extends AsyncTask<String, Integer, Object> {
	
	static final String TAG = "Task";

	private Activity caller;
	private TaskListener listener;
	
	public Task(Activity caller) {
		this.caller = caller;
	}
	
	public void setCaller(Activity caller) {
		this.caller = caller;
		this.onCallerUpdated(caller);
	}
	
	protected Activity caller() {
		return this.caller;
	}
	
	protected void onCallerUpdated(Activity caller) {
		Logger.log(TAG, "onCallerUpdated", "", Log.INFO);
	}
	
	public void setTaskListener(TaskListener listener) {
		this.listener = listener;
	}
	
	@Override
	protected void onPreExecute() {
		if(listener != null)
			listener.onPreExecute();
	}
	
	@Override
	protected void onProgressUpdate(Integer... percent) {
		if(listener != null)
			listener.onProgressUpdate(percent[0]);
	}
	
	@Override
	protected void onCancelled() {
		if(listener != null)
			listener.onCancelled();
	}
	
	@Override
	protected void onPostExecute(Object result) {
		if(listener != null)
			listener.onPostExecute(result);
	}
	
}
