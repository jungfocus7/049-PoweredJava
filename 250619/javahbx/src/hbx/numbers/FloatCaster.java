package hbx.numbers;

public final class FloatCaster {
	public static final float max = Float.MAX_VALUE;
	public static final float min = -Float.MAX_VALUE;

	public static float from(int vn) {
		return vn;
	}

	public static float from(long vf) {
		return vf;
	}

	public static float from(short vs) {
		return vs;
	}

	public static float from(byte vb) {
		return vb;
	}

	public static float from(double vd) {
		if (vd > max) {
			return max;
		}
		else if (vd < min) {
			return min;
		}
		else {
			return (float)vd;
		}
	}
}
