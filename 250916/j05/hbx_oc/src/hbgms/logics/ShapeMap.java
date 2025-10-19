package hbgms.logics;

import hbgms.MainApp;
import hbgms.helpers.StringHelper;


public final class ShapeMap {
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
            MainApp.println("===========");
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
            MainApp.println("_colc: " + _colc);
            MainApp.println("_rowc: " + _rowc);
            MainApp.println("sx: " + sx);
            MainApp.println("ex: " + ex);
            MainApp.println("sy: " + sy);
            MainApp.println("ey: " + ey);
            MainApp.println("_sx: " + _sx);
            MainApp.println("_ex: " + _ex);
            MainApp.println("_sy: " + _sy);
            MainApp.println("_ey: " + _ey);
            MainApp.println("===========");
        }
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private String _tab = StringHelper.empty;
    public String toString(String tab) {
        _tab = tab;
        String rst = toString();
        _tab = StringHelper.empty;

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
