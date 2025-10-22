package testoff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Random;

import javax.swing.Timer;


final class ShapeObject {
	public ShapeObject(String name, int idx) {
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


final class GameLevelInfo {
	public GameLevelInfo(int gn, int spd, int ldc) {
		_gn = gn;
		_spd = spd;
		_ldc = ldc;
	}

	private int _gn;
	public int get_gn() {
		return _gn;
	}

	private int _spd;
	public int get_spd() {
		return _spd;
	}

	private int _ldc;
	public int get_ldc() {
		return _ldc;
	}

}
final class GameWorker implements ActionListener {
	public GameWorker() {
		_adq = new ArrayDeque<ShapeObject>(3);
//		_adq.clear();
		_rnd = new Random();
		_ix = 0;

		_tmr = new Timer(0, this);
//		_tmr.setInitialDelay(0);
//		_tmr.setDelay(0);
//		_tmr.stop();
//		_tmr.start();
//		_tmr.restart();

		_glia = new GameLevelInfo[] {
			new GameLevelInfo(1, 1000, 30),
			new GameLevelInfo(2, 900, 32),
			new GameLevelInfo(3, 800, 34),
			new GameLevelInfo(4, 700, 36),
			new GameLevelInfo(5, 600, 38),
			new GameLevelInfo(6, 500, 40),
			new GameLevelInfo(7, 400, 42),
			new GameLevelInfo(8, 300, 44),
			new GameLevelInfo(9, 200, 46),
		};
	}

	private ArrayDeque<ShapeObject> _adq;
	private Random _rnd;
	private int _ix;

	private Timer _tmr;

	private GameLevelInfo[] _glia;


	@Override
	public void actionPerformed(ActionEvent te) {

	}


	public void stop() {

	}

	public void start() {

	}

}


public final class TestOff87 {
	public static void println(String msg) {
		System.out.println(msg);
	}


	/*
	addLast
	pollFirst
	*/
	public static void main(String[] args) throws Exception {
		/*
		long prtm = System.currentTimeMillis();

		ArrayDeque<ShapeObject> adq = new ArrayDeque<ShapeObject>();
		int l = 10;
		for (int i = 0; i < l; i++) {
			adq.addLast(new ShapeObject("박종명", (i * l) + 1));
			adq.addLast(new ShapeObject("임헌진", (i * l) + 2));
			adq.addLast(new ShapeObject("이중호", (i * l) + 3));
		}

		StringBuilder tsb = new StringBuilder();

		ShapeObject spo = null;
		while ((spo = adq.pollFirst()) != null) {
			println("spo: " + spo);
//			tsb.append(spo.toString());
		}

		prtm = System.currentTimeMillis() - prtm;

		println(">>> " + tsb.toString().length());
		println(">>> " + prtm);
		*/



		_idx = 0;
		_adq = new ArrayDeque<ShapeObject>();
		println("==================================================");
		for (String usnm : _usnms) {
			ShapeObject spo = new ShapeObject(usnm, _idx++);
			_adq.addLast(spo);
			println(">>> " + spo.toString());
		}

		_tmr = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent te) {
				_adq.pollFirst();
				String usnm = _usnms[_rnd.nextInt(_usnms.length)];
				_adq.addLast(new ShapeObject(usnm, _idx++));

				println("==================================================");
				Iterator<ShapeObject> itr = _adq.iterator();
				while (itr.hasNext()) {
					ShapeObject spo = itr.next();
					println(">>> " + spo.toString());
				}
			}
		});
		_tmr.start();

		System.in.read();
	}

	private static final String[] _usnms = { "박종명", "임헌진", "이중호", "정희범" };
	private static final Random _rnd = new Random();
	private static int _idx;
	private static ArrayDeque<ShapeObject> _adq;
	private static Timer _tmr;

}



