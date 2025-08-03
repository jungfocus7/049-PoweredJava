import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public final class HfFrame extends JFrame {
//    private JTextField _txf31;
	private JTextArea _txa31;
	private JScrollPane _scrp31;

	private JPanel _bottomPanel;
	private JButton _btn31;
	private JButton _btn32;

	public HfFrame() {
		setTitle("간단한 Swing UI");
		setBounds(100, 40, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		settingControls();
	}

	private void settingControls() {
//		_txf31 = new JTextField("여기에 텍스트가 표시됩니다.");
//		_txf31.setEditable(true);

		_txa31 = new JTextArea("개발자 입니다.");
		_txa31.setEditable(true);
		_txa31.setLineWrap(true);
		_txa31.setWrapStyleWord(true);
		_scrp31 = new JScrollPane(_txa31);

		_btn31 = new JButton("버튼 1");
		_btn32 = new JButton("버튼 2");

		Cursor cs = new Cursor(Cursor.HAND_CURSOR);
		_btn31.setCursor(cs);
		_btn32.setCursor(cs);

		setLayout(new BorderLayout());

		add(_scrp31, BorderLayout.CENTER);

		_bottomPanel = new JPanel();
		_bottomPanel.add(_btn31);
		_bottomPanel.add(_btn32);
		add(_bottomPanel, BorderLayout.SOUTH);

		_btn31.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
//            	_txf31.setText("버튼 1이 클릭되었습니다!");
			}
		});

		_btn32.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
//            	_txf31.setText("버튼 2가 클릭되었습니다!");
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						_txa31.setText(null);
					}
				});

				_runnable = null;
				System.gc();
			}
		});
	}

	private static void println(String txt) {
		System.out.println(txt);
	}

	private static HfFrame _inst;


	private static final ExecutorService _executor = Executors.newSingleThreadExecutor();
//	private static final ExecutorService _executor = Executors.newFixedThreadPool(3);
	private static volatile Runnable _runnable;

	public static void main(String[] args) {
		println("경계대상 1호");

		System.setProperty("-Dsun.java2d.d3d", "true");
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				_inst = new HfFrame();
				_inst.setVisible(true);
			}
		});

		_runnable = new Runnable() {
			@Override
			public void run() {
				while (_runnable != null) {
					try {
						Thread.sleep(1000);

						SwingUtilities.invokeLater(new Runnable() {
							@Override
							public void run() {
								_inst._txa31.append("~~~~" + System.lineSeparator());
							}
						});
					}
					catch (Exception ex) {
						println(ex.toString());
					}
				}
			}
		};
		_executor.execute(_runnable);
		_executor.execute(_runnable);
		_executor.execute(_runnable);
		_executor.execute(_runnable);
		_executor.execute(_runnable);
	}

}
