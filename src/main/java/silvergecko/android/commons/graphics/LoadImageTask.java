package silvergecko.android.commons.graphics;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import silvergecko.android.commons.Logger;
import silvergecko.android.commons.async.Task;
import silvergecko.android.commons.web.HttpPostTaskConfig;

public class LoadImageTask extends Task{
	
	static final String TAG = "LoadImageTask";
	
	private LoadImageTaskConfig configParams = null;
	private String imagePath;

	public LoadImageTask(Activity caller, String imagePath) {
		super(caller);
		this.imagePath = imagePath;
		this.configParams = new LoadImageTaskConfig();
	}
	
	public LoadImageTask(Activity caller, String imagePath, LoadImageTaskConfig configParams) {
		super(caller);
		this.imagePath = imagePath;
		this.configParams = configParams;
	}

	@Override
	protected Bitmap doInBackground(String... arg0) {
		Logger.log(TAG, "doInBackground", "Loading image at path: " + this.imagePath, Log.INFO);
		BitmapFactory.Options options = new BitmapFactory.Options();
		
        options.inSampleSize = configParams.getSampleSize();
        options.inPurgeable = true;
        
        Bitmap image = BitmapFactory.decodeFile(this.imagePath, options);
        
        Logger.log(TAG, "doInBackground", "Loading done. " + this.imagePath, Log.INFO);
        
		return image;
	}

}
