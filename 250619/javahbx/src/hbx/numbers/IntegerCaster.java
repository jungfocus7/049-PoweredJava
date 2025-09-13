package hbx.numbers;

public final class IntegerCaster {
	public static final int max = Integer.MAX_VALUE;
	public static final int min = Integer.MIN_VALUE;

	public static int from(long vf) {
		if (vf > max) {
			return max;
		}
		else if (vf < min) {
			return min;
		}
		else {
			return (int)vf;
		}
	}

	public static int from(short vs) {
		return vs;
	}

	public static int from(byte vb) {
		return vb;
	}

	public static int from(double vd) {
		if (vd > max) {
			return max;
		}
		else if (vd < min) {
			return min;
		}
		else {
			return (int)vd;
		}
	}

	public static int from(float vf) {
		if (vf > max) {
			return max;
		}
		else if (vf < min) {
			return min;
		}
		else {
			return (int)vf;
		}
	}
}
