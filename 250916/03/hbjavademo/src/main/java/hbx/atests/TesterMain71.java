package hbx.atests;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public final class TesterMain71 {
    public static void println(String msg) {
        System.out.println(msg);
    }

    private static TestFrame _tfrm;

    public static void main(String[] args) {
        println("안녕하세요. 자바입니다.");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                _tfrm = new TestFrame();
                _tfrm.setVisible(true);
            }
        });
    }
}

final class TestFrame extends JFrame {
    static {
        try {
            LookAndFeelInfo[] lafia = UIManager.getInstalledLookAndFeels();
            UIManager.setLookAndFeel(lafia[1].getClassName());

            // final String tmcnm = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
            // final String tmcnm = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
            // final String tmcnm = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
            // final String tmcnm = "javax.swing.plaf.metal.MetalLookAndFeel";
            // UIManager.setLookAndFeel(tmcnm);
        } catch (Exception ex) {
            TesterMain71.println(ex.toString());
        }
    }

    public TestFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 400);
        setMinimumSize(new Dimension(400, 200));
        setLocation(100, 40);
        // setResizable(false);
        setTitle("XXXX");


        _jta = new JTextArea();
        _jsp = new JScrollPane(_jta);

        add(_jsp, BorderLayout.CENTER);

        _pnlLeft = new JPanel();
        _pnlLeft.setLayout(new BoxLayout(_pnlLeft, BoxLayout.Y_AXIS));
        _pnlLeft.setPreferredSize(new Dimension(80, 0));
        _pnlLeft.setBackground(Color.DARK_GRAY);

        Cursor tcs = new Cursor(Cursor.HAND_CURSOR);

        _btn31 = new JButton("TEST31");
        _btn31.setLocation(0, 10);
        _btn31.setCursor(tcs);
        _pnlLeft.add(_btn31);

        _btn32 = new JButton("TEST32");
        _btn32.setLocation(0, 10);
        _btn32.setCursor(tcs);
        _pnlLeft.add(_btn32);

        _btn33 = new JButton("TEST33");
        _btn33.setLocation(0, 10);
        _btn33.setCursor(tcs);
        _pnlLeft.add(_btn33);

        _btn34 = new JButton("TEST34");
        _btn34.setLocation(0, 10);
        _btn34.setCursor(tcs);
        _pnlLeft.add(_btn34);

        _btn35 = new JButton("TEST35");
        _btn35.setLocation(0, 10);
        _btn35.setCursor(tcs);
        _pnlLeft.add(_btn35);

        add(_pnlLeft, BorderLayout.EAST);


        _btn33.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                _jta.setText(null);
                System.gc();
            }
        });

        _btn34.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                clearWork();
            }
        });

        _btn35.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                startWork();
            }
        });
    }

    private JTextArea _jta;
    private JScrollPane _jsp;

    private JPanel _pnlLeft;

    private JButton _btn31;
    private JButton _btn32;
    private JButton _btn33;
    private JButton _btn34;
    private JButton _btn35;

    private static final ExecutorService _executor = Executors.newSingleThreadExecutor();
    private static volatile Runnable _wrun = null;
    private static int _cnt = 0;
    private void clearWork() {
        if (_wrun != null) {
            _wrun = null;
            _cnt = 0;
        }
        TesterMain71.println("clearWork");
    }
    private void startWork() {
        if (_wrun == null) {
            _wrun = new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(10);
                        } catch (Exception ex) {
                        }
                        if (_wrun == null) break;

                        Thread trd = Thread.currentThread();
                        trd.setDaemon(true);
                        // bool br = trd.isDaemon();

                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                // _jta.append("~~~~~~~~~~: " + Integer.toString(_cnt).pad);
                                // _jta.append("~~~~~~~~~~: " + String.format("%05d", _cnt));

                                if ((_cnt % 1000) == 0) {
                                    _jta.setText(null);
                                }
                                String ns = String.format("%05d", _cnt);
                                _jta.append(">>> : " + ns);
                                _jta.append(System.lineSeparator());
                                _cnt++;
                            }
                        });
                    }
                }
            };
            _executor.execute(_wrun);
        }
        TesterMain71.println("startWork");
    }

}
