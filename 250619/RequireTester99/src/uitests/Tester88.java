package uitests;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public final class Tester88 {
	public static void println(String msg) {
		System.out.println(msg);
	}


	public static void main(String[] args) throws Exception {
		println("==================================================");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                _frm = new TestFrame88();
            }
        });
	}

    private static TestFrame88 _frm;
    public static TestFrame88 getFrame() {
        return _frm;
    }

    public static boolean checkNotRenderable() {
    	if (_frm == null) {
			return false;
		}
		else {
			return !_frm.isActive();
		}
    }



	@SuppressWarnings("serial")
	private static final class TestFrame88 extends JFrame {
		public TestFrame88() {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("XXXX");

            _rootCont = (JPanel)getContentPane();
            _rootCont.setPreferredSize(new Dimension(500, 700));
            initComponents();

            pack();
            setLocation(40, 10);
            // setResizable(false);
            setMinimumSize(getSize());

            setVisible(true);
		}
		private JPanel _rootCont;
        private JPanel _pnlLeft;
        private JPanel _pnlRight;

		private void initComponents() {
            _rootCont.setLayout(new BorderLayout());

            _pnlLeft = new JPanel();
            _pnlLeft.setBackground(new Color(0xB5B5B5));
            _pnlLeft.setPreferredSize(new Dimension(140, 0));
            _rootCont.add(_pnlLeft, BorderLayout.WEST);

            _pnlRight = new GamePanel88(this);
            _pnlRight.setBackground(Color.darkGray);
            _rootCont.add(_pnlRight, BorderLayout.CENTER);
		}
	}


	@SuppressWarnings("serial")
	private static final class GamePanel88 extends JPanel implements ComponentListener {
        public GamePanel88(TestFrame88 frm) {
        	_frm = frm;

        	setLayout(null);
            _cvs = new CellCanvas88(this);
            add(_cvs);

            addComponentListener(this);
        }

        private TestFrame88 _frm;
        public TestFrame88 getFrame() {
        	return _frm;
        }

        private CellCanvas88 _cvs;
        public CellCanvas88 getCanvas() {
        	return _cvs;
        }


		@Override
		public void componentResized(ComponentEvent te) {
//			Tester87.println("componentResized");
			_cvs.setBounds(0, 0, getWidth(), getHeight());
//			_cvs.updateSize(getWidth(), getHeight());
		}

		@Override
		public void componentMoved(ComponentEvent te) {
//			Tester87.println("componentMoved");
		}

		@Override
		public void componentShown(ComponentEvent te) {
//			Tester87.println("componentShown");
		}

		@Override
		public void componentHidden(ComponentEvent te) {
//			Tester87.println("componentHidden");
		}

    }


	@SuppressWarnings("serial")
	private static final class CellCanvas88 extends JComponent {
		public CellCanvas88(GamePanel88 pgpnl) {
			_pgpnl = pgpnl;


			setCursor(new Cursor(Cursor.HAND_CURSOR));

			addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent te) {
				}

				@Override
				public void mousePressed(MouseEvent te) {
					Tester88.println("mousePressed");
					Tester88.println(">>> " + te.getButton());

					int mb = te.getButton();
					if (mb == MouseEvent.BUTTON1) {
						_brd = !_brd;
//						renderToBuffer();
						repaint();
					}
				}

				@Override
				public void mouseExited(MouseEvent te) {
				}

				@Override
				public void mouseEntered(MouseEvent te) {
				}

				@Override
				public void mouseClicked(MouseEvent te) {
//					Tester88.println("mouseClicked");
				}
			});
		}
		private GamePanel88 _pgpnl;
		private BufferedImage _bfimg;
		private boolean _brd = true;

//		public void updateSize(int tw, int th) {
//			setBounds(0, 0, tw, th);
//
//			renderToBuffer();
//		}

//		public void renderToBuffer() {
//			_bfimg = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
//
//
//		    Graphics2D g2 = _bfimg.createGraphics();
//
//		    if (_brd) {
//		    	g2.setColor(Color.red);
//		    	int rw = 10;
//		    	int rh = 10;
//		    	int tx, ty;
//		    	for (int i = 0; i < 3000000; i++) {
//			    	tx = 1 * i;
//			    	ty = 3 * i;
//			    	g2.fillRect(tx, ty, rw, rh);
//		    	}
//
////		    	Tester88.println(">>> " + _brd);
//		    	System.gc();
//	    	}
//	    	else {
////		    	Tester88.println(">>> " + _brd);
//		    	System.gc();
//	    	}
//
//		    g2.dispose();
//
//		    repaint();
//		}

        @Override
        protected void paintComponent(Graphics tg) {
            super.paintComponent(tg);

            Tester88.println("CellCanvas88#paintComponent");

//            if (_bfimg != null) {
//                tg.drawImage(_bfimg, 0, 0, this);
//            }

            if (_brd) {
	            tg.setColor(Color.red);
	            int rw = 10;
	            int rh = 10;
	            int tx, ty;
	            for (int i = 0; i < 300000; i++) {
	            	tx = 1 * i;
	            	ty = 3 * i;
					tg.fillRect(tx, ty, rw, rh);
				}

	            Tester88.println(">>> " + _brd);
	            System.gc();
            }
            else {
            	Tester88.println(">>> " + _brd);
            	System.gc();
            }
        }
	}

}
