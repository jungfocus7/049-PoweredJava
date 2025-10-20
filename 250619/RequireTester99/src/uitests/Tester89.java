package uitests;


public final class Tester89 {
	public static void println(String msg) {
		System.out.println(msg);
	}

	public static void main(String[] args) throws Exception {
//		_idr = new IndexRanger(-57, 5, -57, 5);
//		println(_idr.toString());
//
//		_idr = new IndexRanger(-91, 7, -91, 7);
//		println(_idr.toString());
//
//		_idr = new IndexRanger(0, 0, 0, 0);
//		println(_idr.toString());
//
//		_idr = new IndexRanger(-3, 3, -3, 3);
//		println(_idr.toString());
//		_idr.add_xc(100);
//		println(_idr.toString());
//
//		_idr = new IndexRanger(0, 9, 0, 9);
//		println(_idr.toString());
//		_idr.add_xc(99);
//		println(_idr.toString());


		_idr = new IndexRanger(0, 10, 0, 20);
		_idr = new IndexRanger(0, 4, 0, 4);
	}

	private static IndexRanger _idr;

}


final class IndexRanger {
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


final class CellInfo {
    /**
     * CellInfo 생성자
     * @param xi X방향 Index
     * @param yi Y방향 Index
     */
    public CellInfo(int xi, int yi) {
        _xi = xi;
        _yi = yi;
    }

    private int _xi;
    public int get_xi() {
        return _xi;
    }
    public void set_xi(int v) {
        _xi = v;
    }

    private int _yi;
    public int get_yi() {
        return _yi;
    }
    public void set_yi(int v) {
        _yi = v;
    }

    @Override
    public String toString() {
        return "xi: " + _xi + ", yi: " + _yi;
    }

}


final class ShapeMap {
    /**
     * ShapeMap 생성자
     * @param tdm TypeDataMap
     * @param mi MapIndex
     */
    public ShapeMap(String[] tdm, int mi) {
        _tdm = tdm;
        _mi = mi;
        parseData();
    }

    /**
     * TypeDataMap
     */
    private String[] _tdm;
    public String[] get_tdm() {
        return _tdm;
    }

    /**
     * MapIndex (맵순서)
     */
    private int _mi;
    public int get_mi() {
        return _mi;
    }

    /**
     * CellInfoArr
     */
    private CellInfo[] _cia;
    public CellInfo[] get_cia() {
        return _cia;
    }

    /**
     * Cell갯수
     */
    private int getCellCount() {
        int ri = 0;
        for (String ls : _tdm) {
            for (char tc : ls.toCharArray()) {
                if (tc == 'o') {
                    ri++;
                }
            }
        }

        return ri;
    }

    /**
     * 데이터 파싱
     */
    private void parseData() {
        int l = getCellCount();
        int i = 0;
        _cia = new CellInfo[l];

        int yi = 0;
        for (String ls : _tdm) {
            int xi = 0;
            for (char tc : ls.toCharArray()) {
                if (tc == 'o') {
                    CellInfo ci = new CellInfo(xi, yi);
                    _cia[i++] = ci;
                }

                xi++;
            }

            yi++;
        }

        _colc = _tdm[0].length();
        _rowc = _tdm.length;

        initBoundary();
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * Column개수
     */
    private int _colc;
    public int get_colc() {
        return _colc;
    }

    /**
     * Row개수
     */
    private int _rowc;
    public int get_rowc() {
        return _rowc;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private int _sx;
    public int get_sx() {
        return _sx;
    }

    private int _ex;
    public int get_ex() {
        return _ex;
    }

    private int _sy;
    public int get_sy() {
        return _sy;
    }

    private int _ey;
    public int get_ey() {
        return _ey;
    }

    private void initBoundary() {
        boolean bf = true;
        int sx = 0, ex = 0;
        int sy = 0, ey = 0;
        if (_mi == 0) {
        	Tester89.println("===========");
        }
        for (CellInfo ci : _cia) {
            int xi = ci.get_xi();
            int yi = ci.get_yi();
            if (bf) {
                sx = ex = xi;
                sy = ey = yi;
                bf = false;
            } else {
                if (xi < sx) {
                    sx = xi;
                }
                if (yi < sy) {
                    sy = yi;
                }
                if (xi > ex) {
                    ex = xi;
                }
                if (yi > ey) {
                    ey = yi;
                }
            }
        }

        _sx = 0 - sx;
        _ex = GameComponent.get_colc(-(ex + 1));
        _sy = 0 - sy;
        _ey = GameComponent.get_rowc(-(ey + 1));
        if (_mi == 0) {
        	Tester89.println("_colc: " + _colc);
        	Tester89.println("_rowc: " + _rowc);
        	Tester89.println("sx: " + sx);
        	Tester89.println("ex: " + ex);
        	Tester89.println("sy: " + sy);
        	Tester89.println("ey: " + ey);
        	Tester89.println("_sx: " + _sx);
        	Tester89.println("_ex: " + _ex);
        	Tester89.println("_sy: " + _sy);
        	Tester89.println("_ey: " + _ey);
        	Tester89.println("===========");
        }
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private String _tab = "";
    public String toString(String tab) {
        _tab = tab;
        String rst = toString();
        _tab = "";

        return rst;
    }

    @Override
    public String toString() {
        StringBuilder tsb = new StringBuilder();
        tsb.append(String.format("%sMapIndex: %d\n", _tab, _mi));
        tsb.append(String.format("%sMapData: \n", _tab));
        for (String ls : _tdm) {
            tsb.append(String.format("%s%s%s\n", _tab, _tab, ls));
        }

        return tsb.toString();
    }

}





//
//final class IndexRanger {
//	/**
//	 * IndexRanger 생성자
//	 * @param sx StartX Index
//	 * @param ex EndX Index
//	 * @param sy StartY Index
//	 * @param ey EndY Index
//	 */
//	public IndexRanger(int sx, int ex, int sy, int ey) {
//		_sx = sx;
//		_ex = (ex > sx) ? ex : sx;
//		_sy = sy;
//		_ey = (ey > sy) ? ey : sy;
//		_cx = _sx;
//		_cy = _sy;
//	}
//
//	private int _sx;
//	/**
//	 * StartX Index
//	 */
//	public int get_sx() {
//		return _sx;
//	}
//
//	private int _ex;
//	/**
//	 * EndX Index
//	 */
//	public int get_ex() {
//		return _ex;
//	}
//
//	private int _sy;
//	/**
//	 * StartY Index
//	 */
//	public int get_sy() {
//		return _sy;
//	}
//
//	private int _ey;
//	/**
//	 * EndY Index
//	 */
//	public int get_ey() {
//		return _ey;
//	}
//
//	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//	private int _cx;
//	/**
//	 * CurrentX Index
//	 */
//	public int get_cx() {
//		return _cx;
//	}
//	public void set_cx(int i) {
//		if (i < _sx) {
//			i = _sx;
//		} else if (i > _ex) {
//			i = _ex;
//		}
//		_cx = i;
//	}
//
//	private int _cy;
//	/**
//	 * CurrentY Index
//	 */
//	public int get_cy() {
//		return _cy;
//	}
//	public void set_cy(int i) {
//		if (i < _sy) {
//			i = _sy;
//		} else if (i > _ey) {
//			i = _ey;
//		}
//		_cy = i;
//	}
//
//	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//	/**
//	 * Length X
//	 * @return
//	 */
//	public int get_lx() {
//		return (_ex - _sx) + 1;
//	}
//
//	/**
//	 * Length Y
//	 * @return
//	 */
//	public int get_ly() {
//		return (_ey - _sy) + 1;
//	}
//
//	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//	@Override
//	public String toString() {
////		StringBuilder tsb = new StringBuilder();
////		tsb.append(String.format("", null));
//		String rst = String.format("""
//sx: %s, ex: %s,
//sy: %s, ey: %s,
//cx: %s, cy: %s,
//lx: %s, ly: %s,
//		""".trim()
//			, get_sx(), get_ex()
//			, get_sy(), get_ey()
//			, get_cx(), get_cy()
//			, get_lx(), get_ly());
//
//		return rst;
//	}
//
//}
