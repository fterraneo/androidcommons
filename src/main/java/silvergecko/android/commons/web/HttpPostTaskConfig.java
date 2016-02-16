package silvergecko.android.commons.web;

public class HttpPostTaskConfig {
	
	static final String TAG = "HttpPostTaskConfig";
	
	private static final int DEFAULT_SO_TIMEOUT = 20000;
	private static final int DEFAULT_CONN_TIMEOUT = 20000;
	private static final String DEFAULT_CONTENT_TYPE = "application/x-www-form-urlencoded";
	
	private int socketTimeout, connectionTimeout;
	private String contentType;
	
	public HttpPostTaskConfig() {
		socketTimeout = DEFAULT_SO_TIMEOUT;
		connectionTimeout = DEFAULT_CONN_TIMEOUT;
		contentType = DEFAULT_CONTENT_TYPE;
	}
	
	public void setSoTimeout(int soTimeout) {
		this.socketTimeout = soTimeout;
	}
	public void setConnTimeout(int connTimeout) {
		this.connectionTimeout = connTimeout;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public int getSoTimeout() {
		return this.socketTimeout;
	}
	public int getConnTimeout() {
		return this.connectionTimeout;
	}
	public String getContentType() {
		return this.contentType;
	}
}
