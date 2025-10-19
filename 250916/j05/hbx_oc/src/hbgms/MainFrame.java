package hbgms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;


public final class MainFrame extends JFrame {
    /**
     * ColorMainFrame
     */
    private static final Color _clmf = Color.black;

    /**
     * ColorPanelLeft
     */
    private static final Color _clpl = new Color(0x997755);


    /**
     * MainFrame 생성자
     */
	public MainFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Java Tetris");

		initComponents();

		pack();
		setLocation(0, 0);
		setResizable(false);
		setMinimumSize(getSize());
		// setVisible(true);
	}

	private JPanel _pnlRootCont;
	private JPanel _pnlLeft;
	private RightPanel _pnlRight;
    public RightPanel getRightPanel() {
        return _pnlRight;
    }

	private void initComponents() {
		_pnlRootCont = (JPanel)getContentPane();
        _pnlRootCont.setBackground(_clmf);
		_pnlRootCont.setPreferredSize(new Dimension(470, 630));

		_pnlRootCont.setLayout(new BorderLayout(4, 2));
		_pnlLeft = new JPanel();
		_pnlLeft.setBackground(_clpl);
		_pnlLeft.setPreferredSize(new Dimension(150, 0));
		_pnlRootCont.add(_pnlLeft, BorderLayout.WEST);

		_pnlRight = new RightPanel();
		_pnlRootCont.add(_pnlRight, BorderLayout.CENTER);
	}

    public void open() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent te) {
                // MainApp.println(">>> " + te);
                _pnlRight.get_gameComp().keyPressed(te);
            }
        });

        setVisible(true);
        requestFocusInWindow();
    }

}
