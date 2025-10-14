package juirts01;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;


public final class RollTakeMain {
	public static boolean isPrint = true;
	public static void println(String msg) {
		if (isPrint) {
			System.out.println(msg);
		}
	}

    private static void printMemoryUsage() {
        Runtime rtm = Runtime.getRuntime();
        long max = rtm.maxMemory();
        long total = rtm.totalMemory();
        long free = rtm.freeMemory();

        long used = total - free;

        // 바이트(Byte)를 메가바이트(MB)로 변환 (1024 * 1024)
        long toMB = 1024L * 1024L;

        println("--- JVM Heap Memory Usage ---");
        println("Max Memory (최대 할당): " + (max / toMB) + " MB");
        println("Total Allocated (현재 할당): " + (total / toMB) + " MB");
        println("Used Memory (사용 중): " + (used / toMB) + " MB");
        println("Free Memory (사용 가능): " + (free / toMB) + " MB");
    }

	public static void clearCall() {
		println("##clearCall");
		System.gc();
//		printMemoryUsage();
	}

    public static boolean checkNotRenderable() {
    	return !_mfrm.isActive();
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static void main(String[] args) {
		println("==================================================");
		_mfrm = new RollTakeFrame();
//		_mfrm.getCanvas().initAndStart();
	}

	private static RollTakeFrame _mfrm;
	public static RollTakeFrame getFrame() {
		return _mfrm;
	}


	@SuppressWarnings("serial")
	public static abstract class RollFrame extends JFrame
			implements ComponentListener, MouseListener, MouseMotionListener, KeyListener {

		public RollFrame(String title) {
//			println("BaseFrame Call");

            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle(title);

            initComponents();

            pack();
            setLocation(0, 0);
            // setResizable(false);
            setMinimumSize(getSize());
            setVisible(true);

            addComponentListener(this);
            addMouseListener(this);
            addMouseMotionListener(this);
            addKeyListener(this);
		}

		@Override
		public void componentResized(ComponentEvent te) {
//			println("##componentResized");
			clearCall();
		}

		@Override
		public void componentMoved(ComponentEvent te) {
//			println("##componentMoved");
			clearCall();
		}

		@Override
		public void componentShown(ComponentEvent te) {
//			println("##componentShown");
			clearCall();
		}

		@Override
		public void componentHidden(ComponentEvent te) {
//			println("##componentHidden");
			clearCall();
		}


		@Override
		public void mouseClicked(MouseEvent te) {
//			println("##mouseClicked");
		}

		@Override
		public void mousePressed(MouseEvent te) {
//			println("##mousePressed");
		}

		@Override
		public void mouseReleased(MouseEvent te) {
//			println("##mouseReleased");
		}

		@Override
		public void mouseEntered(MouseEvent te) {
//			println("##mouseEntered");
		}

		@Override
		public void mouseExited(MouseEvent te) {
//			println("##mouseExited");
		}


		@Override
		public void mouseDragged(MouseEvent te) {
//			println("##mouseDragged");
		}

		@Override
		public void mouseMoved(MouseEvent te) {
//			println("##mouseMoved");
		}


		@Override
		public void keyTyped(KeyEvent te) {
//			println("##keyTyped");
		}

		@Override
		public void keyPressed(KeyEvent te) {
//			println("##keyPressed");
		}

		@Override
		public void keyReleased(KeyEvent te) {
//			println("##keyReleased");
		}


		protected abstract void initComponents();

	}


	@SuppressWarnings("serial")
	private static final class RollTakeFrame extends RollFrame {
		public RollTakeFrame() {
			super("RollTakeFrame");
		}
		private JPanel _pnlRootCont;
		private JPanel _pnlLeft;
		private RightPanel _pnlRight;
		public RightPanel.GameCanvas getCanvas() {
			return _pnlRight.getCanvas();
		}

		@Override
		protected void initComponents() {
            _pnlRootCont = (JPanel)getContentPane();
            _pnlRootCont.setPreferredSize(new Dimension(470, 630));

			_pnlRootCont.setLayout(new BorderLayout(2, 2));

            _pnlLeft = new JPanel();
            _pnlLeft.setBackground(Color.black);
            _pnlLeft.setPreferredSize(new Dimension(140, 0));
            _pnlRootCont.add(_pnlLeft, BorderLayout.WEST);

            _pnlRight = new RightPanel();
            _pnlRootCont.add(_pnlRight, BorderLayout.CENTER);
		}

//		@Override
//		public void mouseClicked(MouseEvent te) {
//			println("##mouseClicked");
//
//			_pnlRight.bx = !_pnlRight.bx;
//			_pnlRight.repaint();
//		}

		@Override
		public void keyPressed(KeyEvent te) {
			println("##keyPressed");
			_pnlRight.keyAction(te);

//			switch (te.getKeyCode()) {
////				case KeyEvent.VK_UP: {
////					_pnlRight.bx = true;
////					_pnlRight.repaint();
////					break;
////				}
////				case KeyEvent.VK_DOWN: {
////					_pnlRight.bx = false;
////					_pnlRight.repaint();
////					break;
////				}
//				case KeyEvent.VK_DELETE: {
//					clearCall();
//					break;
//				}
//				case KeyEvent.VK_1: {
//					clearCall();
//					break;
//				}
//			}
		}

	}


	@SuppressWarnings("serial")
	private static final class RightPanel extends JPanel {
		public RightPanel() {
            setBackground(Color.darkGray);
            setLayout(null);

            _prc = new Rectangle2D.Double();
            _drc = new Rectangle2D.Double();
            _dpt = new Point2D.Double();

            _prc.setRect(0, 0, 20, 20);
            _drc.setRect(_prc.x, _prc.y, _prc.width, _prc.height);
            _dpt.setLocation(0.0, 0.0);

//            _gcvs = new GameCanvas();
//            add(_gcvs);
//            _gcvs.initAndStart();
		}
		private Rectangle2D.Double _prc;
		private Rectangle2D.Double _drc;
		private Point2D.Double _dpt;
		private GameCanvas _gcvs;
		public GameCanvas getCanvas() {
			return _gcvs;
		}

		private final List<PaintRender> _prds = new ArrayList<PaintRender>();
		@Override
		protected void paintComponent(Graphics tg) {
			super.paintComponent(tg);

			Graphics2D g2 = (Graphics2D)tg;
			for (PaintRender prd : _prds) {
				prd.paint(g2);
			}

			g2.dispose();
			clearCall();
		}

		public void keyAction(KeyEvent te) {
			switch (te.getKeyCode()) {
				case KeyEvent.VK_G: {
					clearCall();
					break;
				}
				case KeyEvent.VK_DELETE: {
					_prds.clear();
					repaint();
					break;
				}
				case KeyEvent.VK_1: {
					_prds.add(new PaintRender() {
						@Override
						public void paint(Graphics2D g2) {
							drawAllRect(g2);
						}
					});
					repaint();
					break;
				}
			}
		}

		private void drawAllRect(Graphics2D g2) {
            g2.setRenderingHint(
            	RenderingHints.KEY_ANTIALIASING,
            	RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setColor(Color.red);

			double gx = 0.0001;
			double gy = 0.0001;
			for (int i = 0; i < 1000000; i++) {
				double tx = gx * i;
				double ty = gy * i;
				double tw = _prc.getWidth();
				double th = _prc.getHeight();
				_drc.setRect(tx, ty, tw, th);
//				g2.fill(_drc);
				g2.fillRect((int)tx, (int)ty, (int)tw, (int)th);
			}
		}


	    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		private static interface PaintRender {
			public void paint(Graphics2D g2);
		}


		private static final class GameCanvas extends Canvas implements Runnable {
			public GameCanvas() {
				setBackground(Color.black);
	            setSize(300, 300);
			}
			private BufferStrategy _bfstg;
			private volatile boolean _isLoop = true;

			public void initAndStart() {
				createBufferStrategy(2);
				_bfstg = getBufferStrategy();

	            _prc = new Rectangle2D.Double();
	            _drc = new Rectangle2D.Double();
	            _prc.setRect(0, 0, 20, 20);
	            _drc.setRect(_prc.x, _prc.y, _prc.width, _prc.height);

		        // 게임 루프 시작
		        new Thread(this).start();
			}

			private Rectangle2D.Double _prc;
			private Rectangle2D.Double _drc;
			private void drawAllRect(Graphics2D g2) {
	            g2.setRenderingHint(
	            	RenderingHints.KEY_ANTIALIASING,
	            	RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(Color.red);

				double gx = 0.0001;
				double gy = 0.0001;
				for (int i = 0; i < 1000000; i++) {
					double tx = gx * i;
					double ty = gy * i;
					double tw = _prc.getWidth();
					double th = _prc.getHeight();
					_drc.setRect(tx, ty, tw, th);
					g2.fill(_drc);
				}
			}

			private void render() {
		        Graphics tg = _bfstg.getDrawGraphics();
/*
		        // 1. 화면 전체를 검은색으로 지우기 (매 프레임마다)
		        tg.setColor(Color.BLACK);
		        tg.fillRect(0, 0, getWidth(), getHeight());

		        // 2. 여기에 실제 그림 그리는 코드를 작성 (빨간색 사각형)
		        tg.setColor(Color.RED);
		        tg.fillRect(50, 50, 100, 100);*/

		        drawAllRect((Graphics2D)tg);

		        // 3. 그래픽스 객체 해제
		        tg.dispose();
			}

			@Override
			public void run() {
				while (_isLoop) {
					try {
						Thread.sleep(100);
					}
					catch (Exception ex) {
					}

					render();
					_bfstg.show();

					break;
				}
			}
		}


		private static final class GameCanvas2 extends Canvas implements Runnable {
			public GameCanvas2() {
				setBackground(Color.black);
	            setSize(300, 300);
			}
			private BufferStrategy _bfstg;
			private volatile boolean _isLoop = true;

			public void initAndStart() {
				createBufferStrategy(2);
				_bfstg = getBufferStrategy();

	            _prc = new Rectangle2D.Double();
	            _drc = new Rectangle2D.Double();
	            _prc.setRect(0, 0, 20, 20);
	            _drc.setRect(_prc.x, _prc.y, _prc.width, _prc.height);

		        // 게임 루프 시작
		        new Thread(this).start();
			}

			private Rectangle2D.Double _prc;
			private Rectangle2D.Double _drc;
			private void drawAllRect(Graphics2D g2) {
	            g2.setRenderingHint(
	            	RenderingHints.KEY_ANTIALIASING,
	            	RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(Color.red);

				double gx = 0.0001;
				double gy = 0.0001;
				for (int i = 0; i < 1000000; i++) {
					double tx = gx * i;
					double ty = gy * i;
					double tw = _prc.getWidth();
					double th = _prc.getHeight();
					_drc.setRect(tx, ty, tw, th);
					g2.fill(_drc);
				}
			}

			private void render() {
		        Graphics tg = _bfstg.getDrawGraphics();
/*
		        // 1. 화면 전체를 검은색으로 지우기 (매 프레임마다)
		        tg.setColor(Color.BLACK);
		        tg.fillRect(0, 0, getWidth(), getHeight());

		        // 2. 여기에 실제 그림 그리는 코드를 작성 (빨간색 사각형)
		        tg.setColor(Color.RED);
		        tg.fillRect(50, 50, 100, 100);*/

		        drawAllRect((Graphics2D)tg);

		        // 3. 그래픽스 객체 해제
		        tg.dispose();
			}

			@Override
			public void run() {
				while (_isLoop) {
					try {
						Thread.sleep(1000);
					}
					catch (Exception ex) {
					}

					render();
					_bfstg.show();

					break;
				}
			}
		}

		/*
		@Override
		protected void paintComponent(Graphics tg) {
			super.paintComponent(tg);

//			drawAllRect((Graphics2D)tg);
			drawAllRect2((Graphics2D)tg);
//			drawAllRect3((Graphics2D)tg);
//			drawAllRect4((Graphics2D)tg);
		}

		public boolean bx = false;
		private void drawAllRect(Graphics2D g2) {
//			if (!bx) {
//				clearCall();
//				return;
//			}

            g2.setRenderingHint(
            	RenderingHints.KEY_ANTIALIASING,
            	RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setColor(Color.red);

			double gx = 0.0001;
			double gy = 0.0001;
			for (int i = 0; i < 1000000; i++) {
				double tx = gx * i;
				double ty = gy * i;
				double tw = _prc.getWidth();
				double th = _prc.getHeight();
				_drc.setRect(tx, ty, tw, th);
				g2.fill(_drc);

//				println(">>> " + _drc);
			}

			g2.dispose();

			clearCall();
		}

		private void drawAllRect2(Graphics2D g2) {
			if (RollTakeMain.checkNotRenderable()) {
				return;
			}
			println("##drawAllRect2");

            g2.setRenderingHint(
            	RenderingHints.KEY_ANTIALIASING,
            	RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setColor(Color.red);

			double gx = 0.0001;
			double gy = 0.0001;
			for (int i = 0; i < 10000000; i++) {
				double tx = gx * i;
				double ty = gy * i;
				double tw = _prc.getWidth();
				double th = _prc.getHeight();
				_drc.setRect(tx, ty, tw, th);
				g2.fill(_drc);
			}

			g2.dispose();

			clearCall();
		}

		private final Area _drea = new Area();
		private void drawAllRect3(Graphics2D g2) {
            g2.setRenderingHint(
            	RenderingHints.KEY_ANTIALIASING,
            	RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setColor(Color.red);

			_drea.reset();
			double gx = 1.0;
			double gy = 0.2;
			for (int i = 0; i < 10000; i++) {
				double tx = gx * i;
				double ty = gy * i;
				double tw = _prc.getWidth();
				double th = _prc.getHeight();
				_drc.setRect(tx, ty, tw, th);
				_drea.add(new Area(_drc));
			}

			g2.fill(_drea);
			g2.dispose();

			clearCall();
		}

		private final Path2D.Double _path = new Path2D.Double();
		private void drawAllRect4(Graphics2D g2) {
            g2.setRenderingHint(
            	RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
    		g2.setColor(Color.red);

    		_path.reset();
			double gx = 1.0;
			double gy = 0.2;
			for (int i = 0; i < 1000000; i++) {
				double tx = gx * i;
				double ty = gy * i;
				double tw = _prc.getWidth();
				double th = _prc.getHeight();
				_drc.setRect(tx, ty, tw, th);
				_path.append(_drc, false);
			}

			g2.fill(_path);

			_path.reset();
			g2.dispose();

			clearCall();
		}
		*/
	}

}
