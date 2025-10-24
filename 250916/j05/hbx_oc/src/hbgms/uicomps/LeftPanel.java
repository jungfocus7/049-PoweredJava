package hbgms.uicomps;

import java.awt.*;
import javax.swing.*;
import hbgms.*;


public final class LeftPanel extends JPanel {
    /**
     * LeftPanel 생성자
     */
    public LeftPanel() {
        setBackground(GameConfig.clplb);
        setPreferredSize(new Dimension(150, 0));
        setLayout(null);

        _previewArea = new PreviewAreaComp();
        add(_previewArea);
    }

    private PreviewAreaComp _previewArea;
    public PreviewAreaComp get_previewArea() {
        return _previewArea;
    }

    // @Override
    // protected void paintComponent(Graphics tg) {
    //     if (MainHelper.checkNotRenderable()) {
    //         return;
    //     }

    //     // MainApp.println("###LeftPanel##paintComponent");
    //     super.paintComponent(tg);

    //     tg.setColor(Color.red);
    //     tg.fillRect(10, 10, 50, 50);
    // }

}
