package hbx.helpers;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;


public final class ReflectionHelper {
	private ReflectionHelper() {
	}

	public static void pushPublicConstantNames(List<String> lst, Class<?> cls, String pr) {
		Field[] fda = cls.getDeclaredFields();
		if ((fda == null) || (fda.length == 0)) {
			return;
		}

		for (Field fd : fda) {
			int md = fd.getModifiers();
			if (Modifier.isPublic(md) && Modifier.isStatic(md) && Modifier.isFinal(md)) {
				String fnm = fd.getName();
				if (pr != null) {
					if (fnm.startsWith(pr)) {
						lst.add(fnm);
					}
				}
				else {
					lst.add(fnm);
				}
			}
		}
	}

	public static List<String> getPublicConstantNames(Class<?> cls, String pr) {
		List<String> lst = new ArrayList<String>();
		pushPublicConstantNames(lst, cls, pr);

		return lst;
	}

}
