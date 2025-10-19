package hbgms;

import java.awt.Color;

import javax.swing.JPanel;

import hbgms.logics.GameComponent;


public final class RightPanel extends JPanel {
    /**
     * ColorPanelRightBackground
     */
    private static final Color _clprb = new Color(0x242323);


    /**
     * RightPanel 생성자
     */
    public RightPanel() {
        setBackground(_clprb);
        setLayout(null);

        _gameComp = new GameComponent(this);
        add(_gameComp);
    }

    private GameComponent _gameComp;
    public GameComponent get_gameComp() {
        return _gameComp;
    }

}
