package hbgms.hbgms.models;


public final class IndexRanger {
	/**
	 * IndexRanger 생성자
	 * @param xs X Start Index
	 * @param xl X Length
	 * @param ys Y Start Index
	 * @param yl Y Length
	 */
	public IndexRanger(int xs, int xl, int ys, int yl) {
		_xs = xs;
		_xl = (xl < 1) ? 1 : xl;
//		_xe = _xs + ((xl > 1) ? (xl - 1) : xl); // uint경우
		_xe = (_xs - 1) + _xl;
		_xc = _xs;

		_ys = ys;
		_yl = (yl < 1) ? 1 : yl;
//		_ye = _ys + ((yl > 1) ? (yl - 1) : yl); // uint경우
		_ye = (_ys - 1) + _yl;
		_yc = _ys;
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private int _xs;
	public int get_xs() {
		return _xs;
	}

	private int _xl;
	public int get_xl() {
		return _xl;
	}

	private int _xe;
	public int get_xe() {
		return _xe;
	}

	private int _xc;
	public int get_xc() {
		return _xc;
	}
	public void set_xc(int tn) {
		if (tn < _xs) {
			_xc = _xs;
		} else if (tn > _xe) {
			_xc = _xe;
		} else {
			_xc = tn;
		}
	}
	public void add_xc(int tn) {
		int tc = _xc + tn;
		if (tc < _xs) {
			_xc = _xs;
		} else if (tc > _xe) {
			_xc = _xe;
		} else {
			_xc = tc;
		}
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private int _ys;
	public int get_ys() {
		return _ys;
	}

	private int _yl;
	public int get_yl() {
		return _yl;
	}

	private int _ye;
	public int get_ye() {
		return _ye;
	}

	private int _yc;
	public int get_yc() {
		return _yc;
	}
	public void set_yc(int tn) {
		if (tn < _ys) {
			_yc = _ys;
		} else if (tn > _ye) {
			_yc = _ye;
		} else {
			_yc = tn;
		}
	}
	public void add_yc(int tn) {
		int tc = _yc + tn;
		if (tc < _ys) {
			_yc = _ys;
		} else if (tc > _ye) {
			_yc = _ye;
		} else {
			_yc = tc;
		}
	}


	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	@Override
	public String toString() {
		String rst = String.format("""
xs: %d, xl: %d, xe: %d, xc: %d,
ys: %d, yl: %d, ye: %d, yc: %d,
			""".trim()
			, get_xs(), get_xl(), get_xe(), get_xc()
			, get_ys(), get_yl(), get_ye(), get_yc()
		);

		return rst;
	}

}
