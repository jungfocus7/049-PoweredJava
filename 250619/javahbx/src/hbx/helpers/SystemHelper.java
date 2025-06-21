package hbx.helpers;

import java.io.Closeable;
import java.io.IOException;


public final class SystemHelper {
	private SystemHelper() { }

	public static void gc() {
		System.gc();
	}

	public static void close(Closeable cl) {
		try {
			cl.close();
		}
		catch (IOException ex) {
		}
	}
}
