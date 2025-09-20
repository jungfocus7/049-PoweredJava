package hbx.tapps.ui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import hbx.tapps.MainApp;
// import hbx.tapps.models.UserInfo;

public final class MainFrame extends JFrame {
    public MainFrame() {
        // setDefaultCloseOperation(EXIT_ON_CLOSE);
        // setSize(800, 400);
        // setLocation(100, 40);

        // // setLocationRelativeTo(null);
        // setTitle("개발자 입니다.");
        // // setBackground(new Color(123, 50, 250));
        // BorderLayout bdlo = new BorderLayout();
        // setLayout(bdlo);

        // Container cont = getContentPane();
        // cont.toString();

        // initControls();
        initControls2();



        // String trtp = "MainRun";
        // switch (trtp) {
        //     case "SysRun": {
        //         break;
        //     }
        //     case "MainRun": {
        //         break;
        //     }
        //     case "SubRun": {
        //         break;
        //     }
        // }

        // _userInfoMap.put(_users, new ArrayList<UserInfo>());
    }

    // private static final String _keeper = "Keeper";
    // private static final String _users = "User";
    // private static final HashMap<String, List<UserInfo>> _userInfoMap = new HashMap<String, List<UserInfo>>();

    // private CanvasPanel _cvs;

    // private void initControls() {
    // // setDefaultCloseOperation(EXIT_ON_CLOSE);
    // // setSize(800, 400);
    // // setLocation(100, 40);

    // // // setLocationRelativeTo(null);
    // // setTitle("개발자 입니다.");
    // // // setBackground(new Color(123, 50, 250));
    // // BorderLayout bdlo = new BorderLayout();
    // // setLayout(bdlo);

    // // Container cont = getContentPane();
    // // cont.toString();
    // }

    private JTextArea _jta;
    private JScrollPane _jsp;
    private JPanel _jpnl;

    private void initControls2() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 400);
        setMinimumSize(new Dimension(400, 200));
        setLocation(100, 40);
        setTitle("개발자 입니다.");

        //
        _jta = new JTextArea();
        _jsp = new JScrollPane(_jta);

        //
        _jpnl = new JPanel();
        _jpnl.setLayout(new BoxLayout(_jpnl, BoxLayout.Y_AXIS));
        _jpnl.setPreferredSize(new Dimension(100, 0));

        //
        Cursor tcs = new Cursor(Cursor.HAND_CURSOR);
        JButton tbtn;

        tbtn = new JButton("버튼 1");
        tbtn.setCursor(tcs);
        tbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent te) {
                StringBuilder tsb = new StringBuilder();
                for (int i = 0; i < 1000000; i++) {
                    tsb.append("실시간 스트리밍 중에 다른 사용자가 이 동영상에 대해 어떤 이야기를 했는지 확인해 보세요.\n");
                }
                _jta.setText(tsb.toString());
            }
        });
        _jpnl.add(tbtn);

        tbtn = new JButton("버튼 2");
        tbtn.setCursor(tcs);
        _jpnl.add(tbtn);

        tbtn = new JButton("버튼 3");
        tbtn.setCursor(tcs);
        _jpnl.add(tbtn);

        //
        add(_jsp, BorderLayout.CENTER);
        add(_jpnl, BorderLayout.EAST);
    }

    public void initOnce() {
        setVisible(true);

        // _cvs = new CanvasPanel();
        // _cvs.toString();
        // add(_cvs);
    }
}

final class CanvasPanel extends JPanel implements MouseMotionListener {
    public CanvasPanel() {
        addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics tg) {
        Graphics2D tg2d = (Graphics2D) tg;
        tg2d.setPaint(Color.BLUE);
        // tg2d.setColor(Color.RED);
        tg2d.setStroke(new BasicStroke(5));
        // tg2d.setBackground(Color.RED);
        // tg2d.drawLine(0, 0, 500, 500);
        // tg2d.drawRect(10, 10, 100, 100);
        tg2d.drawRect(10, 10, 100, 100);
        tg2d.setPaint(Color.RED);
        tg2d.fillRect(10, 10, 100, 100);
        MainApp.println("paint");
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        MainApp.println(">>> " + me.toString());
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}
