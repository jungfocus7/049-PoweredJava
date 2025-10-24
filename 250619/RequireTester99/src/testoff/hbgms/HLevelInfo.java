package testoff.hbgms;

public final class HLevelInfo {
	public HLevelInfo(int gn, int spd, int ldc) {
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
