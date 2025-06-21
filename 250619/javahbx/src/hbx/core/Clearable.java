package hbx.core;


/**
 * 객체를 사용하고 선제적으로 메모리를 해제하려고 할때
 * 사용할수 있음, 단 반드시 구현하고 호출할 필요는 없다.
 */
public interface Clearable {
	public void clear();
}
