import hbx.helpers.StringHelper;
import hbx.numbers.ByteCaster;
import hbx.numbers.DoubleCaster;
import hbx.numbers.FloatCaster;
import hbx.numbers.IntegerCaster;
import hbx.numbers.LongCaster;
import hbx.numbers.ShortCaster;

public final class TesterConsole51 {
	private static void println(String msg) {
		System.out.println(msg);
	}

	private static void testInteger() {
		println("IntegerCaster.from(DoubleCaster.max) >> " + IntegerCaster.from(DoubleCaster.max));
		println("IntegerCaster.from(DoubleCaster.min) >> " + IntegerCaster.from(DoubleCaster.min));
		println("IntegerCaster.from(FloatCaster.max) >> " + IntegerCaster.from(FloatCaster.max));
		println("IntegerCaster.from(FloatCaster.min) >> " + IntegerCaster.from(FloatCaster.min));
		println("IntegerCaster.from(LongCaster.max) >> " + IntegerCaster.from(LongCaster.max));
		println("IntegerCaster.from(LongCaster.min) >> " + IntegerCaster.from(LongCaster.min));
		println("IntegerCaster.from(ShortCaster.max) >> " + IntegerCaster.from(ShortCaster.max));
		println("IntegerCaster.from(ShortCaster.min) >> " + IntegerCaster.from(ShortCaster.min));
		println("IntegerCaster.from(ByteCaster.max) >> " + IntegerCaster.from(ByteCaster.max));
		println("IntegerCaster.from(ByteCaster.min) >> " + IntegerCaster.from(ByteCaster.min));
		println(StringHelper.empty);
		println(StringHelper.empty);

		println(">> " + IntegerCaster.from(Double.POSITIVE_INFINITY));
		println(">> " + IntegerCaster.from(Double.NEGATIVE_INFINITY));
		println(">> " + IntegerCaster.from(Double.NaN));
		println(">> " + IntegerCaster.from(Double.MAX_VALUE));
		println(">> " + IntegerCaster.from(Double.MIN_NORMAL));
		println(">> " + IntegerCaster.from(Double.MIN_VALUE));
		println(StringHelper.empty);

		println(">> " + IntegerCaster.from(Float.POSITIVE_INFINITY));
		println(">> " + IntegerCaster.from(Float.NEGATIVE_INFINITY));
		println(">> " + IntegerCaster.from(Float.NaN));
		println(">> " + IntegerCaster.from(Float.MAX_VALUE));
		println(">> " + IntegerCaster.from(Float.MIN_NORMAL));
		println(">> " + IntegerCaster.from(Float.MIN_VALUE));
		println(StringHelper.empty);
	}

	private static void testLong() {
		println("LongCaster.from(DoubleCaster.max) >> " + LongCaster.from(DoubleCaster.max));
		println("LongCaster.from(DoubleCaster.min) >> " + LongCaster.from(DoubleCaster.min));
		println("LongCaster.from(FloatCaster.max) >> " + LongCaster.from(FloatCaster.max));
		println("LongCaster.from(FloatCaster.min) >> " + LongCaster.from(FloatCaster.min));
		println("LongCaster.from(IntegerCaster.max) >> " + LongCaster.from(IntegerCaster.max));
		println("LongCaster.from(IntegerCaster.min) >> " + LongCaster.from(IntegerCaster.min));
		println("LongCaster.from(ShortCaster.max) >> " + LongCaster.from(ShortCaster.max));
		println("LongCaster.from(ShortCaster.min) >> " + LongCaster.from(ShortCaster.min));
		println("LongCaster.from(ByteCaster.max) >> " + LongCaster.from(ByteCaster.max));
		println("LongCaster.from(ByteCaster.min) >> " + LongCaster.from(ByteCaster.min));
		println(StringHelper.empty);
		println(StringHelper.empty);

		println(">> " + LongCaster.from(Double.POSITIVE_INFINITY));
		println(">> " + LongCaster.from(Double.NEGATIVE_INFINITY));
		println(">> " + LongCaster.from(Double.NaN));
		println(">> " + LongCaster.from(Double.MAX_VALUE));
		println(">> " + LongCaster.from(Double.MIN_NORMAL));
		println(">> " + LongCaster.from(Double.MIN_VALUE));
		println(StringHelper.empty);

		println(">> " + LongCaster.from(Float.POSITIVE_INFINITY));
		println(">> " + LongCaster.from(Float.NEGATIVE_INFINITY));
		println(">> " + LongCaster.from(Float.NaN));
		println(">> " + LongCaster.from(Float.MAX_VALUE));
		println(">> " + LongCaster.from(Float.MIN_NORMAL));
		println(">> " + LongCaster.from(Float.MIN_VALUE));
		println(StringHelper.empty);
	}

	private static void testShort() {
		println("ShortCaster.from(DoubleCaster.max) >> " + ShortCaster.from(DoubleCaster.max));
		println("ShortCaster.from(DoubleCaster.min) >> " + ShortCaster.from(DoubleCaster.min));
		println("ShortCaster.from(FloatCaster.max) >> " + ShortCaster.from(FloatCaster.max));
		println("ShortCaster.from(FloatCaster.min) >> " + ShortCaster.from(FloatCaster.min));
		println("ShortCaster.from(IntegerCaster.max) >> " + ShortCaster.from(IntegerCaster.max));
		println("ShortCaster.from(IntegerCaster.min) >> " + ShortCaster.from(IntegerCaster.min));
		println("ShortCaster.from(LongCaster.max) >> " + ShortCaster.from(LongCaster.max));
		println("ShortCaster.from(LongCaster.min) >> " + ShortCaster.from(LongCaster.min));
		println("ShortCaster.from(ByteCaster.max) >> " + ShortCaster.from(ByteCaster.max));
		println("ShortCaster.from(ByteCaster.min) >> " + ShortCaster.from(ByteCaster.min));
		println(StringHelper.empty);
		println(StringHelper.empty);

		println(">> " + ShortCaster.from(Double.POSITIVE_INFINITY));
		println(">> " + ShortCaster.from(Double.NEGATIVE_INFINITY));
		println(">> " + ShortCaster.from(Double.NaN));
		println(">> " + ShortCaster.from(Double.MAX_VALUE));
		println(">> " + ShortCaster.from(Double.MIN_NORMAL));
		println(">> " + ShortCaster.from(Double.MIN_VALUE));
		println(StringHelper.empty);

		println(">> " + ShortCaster.from(Float.POSITIVE_INFINITY));
		println(">> " + ShortCaster.from(Float.NEGATIVE_INFINITY));
		println(">> " + ShortCaster.from(Float.NaN));
		println(">> " + ShortCaster.from(Float.MAX_VALUE));
		println(">> " + ShortCaster.from(Float.MIN_NORMAL));
		println(">> " + ShortCaster.from(Float.MIN_VALUE));
		println(StringHelper.empty);
	}

	private static void testByte() {
		println("ByteCaster.from(DoubleCaster.max) >> " + ByteCaster.from(DoubleCaster.max));
		println("ByteCaster.from(DoubleCaster.min) >> " + ByteCaster.from(DoubleCaster.min));
		println("ByteCaster.from(FloatCaster.max) >> " + ByteCaster.from(FloatCaster.max));
		println("ByteCaster.from(FloatCaster.min) >> " + ByteCaster.from(FloatCaster.min));
		println("ByteCaster.from(IntegerCaster.max) >> " + ByteCaster.from(IntegerCaster.max));
		println("ByteCaster.from(IntegerCaster.min) >> " + ByteCaster.from(IntegerCaster.min));
		println("ByteCaster.from(LongCaster.max) >> " + ByteCaster.from(LongCaster.max));
		println("ByteCaster.from(LongCaster.min) >> " + ByteCaster.from(LongCaster.min));
		println("ByteCaster.from(ShortCaster.max) >> " + ByteCaster.from(ShortCaster.max));
		println("ByteCaster.from(ShortCaster.min) >> " + ByteCaster.from(ShortCaster.min));
		println(StringHelper.empty);
		println(StringHelper.empty);

		println(">> " + ByteCaster.from(Double.POSITIVE_INFINITY));
		println(">> " + ByteCaster.from(Double.NEGATIVE_INFINITY));
		println(">> " + ByteCaster.from(Double.NaN));
		println(">> " + ByteCaster.from(Double.MAX_VALUE));
		println(">> " + ByteCaster.from(Double.MIN_NORMAL));
		println(">> " + ByteCaster.from(Double.MIN_VALUE));
		println(StringHelper.empty);

		println(">> " + ByteCaster.from(Float.POSITIVE_INFINITY));
		println(">> " + ByteCaster.from(Float.NEGATIVE_INFINITY));
		println(">> " + ByteCaster.from(Float.NaN));
		println(">> " + ByteCaster.from(Float.MAX_VALUE));
		println(">> " + ByteCaster.from(Float.MIN_NORMAL));
		println(">> " + ByteCaster.from(Float.MIN_VALUE));
		println(StringHelper.empty);
	}

	private static void testDouble() {
		println("DoubleCaster.from(FloatCaster.max) >> " + DoubleCaster.from(FloatCaster.max));
		println("DoubleCaster.from(FloatCaster.min) >> " + DoubleCaster.from(FloatCaster.min));
		println("DoubleCaster.from(IntegerCaster.max) >> " + DoubleCaster.from(IntegerCaster.max));
		println("DoubleCaster.from(IntegerCaster.min) >> " + DoubleCaster.from(IntegerCaster.min));
		println("DoubleCaster.from(LongCaster.max) >> " + DoubleCaster.from(LongCaster.max));
		println("DoubleCaster.from(LongCaster.min) >> " + DoubleCaster.from(LongCaster.min));
		println("DoubleCaster.from(ShortCaster.max) >> " + DoubleCaster.from(ShortCaster.max));
		println("DoubleCaster.from(ShortCaster.min) >> " + DoubleCaster.from(ShortCaster.min));
		println("DoubleCaster.from(ByteCaster.max) >> " + DoubleCaster.from(ByteCaster.max));
		println("DoubleCaster.from(ByteCaster.min) >> " + DoubleCaster.from(ByteCaster.min));
		println(StringHelper.empty);
		println(StringHelper.empty);

		println(">> " + DoubleCaster.from(Float.POSITIVE_INFINITY));
		println(">> " + DoubleCaster.from(Float.NEGATIVE_INFINITY));
		println(">> " + DoubleCaster.from(Float.NaN));
		println(">> " + DoubleCaster.from(Float.MAX_VALUE));
		println(">> " + DoubleCaster.from(Float.MIN_NORMAL));
		println(">> " + DoubleCaster.from(Float.MIN_VALUE));
		println(StringHelper.empty);
	}

	private static void testFloat() {
		println("FloatCaster.from(DoubleCaster.max) >> " + FloatCaster.from(DoubleCaster.max));
		println("FloatCaster.from(DoubleCaster.min) >> " + FloatCaster.from(DoubleCaster.min));
		println("FloatCaster.from(IntegerCaster.max) >> " + FloatCaster.from(IntegerCaster.max));
		println("FloatCaster.from(IntegerCaster.min) >> " + FloatCaster.from(IntegerCaster.min));
		println("FloatCaster.from(LongCaster.max) >> " + FloatCaster.from(LongCaster.max));
		println("FloatCaster.from(LongCaster.min) >> " + FloatCaster.from(LongCaster.min));
		println("FloatCaster.from(ShortCaster.max) >> " + FloatCaster.from(ShortCaster.max));
		println("FloatCaster.from(ShortCaster.min) >> " + FloatCaster.from(ShortCaster.min));
		println("FloatCaster.from(ByteCaster.max) >> " + FloatCaster.from(ByteCaster.max));
		println("FloatCaster.from(ByteCaster.min) >> " + FloatCaster.from(ByteCaster.min));
		println(StringHelper.empty);
		println(StringHelper.empty);

		println(">> " + ByteCaster.from(Double.POSITIVE_INFINITY));
		println(">> " + ByteCaster.from(Double.NEGATIVE_INFINITY));
		println(">> " + ByteCaster.from(Double.NaN));
		println(">> " + ByteCaster.from(Double.MAX_VALUE));
		println(">> " + ByteCaster.from(Double.MIN_NORMAL));
		println(">> " + ByteCaster.from(Double.MIN_VALUE));
		println(StringHelper.empty);
	}

//	private static void __test_etc() {
//		println(">> " + ByteCaster.from(Float.POSITIVE_INFINITY));
//		println(">> " + ByteCaster.from(Float.NEGATIVE_INFINITY));
//		println(">> " + ByteCaster.from(Float.BYTES));
//		println(">> " + ByteCaster.from(Float.MAX_EXPONENT));
//		println(">> " + ByteCaster.from(Float.NaN));
//	}

	public static void main(String[] args) {
		testInteger();
		testLong();
		testShort();
		testByte();
		testDouble();
		testFloat();

//		__test_etc();
	}














//	short vs = 30;
//	int vn = IntegerCaster.from(DoubleCaster.max);




//	println("DoubleCaster.toInt(Double.MAX_VALUE) >> " + DoubleCaster.toInt(Double.MAX_VALUE));
//	println("DoubleCaster.toInt(Double.MIN_VALUE) >> " + DoubleCaster.toInt(Double.MIN_VALUE));
//	println("DoubleCaster.toInt(Double.MIN_NORMAL) >> " + DoubleCaster.toInt(Double.MIN_NORMAL));
//	println("DoubleCaster.toInt(Double.NaN) >> " + DoubleCaster.toInt(Double.NaN));
//	println("DoubleCaster.toInt(Double.NEGATIVE_INFINITY) >> " + DoubleCaster.toInt(Double.NEGATIVE_INFINITY));
//	println("DoubleCaster.toInt(Double.POSITIVE_INFINITY) >> " + DoubleCaster.toInt(Double.POSITIVE_INFINITY));
//	println("");
//
//	println("DoubleCaster.toLong(Double.MAX_VALUE) >> " + DoubleCaster.toLong(Double.MAX_VALUE));
//	println("DoubleCaster.toLong(Double.MIN_VALUE) >> " + DoubleCaster.toLong(Double.MIN_VALUE));
//	println("DoubleCaster.toLong(Double.MIN_NORMAL) >> " + DoubleCaster.toLong(Double.MIN_NORMAL));
//	println("DoubleCaster.toLong(Double.NaN) >> " + DoubleCaster.toLong(Double.NaN));
//	println("DoubleCaster.toLong(Double.NEGATIVE_INFINITY) >> " + DoubleCaster.toLong(Double.NEGATIVE_INFINITY));
//	println("DoubleCaster.toLong(Double.POSITIVE_INFINITY) >> " + DoubleCaster.toLong(Double.POSITIVE_INFINITY));
//	println("");
//
//	println("DoubleCaster.toShort(Double.MAX_VALUE) >> " + DoubleCaster.toShort(Double.MAX_VALUE));
//	println("DoubleCaster.toShort(Double.MIN_VALUE) >> " + DoubleCaster.toShort(Double.MIN_VALUE));
//	println("DoubleCaster.toShort(Double.MIN_NORMAL) >> " + DoubleCaster.toShort(Double.MIN_NORMAL));
//	println("DoubleCaster.toShort(Double.NaN) >> " + DoubleCaster.toShort(Double.NaN));
//	println("DoubleCaster.toShort(Double.NEGATIVE_INFINITY) >> " + DoubleCaster.toShort(Double.NEGATIVE_INFINITY));
//	println("DoubleCaster.toShort(Double.POSITIVE_INFINITY) >> " + DoubleCaster.toShort(Double.POSITIVE_INFINITY));
//	println("");
//
//	println("DoubleCaster.toFloat(Double.MAX_VALUE) >> " + DoubleCaster.toFloat(Double.MAX_VALUE));
//	println("DoubleCaster.toFloat(Double.MIN_VALUE) >> " + DoubleCaster.toFloat(Double.MIN_VALUE));
//	println("DoubleCaster.toFloat(Double.MIN_NORMAL) >> " + DoubleCaster.toFloat(Double.MIN_NORMAL));
//	println("DoubleCaster.toFloat(Double.NaN) >> " + DoubleCaster.toFloat(Double.NaN));
//	println("DoubleCaster.toFloat(Double.NEGATIVE_INFINITY) >> " + DoubleCaster.toFloat(Double.NEGATIVE_INFINITY));
//	println("DoubleCaster.toFloat(Double.POSITIVE_INFINITY) >> " + DoubleCaster.toFloat(Double.POSITIVE_INFINITY));
//	println(">>>> >> " + DoubleCaster.toFloat(-3123.4444));
//	println("");
//
//	println("DoubleCaster.toByte(Double.MAX_VALUE) >> " + DoubleCaster.toByte(Double.MAX_VALUE));
//	println("DoubleCaster.toByte(Double.MIN_VALUE) >> " + DoubleCaster.toByte(Double.MIN_VALUE));
//	println("DoubleCaster.toByte(Double.MIN_NORMAL) >> " + DoubleCaster.toByte(Double.MIN_NORMAL));
//	println("DoubleCaster.toByte(Double.NaN) >> " + DoubleCaster.toByte(Double.NaN));
//	println("DoubleCaster.toByte(Double.NEGATIVE_INFINITY) >> " + DoubleCaster.toByte(Double.NEGATIVE_INFINITY));
//	println("DoubleCaster.toByte(Double.POSITIVE_INFINITY) >> " + DoubleCaster.toByte(Double.POSITIVE_INFINITY));
//	println("");





//	public static void main(String[] args) {
//		println("DoubleCaster.toInt(Double.MAX_VALUE) >> " + DoubleCaster.toInt(Double.MAX_VALUE));
//		println("DoubleCaster.toInt(Double.MIN_VALUE) >> " + DoubleCaster.toInt(Double.MIN_VALUE));
//		println("DoubleCaster.toInt(Double.MIN_NORMAL) >> " + DoubleCaster.toInt(Double.MIN_NORMAL));
//		println("DoubleCaster.toInt(Double.NaN) >> " + DoubleCaster.toInt(Double.NaN));
//		println("DoubleCaster.toInt(Double.NEGATIVE_INFINITY) >> " + DoubleCaster.toInt(Double.NEGATIVE_INFINITY));
//		println("DoubleCaster.toInt(Double.POSITIVE_INFINITY) >> " + DoubleCaster.toInt(Double.POSITIVE_INFINITY));
//		println("");
//
//		println("DoubleCaster.toLong(Double.MAX_VALUE) >> " + DoubleCaster.toLong(Double.MAX_VALUE));
//		println("DoubleCaster.toLong(Double.MIN_VALUE) >> " + DoubleCaster.toLong(Double.MIN_VALUE));
//		println("DoubleCaster.toLong(Double.MIN_NORMAL) >> " + DoubleCaster.toLong(Double.MIN_NORMAL));
//		println("DoubleCaster.toLong(Double.NaN) >> " + DoubleCaster.toLong(Double.NaN));
//		println("DoubleCaster.toLong(Double.NEGATIVE_INFINITY) >> " + DoubleCaster.toLong(Double.NEGATIVE_INFINITY));
//		println("DoubleCaster.toLong(Double.POSITIVE_INFINITY) >> " + DoubleCaster.toLong(Double.POSITIVE_INFINITY));
//		println("");
//
//		println("DoubleCaster.toShort(Double.MAX_VALUE) >> " + DoubleCaster.toShort(Double.MAX_VALUE));
//		println("DoubleCaster.toShort(Double.MIN_VALUE) >> " + DoubleCaster.toShort(Double.MIN_VALUE));
//		println("DoubleCaster.toShort(Double.MIN_NORMAL) >> " + DoubleCaster.toShort(Double.MIN_NORMAL));
//		println("DoubleCaster.toShort(Double.NaN) >> " + DoubleCaster.toShort(Double.NaN));
//		println("DoubleCaster.toShort(Double.NEGATIVE_INFINITY) >> " + DoubleCaster.toShort(Double.NEGATIVE_INFINITY));
//		println("DoubleCaster.toShort(Double.POSITIVE_INFINITY) >> " + DoubleCaster.toShort(Double.POSITIVE_INFINITY));
//		println("");
//
//		println("DoubleCaster.toFloat(Double.MAX_VALUE) >> " + DoubleCaster.toFloat(Double.MAX_VALUE));
//		println("DoubleCaster.toFloat(Double.MIN_VALUE) >> " + DoubleCaster.toFloat(Double.MIN_VALUE));
//		println("DoubleCaster.toFloat(Double.MIN_NORMAL) >> " + DoubleCaster.toFloat(Double.MIN_NORMAL));
//		println("DoubleCaster.toFloat(Double.NaN) >> " + DoubleCaster.toFloat(Double.NaN));
//		println("DoubleCaster.toFloat(Double.NEGATIVE_INFINITY) >> " + DoubleCaster.toFloat(Double.NEGATIVE_INFINITY));
//		println("DoubleCaster.toFloat(Double.POSITIVE_INFINITY) >> " + DoubleCaster.toFloat(Double.POSITIVE_INFINITY));
//		println(">>>> >> " + DoubleCaster.toFloat(-3123.4444));
//		println("");
//
//		println("DoubleCaster.toByte(Double.MAX_VALUE) >> " + DoubleCaster.toByte(Double.MAX_VALUE));
//		println("DoubleCaster.toByte(Double.MIN_VALUE) >> " + DoubleCaster.toByte(Double.MIN_VALUE));
//		println("DoubleCaster.toByte(Double.MIN_NORMAL) >> " + DoubleCaster.toByte(Double.MIN_NORMAL));
//		println("DoubleCaster.toByte(Double.NaN) >> " + DoubleCaster.toByte(Double.NaN));
//		println("DoubleCaster.toByte(Double.NEGATIVE_INFINITY) >> " + DoubleCaster.toByte(Double.NEGATIVE_INFINITY));
//		println("DoubleCaster.toByte(Double.POSITIVE_INFINITY) >> " + DoubleCaster.toByte(Double.POSITIVE_INFINITY));
//		println("");
//	}










//	private static short toShort(double vd) {
//		if (vd > Short.MAX_VALUE) {
//			return Short.MAX_VALUE;
//		}
//		else if (vd < Short.MIN_VALUE) {
//			return Short.MIN_VALUE;
//		}
//		else {
//			return (short)vd;
//		}
//	}

//	public static void main(String[] args) {
//		println("toByte(Double.MAX_VALUE) >> " + DoubleCaster.toByte(Double.MAX_VALUE));
//		println("toByte(Double.MIN_VALUE) >> " + DoubleCaster.toByte(Double.MIN_VALUE));
//		println("toByte(Double.MIN_NORMAL) >> " + DoubleCaster.toByte(Double.MIN_NORMAL));
//		println("toByte(Double.MIN_NORMAL) >> " + DoubleCaster.toByte(Double.MIN_NORMAL));
//
//
//
//
///*
//		boolean bx = Double.MIN_VALUE < -100.0d;
//		boolean by = Double.MIN_VALUE < Short.MIN_VALUE;
//		boolean bz = Double.MIN_VALUE < Double.MAX_VALUE;
//
//
//
//		short vs;
//
//		vs = toShort(Double.MAX_VALUE);
//		System.out.println(":: " + vs);
//
//		vs = toShort(Double.MIN_VALUE);
//		System.out.println(":: " + vs);
//
//		vs = toShort(Double.MIN_NORMAL);
//		System.out.println(":: " + vs);
//
//		vs = toShort(Double.NaN);
//		System.out.println(":: " + vs);
//
//		vs = toShort(Double.NEGATIVE_INFINITY);
//		System.out.println(":: " + vs);
//
//		vs = toShort(Double.POSITIVE_INFINITY);
//		System.out.println(":: " + vs);
//*/
//
//	}

}




