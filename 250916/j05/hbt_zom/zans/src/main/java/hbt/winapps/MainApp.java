package hbt.winapps;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.UIManager.*;


public final class MainApp {
//#region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 00)
    public static void println(String msg) {
        System.out.println(msg);
    }
//#endregion


//#region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 01)
    private static class MainFrame extends JFrame {
        static {
            try {
                LookAndFeelInfo[] lafia = UIManager.getInstalledLookAndFeels();
                UIManager.setLookAndFeel(lafia[1].getClassName());
            } catch (Exception ex) {
                MainApp.println(ex.toString());
            }
        }

        public MainFrame() {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("XXXX");

            _rootCont = (JPanel)getContentPane();
            // _rootCont.setPreferredSize(new Dimension(500, 700));
            _rootCont.setPreferredSize(new Dimension(470, 640));
            initComponents();

            pack();
            // setLocation(100, 10);
            setLocation(0, 0);
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

            _pnlRight = new _GamePanel();
            _pnlRight.setBackground(Color.darkGray);
            _rootCont.add(_pnlRight, BorderLayout.CENTER);
        }
    }

    private static class _GamePanel extends JPanel {
        public _GamePanel() {
            setLayout(null);
            _ccvs = new _CellCanvas(this);
            add(_ccvs);
        }
        private _CellCanvas _ccvs;
    }

    private static class _CellCanvas extends JComponent {
        public _CellCanvas(_GamePanel pgpnl) {
            _pgpnl = pgpnl;

            MainApp.println(">>> _cellw: " + _cellw);
            MainApp.println(">>> _cellh: " + _cellh);
            MainApp.println(">>> _colcnt: " + _colcnt);
            MainApp.println(">>> _rowcnt: " + _rowcnt);
            MainApp.println(">>> _grdw: " + _grdw);
            MainApp.println(">>> _grdh: " + _grdh);

            setLayout(null);
            setSize(_grdw, _grdh);


            addMouseMotionListener(new MouseMotionListener() {
                @Override
                public void mouseDragged(MouseEvent te) {
                }

                private int get_dx(Point2D mpt) {
                    int ri = (int)Math.floor(mpt.getX() / (_cellw + 1));
                    // if (ri >= _colcnt)
                    //     ri = -1;
                    if (ri < 0) ri = 0;
                    else if (ri >= _colcnt)
                        ri = _colcnt - 1;
                    return ri;
                }

                private int get_dy(Point2D mpt) {
                    int ri = (int)Math.floor(mpt.getY() / (_cellh + 1));
                    // if (ri >= _rowcnt)
                    //     ri = -1;
                    if (ri < 0) ri = 0;
                    else if (ri >= _rowcnt)
                        ri = _rowcnt - 1;
                    return ri;
                }

                @Override
                public void mouseMoved(MouseEvent te) {
                    // MainApp.println("Unimplemented method 'mousePressed'");

                    Point2D mpt = (Point2D)getMousePosition();

                    int dx = get_dx(mpt);
                    int dy = get_dy(mpt);
                    String msg = ">>> dx: " + dx + ", dy: " + dy;
                    MainApp.println(msg);
                }
            });

            addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent te) {
                    // MainApp.println("Unimplemented method 'mouseClicked'");
                }

                @Override
                public void mousePressed(MouseEvent te) {
                    // MainApp.println("Unimplemented method 'mousePressed'");
                }

                @Override
                public void mouseReleased(MouseEvent te) {
                    // MainApp.println("Unimplemented method 'mouseReleased'");
                }

                @Override
                public void mouseEntered(MouseEvent te) {
                    // MainApp.println("Unimplemented method 'mouseEntered'");
                }

                @Override
                public void mouseExited(MouseEvent te) {
                    // MainApp.println("Unimplemented method 'mouseExited'");
                }
            });

            add(new _CellRect(this, 2, 2));
        }
        private _GamePanel _pgpnl;
        public _GamePanel getGamePanel() {
            return _pgpnl;
        }

        private final double _cellw = 30;
        public int get_crw(boolean ba) {
            if (ba)
                return (int)_cellw + 1;
            else
                return (int)_cellw;
        }
        private final double _cellh = 30;
        public int get_crh(boolean ba) {
            if (ba)
                return (int)_cellh + 1;
            else
                return (int)_cellh;
        }

        private final int _colcnt = 10;
        public int get_colcnt() {
            return _colcnt;
        }
        private final int _rowcnt = 20;
        public int get_rowcnt() {
            return _rowcnt;
        }

        private final Rectangle2D.Double _drc = new Rectangle2D.Double();
        private final Line2D.Double _dln = new Line2D.Double();

        private final int _grdw = (get_crw(true) * _colcnt) + 1;
        public int get_grdw() {
            return _grdw;
        }
        private final int _grdh = (get_crh(true) * _rowcnt) + 1;
        public int get_grdh() {
            return _grdh;
        }

        private final Color _clggrd = Color.black;
        private final Color _clgln = new Color(0x242323);

        @Override
        protected void paintComponent(Graphics tg) {
            super.paintComponent(tg);

            if (checkNotRenderable()) return;

            Graphics2D g2d = (Graphics2D)tg;
            g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
            );

            g2d.setColor(_clggrd);
            _drc.setRect(0, 0, _grdw, _grdh);
            g2d.fill(_drc);

            MainApp.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            // MainApp.println(">> " + MainApp.getMainFrame().isActive());
            // MainApp.println(">> " + _pgpnl.getWidth());
            // MainApp.println(">> " + _pgpnl.getHeight());

            g2d.setColor(_clgln);
            for (int l = _colcnt + 1, i = 0; i < l; i++) {
                double tx = (_cellw + 1) * i;
                _dln.setLine(tx, 0, tx, _grdh);
                g2d.draw(_dln);
            }
            for (int l = _rowcnt + 1, i = 0; i < l; i++) {
                double ty = (_cellh + 1) * i;
                _dln.setLine(0, ty, _grdw, ty);
                g2d.draw(_dln);
            }
        }

        // private double _cvsw = Double.NaN;
        // private double _cvsh = Double.NaN;
        private boolean checkNotRenderable() {
            if (!MainApp.getMainFrame().isActive()) return true;

            return false;
            // double tcw = getWidth();
            // double tch = getHeight();
            // if ((tcw == _cvsw) && (tch == _cvsh)) {
            //     return true;
            // } else {
            //     _cvsw = tcw;
            //     _cvsh = tch;
            //     return false;
            // }
        }
    }

    private static class _CellRect extends JComponent implements ActionListener {
        public _CellRect(_CellCanvas pcvs, int dx, int dy) {
            // int tx = (int)((pcvs.get_crw() * (dx + 1)) / 2.0);
            // int tx = (pcvs.get_crw() * (dx + 1)) / 2;
            // int ty = (pcvs.get_crh() * (dy + 1)) / 2;
            // MainApp.println(">>>");

            // 여기서 내가 뭘하는 건가.... (어렵다)
            // int crw = pcvs.get_crw(false);
            // int crh = pcvs.get_crh(false);
            // int rx = (crw * (dx + 1)) / 2;
            // int ry = (crh * (dy + 1)) / 2;
            // int rx = crw * dx;
            // int ry = crh * dy;
            // int rw = crw;
            // int rh = crh;
            // int rw = crw * 3;
            // int rh = crh * 3;
            // int rx = (int)Math.round(dx - ((double)rw / 2));
            // int ry = (int)Math.round(dy - ((double)rh / 2));

            int rx = pcvs.get_crw(true) * dx;
            int ry = pcvs.get_crh(true) * dy;
            int rw = pcvs.get_crw(false);
            int rh = pcvs.get_crh(false);
            _frc = new Rectangle(rx, ry, rw, rh);
            /*
            _timer = new Timer(100, this);
            _scx = 1.0;
            _scy = 1.0;
            _jct = new Rectangle2D.Double();
*/
            setOpaque(true);
            setSize(_frc.width, _frc.height);

            // _timer.start();
        }
        private Rectangle _frc;
        private Timer _timer;
        private double _scx;
        private double _scy;
        private Rectangle2D.Double _jct;

        @Override
        public void actionPerformed(ActionEvent te) {
            repaint(getBounds());
        }

        @Override
        protected void paintComponent(Graphics tg) {
            super.paintComponent(tg);

            MainApp.println("반복실행...");

            Graphics2D g2d = (Graphics2D)tg;
            g2d.setColor(Color.blue);
            g2d.fill(_frc);
            // g2d.fillRect(0, 0, _frc.width, _frc.height);

            // _scx += 0.5;
            // _scy += 0.5;
            // g2d.translate(50.0, 50.0);
            // g2d.translate(5.0, 5.0);
            // g2d.scale(_scx, _scy);
            // g2d.translate(-50.0, -50.0);
            // g2d.translate(-5.0, -5.0);
            // g2d.setColor(Color.red);
            // _rct.setRect(0, 0, _pcvs.get_crw(), _pcvs.get_crh());
            // g2d.fill(_rct);

            _timer.stop();
        }

    }
//#endregion


//#region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 02)
    private static MainFrame _mfrm;
    public static MainFrame getMainFrame() {
        return _mfrm;
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                _mfrm = new MainFrame();
            }
        });
    }
//#endregion
}









/* =============================== BACKUP-CODE
        @Override
        protected void paintComponent(Graphics tg) {
            super.paintComponent(tg);

            // // 2. 폰트와 색상 설정
            // tg.setColor(Color.red); // 텍스트 색상을 빨간색으로 설정
            // tg.setFont(new Font("Serif", Font.BOLD, 20)); // 폰트 종류, 스타일, 크기 설정

            // // 3. 텍스트 그리기
            // Dimension dms = getSize();
            // String message = ":: " + dms.getWidth() + ", " + dms.getHeight();

            // // drawString(그릴 텍스트, X 좌표, Y 좌표)
            // // Y 좌표는 텍스트의 '베이스라인(baseline)' 위치를 의미합니다.
            // tg.drawString(message, 30, 80);


            // tg.setColor(Color.green);
            // tg.fillRect(0, 0, _grdw, 100);



            // // 테스트리 가로세로 10x20개 (27x27px)

            // Graphics2D g2d = (Graphics2D)tg;
            // // double lgw = _cellw + 1;
            // // double lgh = _cellh + 1;
            // // _drc.setRect(0, lgw, 360, 1);
            // // g2d.fill(_drc);
            // // _drc.setRect(0, lgw * 2, 360, 1);
            // // g2d.fill(_drc);
            // // tg.fillRect(0, 28, 360, );
            // g2d.setColor(Color.blue);

            // for (int i = 0; i < _rowcnt; i++) {
            //     if (i == 0) continue;
            //     double ty = _cellh * i;
            //     _drc.setRect(0, ty, 360, 1);
            //     g2d.fill(_drc);
            // }


            // Graphics2D g2d = (Graphics2D)tg;
            // g2d.setColor(Color.green);

            // _drc.setRect(0, 0, _grdw, _grdh);
            // g2d.fill(_drc);
        }


        private final double _cellw = 27;
        private final double _cellh = 27;
        private final int _colcnt = 10;
        private final int _rowcnt = 20;
        private final Rectangle2D.Double _drc = new Rectangle2D.Double();

        private final double _grdw = _cellw * _colcnt;
        private final double _grdh = _cellh * _rowcnt;
        // private final double _lgw = _cellw + 1;
        // private final double _lgh = _cellh + 1;






        public MainFrame() {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("XXXX");
            // setMinimumSize(new Dimension(900, 500));
            // setSize(900, 500);
            // setLocation(100, 40);
            // setLayout(new GridBagLayout());
            // setResizable(false);

            _mpnl = (JPanel)getContentPane();
            Dimension dms = new Dimension(500, 700);
            _mpnl.setPreferredSize(dms);
            // _mpnl.setMinimumSize(_mpnl.getSize());
            // setMinimumSize(dms);
            // setPreferredSize(dms);
            // println(">>>>>>>>>> 1 " + getSize());

            initComponents();

            pack();
            setLocation(100, 40);
            setMinimumSize(getSize());

            setVisible(true);
            println(">>>>>>>>>> 2 " + getSize());
        }



 */