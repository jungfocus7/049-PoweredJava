package permit_x;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


@SuppressWarnings("serial")
public final class XTestFrame extends JFrame {
	public static void trace(String msg) {
		System.out.println(msg);
	}


	private static XTestFrame _mfrm;

	public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                _mfrm = new XTestFrame();
                _mfrm.open();
            }
        });
	}



	public XTestFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("XTestFrame");

		initComponents();

		pack();
		setLocation(0, 0);
		setResizable(false);
		setMinimumSize(getSize());
		// setVisible(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent te) {
            }
        });
	}

	private JPanel _pnlRootCont;
    public JPanel getRootPanel() {
        return _pnlRootCont;
    }

	private JPanel _pnlLeft;
    public JPanel getLeftPanel() {
        return _pnlLeft;
    }

	private JPanel _pnlRight;
    public JPanel getRightPanel() {
        return _pnlRight;
    }

	private void initComponents() {
		_pnlRootCont = (JPanel)getContentPane();
        _pnlRootCont.setBackground(Color.black);
		_pnlRootCont.setPreferredSize(new Dimension(470, 630));

		_pnlRootCont.setLayout(new BorderLayout(4, 2));
		_pnlLeft = new JPanel();
		_pnlLeft.setBackground(Color.black);
		_pnlLeft.setPreferredSize(new Dimension(150, 0));
		_pnlLeft.setLayout(null);
		_pnlRootCont.add(_pnlLeft, BorderLayout.WEST);

		_pnlRight = new RightPanel();
		_pnlRootCont.add(_pnlRight, BorderLayout.CENTER);
	}

    public void open() {
        setVisible(true);
        requestFocusInWindow();
    }

}


interface ICallback {
	void invoke(String cbt, double now);
}
final class SmoothMove {
	public SmoothMove(double now, double speed) {
		_running = false;
		_end = now;
		_now = now;
		_speed = speed;

		_tmr = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent te) {
				loopFrame(te);
			}
		});
	}

    private boolean _running;
    public boolean is_running() {
    	return _running;
    }

    private double _end;
    public double get_end() {
    	return _end;
    }

    private double _now;
    public double get_now() {
    	return _now;
    }

    private double _speed;
    public double get_speed() {
    	return _speed;
    }

    public ICallback callback;
	private void performed(String ept) {
//		XTestFrame.trace("##performed >> " + ept + ", now: ");
//		XTestFrame.trace("##performed >> _now: " + _now);
		if (callback != null) {
			callback.invoke(ept, _now);
		}
	}

	private Timer _tmr;
	private void clearFrame() {
    	if (_running) {
    		_tmr.stop();
    		_running = false;
    	}

	}
	private void loopFrame(ActionEvent te) {
		double dst = _end - _now;
		if (Math.abs(dst) < 1) {
			_now = _end;
			clearFrame();
			performed("End");
		} else {
			_now = _now + (dst * _speed);
			performed("Update");
		}
	}


    public void stop() {
		clearFrame();
    }

    public void fromTo(double end, double now) {
    	if (_running) {
    		clearFrame();
    	}

    	_end = end;
    	_now = now;
    	_running = true;
    	_tmr.setInitialDelay(0);
    	_tmr.start();
    }

    public void to(double end) {
    	fromTo(end, _now);
    }

}

@SuppressWarnings("serial")
final class RightPanel extends JPanel implements MouseListener, MouseMotionListener {
    public RightPanel() {
        setBackground(Color.darkGray);
        setLayout(null);

        addMouseListener(this);
        addMouseMotionListener(this);
    }

    private boolean _bcr = true;
    @Override
    protected void paintComponent(Graphics tg) {
    	if (_bcr) {
    		_bcr = false;
    		return;
    	}

    	super.paintComponent(tg);
//    	XTestFrame.trace("한번만 실행되라 좀");

    	Graphics2D g2 = (Graphics2D)tg;
    	drawRect(g2);
    }

    private final SmoothMove _smm = new SmoothMove(0.0, 0.1);
    private final Rectangle2D.Double _rct = new Rectangle2D.Double(10, 10, 100, 100);
    private void drawRect(Graphics2D g2) {
    	g2.setColor(Color.red);
    	g2.fill(_rct);
    }

	@Override
	public void mousePressed(MouseEvent te) {
		if (_smm.callback == null) {
			_smm.callback = new ICallback() {
				@Override
				public void invoke(String cbt, double now) {
					_rct.setRect(_rct.getX(), now, _rct.getWidth(), _rct.getHeight());
					repaint();
				}
			};
		}
		_smm.to(te.getY());
	}

	@Override
	public void mouseMoved(MouseEvent te) {
		if (_smm.callback == null) {
			_smm.callback = new ICallback() {
				@Override
				public void invoke(String cbt, double now) {
					_rct.setRect(_rct.getX(), now, _rct.getWidth(), _rct.getHeight());
					repaint();
				}
			};
		}
		_smm.to(te.getY());
	}

	@Override
	public void mouseClicked(MouseEvent te) {
	}

	@Override
	public void mouseReleased(MouseEvent te) {
	}

	@Override
	public void mouseEntered(MouseEvent te) {
	}

	@Override
	public void mouseExited(MouseEvent te) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}



