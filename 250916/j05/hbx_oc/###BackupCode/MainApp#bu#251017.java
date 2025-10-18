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
import java.util.ArrayList;

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
		// println("##clearCall");
		System.gc();
	}

    public static boolean checkNotRenderable() {
        return !getMainFrame().isActive();
    }


    public static void main(String[] args) throws Exception {
        println("##MainApp#main");

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
     * ShapeMapArr
     */
    private static final ShapeObject[] _spos = ShapeObject.createAll();

    /**
     * ColorGroundLine
     */
    private static final Color _clgln = Color.black;


    private final int _celw = 27;
    public int get_celw(int an) {
        return _celw + an;
    }

    private final int _celh = 27;
    public int get_celh(int an) {
        return _celh + an;
    }

    private final int _colcnt = 10;
    public int get_colcnt(int an) {
        return _colcnt + an;
    }

    private final int _rowcnt = 20;
    public int get_rowcnt(int an) {
        return _rowcnt + an;
    }

    private final int _grdw = get_celw(1) * _colcnt;
    public int get_grdw(int an) {
        return _grdw + an;
    }

    private final int _grdh = get_celh(1) * _rowcnt;
    public int get_grdh(int an) {
        return _grdh + an;
    }


    /**
     * GameComponent 생성자
     */
    public GameComponent(RightPanel pnlpr) {
        // MainApp.println("##GameComponent");
        _pnlpr = pnlpr;

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                invokeLater_core();
            }
        });
    }

    private void invokeLater_core() {
        _frct = new Rectangle(10, 10, get_grdw(1), get_grdh(1));
        // MainApp.println("##GameComponent#invokeLater_core");

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

        // MainApp.println("##GameComponent#paintComponent");
        super.paintComponent(tg);

        drawBackGrid(tg);

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

    public void keyPressed(KeyEvent te) {
        switch (te.getKeyCode()) {
            case KeyEvent.VK_LEFT: {
                break;
            }
            case KeyEvent.VK_RIGHT: {
                break;
            }
            case KeyEvent.VK_UP: {
                break;
            }
            case KeyEvent.VK_DOWN: {
                break;
            }
        }
    }

}

final class ShapeObject {
    public static ShapeObject[] createAll() {
	    return new ShapeObject[] {
            create(1, new String[][] {
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

            create(2, new String[][] {
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

            create(3, new String[][] {
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

            create(4, new String[][] {
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

            create(5, new String[][] {
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

            create(6, new String[][] {
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

            create(7, new String[][] {
                {
                    "oo",
                    "oo",
                },
            }),

        };
    }

    private static ShapeObject create(int tpn, String[][] tdma) {
        ShapeObject spo = new ShapeObject();
        spo._tpn = tpn;
        spo.parseData(tdma);

        return spo;
    }

    private ShapeObject() {}

    private int _tpn;
    public int get_tpn() {
        return _tpn;
    }

    private final ArrayList<CellInfo> _cis = new ArrayList<CellInfo>();

    private void parseData(String[][] tdma) {
        for (String[] tdm : tdma) {
            parseWork_tdm(tdm);

            break;
            // for (String dls : tdm) {
            //     for (char mc : dls.toCharArray()) {
            //         MainApp.println("~~~~~~~~~ " + mc);
            //     }
            // }

            // int l = tdm.length;
            // MainApp.println("~~~~~~~~~ " + l);

            // _cis = new CellInfo[l];
            // for (int i = 0; i < l; i++) {
            //     String td = tdm[i];
            //     _cis[i] = new CellInfo(td);
            // }
        }
    }

    private void parseWork_tdm(String[] tdm) {
        MainApp.println("~~~~~~~~~ " + tdm);
        /*int l, m, i, j;
        String ds;
        char[] mca;
        char mc;*/

        int m = tdm.length;
        for (int j = 0; j < m; j++) {
            String ds = tdm[j];
            // MainApp.println("~~~~~~~~~ " + ds);
            char[] mca = ds.toCharArray();
            int l = mca.length;
            for (int i = 0; i < l; i++) {
                char mc = mca[i];
                if (mc == 'o') {
                    // MainApp.println(":: " + mc + ", " + i + ", " + j + ", " + get_tpn());
                    // MainApp.println(":: " + mc + ", " + i + ", " + j);
                    CellInfo ci = new CellInfo(i, j);
                    _cis.add(ci);
                }
                //
            }

            break;
        }


        /*
        for (String dls : tdm) {
            char[] mca = dls.toCharArray();
            int l = mca.length;
            for (int i = 0; i < l; i++) {
                char mc = mca[i];
                MainApp.println("~~~~~~~~~ " + mc + " ~~ " + i);
            }
        }*/
    }

    @Override
    public String toString() {
        return super.toString();
    }

}

final class ShapeMap {
    public ShapeMap() {
    }
}

final class CellInfo {
    public CellInfo(int i, int j) {
        MainApp.println("##CellInfo#CellInfo >>> i: " + i + ", j: " + j);
    }
}
//#endregion
