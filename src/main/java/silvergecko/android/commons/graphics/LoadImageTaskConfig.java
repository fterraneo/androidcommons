package silvergecko.android.commons.graphics;

public class LoadImageTaskConfig {
	
	private static final int DEFAULT_SAMPLESIZE = 1;
	
	private int sampleSize = DEFAULT_SAMPLESIZE;
	
	public void setSampleSize(int sampleSize) {
		this.sampleSize = sampleSize;
	}
	public int getSampleSize() {
		return this.sampleSize;
	}
		
}
