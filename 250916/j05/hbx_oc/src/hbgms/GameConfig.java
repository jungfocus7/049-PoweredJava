package hbgms;

import java.awt.*;


public final class GameConfig {
    private GameConfig() { }

//#region [01)]
    /**
     * ColorMainFrame
     */
    public static final Color clmfb = Color.black;

    /**
     * ColorPanelLeftBackground
     */
    public static final Color clplb = new Color(0x997755);

    /**
     * ColorPanelRightBackground
     */
    public static final Color clprb = new Color(0x242323);

    /**
     * ColorGroundLine
     */
    public static final Color clgln = Color.black;

    /**
     * ColorPreviewAreaComp
     */
    public static final Color clpab = new Color(0x2F2854);
//#endregion


//#region [02)]
    private static final int _celw = 27;
    /**
     * CellWidth (Cell넓이)
     * @param an
     * @return
     */
    public static int get_celw(int an) {
        return _celw + an;
    }

    private static final int _celh = 27;
    /**
     * CellHeight (Cell높이)
     * @param an
     * @return
     */
    public static int get_celh(int an) {
        return _celh + an;
    }

    private static final int _colc = 10;
    /**
     * ColumnCount (행개수)
     * @param an
     * @return
     */
    public static int get_colc(int an) {
        return _colc + an;
    }

    private static final int _rowc = 20;
    /**
     * RowCount (열개수)
     * @param an
     * @return
     */
    public static int get_rowc(int an) {
        return _rowc + an;
    }

    private static final int _grdw = get_celw(1) * _colc;
    /**
     * GroundWidth
     * @param an
     * @return
     */
    public static int get_grdw(int an) {
        return _grdw + an;
    }

    private static final int _grdh = get_celh(1) * _rowc;
    /**
     * GroundHeight
     * @param an
     * @return
     */
    public static int get_grdh(int an) {
        return _grdh + an;
    }
//#endregion

}
