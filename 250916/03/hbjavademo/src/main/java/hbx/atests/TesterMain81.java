package hbx.atests;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.UIManager.*;

import org.apache.commons.lang3.StringUtils;
// import org.bytedeco.javacv.CanvasFrame;
// import org.bytedeco.javacv.FrameGrabber;
// import org.bytedeco.javacv.OpenCVFrameGrabber;

//#region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 01)
final class ProcessHelper {
    public static void openExplorerAtFolder(String folderPath) {
        if (StringHelper.isEmpty(folderPath)) {
            return;
        }

        // 열고 싶은 폴더 경로
        // String folderPath = "C:\\Users\\Public\\Documents";

        try {
            // ProcessBuilder를 사용하여 'explorer.exe' 명령과 폴더 경로를 실행
            ProcessBuilder pb = new ProcessBuilder("explorer.exe", folderPath);
            pb.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

final class StringHelper {
    public static boolean isEmpty(String txt) {
        return (txt == null) || (txt.length() == 0);
    }
}

final class MainHelper {
    public static void println(String msg) {
        System.out.println(msg);
    }
}
//#endregion

final class TesterFrame81 extends JFrame {
    static {
        try {
            LookAndFeelInfo[] lafia = UIManager.getInstalledLookAndFeels();
            UIManager.setLookAndFeel(lafia[1].getClassName());
        } catch (Exception ex) {
            TesterMain72.println(ex.toString());
        }
    }

    public TesterFrame81() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 400);
        setMinimumSize(new Dimension(400, 200));
        setLocation(100, 40);
        // setResizable(false);
        setTitle("XXXX");

        initComponents();
    }

    private Container _rcont;

    private JTextArea _jta;
    private JScrollPane _jsp;

    private JPanel _pnlLeft;
    private JButton _btn31;
    private JButton _btn32;
    private JButton _btn33;
    private JButton _btn34;
    private JButton _btn35;

    private void initComponents() {
        _rcont = getContentPane();

        _jta = new JTextArea();
        _jta.setEditable(false);
        _jsp = new JScrollPane(_jta);

        _rcont.add(_jsp, BorderLayout.CENTER);

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

        _rcont.add(_pnlLeft, BorderLayout.EAST);


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
            }
        });

        _btn35.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
            }
        });
    }
}

public final class TesterMain81 {
    private static TesterFrame81 _tfrm;

    public static void main(String[] args) throws Exception {
        String tnm = "박종명";
        boolean tb = StringUtils.isBlank(tnm);

        MainHelper.println(":: " + tb);

        if (true) {

        } else {

        }

        /*
        ProcessHelper.openExplorerAtFolder("C:\\Users\\Public\\Documents");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                _tfrm = new TesterFrame81();
                _tfrm.setVisible(true);
            }
        });
        */
    }
}


