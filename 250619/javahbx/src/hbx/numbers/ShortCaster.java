package hbx.numbers;

public final class ShortCaster {
	public static final short max = Short.MAX_VALUE;
	public static final short min = Short.MIN_VALUE;

	public static short from(int vn) {
		if (vn > max) {
			return max;
		}
		else if (vn < min) {
			return min;
		}
		else {
			return (short)vn;
		}
	}

	public static short from(long vl) {
		if (vl > max) {
			return max;
		}
		else if (vl < min) {
			return min;
		}
		else {
			return (short)vl;
		}
	}

	public static short from(byte vb) {
		return vb;
	}

	public static short from(double vd) {
		if (vd > max) {
			return max;
		}
		else if (vd < min) {
			return min;
		}
		else {
			return (short)vd;
		}
	}

	public static short from(float vf) {
		if (vf > max) {
			return max;
		}
		else if (vf < min) {
			return min;
		}
		else {
			return (short)vf;
		}
	}
}
