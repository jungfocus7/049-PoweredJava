package hbx.numbers;

public final class DoubleCaster {
	public static final double max = Double.MAX_VALUE;
	public static final double min = -Double.MAX_VALUE;

	public static double from(int vn) {
		return vn;
	}

	public static double from(long vf) {
		return vf;
	}

	public static double from(short vs) {
		return vs;
	}

	public static double from(byte vb) {
		return vb;
	}

	public static double from(float vs) {
		return vs;
	}
}
