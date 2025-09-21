package hbx.tapps.ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import hbx.tapps.MainApp;

public final class CanvasPanel extends JPanel implements MouseMotionListener {
    public CanvasPanel() {
    }

    private MainFrame _mfrm;

    public void initOnce(MainFrame mfrm) {
        _mfrm = mfrm;
        addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics tg) {
        Graphics2D tg2d = (Graphics2D) tg;
        tg2d.setPaint(Color.BLUE);
        // tg2d.setColor(Color.RED);
        tg2d.setStroke(new BasicStroke(5));
        // tg2d.setBackground(Color.RED);
        // tg2d.drawLine(0, 0, 500, 500);
        // tg2d.drawRect(10, 10, 100, 100);
        tg2d.drawRect(10, 10, 100, 100);
        tg2d.setPaint(Color.RED);
        tg2d.fillRect(10, 10, 100, 100);
        MainApp.println("paint");
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        _mfrm.setTitle(">>> " + me.toString());
        // MainApp.println(">>> " + me.toString());
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}
