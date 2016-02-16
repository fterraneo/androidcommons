package silvergecko.android.commons.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.util.Log;

import silvergecko.android.commons.Logger;
import silvergecko.android.commons.async.Task;

public class HttpPostTask extends Task {

	static final String TAG = "HttpPostTask";
	
	private HttpPostTaskConfig configParams = null;
	private String url = null;
	private HashMap<String, String> additionalHeader = null;
	private HashMap<String, String> params = null;
	
	public HttpPostTask(Activity caller, String url) {
		super(caller);
		this.url = url;
		this.additionalHeader = new HashMap<String, String>();
		this.params = new HashMap<String, String>();
		this.configParams = new HttpPostTaskConfig();
	}
	public HttpPostTask(Activity caller, String url, HttpPostTaskConfig configParams) {
		super(caller);
		this.url = url;
		this.additionalHeader = new HashMap<String, String>();
		this.params = new HashMap<String, String>();
		this.configParams = configParams;
	}
	
	public void addHeader(String key, String value) {
		this.additionalHeader.put(key, value);
	}
	
	public void addParam(String key, String value) {
		this.params.put(key, value);
	}

	@Override
	protected String doInBackground(String... arg0) {
		
		String s = null;
		
	    // Create a new HttpClient and Post Header
		HttpParams httpParameters = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParameters, this.configParams.getConnTimeout());
		HttpConnectionParams.setSoTimeout(httpParameters, this.configParams.getSoTimeout());
	    HttpClient httpclient = new DefaultHttpClient(httpParameters);

	    HttpPost httppost = new HttpPost(this.url);
	    Logger.log(TAG, "doInBackground", "Executing http call...", Log.INFO);
	    try {
	        // Add standard header content
	    	httppost.setHeader("Content-Type", this.configParams.getContentType());
	    	
	    	// Add custom header content
	    	Iterator<String> it = this.additionalHeader.keySet().iterator();
	    	while(it.hasNext()) {
	    		String key = it.next();
	    		String value = this.additionalHeader.get(key);
	    		httppost.addHeader(key, value);
	    		Logger.log(TAG, "doInBackground", "Adding header entry: [" + key + "," + value + "]", Log.INFO);
	    	}
	    	
	    	// Add your data
	    	it = this.params.keySet().iterator();
	    	List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(this.params.keySet().size());
	    	while(it.hasNext()) {
	    		String key = it.next();
	    		String value = this.params.get(key);
	    		nameValuePairs.add(new BasicNameValuePair(key, value));
	    		Logger.log(TAG, "doInBackground", "Adding param: [" + key + "," + value + "]", Log.INFO);
	    	}      
	        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	        
	        // Execute HTTP Post Request
	        
	        HttpResponse response = httpclient.execute(httppost);
	        Logger.log(TAG, "doInBackground", "...call executed. ", Log.INFO);
	        
	        String responseBody = EntityUtils.toString(response.getEntity());
	        s = responseBody;
	        
	    } catch (ClientProtocolException e) {
			Logger.log(TAG, "doInBackground", "An error occured during http POST", Log.ERROR);
			Logger.log(TAG, "doInBackground", Log.getStackTraceString(e), Log.DEBUG);
	    } catch (IOException e) {
			Logger.log(TAG, "doInBackground", "An error occured during http POST", Log.ERROR);
			Logger.log(TAG, "doInBackground", Log.getStackTraceString(e), Log.DEBUG);
	    }
			
		return s;
	}

}
