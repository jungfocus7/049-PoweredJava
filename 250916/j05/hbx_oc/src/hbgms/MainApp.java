package hbgms;

import javax.swing.SwingUtilities;

import hbgms.logics.CellInfo;


public final class MainApp {
    public static void println(String msg) {
        System.out.println(msg);
    }

	public static void clearCall() {
		// println("###MainApp##clearCall");
		System.gc();
	}

    public static boolean checkNotRenderable() {
        return !getMainFrame().isActive();
    }

    public static void print_cellInfos(CellInfo[] cia) {
        StringBuilder tsb = new StringBuilder();
        for (CellInfo ci : cia) {
            String tx = String.format("xi: %d, yi: %d%s",
                ci.get_xi(), ci.get_yi(), System.lineSeparator());
            tsb.append(tx);
        }

        println(tsb.toString());
    }


    public static void main(String[] args) throws Exception {
        // println("###MainApp##main");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createMainFrame();
            }
        });
    }

    private static MainFrame _mfrm;
    public static MainFrame getMainFrame() {
        return _mfrm;
    }

    private static void createMainFrame() {
        if (_mfrm == null) {
            _mfrm = new MainFrame();
            _mfrm.open();
        }
    }

}

