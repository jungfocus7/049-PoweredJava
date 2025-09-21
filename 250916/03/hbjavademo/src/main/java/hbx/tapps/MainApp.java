package hbx.tapps;

import javax.swing.SwingUtilities;

import hbx.tapps.ui.MainFrame;

public final class MainApp {
    public static void println(String msg) {
        System.out.println(msg);
    }

    private static final MainFrame _mfrm = new MainFrame();

    public static void main(String[] args) {
        println("Hello world!");
        println("Hello world!");
        println("Hello world!");
        println("Hello world!");
        println("Hello world!");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                _mfrm.initOnce();
            }
        });
    }
}