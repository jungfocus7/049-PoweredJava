package hbx.helpers;

import java.util.Collection;
import java.util.List;


public final class CollectionHelper {
	private CollectionHelper() {
	}

	/**
	 * 컬렉션객체가 비어있는지 확인
	 * @param <T>
	 * @param clt Collection
	 * @return
	 */
	public static <T> boolean isEmpty(Collection<T> clt) {
		return (clt == null) || (clt.size() == 0);
	}

	/**
	 * 컬렉션객체가 유효한지 확인
	 * @param <T>
	 * @param clt Collection
	 * @return
	 */
	public static <T> boolean isNotEmpty(Collection<T> clt) {
		return (clt != null) && (clt.size() > 0);
	}

	/**
	 * 컬렉션객체에서 아이템 가져오기 (없으면 기본으로 설정)
	 * @param <T>
	 * @param lst List
	 * @param i Index
	 * @param d Default
	 * @return
	 */
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

	/**
	 * 컬렉션객체에서 아이템 가져오기
	 * @param <T>
	 * @param lst List
	 * @param i Index
	 * @return
	 */
	public static <T> T get(List<T> lst, int i) {
		return get(lst, i, null);
	}
}
