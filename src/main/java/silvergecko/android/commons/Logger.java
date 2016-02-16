package silvergecko.android.commons;

import android.util.Log;
/**
 * 
 * Wrapper class for LogCat logging.
 *
 */
public class Logger {
	
	private static int LOG_LEVEL = Log.VERBOSE;
	
	private static final boolean VERBOSE = LOG_LEVEL <= Log.VERBOSE;
	private static final boolean DEBUG = LOG_LEVEL <= Log.DEBUG;
	private static final boolean INFO = LOG_LEVEL <= Log.INFO;
	private static final boolean WARN = LOG_LEVEL <= Log.WARN;
	private static final boolean ERROR = LOG_LEVEL <= Log.ERROR;
	private static final boolean ASSERT = LOG_LEVEL <= Log.ASSERT;
	
	/**
	 * Calls android log method with some formatting.
	 * If level is less than current log level, the log is not written. See setLoggingLevel() for setting current log level
	 * @param tag classname of the caller
	 * @param method caller method
	 * @param msg message
	 * @param level log level
	 */
	public static void log(String tag, String method, String msg, int level) {
		switch(level) {
			case Log.VERBOSE:
				if (VERBOSE) Log.v(tag, "[" + method + "] " + msg);
				break;
			case Log.DEBUG:
				if (DEBUG) Log.d(tag, "[" + method + "] " + msg);
				break;
			case Log.INFO:
				if (INFO) Log.i(tag, "[" + method + "] " + msg);
				break;
			case Log.WARN:
				if (WARN) Log.w(tag, "[" + method + "] " + msg);
				break;
			case Log.ERROR:
				if (ERROR) Log.e(tag, "[" + method + "] " + msg);
				break;
			case Log.ASSERT:
				if (ASSERT) Log.wtf(tag, "[" + method + "] " + msg);
				break;
		}
	}
	
	/**
	 * Calls android log method with some formatting, passing Log.INFO as default level
	 * @param tag classname of the caller
	 * @param method caller method
	 * @param msg message
	 */
	public static void log(String tag, String method, String msg) {
		log(tag, method, msg, Log.INFO);
	}
	
	/**
	 * Statically sets the maximum logging level allowed.
	 * @param newLevel log level
	 */
	public static void setLoggingLevel (int newLevel) {
		LOG_LEVEL = newLevel;
	}
	
}
