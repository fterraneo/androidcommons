package silvergecko.android.commons.async;

public interface ITaskListener {
	
	void onPreExecute();
    void onProgressUpdate(int percent);
    void onCancelled();
    void onPostExecute(Object result);
    
}
