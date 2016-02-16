package silvergecko.android.commons.web;

import silvergecko.android.commons.Logger;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.WebView;

public class JSDownInterface {
	
	static final String TAG = "JSDownInterface";
	
	private Context mContext;
	private Handler mHandler;
	protected WebView mWebview;
	
	public JSDownInterface(Context c, WebView wv) {
		
		mContext = c;
		mHandler = new Handler(Looper.getMainLooper());
		mWebview =  wv;
		
	}
	
	public void executeJS(String jsString) {
		Logger.log(TAG, "executeJS", "Executing js : " + jsString, Log.INFO);
		mWebview.loadUrl("javascript:" + jsString);
	}

}
