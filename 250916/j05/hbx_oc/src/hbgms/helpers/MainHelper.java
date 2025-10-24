package hbgms.helpers;

import javax.swing.JPanel;

import hbgms.*;
import hbgms.logics.*;
import hbgms.uicomps.*;


public final class MainHelper {
    public static void trace(String msg) {
        System.out.println(msg);
    }

	public static void clearCall() {
		// println("###MainHelper##clearCall");
		System.gc();
	}

    public static boolean checkNotRenderable() {
        return !_mfrm.isActive();
    }

    /**
     * CreateIndexRanger
     * @param spm
     * @return
     */
    public static IndexRanger create_idr(ShapeMap spm) {
        return new IndexRanger(
            0, GameConfig.get_colc(1 - spm.get_colc(0)),
            0, GameConfig.get_rowc(1 - spm.get_rowc(0)));
    }


    private static MainFrame _mfrm;
    /**
     * MainFrame
     * @return
     */
    public static MainFrame getMainFrame() {
        return _mfrm;
    }

    /**
     * MainFrame 생성
     */
    public static void create_mfrm() {
        if (_mfrm == null) {
            _mfrm = new MainFrame();
            _mfrm.open();
        }
    }

    /**
     * RootPanel (JFrame.getContentPane)
     * @return
     */
    public JPanel getRootPanel() {
        return _mfrm.getRootPanel();
    }

    /**
     * LeftPanel
     * @return
     */
    public LeftPanel getLeftPanel() {
        return _mfrm.getLeftPanel();
    }

    /**
     * RightPanel
     * @return
     */
    public RightPanel getRightPanel() {
        return _mfrm.getRightPanel();
    }

}
