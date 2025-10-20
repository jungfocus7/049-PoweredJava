package hbgms.logics;

import hbgms.hbgms.models.CellInfo;
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
    private int _colc;
    /**
     * ColumnCount
     */
    public int get_colc() {
        return _colc;
    }

    private int _rowc;
    /**
     * RowCount
     */
    public int get_rowc() {
        return _rowc;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private int _xs;
    private int _xe;
    private int _ys;
    private int _ye;

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private int _pxs;
    /**
     * Point X-Start
     * @return
     */
    public int get_pxs() {
        return _pxs;
    }

    private int _pxe;
    /**
     * Point X-End
     * @return
     */
    public int get_pxe() {
        return _pxe;
    }

    private int _pys;
    /**
     * Point Y-Start
     * @return
     */
    public int get_pys() {
        return _pys;
    }

    private int _pye;
    /**
     * Point Y-End
     * @return
     */
    public int get_pye() {
        return _pye;
    }

    /**
     * Shape의 실제 Cells영역 X-Start, X-End, Y-Start, Y-End 설정
     */
    private void initBoundary() {
        boolean bf = true;
        int xs = 0, xe = 0;
        int ys = 0, ye = 0;

        for (CellInfo ci : _cia) {
            int xi = ci.get_xi();
            int yi = ci.get_yi();
            if (bf) {
                xs = xe = xi;
                ys = ye = yi;
                bf = false;
            } else {
                if (xi < xs) {
                    xs = xi;
                }
                if (yi < ys) {
                    ys = yi;
                }
                if (xi > xe) {
                    xe = xi;
                }
                if (yi > ye) {
                    ye = yi;
                }
            }
        }

        _pxs = 0 - xs;
        _pxe = GameComponent.get_colc(-(xe + 1));
        _pys = 0 - ys;
        _pye = GameComponent.get_rowc(-(ye + 1));
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
