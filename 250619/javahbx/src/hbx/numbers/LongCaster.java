package hbx.numbers;

public final class LongCaster {
	public static final long max = Long.MAX_VALUE;
	public static final long min = Long.MIN_VALUE;

	public static long from(int vn) {
		return vn;
	}

	public static long from(short vs) {
		return vs;
	}

	public static long from(byte vb) {
		return vb;
	}

	public static long from(double vd) {
		if (vd > max) {
			return max;
		}
		else if (vd < min) {
			return min;
		}
		else {
			return (long)vd;
		}
	}

	public static long from(float vf) {
		if (vf > max) {
			return max;
		}
		else if (vf < min) {
			return min;
		}
		else {
			return (long)vf;
		}
	}
}
