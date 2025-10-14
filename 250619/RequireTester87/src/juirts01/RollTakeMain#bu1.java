//package juirts01;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.RenderingHints;
//import java.awt.event.ComponentEvent;
//import java.awt.event.ComponentListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseMotionListener;
//import java.awt.geom.Point2D;
//import java.awt.geom.Rectangle2D;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
//
//public final class RollTakeMain {
//	public static boolean isPrint = true;
//	public static void println(String msg) {
//		if (isPrint) {
//			System.out.println(msg);
//		}
//	}
//
//    private static void printMemoryUsage() {
//        Runtime rtm = Runtime.getRuntime();
//        long max = rtm.maxMemory();
//        long total = rtm.totalMemory();
//        long free = rtm.freeMemory();
//
//        long used = total - free;
//
//        // 바이트(Byte)를 메가바이트(MB)로 변환 (1024 * 1024)
//        long toMB = 1024L * 1024L;
//
//        println("--- JVM Heap Memory Usage ---");
//        println("Max Memory (최대 할당): " + (max / toMB) + " MB");
//        println("Total Allocated (현재 할당): " + (total / toMB) + " MB");
//        println("Used Memory (사용 중): " + (used / toMB) + " MB");
//        println("Free Memory (사용 가능): " + (free / toMB) + " MB");
//    }
//
//	public static void clearCall() {
////		println("##clearCall");
//		System.gc();
////		printMemoryUsage();
//	}
//
//
//	public static void main(String[] args) {
//		println("==================================================");
//		_mfrm = new RollTakeFrame();
//	}
//
//	private static RollTakeFrame _mfrm;
//	public static RollTakeFrame getFrame() {
//		return _mfrm;
//	}
//
//
//	@SuppressWarnings("serial")
//	public static abstract class RollFrame extends JFrame
//			implements ComponentListener, MouseListener, MouseMotionListener, KeyListener {
//
//		public RollFrame(String title) {
////			println("BaseFrame Call");
//
//            setDefaultCloseOperation(EXIT_ON_CLOSE);
//            setTitle(title);
//
//            initComponents();
//
//            pack();
//            setLocation(0, 0);
//            // setResizable(false);
//            setMinimumSize(getSize());
//            setVisible(true);
//
//            addComponentListener(this);
//            addMouseListener(this);
//            addMouseMotionListener(this);
//            addKeyListener(this);
//		}
//
//		@Override
//		public void componentResized(ComponentEvent te) {
////			println("##componentResized");
//			clearCall();
//		}
//
//		@Override
//		public void componentMoved(ComponentEvent te) {
////			println("##componentMoved");
//			clearCall();
//		}
//
//		@Override
//		public void componentShown(ComponentEvent te) {
////			println("##componentShown");
//			clearCall();
//		}
//
//		@Override
//		public void componentHidden(ComponentEvent te) {
////			println("##componentHidden");
//			clearCall();
//		}
//
//
//		@Override
//		public void mouseClicked(MouseEvent te) {
////			println("##mouseClicked");
//		}
//
//		@Override
//		public void mousePressed(MouseEvent te) {
////			println("##mousePressed");
//		}
//
//		@Override
//		public void mouseReleased(MouseEvent te) {
////			println("##mouseReleased");
//		}
//
//		@Override
//		public void mouseEntered(MouseEvent te) {
////			println("##mouseEntered");
//		}
//
//		@Override
//		public void mouseExited(MouseEvent te) {
////			println("##mouseExited");
//		}
//
//
//		@Override
//		public void mouseDragged(MouseEvent te) {
////			println("##mouseDragged");
//		}
//
//		@Override
//		public void mouseMoved(MouseEvent te) {
////			println("##mouseMoved");
//		}
//
//
//		@Override
//		public void keyTyped(KeyEvent te) {
////			println("##keyTyped");
//		}
//
//		@Override
//		public void keyPressed(KeyEvent te) {
////			println("##keyPressed");
//		}
//
//		@Override
//		public void keyReleased(KeyEvent te) {
////			println("##keyReleased");
//		}
//
//
//		protected abstract void initComponents();
//
//	}
//
//	@SuppressWarnings("serial")
//	private static final class RollTakeFrame extends RollFrame {
//		public RollTakeFrame() {
//			super("RollTakeFrame");
//		}
//		private JPanel _pnlRootCont;
//		private JPanel _pnlLeft;
//		private RightPanel _pnlRight;
//
//		@Override
//		protected void initComponents() {
//            _pnlRootCont = (JPanel)getContentPane();
//            _pnlRootCont.setPreferredSize(new Dimension(470, 630));
//
//			_pnlRootCont.setLayout(new BorderLayout(2, 2));
//
//            _pnlLeft = new JPanel();
//            _pnlLeft.setBackground(Color.black);
//            _pnlLeft.setPreferredSize(new Dimension(140, 0));
//            _pnlRootCont.add(_pnlLeft, BorderLayout.WEST);
//
//            _pnlRight = new RightPanel();
//            _pnlRootCont.add(_pnlRight, BorderLayout.CENTER);
//		}
//
////		@Override
////		public void mouseClicked(MouseEvent te) {
////			println("##mouseClicked");
////
////			_pnlRight.bx = !_pnlRight.bx;
////			_pnlRight.repaint();
////		}
//
//		@Override
//		public void keyPressed(KeyEvent te) {
//			println("##keyPressed");
//
//			switch (te.getKeyCode()) {
//				case KeyEvent.VK_UP: {
//					_pnlRight.bx = true;
//					_pnlRight.repaint();
//					break;
//				}
//				case KeyEvent.VK_DOWN: {
//					_pnlRight.bx = false;
//					_pnlRight.repaint();
//					break;
//				}
//			}
//		}
//
//	}
//
//	@SuppressWarnings("serial")
//	private static final class RightPanel extends JPanel {
//		public RightPanel() {
//            setBackground(Color.darkGray);
//
//            _prc = new Rectangle2D.Double();
//            _drc = new Rectangle2D.Double();
//            _dpt = new Point2D.Double();
//
//            _prc.setRect(0, 0, 20, 20);
//            _drc.setRect(_prc.x, _prc.y, _prc.width, _prc.height);
//            _dpt.setLocation(0.0, 0.0);
//		}
//		private Rectangle2D.Double _prc;
//		private Rectangle2D.Double _drc;
//		private Point2D.Double _dpt;
//
//
//		@Override
//		protected void paintComponent(Graphics tg) {
//			super.paintComponent(tg);
//
//			if (!bx) {
//				clearCall();
//				return;
//			}
//
//			Graphics2D g2 = (Graphics2D)tg;
//            g2.setRenderingHint(
//            	RenderingHints.KEY_ANTIALIASING,
//            	RenderingHints.VALUE_ANTIALIAS_ON);
//			g2.setColor(Color.red);
//
//			double gx = 1.0;
//			double gy = 0.2;
//			for (int i = 0; i < 1000000; i++) {
//				double tx = gx * i;
//				double ty = gy * i;
//				double tw = _prc.getWidth();
//				double th = _prc.getHeight();
//				_drc.setRect(tx, ty, tw, th);
//				g2.fill(_drc);
//
////				println(">>> " + _drc);
//			}
//
//			g2.dispose();
//
//			clearCall();
//		}
//
//		public boolean bx = false;
//	}
//
//}
