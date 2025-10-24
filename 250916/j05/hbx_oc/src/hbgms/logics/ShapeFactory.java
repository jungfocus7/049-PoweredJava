package hbgms.logics;

import java.util.*;


public final class ShapeFactory {
//#region [ShapeItemArr]
	private static final ShapeItem[] _spia = new ShapeItem[] {
        new ShapeItem(1, new String[][] {
            {
                "xxxx",
                "oooo",
                "xxxx",
                "xxxx",
            },
            {
                "xoxx",
                "xoxx",
                "xoxx",
                "xoxx",
            },
        }),

        new ShapeItem(2, new String[][] {
            {
                "xxx",
                "ooo",
                "xox",
            },
            {
                "xox",
                "oox",
                "xox",
            },
            {
                "xxx",
                "xox",
                "ooo",
            },
            {
                "xox",
                "xoo",
                "xox",
            },
        }),

        new ShapeItem(3, new String[][] {
            {
                "xxx",
                "ooo",
                "oxx",
            },
            {
                "oox",
                "xox",
                "xox",
            },
            {
                "xxx",
                "xxo",
                "ooo",
            },
            {
                "xox",
                "xox",
                "xoo",
            },
        }),

        new ShapeItem(4, new String[][] {
            {
                "xxx",
                "ooo",
                "xxo",
            },
            {
                "xox",
                "xox",
                "oox",
            },
            {
                "xxx",
                "oxx",
                "ooo",
            },
            {
                "xoo",
                "xox",
                "xox",
            },
        }),

        new ShapeItem(5, new String[][] {
            {
                "xxx",
                "xoo",
                "oox",
            },
            {
                "oxx",
                "oox",
                "xox",
            },
        }),

        new ShapeItem(6, new String[][] {
            {
                "xxx",
                "oox",
                "xoo",
            },
            {
                "xxo",
                "xoo",
                "xox",
            },
        }),

        new ShapeItem(7, new String[][] {
            {
                "oo",
                "oo",
            },
        }),
	};
//#endregion

	public ShapeFactory() {
		_adq = new ArrayDeque<ShapeItem>();
		_rnd = new Random();
	}

	private ArrayDeque<ShapeItem> _adq;
	private Random _rnd;

	private boolean _brd;
	public boolean isReady() {
		return _brd;
	}

	private ShapeItem _spi;
	public ShapeItem get_spi() {
		return _spi;
	}

	public void reset() {
		if (_brd) {
			_adq.clear();
			_spi = null;
		}
	}

	public void ready() {
		if (!_brd) {
			final int l = 3;
			for (int j = 0; j < l; j++) {
				int i = _rnd.nextInt(_spia.length);
				_adq.addLast(_spia[i]);
			}
			_brd = true;
		}
	}

	public ShapeItem next() {
		if (_brd) {
			_spi = _adq.pollFirst();
			int i = _rnd.nextInt(_spia.length);
			_adq.addLast(_spia[i]);
			return _spi;
		} else {
			return null;
		}
	}

}
