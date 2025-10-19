package hbgms.logics;


public final class CellInfo {
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
