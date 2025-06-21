package hbx.helpers;

import java.io.Closeable;
import java.io.IOException;


public final class GCHelper {
	private GCHelper() { }

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
