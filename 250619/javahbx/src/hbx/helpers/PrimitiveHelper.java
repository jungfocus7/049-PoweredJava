package hbx.helpers;

public final class PrimitiveHelper {
	private PrimitiveHelper() {
	}

	public static Byte[] toByteArray(byte[] arr) {
		if ((arr == null) || (arr.length == 0)) {
			return null;
		}

		int l = arr.length;
		Byte[] rra = new Byte[l];

		for (int i = 0; i < l; i++) {
			rra[i] = Byte.valueOf(arr[i]);
		}

		return rra;
	}

	public static Short[] toShortArray(short[] arr) {
		if ((arr == null) || (arr.length == 0)) {
			return null;
		}

		int l = arr.length;
		Short[] rra = new Short[l];

		for (int i = 0; i < l; i++) {
			rra[i] = Short.valueOf(arr[i]);
		}

		return rra;
	}

	public static Integer[] toIntegerArray(int[] arr) {
		if ((arr == null) || (arr.length == 0)) {
			return null;
		}

		int l = arr.length;
		Integer[] rra = new Integer[l];

		for (int i = 0; i < l; i++) {
			rra[i] = Integer.valueOf(arr[i]);
		}

		return rra;
	}

	public static Long[] toLongArray(long[] arr) {
		if ((arr == null) || (arr.length == 0)) {
			return null;
		}

		int l = arr.length;
		Long[] rra = new Long[l];

		for (int i = 0; i < l; i++) {
			rra[i] = Long.valueOf(arr[i]);
		}

		return rra;
	}

	public static Float[] toFloatArray(float[] arr) {
		if ((arr == null) || (arr.length == 0)) {
			return null;
		}

		int l = arr.length;
		Float[] rra = new Float[l];

		for (int i = 0; i < l; i++) {
			rra[i] = Float.valueOf(arr[i]);
		}

		return rra;
	}

	public static Double[] toDoubleArray(double[] arr) {
		if ((arr == null) || (arr.length == 0)) {
			return null;
		}

		int l = arr.length;
		Double[] rra = new Double[l];

		for (int i = 0; i < l; i++) {
			rra[i] = Double.valueOf(arr[i]);
		}

		return rra;
	}

	public static Character[] toCharacterArray(char[] arr) {
		if ((arr == null) || (arr.length == 0)) {
			return null;
		}

		int l = arr.length;
		Character[] rra = new Character[l];

		for (int i = 0; i < l; i++) {
			rra[i] = Character.valueOf(arr[i]);
		}

		return rra;
	}

	public static Boolean[] toBooleanArray(boolean[] arr) {
		if ((arr == null) || (arr.length == 0)) {
			return null;
		}

		int l = arr.length;
		Boolean[] rra = new Boolean[l];

		for (int i = 0; i < l; i++) {
			rra[i] = Boolean.valueOf(arr[i]);
		}

		return rra;
	}
}
