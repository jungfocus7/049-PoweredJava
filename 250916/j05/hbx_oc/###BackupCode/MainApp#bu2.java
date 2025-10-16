import java.awt.BorderLayout;
import java.awt.Color;
// import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
// import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
// import java.awt.geom.Rectangle2D;

// import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


//#region [01)~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ MainApp]
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
        println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

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


//#region [02)~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ MainFrame]
final class MainFrame extends JFrame {
    private static final Color _clmf = new Color(0x725546);
    private static final Color _clpl = new Color(0x997755);
    private static final Color _clpr = new Color(0xDDCC88);

	public MainFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("MainFrame");

		initComponents();

		pack();
		setLocation(0, 0);
		// setResizable(false);
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

		_pnlRootCont.setLayout(new BorderLayout(2, 2));
		_pnlLeft = new JPanel();
		_pnlLeft.setBackground(_clpl);
		_pnlLeft.setPreferredSize(new Dimension(140, 0));
		_pnlRootCont.add(_pnlLeft, BorderLayout.WEST);

		_pnlRight = new RightPanel();
        _pnlRight.setBackground(_clpr);
		_pnlRootCont.add(_pnlRight, BorderLayout.CENTER);
	}

    public void open() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent te) {
                // MainApp.println(">>> " + te);
                _pnlRight.keyPressed(te);
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent te) {
                // MainApp.println(">>> " + te);
                _pnlRight.mouseMoved(te);
            }
        });

        setVisible(true);
        requestFocusInWindow();
    }

}
//#endregion


//#region [03)~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ RightPanel]
interface PaintAction {
    void render(Graphics2D g2);
}

final class RightPanel extends JPanel {
    private static final Color _clgln = new Color(0x242323);

    public RightPanel() {
        // setLayout(null);
    }

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

    private int _dfx = 10;
    public int get_dfx(int an) {
        return _dfx + an;
    }

    private int _dfy = 10;
    public int get_dfy(int an) {
        return _dfy + an;
    }

    // private final Rectangle2D.Double _drct = new Rectangle2D.Double();
    private final Line2D.Double _dln = new Line2D.Double();


    // private boolean _bfi = true;
    @Override
    protected void paintComponent(Graphics tg) {
        // if (_bfi) {
        //     _bfi = false;
        //     return;
        // }
        if (MainApp.checkNotRenderable()) {
            return;
        }

        // MainApp.println("##RightPanel#paintComponent");
        super.paintComponent(tg);

        Graphics2D g2 = (Graphics2D)tg;
        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

        drawBackGrid(g2);
        drawBlock(g2);

        MainApp.clearCall();
    }

    private void drawBackGrid(Graphics2D g2) {
        g2.setColor(_clgln);

        for (int l = _colcnt + 1, i = 0; i < l; i++) {
            int t1x = get_dfx(0) + (get_celw(1) * i);
            int t1y = get_dfy(0);
            int t2x = t1x;
            int t2y = get_grdh(t1y);
            _dln.setLine(t1x, t1y, t2x, t2y);
            g2.draw(_dln);
        }

        for (int l = _rowcnt + 1, i = 0; i < l; i++) {
            int t1x = get_dfx(0);
            int t1y = get_dfy(0) + (get_celh(1) * i);
            int t2x = get_grdw(t1x);
            int t2y = t1y;
            _dln.setLine(t1x, t1y, t2x, t2y);
            g2.draw(_dln);
        }
    }

    private void drawBlock(Graphics2D g2) {
        g2.setColor(Color.white);

        int tx = get_dfx(1) + (get_celw(1) * _cix);
        int ty = get_dfy(1) + (get_celh(1) * _ciy);
        g2.fillRect(tx, ty, get_celw(0), get_celh(0));
    }

    private int _cix = 0;
    public void add_cix(int an) {
        int tn = _cix + an;
        if (tn < 0) {
            tn = 0;
        } else if (tn >= get_colcnt(0)) {
            tn = get_colcnt(-1);
        }
        _cix = tn;
    }

    private int _ciy = 0;
    public void add_ciy(int an) {
        int tn = _ciy + an;
        if (tn < 0) {
            tn = 0;
        } else if (tn >= get_rowcnt(0)) {
            tn = get_rowcnt(-1);
        }
        _ciy = tn;
    }

    public void keyPressed(KeyEvent te) {
        switch (te.getKeyCode()) {
            case KeyEvent.VK_LEFT: {
                add_cix(-1);
                repaint();
                break;
            }
            case KeyEvent.VK_RIGHT: {
                add_cix(1);
                repaint();
                break;
            }
            case KeyEvent.VK_UP: {
                add_ciy(-1);
                repaint();
                break;
            }
            case KeyEvent.VK_DOWN: {
                add_ciy(1);
                repaint();
                break;
            }
        }
    }

    public void mouseMoved(MouseEvent te) {
        // MainApp.println(">>> " + te.getLocationOnScreen());
        Point gpt = te.getPoint();
        Point lpt = SwingUtilities.convertPoint(te.getComponent(), gpt, this);
        // MainApp.println(">>> " + lpt);

        _dfx = lpt.x;
        _dfy = lpt.y;
        repaint();
    }

}
//#endregion









// final class RenderComponent extends JComponent {
//     public RenderComponent() {
//         setCursor(new Cursor(Cursor.HAND_CURSOR));
//         setSize(new Dimension(100, 100));

//         addMouseListener(new MouseAdapter() {
//             @Override
//             public void mousePressed(MouseEvent te) {
//                 super.mousePressed(te);
//                 _mx += 3;
//                 repaint();
//             }
//         });
//     }

//     private int _mx = 10;
//     @Override
//     protected void paintComponent(Graphics tg) {
//         if (MainApp.checkNotRenderable()) {
//             return;
//         }

//         MainApp.println("##RenderComponent#paintComponent");
//         super.paintComponent(tg);

//         tg.setColor(Color.red);
//         tg.fillRect(_mx, 10, 100, 100);
//     }
// }









/*
725546
    private final ArrayList<PaintAction> _pats = new ArrayList<PaintAction>();


    @Override
    protected void paintComponent(Graphics tg) {
        super.paintComponent(tg);

        normalRender(tg);
        tg.dispose();

        MainApp.clearCall();
    }

    // ~~~~~~
    private void normalRender(Graphics tg) {
        Graphics2D g2 = (Graphics2D)tg;
        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

        for (PaintAction pat : _pats) {
            pat.render(g2);
        }
    }


    private final double _cellw = 27;
    private final double _cellh = 27;
    private final int _colcnt = 10;
    private final int _rowcnt = 20;

    private final double _grdw = _cellw * _colcnt;
    private final double _grdh = _cellh * _rowcnt;
    private final Color _clggrd = Color.black;
    private final Color _clgln = new Color(0x242323);

    private final Rectangle2D.Double _drc = new Rectangle2D.Double();
    private final Line2D.Double _dln = new Line2D.Double();


    private void drawBackGrid() {
        // _pats.add(new PaintAction() {
        //     @Override
        //     public void render(Graphics2D g2) {
        //         g2.setColor(Color.red);
        //         g2.fillRect(10, 500, 100, 100);
        //     }
        // });
        // _pats.add(new PaintAction() {
        //     @Override
        //     public void render(Graphics2D g2) {
        //         g2.setColor(Color.green);
        //         for (int i = 0; i < 5000000; i++) {
        //             int tx = (int)(0.00002 * i);
        //             int ty = (int)(0.00002 * i);
        //             g2.fillRect(tx, ty, 10, 10);
        //         }
        //     }
        // });

        // _pats.add(new PaintAction() {
        //     @Override
        //     public void render(Graphics2D g2) {
        //         g2.setColor(_clgln);

        //         for (int l = _colcnt + 1, i = 0; i < l; i++) {
        //             double tx = (_cellw + 1) * i;
        //             _dln.setLine(tx, 0, tx, _grdh);
        //             g2.draw(_dln);
        //         }

        //         for (int l = _rowcnt + 1, i = 0; i < l; i++) {
        //             double ty = (_cellh + 1) * i;
        //             _dln.setLine(0, ty, _grdw, ty);
        //             g2.draw(_dln);
        //         }
        //     }
        // });
    }

 */
