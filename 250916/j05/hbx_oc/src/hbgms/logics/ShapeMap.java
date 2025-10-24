package hbgms.logics;

import hbgms.*;
import hbgms.helpers.*;


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
     * CellItemArr
     */
    private CellItem[] _cia;
    public CellItem[] get_cia() {
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
        _cia = new CellItem[l];

        int yi = 0;
        for (String ls : _tdm) {
            int xi = 0;
            for (char tc : ls.toCharArray()) {
                if (tc == 'o') {
                    CellItem ci = new CellItem(xi, yi);
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
    public int get_colc(int an) {
        return _colc + an;
    }

    private int _rowc;
    /**
     * RowCount
     */
    public int get_rowc(int an) {
        return _rowc + an;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private int _xis;
    /**
     * Cell X Index Start
     * @return
     */
    public int get_xis(int an) {
        return _xis + an;
    }

    private int _xie;
    /**
     * Cell X Index End
     * @return
     */
    public int get_xie(int an) {
        return _xie + an;
    }

    private int _yis;
    /**
     * Cell Y Index Start
     * @return
     */
    public int get_yis(int an) {
        return _yis + an;
    }

    private int _yie;
    /**
     * Cell Y Index End
     * @return
     */
    public int get_yie(int an) {
        return _yie + an;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private int _pxs;
    /**
     * Point X-Start
     * @return
     */
    public int get_pxs(int an) {
        return _pxs + an;
    }

    private int _pxe;
    /**
     * Point X-End
     * @return
     */
    public int get_pxe(int an) {
        return _pxe + an;
    }

    private int _pys;
    /**
     * Point Y-Start
     * @return
     */
    public int get_pys(int an) {
        return _pys + an;
    }

    private int _pye;
    /**
     * Point Y-End
     * @return
     */
    public int get_pye(int an) {
        return _pye + an;
    }

    /**
     * Shape의 실제 Cells영역 X-Start, X-End, Y-Start, Y-End 설정
     */
    private void initBoundary() {
        boolean bf = true;

        for (CellItem ci : _cia) {
            int xi = ci.get_xi();
            int yi = ci.get_yi();
            if (bf) {
                _xis = _xie = xi;
                _yis = _yie = yi;
                bf = false;
            } else {
                if (xi < _xis) {
                    _xis = xi;
                }
                if (yi < _yis) {
                    _yis = yi;
                }
                if (xi > _xie) {
                    _xie = xi;
                }
                if (yi > _yie) {
                    _yie = yi;
                }
            }
        }

        _pxs = 0 - _xis;
        _pxe = GameConfig.get_colc(-(_xie + 1));

        _pys = 0 - _yis;
        _pye = GameConfig.get_rowc(-(_yie + 1));
    }

    public int get_lup() {
        return -get_yie(1);
    }

    public int get_ctp() {
        return (GameConfig.get_colc(0) / 2) - (int)Math.ceil(get_colc(0) / 2.0);
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
