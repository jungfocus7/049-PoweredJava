package hbgms.logics;

import hbgms.MainApp;
import hbgms.hbgms.models.IndexRanger;


public final class ShapeObject {
    public static ShapeObject[] createAll() {
	    return new ShapeObject[] {
            new ShapeObject(1, new String[][] {
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

            new ShapeObject(2, new String[][] {
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

            new ShapeObject(3, new String[][] {
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

            new ShapeObject(4, new String[][] {
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

            new ShapeObject(5, new String[][] {
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

            new ShapeObject(6, new String[][] {
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

            new ShapeObject(7, new String[][] {
                {
                    "oo",
                    "oo",
                },
            }),

            // new ShapeObject(7, new String[][] {
            //     {
            //         "xxxoxxx",
            //         "xxxoxxx",
            //         "xxxoxxx",
            //         "xooooox",
            //         "xxxoxxx",
            //         "xxxoxxx",
            //         "xxxoxxx",
            //     },
            //     {
            //         "xxxxxxx",
            //         "xxxoxxx",
            //         "xxxoxxx",
            //         "ooooooo",
            //         "xxxoxxx",
            //         "xxxoxxx",
            //         "xxxxxxx",
            //     },
            // }),

            // new ShapeObject(8, new String[][] {
            //     {
            //         "oxxxxxx",
            //         "xoxxxxx",
            //         "xxoxxxx",
            //         "xxxoxxx",
            //         "xxxxoxx",
            //         "xxxxoxx",
            //         "xxxxoxx",
            //     },
            //     {
            //         "xxoxxxx",
            //         "xxoxxxx",
            //         "xxoxxxx",
            //         "xxxoxxx",
            //         "xxxxoxx",
            //         "xxxxxox",
            //         "xxxxxxo",
            //     },
            // }),

            new ShapeObject(8, new String[][] {
                {
                    "xxx",
                    "xox",
                    "xxx",
                },
            }),

        };
    }

    public ShapeObject(int tpn, String[][] tdma) {
        _tpn = tpn;

        int l = tdma.length;
        _spma = new ShapeMap[l];
        for (int i = 0; i < l; i++) {
            String[] tdm = tdma[i];
            ShapeMap spm = new ShapeMap(tdm, i);
            _spma[i] = spm;
        }

        _idr = GameComponent.create_idr(get_cspm());
    }

    private int _tpn;
    public int get_tpn() {
        return _tpn;
    }

    private ShapeMap[] _spma;
    public ShapeMap[] get_spma() {
        return _spma;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private int _mi;
    public int get_mi() {
        return _mi;
    }
    public void set_mi(int i) {
        if (i < 0) {
            _mi = 0;
        } else {
            int ei = _spma.length - 1;
            if (i > ei) {
                _mi = ei;
            } else {
                _mi = i;
            }
        }
    }

    /**
     * CurrentShapeMap
     * @return
     */
    public ShapeMap get_cspm() {
        ShapeMap spm = _spma[_mi];
        return spm;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private IndexRanger _idr;
    public IndexRanger get_idr() {
        return _idr;
    }

    /**
     * X Index Start
     */
    public int get_xs() {
        return _idr.get_xs();
    }

    /**
     * X Index End
     */
    public int get_xe() {
        return _idr.get_xe();
    }

    /**
     * X Index Current
     */
    public int get_xc() {
        return _idr.get_xc();
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * Y Index Start
     */
    public int get_ys() {
        return _idr.get_ys();
    }

    /**
     * Y Index End
     */
    public int get_ye() {
        return _idr.get_ye();
    }

    /**
     * Y Index Current
     */
    public int get_yc() {
        return _idr.get_yc();
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private int _xi;
    /**
     * 현재 x점
     */
    public int get_xi() {
        return _xi;
    }

    private int _yi;
    /**
     * 현재 y점
     */
    public int get_yi() {
        return _yi;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void moveLeft() {
        int i = _xi - 1;
        int xs = get_cspm().get_pxs(0);
        if (i < xs) {
            i = xs;
        }
        _xi = i;
    }

    public void moveRight() {
        int i = _xi + 1;
        int xe = get_cspm().get_pxe(0);
        if (i > xe) {
            i = xe;
        }
        _xi = i;
    }

    public void moveUp() {
        int i = _yi - 1;
        // int ys = get_cspm().get_ys(0);
        int ys = get_cspm().get_lup();
        if (i < ys) {
            i = ys;
        }
        _yi = i;
        MainApp.println(">>> " + ys);
        MainApp.println(">>> " + _yi);
    }

    public void moveDown() {
        int i = _yi + 1;
        int ye = get_cspm().get_pye(0);
        if (i > ye) {
            i = ye;
        }
        _yi = i;
    }

    private void check_xiyi() {
        int xs = get_cspm().get_pxs(0);
        int xe = get_cspm().get_pxe(0);
        if (_xi < xs) {
            _xi = xs;
        } else if (_xi > xe) {
            _xi = xe;
        }

        // int ys = get_cspm().get_pys(0);
        int ys = get_cspm().get_lup();
        int ye = get_cspm().get_pye(0);
        if (_yi < ys) {
            _yi = ys;
        } else if (_yi > ye) {
            _yi = ye;
        }
    }

    public void rotate() {
        int l = _spma.length;
        _mi = (_mi + 1) % l;
        check_xiyi();
    }

    public void reset() {
        // _xi = 0;
        // _yi = 0;
        _xi = get_cspm().get_ctp();
        // _yi = get_cspm().get_lup();
        _yi = -get_cspm().get_yis(0);
        _mi = 0;
    }


    @Override
    public String toString() {
        StringBuilder tsb = new StringBuilder();
        tsb.append(String.format("TypeNum: %d\n", _tpn));
        tsb.append("ShapeMaps: \n");
        for (ShapeMap spm : _spma) {
            tsb.append(String.format("%s", spm.toString("   ")));
        }

        return tsb.toString();
    }

}
