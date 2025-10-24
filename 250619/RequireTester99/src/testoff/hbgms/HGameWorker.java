package testoff.hbgms;

import java.util.ArrayDeque;
import java.util.Random;


final class HShapeItem {
	public HShapeItem(String name, int idx) {
		_name = name;
		_idx = idx;
	}
	private String _name;
	public String getName() {
		return _name;
	}
	private int _idx;
	public int getIndex() {
		return _idx;
	}

	@Override
	public String toString() {
		return "_nm: " + getName() + ", _idx: " + getIndex();
	}

}

final class HShapeFactory {
	private static final HShapeItem[] _spia = {
		new HShapeItem("김사부", 0),
		new HShapeItem("박민국", 1),
		new HShapeItem("서우진", 2),
		new HShapeItem("차은재", 3),
		new HShapeItem("오명심", 4),
		new HShapeItem("박은탁", 5),
		new HShapeItem("장기태", 6),
		new HShapeItem("정인수", 7),
		new HShapeItem("배문정", 8),
		new HShapeItem("윤아름", 9),
	};


	public HShapeFactory() {
		_adq = new ArrayDeque<HShapeItem>();
		_rnd = new Random();
	}

	private ArrayDeque<HShapeItem> _adq;
	private Random _rnd;

	private boolean _brd;
	private boolean isReady() {
		return _brd;
	}

	private HShapeItem _spi;
	public HShapeItem get_spi() {
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

	public HShapeItem next() {
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

public final class HGameWorker {
	public static void println(String msg) {
		System.out.println(msg);
	}

	public HGameWorker() {
		_glia = new HLevelInfo[] {
			new HLevelInfo(1, 1000, 30),
			new HLevelInfo(2, 900, 32),
			new HLevelInfo(3, 800, 34),
			new HLevelInfo(4, 700, 36),
			new HLevelInfo(5, 600, 38),
			new HLevelInfo(6, 500, 40),
			new HLevelInfo(7, 400, 42),
			new HLevelInfo(8, 300, 44),
			new HLevelInfo(9, 200, 46),
		};

		 _spftr = new HShapeFactory();
//		 _spftr.ready();
		 _spftr.next();

		 println(">>>");
		 Integer x;
	}

	private HLevelInfo[] _glia;
	private HShapeFactory _spftr;



	public static void main(String[] args) {
		_gmwk = new HGameWorker();
	}

	private static HGameWorker _gmwk;

}
