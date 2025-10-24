package hbgms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import hbgms.helpers.*;
import hbgms.uicomps.*;


public final class MainFrame extends JFrame {
    public static void main(String[] args) throws Exception {
        MainHelper.trace("###MainApp##main");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainHelper.create_mfrm();
            }
        });
    }


	public MainFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Java Tetris");

		initComponents();

		pack();
		setLocation(0, 0);
		setResizable(false);
		setMinimumSize(getSize());
		// setVisible(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent te) {
                _pnlRight.get_gameArea().keyPressed(te);
            }
        });
	}

	private JPanel _pnlRootCont;
    public JPanel getRootPanel() {
        return _pnlRootCont;
    }

	private LeftPanel _pnlLeft;
    public LeftPanel getLeftPanel() {
        return _pnlLeft;
    }

	private RightPanel _pnlRight;
    public RightPanel getRightPanel() {
        return _pnlRight;
    }


	private void initComponents() {
		_pnlRootCont = (JPanel)getContentPane();
        _pnlRootCont.setBackground(GameConfig.clmfb);
		_pnlRootCont.setPreferredSize(new Dimension(470, 630));

		_pnlRootCont.setLayout(new BorderLayout(4, 2));
		_pnlLeft = new LeftPanel();
		_pnlRootCont.add(_pnlLeft, BorderLayout.WEST);

		_pnlRight = new RightPanel();
		_pnlRootCont.add(_pnlRight, BorderLayout.CENTER);
	}


    public void open() {
        setVisible(true);
        requestFocusInWindow();
    }

}
