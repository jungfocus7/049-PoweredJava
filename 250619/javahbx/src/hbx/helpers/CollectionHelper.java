package hbx.helpers;

import java.util.Collection;
import java.util.List;


public final class CollectionHelper {
	private CollectionHelper() { }

	public static <T> boolean isEmpty(Collection<T> clt) {
		return (clt == null) || (clt.size() == 0);
	}

	public static <T> boolean isNotEmpty(Collection<T> clt) {
		return (clt != null) && (clt.size() > 0);
	}

	public static <T> T get(List<T> lst, int i, T d) {
		if (isNotEmpty(lst)) {
			if ((i >= 0) && (i < lst.size())) {
				return lst.get(i);
			}
			else {
				return d;
			}
		}
		else {
			return d;
		}
	}

	public static <T> T get(List<T> p_lst, int i) {
		return get(p_lst, i, null);
	}
}
