package hbgms.logics;


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

        // _sx = 0;
        _ex = GameComponent.get_colc(-get_cspm().get_colc());
        // _sy = -get_cspm().get_rowc();
        // _sy = -get_cspm().get_ey();
        _ey = GameComponent.get_rowc(-get_cspm().get_rowc());
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

    public ShapeMap get_cspm() {
        ShapeMap spm = _spma[_mi];
        return spm;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * _xi가 이동 가능한 시작점
     */
    private int _sx;
    public int get_sx() {
        return _sx;
    }

    /**
     * _xi가 이동 가능한 끝점
     */
    private int _ex;
    public int get_ex() {
        return _ex;
    }

    /**
     * _yi가 이동 가능한 시작점
     */
    private int _sy;
    public int get_sy() {
        return _sy;
    }

    /**
     * _yi가 이동 가능한 끝점
     */
    private int _ey;
    public int get_ey() {
        return _ey;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /**
     * 현재 x점
     */
    private int _xi;
    public int get_xi() {
        return _xi;
    }

    /**
     * 현재 y점
     */
    private int _yi;
    public int get_yi() {
        return _yi;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public void moveLeft() {
        int i = _xi - 1;
        int sx = get_cspm().get_sx();
        if (i < sx) {
            i = sx;
        }
        _xi = i;
    }

    public void moveRight() {
        int i = _xi + 1;
        int ex = get_cspm().get_ex();
        if (i > ex) {
            i = ex;
        }
        _xi = i;
    }

    public void moveUp() {
        int i = _yi - 1;
        int sy = get_cspm().get_sy();
        // int sy = _sy;
        if (i < sy) {
            i = sy;
        }
        _yi = i;
    }

    public void moveDown() {
        int i = _yi + 1;
        int ey = get_cspm().get_ey();
        if (i > ey) {
            i = ey;
        }
        _yi = i;
    }

    private void check_xiyi() {
        int sx = get_cspm().get_sx();
        int ex = get_cspm().get_ex();
        if (_xi < sx) {
            _xi = sx;
        } else if (_xi > ex) {
            _xi = ex;
        }

        int sy = get_cspm().get_sy();
        int ey = get_cspm().get_ey();
        if (_yi < sy) {
            _yi = sy;
        } else if (_yi > ey) {
            _yi = ey;
        }
    }

    public void rotate() {
        int l = _spma.length;
        _mi = (_mi + 1) % l;
        check_xiyi();
    }

    public void reset() {
        // _xi = 0;
        _yi = 0;
        _xi = (GameComponent.get_colc(0) / 2) - (int)Math.ceil(get_cspm().get_colc() / 2.0);
        // _yi = -get_cspm().get_rowc();
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
