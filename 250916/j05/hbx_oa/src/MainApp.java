import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;


public final class MainApp {
    public static void println(String msg) {
        System.out.println(msg);
    }

    private static JFrame _tfrm;

    public static void main(String[] args) throws Exception {
        println("MainApp main ~~~");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                _tfrm = new TestFrame82__GridBagLayout();
                _tfrm.setVisible(true);
            }
        });
    }
}


final class TestFrame82__GridBagLayout extends JFrame {
    static {
        try {
            LookAndFeelInfo[] lafia = UIManager.getInstalledLookAndFeels();
            UIManager.setLookAndFeel(lafia[1].getClassName());
        } catch (Exception ex) {
            MainApp.println(ex.toString());
        }
    }

    public TestFrame82__GridBagLayout() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(900, 500));
        setSize(900, 500);
        setLocation(100, 40);
        // setLayout(new GridBagLayout());
        // setResizable(false);
        setTitle("XXXX");

        initComponents();
    }

    private GridBagLayout _gblo;
    private GridBagConstraints _gbc;
    private Container _mcont;

    private JPanel _pnl11;
    private JPanel _pnl12;
    private JPanel _pnl13;


    private void initComponents() {
        _gblo = new GridBagLayout();
        _gbc = new GridBagConstraints();

        _mcont = getContentPane();
        _mcont.setBackground(Color.black);
        _mcont.setLayout(_gblo);
        _mcont.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                System.gc();
            }
        });

        this.addComponentListener(new ComponentListener() {

            @Override
            public void componentResized(ComponentEvent te) {
            }

            @Override
            public void componentMoved(ComponentEvent te) {
            }

            @Override
            public void componentShown(ComponentEvent te) {
            }

            @Override
            public void componentHidden(ComponentEvent te) {
            }

        });


        //{ 1) _pnl11:
        _pnl11 = new JPanel();
        final Dimension dms = new Dimension(200, 200);
        _pnl11.setMinimumSize(dms);
        _pnl11.setPreferredSize(dms);
        _pnl11.setBackground(Color.lightGray);
        _gbc.gridx = 0;
        _gbc.gridy = 0;
        _gbc.weightx = 0.0;
        _gbc.weighty = 0.0;
        _gbc.ipadx = 1;
        _gbc.ipady = 1;
        _gbc.fill = GridBagConstraints.NONE;
        _gbc.anchor = GridBagConstraints.NORTH;
        // _gbc.insets = new Insets(0, 0, 0, 1);
        _mcont.add(_pnl11, _gbc);
        //}

        //{ 2) _pnl12:
        _pnl12 = new JPanel();
        _pnl12.setBackground(Color.lightGray);
        _gbc.gridx = 1;
        _gbc.gridy = 0;
        _gbc.weightx = 1.0;
        _gbc.weighty = 1.0;
        _gbc.ipadx = 1;
        _gbc.ipady = 1;
        _gbc.fill = GridBagConstraints.BOTH;
        // _gbc.anchor = GridBagConstraints.CENTER; //기본값
        // _gbc.insets = new Insets(0, 1, 0, 1);
        _mcont.add(_pnl12, _gbc);
        //}

        //{ 3) _pnl13:
        _pnl13 = new JPanel();
        _pnl13.setBackground(Color.lightGray);
        _gbc.gridx = 2;
        _gbc.gridy = 0;
        _gbc.weightx = 1.0;
        _gbc.weighty = 1.0;
        _gbc.ipadx = 1;
        _gbc.ipady = 1;
        _gbc.fill = GridBagConstraints.BOTH;
        // _gbc.anchor = GridBagConstraints.CENTER; //기본값
        // _gbc.insets = new Insets(0, 1, 0, 0);
        _mcont.add(_pnl13, _gbc);
        //}
    }


    // private void initComponents() {
    //     _mcont = getContentPane();
    //     _mcont.setBackground(Color.black);
    //     _mcont.setLayout(_gblo);

    //     // 전체 레이아웃의 기본 설정을 상단에서 먼저 정의합니다.
    //     // _gbc.fill = GridBagConstraints.BOTH; // 셀 내부에서 컴포넌트가 모두 채워지도록 설정합니다.
    //     // _gbc.weighty = 1.0; // 모든 행이 수직 공간을 동일하게 나눠 갖습니다.

    //     // 1. _pnl11: 고정된 100x100 크기를 가집니다.
    //     _pnl11 = new JPanel();
    //     _pnl11.setPreferredSize(new Dimension(200, 200)); // **크기를 100x100으로 고정**
    //     _pnl11.setMinimumSize(new Dimension(200, 200));
    //     // _pnl11.setSize(new Dimension(100, 100));
    //     _pnl11.setBackground(Color.lightGray);
    //     // _gbc.fill = GridBagConstraints.NORTH;
    //     _gbc.anchor = GridBagConstraints.NORTH;
    //     _gbc.gridx = 0;
    //     _gbc.gridy = 0;
    //     _gbc.weightx = 0.0; // **가로 크기 조절 우선 순위를 0으로 설정하여 고정 크기를 유지**
    //     // _gbc.weighty = 1.0;
    //     _gbc.insets = new Insets(0, 0, 0, 1);
    //     _mcont.add(_pnl11, _gbc);

    //     // 2. _pnl12: 남은 공간의 일부를 차지합니다.
    //     _pnl12 = new JPanel();
    //     _pnl12.setBackground(Color.lightGray);
    //     _gbc.fill = GridBagConstraints.BOTH;
    //     _gbc.gridx = 1;
    //     _gbc.gridy = 0;
    //     _gbc.weightx = 1.0; // **남은 가로 공간을 1의 비율로 차지 (1/2)**
    //     _gbc.weighty = 1.0;
    //     _gbc.insets = new Insets(0, 1, 0, 1);
    //     _mcont.add(_pnl12, _gbc);

    //     // 3. _pnl13: 남은 공간의 나머지 일부를 차지합니다.
    //     _pnl13 = new JPanel();
    //     _pnl13.setBackground(Color.lightGray);
    //     _gbc.fill = GridBagConstraints.BOTH;
    //     _gbc.gridx = 2;
    //     _gbc.gridy = 0;
    //     _gbc.weightx = 1.0; // **남은 가로 공간을 1의 비율로 차지 (1/2)**
    //     _gbc.weighty = 1.0;
    //     _gbc.insets = new Insets(0, 1, 0, 0);
    //     _mcont.add(_pnl13, _gbc);
    // }
}


// final class TestFrame72__GridBagLayout extends JFrame {
//     static {
//         try {
//             LookAndFeelInfo[] lafia = UIManager.getInstalledLookAndFeels();
//             UIManager.setLookAndFeel(lafia[1].getClassName());
//         } catch (Exception ex) {
//             MainApp.println(ex.toString());
//         }
//     }

//     public TestFrame72__GridBagLayout() {
//         setDefaultCloseOperation(EXIT_ON_CLOSE);
//         setSize(400, 400);
//         // setMinimumSize(new Dimension(900, 500));
//         setLocation(100, 40);
//         // setLayout(new GridBagLayout());
//         // setResizable(false);
//         setTitle("XXXX");

//         initComponents();
//     }

//     private static final GridBagLayout _gblo = new GridBagLayout();
//     private static final GridBagConstraints _gbc = new GridBagConstraints();
//     private Container _mcont;

//     private JPanel _pnl31;
//     private JPanel _pnl32;
//     private JPanel _pnl33;
//     private JPanel _pnl34;
//     private JPanel _pnl35;
//     private JPanel _pnl36;
//     private JPanel _pnl37;
//     private JPanel _pnl38;
//     private JPanel _pnl39;

//     private void initComponents() {
//         _mcont = getContentPane();
//         _mcont.setBackground(Color.black);
//         _mcont.setLayout(_gblo);

//         _gbc.fill = GridBagConstraints.EAST;
//         _gbc.weightx = 1.0;
//         _gbc.weighty = 1.0;

//         _pnl31 = new JPanel();
//         _pnl31.setPreferredSize(new Dimension(200, 200));
//         _pnl31.setBackground(Color.lightGray);
//         _gbc.gridx = 0;
//         _gbc.gridy = 0;
//         _gbc.insets = new Insets(0, 0, 1, 1);
//         _mcont.add(_pnl31, _gbc);

//         _pnl32 = new JPanel();
//         _pnl32.setBackground(Color.lightGray);
//         _gbc.gridx = 1;
//         _gbc.gridy = 0;
//         _gbc.insets = new Insets(0, 1, 1, 1);
//         _mcont.add(_pnl32, _gbc);

//         _pnl33 = new JPanel();
//         _pnl33.setBackground(Color.lightGray);
//         _gbc.gridx = 2;
//         _gbc.gridy = 0;
//         _gbc.insets = new Insets(0, 1, 1, 0);
//         _mcont.add(_pnl33, _gbc);

//         _pnl34 = new JPanel();
//         _pnl34.setBackground(Color.lightGray);
//         _gbc.gridx = 0;
//         _gbc.gridy = 1;
//         _gbc.insets = new Insets(1, 0, 1, 1);
//         _mcont.add(_pnl34, _gbc);

//         _pnl35 = new JPanel();
//         _pnl35.setBackground(Color.lightGray);
//         _gbc.gridx = 1;
//         _gbc.gridy = 1;
//         _gbc.gridwidth = 1;
//         _gbc.gridheight = 1;
//         _gbc.insets = new Insets(1, 1, 1, 1);
//         _mcont.add(_pnl35, _gbc);

//         _pnl36 = new JPanel();
//         _pnl36.setBackground(Color.lightGray);
//         _gbc.gridx = 2;
//         _gbc.gridy = 1;
//         _gbc.gridwidth = 1;
//         _gbc.gridheight = 1;
//         _gbc.insets = new Insets(1, 1, 1, 0);
//         _mcont.add(_pnl36, _gbc);

//         _pnl37 = new JPanel();
//         _pnl37.setBackground(Color.lightGray);
//         _gbc.gridx = 0;
//         _gbc.gridy = 2;
//         _gbc.gridwidth = 1;
//         _gbc.gridheight = 1;
//         _gbc.insets = new Insets(1, 0, 0, 1);
//         _mcont.add(_pnl37, _gbc);

//         _pnl38 = new JPanel();
//         _pnl38.setBackground(Color.lightGray);
//         _gbc.gridx = 1;
//         _gbc.gridy = 2;
//         _gbc.gridwidth = 1;
//         _gbc.gridheight = 1;
//         _gbc.insets = new Insets(1, 1, 0, 1);
//         _mcont.add(_pnl38, _gbc);

//         _pnl39 = new JPanel();
//         _pnl39.setBackground(Color.lightGray);
//         _gbc.gridx = 2;
//         _gbc.gridy = 2;
//         _gbc.gridwidth = 1;
//         _gbc.gridheight = 1;
//         _gbc.insets = new Insets(1, 1, 0, 0);
//         _mcont.add(_pnl39, _gbc);


//         MainApp.println("....");
//     }
// }




// final class MainFrame72 extends JFrame {
//     static {
//         try {
//             LookAndFeelInfo[] lafia = UIManager.getInstalledLookAndFeels();
//             UIManager.setLookAndFeel(lafia[1].getClassName());

//             // final String tmcnm = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
//             // final String tmcnm = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
//             // final String tmcnm = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
//             // final String tmcnm = "javax.swing.plaf.metal.MetalLookAndFeel";
//             // UIManager.setLookAndFeel(tmcnm);
//         } catch (Exception ex) {
//             MainApp.println(ex.toString());
//         }
//     }

//     public MainFrame72() {
//         setDefaultCloseOperation(EXIT_ON_CLOSE);
//         setSize(800, 400);
//         setMinimumSize(new Dimension(900, 500));
//         setLocation(100, 40);
//         // setResizable(false);
//         setTitle("XXXX");

//         initComponents();
//     }

//     private Container _mcont;

//     private JPanel _pnlBottom;
//     private JTextArea _txa31;
//     private JScrollPane _scp31;

//     private JPanel _pnlLeft;
//     private JButton _btn31;
//     private JButton _btn32;
//     private JButton _btn33;
//     private JButton _btn34;
//     private JButton _btn35;

//     private void initComponents() {
//         _mcont = getContentPane();

//         _pnlBottom = new JPanel();
//         _pnlBottom.setLayout(new BoxLayout(_pnlLeft, BoxLayout.Y_AXIS));
//         _pnlBottom.setPreferredSize(new Dimension(80, 0));
//         _pnlBottom.setBackground(Color.DARK_GRAY);

//         GridBagConstraints.BOTH;

//         _txa31 = new JTextArea();
//         _txa31.setEditable(false);
//         _scp31 = new JScrollPane(_txa31);
//         _mcont.add(_scp31, BorderLayout.SOUTH);

//         _pnlLeft = new JPanel();
//         _pnlLeft.setLayout(new BoxLayout(_pnlLeft, BoxLayout.Y_AXIS));
//         _pnlLeft.setPreferredSize(new Dimension(80, 0));
//         _pnlLeft.setBackground(Color.DARK_GRAY);

//         Cursor tcs = new Cursor(Cursor.HAND_CURSOR);

//         _btn31 = new JButton("TEST31");
//         _btn31.setLocation(0, 10);
//         _btn31.setCursor(tcs);
//         _pnlLeft.add(_btn31);

//         _btn32 = new JButton("TEST32");
//         _btn32.setLocation(0, 10);
//         _btn32.setCursor(tcs);
//         _pnlLeft.add(_btn32);

//         _btn33 = new JButton("TEST33");
//         _btn33.setLocation(0, 10);
//         _btn33.setCursor(tcs);
//         _pnlLeft.add(_btn33);

//         _btn34 = new JButton("TEST34");
//         _btn34.setLocation(0, 10);
//         _btn34.setCursor(tcs);
//         _pnlLeft.add(_btn34);

//         _btn35 = new JButton("TEST35");
//         _btn35.setLocation(0, 10);
//         _btn35.setCursor(tcs);
//         _pnlLeft.add(_btn35);

//         _mcont.add(_pnlLeft, BorderLayout.EAST);

//         // _btn33.addActionListener(new ActionListener() {
//         // @Override
//         // public void actionPerformed(ActionEvent evt) {
//         // _jta.setText(null);
//         // System.gc();
//         // }
//         // });

//         // _btn34.addActionListener(new ActionListener() {
//         // @Override
//         // public void actionPerformed(ActionEvent evt) {
//         // clearWork();
//         // }
//         // });

//         // _btn35.addActionListener(new ActionListener() {
//         // @Override
//         // public void actionPerformed(ActionEvent evt) {
//         // startWork();
//         // }
//         // });
//     }
// }
