package rqtt87;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public final class MainApp {
	private static void println(String msg) {
		System.out.println(msg);
	}

	public static void main(String[] args) {
		println("==================================================");
		_mfrm = new MainFrame();
	}

	@SuppressWarnings("unused")
	private static MainFrame _mfrm;


	@SuppressWarnings("serial")
	private static final class MainFrame extends JFrame {
		public MainFrame() {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("XXXX");

            _pnlRootCont = (JPanel)getContentPane();
            _pnlRootCont.setPreferredSize(new Dimension(470, 630));
            initComponents();

            pack();
            setLocation(0, 0);
            // setResizable(false);
            setMinimumSize(getSize());
            setVisible(true);
		}
		private JPanel _pnlRootCont;
		private JPanel _pnlLeft;
		private JPanel _pnlRight;

		private void initComponents() {
			_pnlRootCont.setLayout(new BorderLayout(2, 2));

            _pnlLeft = new JPanel();
            _pnlLeft.setBackground(Color.black);
            _pnlLeft.setPreferredSize(new Dimension(140, 0));
            _pnlRootCont.add(_pnlLeft, BorderLayout.WEST);

            _pnlRight = new RightPanel();
            _pnlRootCont.add(_pnlRight, BorderLayout.CENTER);
		}
	}

	@SuppressWarnings("serial")
	private static final class RightPanel extends JPanel implements ActionListener {
		public RightPanel() {
            setBackground(Color.darkGray);

            _drc = new Rectangle2D.Double();
			_drc.setRect(100, 100, 30, 30);
            _tmr = new Timer(10, this);
            _tmr.start();
		}

		private Rectangle2D.Double _drc;
		private double _scx = 1.0;
		private double _scy = 1.0;

		private Timer _tmr;
		@Override
		public void actionPerformed(ActionEvent te) {
			repaint();
		}

		@Override
		protected void paintComponent(Graphics tg) {
			super.paintComponent(tg);
//			println("====================" + tg.hashCode());

			/*
			Graphics2D g2 = (Graphics2D)tg;
			g2.setColor(Color.red);

			AffineTransform atf = g2.getTransform();
			double ew = _drc.getWidth();
			double eh = _drc.getHeight();
			double ex = _drc.getX() + (ew / 2);
			double ey = _drc.getY() + (eh / 2);
			atf.translate(ex, ey);
			_scx += 0.1;
			_scy += 0.1;
			atf.scale(_scx, _scy);
			atf.translate(-ex, -ey);
			g2.setTransform(atf);
			g2.fill(_drc);
			*/

//			Graphics2D g2 = (Graphics2D)tg;
//            g2.setRenderingHint(
//                RenderingHints.KEY_ANTIALIASING,
//                RenderingHints.VALUE_ANTIALIAS_ON
//            );
//            AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
//            g2.setComposite(ac);
//			g2.setColor(Color.red);
//
//			double ex = _drc.getX() + (_drc.getWidth() / 2);
//			double ey = _drc.getY() + (_drc.getHeight() / 2);
//			g2.translate(ex, ey);
//
//			_scx += 0.01;
//			_scy += 0.01;
//			g2.scale(_scx, _scy);
//			g2.translate(-ex, -ey);
//
//			g2.fill(_drc);
//
//			System.gc();

//			zoomInRect((Graphics2D)tg);
			zoomInRect2((Graphics2D)tg);
		}

		private void zoomInRect(Graphics2D g2) {
            g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
            );
            AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
            g2.setComposite(ac);
			g2.setColor(Color.red);

			double ex = _drc.getX() + (_drc.getWidth() / 2);
			double ey = _drc.getY() + (_drc.getHeight() / 2);
			g2.translate(ex, ey);

			_scx += 0.01;
			_scy += 0.01;
			g2.scale(_scx, _scy);
			g2.translate(-ex, -ey);

			g2.fill(_drc);

			System.gc();
		}

		private void zoomInRect2(Graphics2D g2) {
//			org.jd

            g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
            );
//            g2.setRenderingHint(
//        	    RenderingHints.KEY_INTERPOLATION,
//        	    RenderingHints.VALUE_INTERPOLATION_BILINEAR // 또는 BICUBIC
//        	);
			g2.setColor(Color.red);

			// 100, 100, 30, 30

			double gv = 0.5;
			double tx = _drc.getX() - gv;
			double ty = _drc.getY() - gv;
			double tw = _drc.getWidth() + (gv * 2);
			double th = _drc.getHeight() + (gv * 2);
			if (tx < 0) {
				tx = 0;
				tw = 200;
			}
			if (ty < 0) {
				ty = 0;
				th = 200;
			}
			_drc.setRect(tx, ty, tw, th);
			g2.fill(_drc);

			System.gc();
		}
	}
}
