package hbx.tapps.ui;

import java.awt.BorderLayout;
// import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public final class MainFrame extends JFrame {
    public MainFrame() {
        // initControls();
        initControls2();
    }

    private JTextArea _jta;
    private JScrollPane _jsp;
    private JPanel _jpnl;
    private CanvasPanel _cvs;

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
                for (int i = 0; i < 10000000; i++) {
                    tsb.append("실시간 스트리밍 중에 다른 사용자가 이 동영상에 대해 어떤 이야기를 했는지 확인해 보세요.\n");
                }
                _jta.setText(">>>" + tsb.length());
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
        _cvs = new CanvasPanel();
        _cvs.initOnce(this);
        add(_cvs, BorderLayout.CENTER);

        setVisible(true);
    }

    public void msgOut(String msg) {
        _jta.setText(msg);
    }

}
