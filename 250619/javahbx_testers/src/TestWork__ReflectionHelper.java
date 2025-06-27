import java.util.List;

import hbx.helpers.ReflectionHelper;
import helpers.TesterHelper;


public final class TestWork__ReflectionHelper {
	private TestWork__ReflectionHelper() {
	}

	public static final String PN_NAME = "박종명";
	public static final String PN_AGE = "37";
	public static final String PN_EMAIL = "pool61@naver.com";
	private static final String PN_XXX2 = "pool61@naver.com";
	public static final String GT_XXX2 = "pool61@naver.com";

	private static void test30() {
		List<String> lst = ReflectionHelper.getPublicConstantNames(TesterProgram.class, "PN_");
		TesterHelper.println(">>>");
	}

	private static void test31() {
	}

	public static void testAll() {
		test30();

		test31();
	}
}
