package silvergecko.android.commons.web;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class JSUpInterface {
	
	protected Context mContext;
	protected Handler mHandler;
	
	public JSUpInterface(Context c) {
		mContext = c;
		mHandler = new Handler(Looper.getMainLooper());
	}
	
	@JavascriptInterface
	public String toString() {
		return "JSUpInterface";
	}
	
	@JavascriptInterface
	public void showToast(String message) {
		Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
	}

}
