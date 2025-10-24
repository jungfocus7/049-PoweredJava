package hbgms.uicomps;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.*;
import hbgms.*;
import hbgms.helpers.*;
import hbgms.logics.*;


public final class GameAreaComp extends JComponent {
    /**
     * GameAreaComp 생성자
     */
    public GameAreaComp() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                invokeLater_core();
            }
        });
    }

    private void invokeLater_core() {
        _frct = new Rectangle(10, 10, GameConfig.get_grdw(1), GameConfig.get_grdh(1));
        setBounds(_frct);

        _spftr = new ShapeFactory();
        _spftr.ready();
        next_cspi();
    }

    private Rectangle _frct;
    public Rectangle get_frct() {
        return _frct;
    }

	private ShapeFactory _spftr;
    public ShapeFactory get_spftr() {
        return _spftr;
    }

    private ShapeItem _cspi;
    public ShapeItem next_cspi() {
        _cspi = get_spftr().next();
        _cspi.reset();
        return _cspi;
    }
    public ShapeItem get_cspi() {
        _cspi = get_spftr().get_spi();
        return _cspi;
    }


    @Override
    protected void paintComponent(Graphics tg) {
        if (MainHelper.checkNotRenderable()) {
            return;
        }

        // MainApp.println("###GameAreaComp##paintComponent");
        super.paintComponent(tg);

        drawBackGrid(tg);
        drawShape(tg);

        MainHelper.clearCall();
    }


    private BufferedImage _bfimg;
    private void drawBackGrid(Graphics tg) {
        if (_bfimg == null) {
            _bfimg = new BufferedImage(_frct.width, _frct.height, BufferedImage.TYPE_INT_ARGB);

            Graphics2D g2 = _bfimg.createGraphics();
            g2.setColor(GameConfig.clgln);

            Line2D.Double dln = new Line2D.Double();
            for (int l = GameConfig.get_colc(1), i = 0; i < l; i++) {
                int x1 = GameConfig.get_celw(1) * i;
                int y1 = 0;
                int x2 = x1;
                int y2 = GameConfig.get_grdh(y1);
                dln.setLine(x1, y1, x2, y2);
                g2.draw(dln);
            }
            for (int l = GameConfig.get_rowc(1), i = 0; i < l; i++) {
                int x1 = 0;
                int y1 = GameConfig.get_celh(1) * i;
                int x2 = GameConfig.get_grdw(x1);
                int y2 = y1;
                dln.setLine(x1, y1, x2, y2);
                g2.draw(dln);
            }
        }

        tg.drawImage(_bfimg, 0, 0, this);
    }

    private boolean _bdbg = false;
    /**
     * CurrentShapeItemDraw
     */
    private void drawShape(Graphics tg) {
        ShapeMap spm = get_cspi().get_cspm();

        if (_bdbg) {
            tg.setColor(Color.green);
            for (int l = spm.get_colc(0), i = 0; i < l; i++) {
                for (int m = spm.get_rowc(0), j = 0; j < m; j++) {
                    int xi = get_cspi().get_xi() + i;
                    int yi = get_cspi().get_yi() + j;
                    int tx = (GameConfig.get_celw(1) * xi) + 1;
                    int ty = (GameConfig.get_celh(1) * yi) + 1;
                    int tw = GameConfig.get_celw(0);
                    int th = GameConfig.get_celh(0);
                    tg.fillRect(tx, ty, tw, th);
                }
            }
        }

        tg.setColor(Color.white);
        for (CellItem ci : spm.get_cia()) {
            int xi = get_cspi().get_xi() + ci.get_xi();
            int yi = get_cspi().get_yi() + ci.get_yi();
            int tx = (GameConfig.get_celw(1) * xi) + 1;
            int ty = (GameConfig.get_celh(1) * yi) + 1;
            int tw = GameConfig.get_celw(0);
            int th = GameConfig.get_celh(0);
            tg.fillRect(tx, ty, tw, th);
        }

    }

    /**
     * keyPressed 이벤트 함수
     * @param te
     */
    public void keyPressed(KeyEvent te) {
        switch (te.getKeyCode()) {
            case KeyEvent.VK_LEFT, KeyEvent.VK_A: {
                get_cspi().moveLeft();
                repaint();
                break;
            }

            case KeyEvent.VK_RIGHT, KeyEvent.VK_D: {
                get_cspi().moveRight();
                repaint();
                break;
            }

            case /*KeyEvent.VK_UP, */KeyEvent.VK_W: {
                get_cspi().moveUp();
                repaint();
                break;
            }

            case KeyEvent.VK_DOWN, KeyEvent.VK_S: {
                get_cspi().moveDown();
                repaint();
                break;
            }

            case KeyEvent.VK_UP, KeyEvent.VK_Z: {
                get_cspi().rotate();
                repaint();
                break;
            }

            case KeyEvent.VK_X: {
                next_cspi();
                repaint();
                break;
            }

            case KeyEvent.VK_G: {
                _bdbg = !_bdbg;
                repaint();
                break;
            }
        }
    }

}
