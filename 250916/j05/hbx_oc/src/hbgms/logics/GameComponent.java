package hbgms.logics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;

import hbgms.MainApp;
import hbgms.RightPanel;


public final class GameComponent extends JComponent {
    /**
     * ShapeObjectArr
     */
    private static final ShapeObject[] _spoa = ShapeObject.createAll();
    public static ShapeObject[] get_spoa() {
        return _spoa;
    }

    private static final Random _rnd = new Random();
    private ShapeObject _cspo;
    public ShapeObject next_cspo() {
        int i = _rnd.nextInt(_spoa.length);
        _cspo = _spoa[i];
        _cspo.reset();
        return _cspo;
    }
    public ShapeObject get_cspo() {
        if (_cspo == null) {
            next_cspo();
        }
        return _cspo;
    }


    private static final int _celw = 27;
    public static int get_celw(int an) {
        return _celw + an;
    }

    private static final int _celh = 27;
    public static int get_celh(int an) {
        return _celh + an;
    }

    private static final int _colc = 10;
    public static int get_colc(int an) {
        return _colc + an;
    }

    private static final int _rowc = 20;
    public static int get_rowc(int an) {
        return _rowc + an;
    }

    private static final int _grdw = get_celw(1) * _colc;
    public static int get_grdw(int an) {
        return _grdw + an;
    }

    private static final int _grdh = get_celh(1) * _rowc;
    public static int get_grdh(int an) {
        return _grdh + an;
    }


    /**
     * GameComponent 생성자
     */
    public GameComponent(RightPanel pnlpr) {
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

    /**
     * ColorGroundLine
     */
    private static final Color _clgln = Color.black;
    private BufferedImage _bfimg;
    private void drawBackGrid(Graphics tg) {
        if (_bfimg == null) {
            _bfimg = new BufferedImage(_frct.width, _frct.height, BufferedImage.TYPE_INT_ARGB);

            Graphics2D g2 = _bfimg.createGraphics();
            g2.setColor(_clgln);

            Line2D.Double dln = new Line2D.Double();
            for (int l = _colc + 1, i = 0; i < l; i++) {
                int t1x = get_celw(1) * i;
                int t1y = 0;
                int t2x = t1x;
                int t2y = get_grdh(t1y);
                dln.setLine(t1x, t1y, t2x, t2y);
                g2.draw(dln);
            }
            for (int l = _rowc + 1, i = 0; i < l; i++) {
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
     * CurrentShapeObjectDraw
     */
    private void drawShape(Graphics tg) {
        ShapeMap spm = get_cspo().get_cspm();
        tg.setColor(Color.green);
        for (int l = spm.get_colc(), i = 0; i < l; i++) {
            for (int m = spm.get_rowc(), j = 0; j < m; j++) {
                int xi = get_cspo().get_xi() + i;
                int yi = get_cspo().get_yi() + j;
                int tx = (get_celw(1) * xi) + 1;
                int ty = (get_celh(1) * yi) + 1;
                int tw = get_celw(0);
                int th = get_celh(0);
                tg.fillRect(tx, ty, tw, th);
            }
        }

        tg.setColor(Color.white);
        for (CellInfo ci : spm.get_cia()) {
            int xi = _cspo.get_xi() + ci.get_xi();
            int yi = _cspo.get_yi() + ci.get_yi();
            int tx = (get_celw(1) * xi) + 1;
            int ty = (get_celh(1) * yi) + 1;
            int tw = get_celw(0);
            int th = get_celh(0);
            tg.fillRect(tx, ty, tw, th);
        }

    }

    /**
     * keyPressed 이벤트 함수
     * @param te
     */
    public void keyPressed(KeyEvent te) {
        switch (te.getKeyCode()) {
            case KeyEvent.VK_LEFT: {
                get_cspo().moveLeft();
                repaint();
                break;
            }

            case KeyEvent.VK_RIGHT: {
                get_cspo().moveRight();
                repaint();
                break;
            }

            case KeyEvent.VK_UP: {
                get_cspo().moveUp();
                repaint();
                break;
            }

            case KeyEvent.VK_DOWN: {
                get_cspo().moveDown();
                repaint();
                break;
            }

            case KeyEvent.VK_Z: {
                get_cspo().rotate();
                repaint();
                break;
            }

            case KeyEvent.VK_X: {
                next_cspo();
                repaint();
                break;
            }
        }
    }

}
