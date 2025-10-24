package hbgms.uicomps;

import javax.swing.*;
import hbgms.*;


public final class RightPanel extends JPanel {
    /**
     * RightPanel 생성자
     */
    public RightPanel() {
        setBackground(GameConfig.clprb);
        setLayout(null);

        _gameArea = new GameAreaComp();
        add(_gameArea);
    }

    private GameAreaComp _gameArea;
    public GameAreaComp get_gameArea() {
        return _gameArea;
    }

}
