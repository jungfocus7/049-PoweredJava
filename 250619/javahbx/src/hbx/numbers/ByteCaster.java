package hbx.numbers;

public final class ByteCaster {
	public static final byte max = Byte.MAX_VALUE;
	public static final byte min = Byte.MIN_VALUE;

	public static byte from(int vn) {
		if (vn > max) {
			return max;
		}
		else if (vn < min) {
			return min;
		}
		else {
			return (byte)vn;
		}
	}

	public static byte from(long vl) {
		if (vl > max) {
			return max;
		}
		else if (vl < min) {
			return min;
		}
		else {
			return (byte)vl;
		}
	}

	public static byte from(short vs) {
		if (vs > max) {
			return max;
		}
		else if (vs < min) {
			return min;
		}
		else {
			return (byte)vs;
		}
	}

	public static byte from(double vd) {
		if (vd > max) {
			return max;
		}
		else if (vd < min) {
			return min;
		}
		else {
			return (byte)vd;
		}
	}

	public static byte from(float vf) {
		if (vf > max) {
			return max;
		}
		else if (vf < min) {
			return min;
		}
		else {
			return (byte)vf;
		}
	}
}
