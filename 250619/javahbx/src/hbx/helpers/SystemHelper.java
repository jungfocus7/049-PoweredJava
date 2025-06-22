package hbx.helpers;

import java.io.Closeable;
import java.util.Collection;

import hbx.core.Clearable;


public final class SystemHelper {
	private SystemHelper() { }

	/**
	 * GC 호출 (특별한 경우만 사용)
	 */
	public static void gc() {
		System.gc();
	}

	/**
	 * 객체 정리 (java.core)
	 * @param cl Closeable
	 */
	public static void close(Closeable cl) {
		try {
			cl.close();
		}
		catch (Exception ex) {
		}
	}

	/**
	 * 컬렉션에서 객체 정리 (java.core)
	 * @param objs
	 */
	public static void closeAll(Collection<Object> objs) {
		for (Object obj : objs) {
			if (obj instanceof Closeable) {
				close((Closeable)obj);
			}
		}
	}

	/**
	 * 객체 정리 (hbx)
	 * @param cl Clearable
	 */
	public static void clear(Clearable cl) {
		cl.clear();
	}

	/**
	 * 컬렉션에서 객체 정리 (hbx)
	 * @param objs
	 */
	public static void clearAll(Collection<Object> objs) {
		for (Object obj : objs) {
			if (obj instanceof Clearable) {
				clear((Clearable)obj);
			}
		}
	}

	/**
	 * 객체를 확인하여 정리하기 (hbx)
	 * @param obj Object
	 */
	public static void dispose(Object obj) {
		if (obj instanceof Closeable) {
			close((Closeable)obj);
		}
		else if (obj instanceof Clearable) {
			clear((Clearable)obj);
		}
	}

	/**
	 * 객체를 확인하여 모두 정리하기 (hbx)
	 * @param obj Object
	 */
	public static void disposeAll(Collection<Object> objs) {
		for (Object obj : objs) {
			dispose(obj);
		}
	}
}
