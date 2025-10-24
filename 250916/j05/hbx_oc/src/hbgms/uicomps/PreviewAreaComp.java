package hbgms.uicomps;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.*;
import hbgms.GameConfig;
import hbgms.helpers.*;


public final class PreviewAreaComp extends JComponent {
    /**
     * PreviewAreaComp 생성자
     */
    public PreviewAreaComp() {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                invokeLater_core();
            }
        });
    }

    private final int _dcc = 4;
    private void invokeLater_core() {
        int tx = 15 - 4;
        int ty = 15 - 4;
        // int tw = ((GameConfig.get_celw(1) * _dcc) + 1) + 8;
        // int th = ((GameConfig.get_celh(1) * 12) + 1) + 8;
        int tw = 121;
        int th = 373;
        _frct = new Rectangle(tx, ty, tw, th);
        setBounds(_frct);
    }

    private Rectangle _frct;
    public Rectangle get_frct() {
        return _frct;
    }

    @Override
    protected void paintComponent(Graphics tg) {
        if (MainHelper.checkNotRenderable()) {
            return;
        }

        // MainApp.println("###PreviewAreaComp##paintComponent");
        super.paintComponent(tg);

        // tg.setColor(GameConfig.clprb);
        // tg.fillRect(0, 0, _frct.width, _frct.height);
        drawBackGrid(tg);

        MainHelper.clearCall();
    }

    private BufferedImage _bfimg;
    private void drawTargetSubGrid(Graphics2D g2, int bx, int by) {
        Line2D.Double dln = new Line2D.Double();

        for (int l = _dcc + 1, i = 0; i < l; i++) {
            int x1 = bx + (GameConfig.get_celw(1) * i);
            int y1 = by;
            int x2 = x1;
            int y2 = by + (GameConfig.get_celh(1) * _dcc);
            dln.setLine(x1, y1, x2, y2);
            g2.draw(dln);
        }

        for (int l = _dcc + 1, i = 0; i < l; i++) {
            int x1 = bx;
            int y1 = by + (GameConfig.get_celh(1) * i);
            int x2 = bx + (GameConfig.get_celw(1) * _dcc);
            int y2 = y1;
            dln.setLine(x1, y1, x2, y2);
            g2.draw(dln);
        }
    }
    private void drawBackGrid(Graphics tg) {
        if (_bfimg == null) {
            _bfimg = new BufferedImage(_frct.width, _frct.height, BufferedImage.TYPE_INT_ARGB);

            Graphics2D g2 = _bfimg.createGraphics();
            g2.scale(0.7, 0.7);
            g2.setColor(GameConfig.clpab);
            g2.fillRect(0, 0, _frct.width, _frct.height);

            g2.setColor(GameConfig.clgln);
            drawTargetSubGrid(g2, 4, 4);
            drawTargetSubGrid(g2, 4, 130);
            drawTargetSubGrid(g2, 4, 256);
        }

        tg.drawImage(_bfimg, 0, 0, this);
    }

}
