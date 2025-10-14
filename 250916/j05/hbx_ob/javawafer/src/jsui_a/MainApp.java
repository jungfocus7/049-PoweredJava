package jsui_a;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
// import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


//#region [01)~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ MainApp]
public final class MainApp {
    public static void println(String msg) {
        System.out.println(msg);
    }

	public static void clearCall() {
		println("##clearCall");
		System.gc();
	}


    public static void main(String[] args) throws Exception {
        println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        createMainFrame();
    }

    private static MainFrame _mfrm;
    public static MainFrame getMainFrame() {
        return _mfrm;
    }

    private static void createMainFrame() {
        if (_mfrm == null) {
            _mfrm = new MainFrame();
            _mfrm.open();

            _mfrm.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent te) {
                    // MainApp.println(">>> " + te);
                    _mfrm.getRightPanel().updateRenderType(te.getKeyCode());
                }
            });
        }
    }
}
//#endregion


final class MainFrame extends JFrame {
	public MainFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("MainFrame");

		initComponents();

		pack();
		setLocation(0, 0);
		// setResizable(false);
		setMinimumSize(getSize());
		// setVisible(true);

		// addComponentListener(this);
		// addMouseListener(this);
		// addMouseMotionListener(this);
		// addKeyListener(this);
	}

	private JPanel _pnlRootCont;
	private JPanel _pnlLeft;
	private RightPanel _pnlRight;
    public RightPanel getRightPanel() {
        return _pnlRight;
    }

	private void initComponents() {
		_pnlRootCont = (JPanel)getContentPane();
		_pnlRootCont.setPreferredSize(new Dimension(470, 630));

		_pnlRootCont.setLayout(new BorderLayout(2, 2));
		_pnlLeft = new JPanel();
		_pnlLeft.setBackground(Color.black);
		_pnlLeft.setPreferredSize(new Dimension(140, 0));
		_pnlRootCont.add(_pnlLeft, BorderLayout.WEST);

		_pnlRight = new RightPanel();
        _pnlRight.setBackground(Color.darkGray);
		_pnlRootCont.add(_pnlRight, BorderLayout.CENTER);
	}

	public void open() {
		setVisible(true);
	}

}

interface PaintAction {
    void render(Graphics2D g2);
}

final class RightPanel extends JPanel {
    public RightPanel() {
        _pats.add(new PaintAction() {
            @Override
            public void render(Graphics2D g2) {
                g2.setColor(Color.red);
                g2.fillRect(10, 500, 100, 100);
            }
        });
        _pats.add(new PaintAction() {
            @Override
            public void render(Graphics2D g2) {
                g2.setColor(Color.green);
                for (int i = 0; i < 5000000; i++) {
                    int tx = (int)(0.00002 * i);
                    int ty = (int)(0.00002 * i);
                    g2.fillRect(tx, ty, 10, 10);
                }
            }
        });
    }

    private final ArrayList<PaintAction> _pats = new ArrayList<PaintAction>();

    private static final String _RTP_NORMAL = "rtpNormal";
    private static final String _RTP_BITMAP = "rtpBitmap";
    private String _rtp = _RTP_NORMAL;
    public void updateRenderType(int keyCode) {
        if (keyCode == KeyEvent.VK_0) {
            _rtp = null;
            repaint();
        } else if (keyCode == KeyEvent.VK_1) {
            _rtp = _RTP_NORMAL;
            repaint();
        } else if (keyCode == KeyEvent.VK_2) {
            _rtp = _RTP_BITMAP;
            repaint();
        } else if (keyCode == KeyEvent.VK_G) {
            MainApp.clearCall();
        }
    }

    private BufferedImage _bfimg;
    private void bitmapRender(Graphics tg) {
        int rw = getWidth();
        int rh = getHeight();
        _bfimg = new BufferedImage(rw, rh, BufferedImage.TYPE_INT_RGB);

        Graphics2D g2 = _bfimg.createGraphics();
        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(Color.blue);
        g2.fillRect(0, 0, rw, rh);

        for (PaintAction pat : _pats) {
            pat.render(g2);
        }

        tg.drawImage(_bfimg, 0, 0, this);
        g2.dispose();
    }

    private void normalRender(Graphics tg) {
        Graphics2D g2 = (Graphics2D)tg;
        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

        for (PaintAction pat : _pats) {
            pat.render(g2);
        }

        g2.dispose();
    }


    @Override
    protected void paintComponent(Graphics tg) {
        super.paintComponent(tg);

        if (_RTP_NORMAL.equals(_rtp)) {
            normalRender(tg);
        } else if (_RTP_BITMAP.equals(_rtp)) {
            bitmapRender(tg);
        }

        MainApp.clearCall();
    }
}


