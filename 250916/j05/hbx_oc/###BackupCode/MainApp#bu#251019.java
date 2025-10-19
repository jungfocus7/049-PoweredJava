import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


//#region [01) MainApp]
public final class MainApp {
    public static void println(String msg) {
        System.out.println(msg);
    }

	public static void clearCall() {
		// println("###MainApp##clearCall");
		System.gc();
	}

    public static boolean checkNotRenderable() {
        return !getMainFrame().isActive();
    }

    public static void print_cellInfos(CellInfo[] cia) {
        StringBuilder tsb = new StringBuilder();
        for (CellInfo ci : cia) {
            String tx = String.format(
                "xi: %d, yi: %d%s",
                ci.get_xi(), ci.get_yi(),
                System.lineSeparator());
            tsb.append(tx);
        }

        println(tsb.toString());
    }


    public static void main(String[] args) throws Exception {
        // println("###MainApp##main");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createMainFrame();
            }
        });
    }

    private static MainFrame _mfrm;
    public static MainFrame getMainFrame() {
        return _mfrm;
    }

    private static void createMainFrame() {
        if (_mfrm == null) {
            _mfrm = new MainFrame();
            _mfrm.open();
        }
    }

}
//#endregion


//#region [02) MainFrame]
final class MainFrame extends JFrame {
    /**
     * ColorMainFrame
     */
    private static final Color _clmf = Color.black;

    /**
     * ColorPanelLeft
     */
    private static final Color _clpl = new Color(0x997755);


    /**
     * MainFrame 생성자
     */
	public MainFrame() {
        // MainApp.println("###MainFrame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Java Tetris");

		initComponents();

		pack();
		setLocation(0, 0);
		setResizable(false);
		setMinimumSize(getSize());
		// setVisible(true);

		// addComponentListener(this);
		// addMouseListener(this);
		// addMouseMotionListener(this);
		// addKeyListener(this);
	}

	private JPanel _pnlRootCont;
	private JPanel _pnlLeft;
	private RightPanel _pnlRight;
    public RightPanel getRightPanel() {
        return _pnlRight;
    }

	private void initComponents() {
		_pnlRootCont = (JPanel)getContentPane();
        _pnlRootCont.setBackground(_clmf);
		_pnlRootCont.setPreferredSize(new Dimension(470, 630));

		_pnlRootCont.setLayout(new BorderLayout(4, 2));
		_pnlLeft = new JPanel();
		_pnlLeft.setBackground(_clpl);
		_pnlLeft.setPreferredSize(new Dimension(150, 0));
		_pnlRootCont.add(_pnlLeft, BorderLayout.WEST);

		_pnlRight = new RightPanel();
		_pnlRootCont.add(_pnlRight, BorderLayout.CENTER);
	}

    public void open() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent te) {
                // MainApp.println(">>> " + te);
                _pnlRight.get_gameComp().keyPressed(te);
            }
        });

        setVisible(true);
        requestFocusInWindow();
    }

}
//#endregion


//#region [03) RightPanel]
final class RightPanel extends JPanel {
    /**
     * ColorPanelRightBackground
     */
    private static final Color _clprb = new Color(0x242323);


    /**
     * RightPanel 생성자
     */
    public RightPanel() {
        // MainApp.println("###RightPanel");
        setBackground(_clprb);
        setLayout(null);

        _gameComp = new GameComponent(this);
        add(_gameComp);
    }

    private GameComponent _gameComp;
    public GameComponent get_gameComp() {
        return _gameComp;
    }

}
//#endregion


//#region [04) GameComponent]
final class GameComponent extends JComponent {
    /**
     * ShapeObjectArr
     */
    private static final ShapeObject[] _spoa = ShapeObject.createAll();
    public static ShapeObject[] get_spoa() {
        return _spoa;
    }

    /**
     * ColorGroundLine
     */
    private static final Color _clgln = Color.black;


    private static final int _celw = 27;
    public static int get_celw(int an) {
        return _celw + an;
    }

    private static final int _celh = 27;
    public static int get_celh(int an) {
        return _celh + an;
    }

    private static final int _colcnt = 10;
    public static int get_colcnt(int an) {
        return _colcnt + an;
    }

    private static final int _rowcnt = 20;
    public static int get_rowcnt(int an) {
        return _rowcnt + an;
    }

    private static final int _grdw = get_celw(1) * _colcnt;
    public static int get_grdw(int an) {
        return _grdw + an;
    }

    private static final int _grdh = get_celh(1) * _rowcnt;
    public static int get_grdh(int an) {
        return _grdh + an;
    }


    /**
     * GameComponent 생성자
     */
    public GameComponent(RightPanel pnlpr) {
        // MainApp.println("###GameComponent");
        _pnlpr = pnlpr;

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                invokeLater_core();
            }
        });
    }

    private void invokeLater_core() {
        // MainApp.println("###GameComponent##invokeLater_core");
        _frct = new Rectangle(10, 10, get_grdw(1), get_grdh(1));
        setBounds(_frct);
    }

    private RightPanel _pnlpr;
    public RightPanel get_pnlpr() {
        return _pnlpr;
    }

    private Rectangle _frct;
    public Rectangle get_frct() {
        return _frct;
    }


    @Override
    protected void paintComponent(Graphics tg) {
        if (MainApp.checkNotRenderable()) {
            return;
        }

        // MainApp.println("###GameComponent##paintComponent");
        super.paintComponent(tg);

        drawBackGrid(tg);
        drawShape(tg);

        MainApp.clearCall();
    }

    private BufferedImage _bfimg;
    private void drawBackGrid(Graphics tg) {
        if (_bfimg == null) {
            _bfimg = new BufferedImage(_frct.width, _frct.height, BufferedImage.TYPE_INT_ARGB);

            Graphics2D g2 = _bfimg.createGraphics();
            g2.setColor(_clgln);

            Line2D.Double dln = new Line2D.Double();
            for (int l = _colcnt + 1, i = 0; i < l; i++) {
                int t1x = get_celw(1) * i;
                int t1y = 0;
                int t2x = t1x;
                int t2y = get_grdh(t1y);
                dln.setLine(t1x, t1y, t2x, t2y);
                g2.draw(dln);
            }
            for (int l = _rowcnt + 1, i = 0; i < l; i++) {
                int t1x = 0;
                int t1y = get_celh(1) * i;
                int t2x = get_grdw(t1x);
                int t2y = t1y;
                dln.setLine(t1x, t1y, t2x, t2y);
                g2.draw(dln);
            }
        }

        tg.drawImage(_bfimg, 0, 0, this);
    }

    /**
     * CurrentShapeObject
     */
    private ShapeObject _cso = _spoa[0];
    private void drawShape(Graphics tg) {
        tg.setColor(Color.white);

        // int tx = (get_celw(1) * _cso.get_xi()) + 1;
        // int ty = (get_celh(1) * _cso.get_yi()) + 1;
        // int tw = get_celw(0);
        // int th = get_celh(0);
        // tg.fillRect(tx, ty, tw, th);

        /*ShapeMap[] spma = _cso.get_spma();
        for (ShapeMap spm : spma) {
            spm.get_cia()
        }*/

        ShapeMap spm = _cso.get_cspm();
        for (CellInfo ci : spm.get_cia()) {
            int xi = _cso.get_xi() + ci.get_xi();
            int yi = _cso.get_yi() + ci.get_yi();
            int tx = (get_celw(1) * xi) + 1;
            int ty = (get_celh(1) * yi) + 1;
            int tw = get_celw(0);
            int th = get_celh(0);
            tg.fillRect(tx, ty, tw, th);
        }
    }

    public void keyPressed(KeyEvent te) {
        switch (te.getKeyCode()) {
            case KeyEvent.VK_LEFT: {
                _cso.moveLeft();
                repaint();
                break;
            }
            case KeyEvent.VK_RIGHT: {
                _cso.moveRight();
                repaint();
                break;
            }
            case KeyEvent.VK_UP: {
                _cso.moveUp();
                repaint();
                break;
            }
            case KeyEvent.VK_DOWN: {
                _cso.moveDown();
                repaint();
                break;
            }
        }
    }

}


final class ShapeObject {
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
        // MainApp.println("###ShapeObject");
        _tpn = tpn;
        _tdma = tdma;

        int l = _tdma.length;
        _spma = new ShapeMap[l];
        for (int i = 0; i < l; i++) {
            String[] tdm = _tdma[i];
            ShapeMap spm = new ShapeMap(tdm, i);
            _spma[i] = spm;
        }

        init_lxly();

        // if (_tpn == 1) {
        //     MainApp.println(toString());
        //     MainApp.println("_lx: " + _lx + ", _ly: " + _ly);
        // }
        // MainApp.println(toString());
    }

    private int _tpn;
    public int get_tpn() {
        return _tpn;
    }

    private String[][] _tdma;
    public String[][] get_tdma() {
        return _tdma;
    }

    private ShapeMap[] _spma;
    public ShapeMap[] get_spma() {
        return _spma;
    }

    // private int _ex;
    // public int get_ex() {
    //     return _ex;
    // }

    // private int _ey;
    // public int get_ey() {
    //     return _ey;
    // }

    private void init_lxly() {
        /*String[] txa = _spma[0].get_tdm();
        int mlx = txa[0].length();
        int mly = txa.length;
        int glx = GameComponent.get_colcnt(0);
        int gly = GameComponent.get_rowcnt(0);
        _ex = (glx - mlx) + 1;
        _ey = (gly - mly) + 1;
        */
        // _ex = 9;
    }

    public int get_ex(int an) {
        return 0;
    }

    public int get_ey(int an) {
        return 0;
    }

    private int _xi;
    public int get_xi() {
        return _xi;
    }
    // public void set_xi(int i) {
    //     _xi = i;
    // }

    private int _yi;
    public int get_yi() {
        return _yi;
    }
    // public void set_yi(int i) {
    //     _yi = i;
    // }

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
            }
        }
        _mi = i;
    }

    public ShapeMap get_cspm() {
        ShapeMap spm = _spma[_mi];
        return spm;
    }

    public void moveLeft() {
        int i = _xi - 1;
        if (i < 0) {
            i = 0;
        }
        _xi = i;
    }

    public void moveRight() {
        int i = _xi + 1;
        int ei = get_ex(-1);
        if (i > ei) {
            i = ei;
        }
        _xi = i;
    }

    public void moveUp() {
        int ti = _yi - 1;
        if (ti < 0) {
            ti = 0;
        }
        _yi = ti;
    }

    public void moveDown() {
        int ti = _yi + 1;
        int li = get_ey(-1);
        if (ti > li) {
            ti = li;
        }
        _yi = ti;
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


final class ShapeMap {
    /**
     * ShapeMap 생성자
     * @param tdm TypeDataMap
     * @param mi MapIndex
     */
    public ShapeMap(String[] tdm, int mi) {
        // println("###ShapeMap");
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
     * MapIndex (배열순서)
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

    private void parseData() {
        // MainApp.println("###ShapeMap##parseData");

        int l = getCellCount();
        int i = 0;
        _cia = new CellInfo[l];

        int xi = 0;
        for (String ls : _tdm) {
            int yi = 0;
            for (char tc : ls.toCharArray()) {
                if (tc == 'o') {
                    CellInfo ci = new CellInfo(xi, yi);
                    _cia[i++] = ci;
                }

                yi++;
            }

            xi++;
        }
    }

    private String _tab = "";
    public String toString(String tab) {
        _tab = tab;
        String rst = toString();
        _tab = "";

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


final class CellInfo {
    public CellInfo(int xi, int yi) {
        // MainApp.println("###CellInfo");
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
//#endregion
