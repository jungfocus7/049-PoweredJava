package uitests;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public final class Tester87 {
	public static void println(String msg) {
		System.out.println(msg);
	}


	public static void main(String[] args) {
		println("==================================================");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                _frm = new TestFrame87();
            }
        });
	}

    private static TestFrame87 _frm;
    public static TestFrame87 getFrame() {
        return _frm;
    }

    public static boolean checkNotRenderable() {
    	return !_frm.isActive();
    }



	@SuppressWarnings("serial")
	private static final class TestFrame87 extends JFrame implements ComponentListener {
		public TestFrame87() {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("XXXX");

            _rootCont = (JPanel)getContentPane();
            _rootCont.setPreferredSize(new Dimension(500, 700));
            initComponents();

            pack();
            setLocation(40, 10);
            // setResizable(false);
            setMinimumSize(getSize());

            addComponentListener(this);

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

            _pnlRight = new GamePanel87(this);
            _pnlRight.setBackground(Color.darkGray);
            _rootCont.add(_pnlRight, BorderLayout.CENTER);

//            TestFrame87__main.println(">>>>>>>>>> " + _pnlLeft.getPreferredSize());
//            TestFrame87__main.println(">>>>>>>>>> " + _pnlRight.getSize());
		}


		@Override
		public void componentResized(ComponentEvent te) {
//			Tester87.println("componentResized");
//			Tester87.println(">>> " + _pnlRight.getSize());
		}

		@Override
		public void componentMoved(ComponentEvent te) {
//			Tester87.println("componentMoved");
//			Tester87.println(">>> " + _pnlRight.getSize());
		}

		@Override
		public void componentShown(ComponentEvent te) {
//			Tester87.println("componentShown");
//			Tester87.println(">>> " + _pnlRight.getSize());
		}

		@Override
		public void componentHidden(ComponentEvent te) {
//			Tester87.println("componentHidden");
//			Tester87.println(">>> " + _pnlRight.getSize());
		}

	}


	@SuppressWarnings("serial")
	private static class GamePanel87 extends JPanel {
        public GamePanel87(TestFrame87 frm) {
        	_frm = frm;

//            setLayout(new BorderLayout());
        	Tester87.println(")))))) " + getLayout());
            _cvs = new CellCanvas87(this);
            add(_cvs);

//            TestFrame87__main.println(">>> " + getComponentCount());
            addMouseMotionListener(new MouseMotionListener() {
				@Override
				public void mouseDragged(MouseEvent te) {
				}

				@Override
				public void mouseMoved(MouseEvent te) {
//					TestFrame87__main.println(">>> " + getComponentCount());
				}
			});
        }

        private TestFrame87 _frm;
        public TestFrame87 getFrame() {
        	return _frm;
        }

        private CellCanvas87 _cvs;
        public CellCanvas87 getCanvas() {
        	return _cvs;
        }

        private final Rectangle _frct = new Rectangle();
        @Override
        protected void paintComponent(Graphics tg) {
        	if (Tester87.checkNotRenderable()) {
				return;
			}

            super.paintComponent(tg);

//            Tester87.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~1");
//            TestFrame87__main.println(">>>>>>>>>> " + tg.getClip());
//            TestFrame87__main.println(">>>>>>>>>> " + tg.getClipBounds());

//            Rectangle rct = new Rectangle();
//            tg.getClipBounds(rct);
//
//            Graphics2D g2 = (Graphics2D)tg;
//            g2.getClipBounds(_frct);
//            TestFrame87__main.println("#### " + _frct.hashCode());

//			Graphics2D g2 = (Graphics2D)tg;
//			Rectangle frc = g2.getClipBounds(_frct);
//			TestFrame87__main.println("#### " + frc.hashCode());
//            _cvs.setSize(frc.width, frc.height);

        }

    }


	@SuppressWarnings("serial")
	private static class CellCanvas87 extends JComponent {
		public CellCanvas87(GamePanel87 pgpnl) {
			_pgpnl = pgpnl;

//			setPreferredSize(new Dimension(100, 100));
//			setSize(100, 100);

//			TestFrame87__main.println(">>>1 " + getSize());
//			TestFrame87__main.println(">>>2 " + getPreferredSize());
//			TestFrame87__main.println(">>>3 " + _pgpnl.getPreferredSize());
		}
		private GamePanel87 _pgpnl;


        @Override
        protected void paintComponent(Graphics tg) {
        	if (Tester87.checkNotRenderable()) {
				return;
			}

//        	Tester87.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~2");
//        	Tester87.println(">>> " + getPreferredSize());
//        	Tester87.println(">>> " + getSize());
//        	TestFrame87__main.println(">>> " + isFocusable());
//        	TestFrame87__main.println(">>> " + TestFrame87__main.checkNotRenderable());

//            super.paintComponent(tg);

//            tg.setColor(Color.red);
//            tg.fillRect(10, 10, 400, 400);
        }
	}


}
