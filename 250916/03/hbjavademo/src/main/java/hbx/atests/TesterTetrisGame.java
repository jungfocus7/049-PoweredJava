package hbx.atests;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * A complete Tetris game in a single Java file.
 * To play: Compile and run this file.
 * Requires Java SE (standard edition) with Swing.
 */
public class TesterTetrisGame extends JFrame {




    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        super.paint(g);
    }

    @Override
    public void paintComponents(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponents(g);
    }

    @Override
    public void paintAll(Graphics g) {
        // TODO Auto-generated method stub
        super.paintAll(g);
    }



    public TesterTetrisGame() {
        setTitle("Single File Tetris");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        GamePanel panel = new GamePanel();
        add(panel);

        pack(); // Sizes the window so that all its contents are at or above their preferred sizes.
        setLocationRelativeTo(null); // Center the window
        setVisible(true);

        panel.startGame();
    }

    public static void main(String[] args) {
        // Run the game on the Event Dispatch Thread (EDT) for thread safety.
        SwingUtilities.invokeLater(TesterTetrisGame::new);
    }

    /**
     * The main panel where the game logic and rendering happens.
     */
    class GamePanel extends JPanel implements ActionListener {

        // --- Game Constants ---
        private static final int BOARD_WIDTH = 10;
        private static final int BOARD_HEIGHT = 20;
        private static final int BLOCK_SIZE = 30;
        private static final int TIMER_DELAY = 400; // Milliseconds between each game tick (initial speed)

        // --- Game State Variables ---
        private Timer timer;
        private boolean isFallingFinished = false;
        private boolean isPaused = false;
        private int score = 0;
        private int linesRemoved = 0;

        // Current piece
        private Point pieceOrigin;
        private Tetrominoes currentPiece;
        private int currentRotation;

        // Next piece
        private Tetrominoes nextPiece;

        // The board, storing the colors of landed blocks
        private Color[][] board;

        public GamePanel() {
            // Set up panel properties
            setPreferredSize(new Dimension(BOARD_WIDTH * BLOCK_SIZE + 150, BOARD_HEIGHT * BLOCK_SIZE));
            setFocusable(true);
            setBackground(new Color(20, 30, 40));

            // Add key listener for user input
            addKeyListener(new GameKeyAdapter());
        }

        /**
         * Initializes and starts the game.
         */
        public void startGame() {
            board = new Color[BOARD_WIDTH][BOARD_HEIGHT];
            clearBoard();

            score = 0;
            linesRemoved = 0;
            isPaused = false;
            isFallingFinished = false;

            // Create and start the game loop timer
            timer = new Timer(TIMER_DELAY, this);
            timer.start();

            // Spawn the first and next pieces
            spawnNewPiece();
            spawnNewPiece(); // Call twice to populate current and next
        }

        private void clearBoard() {
            for (int i = 0; i < BOARD_WIDTH; i++) {
                for (int j = 0; j < BOARD_HEIGHT; j++) {
                    board[i][j] = null; // null means empty
                }
            }
        }

        /**
         * Spawns a new Tetromino at the top of the board.
         */
        private void spawnNewPiece() {
            currentPiece = (nextPiece != null) ? nextPiece : Tetrominoes.getRandomShape();
            nextPiece = Tetrominoes.getRandomShape();
            currentRotation = 0;
            pieceOrigin = new Point(BOARD_WIDTH / 2 - 1, 0); // Start at top-middle

            // If the new piece immediately collides, game over.
            if (!canMove(currentPiece, pieceOrigin, currentRotation)) {
                timer.stop();
                isFallingFinished = true;
                currentPiece = Tetrominoes.NoShape; // Clear the current piece
            }
        }

        /**
         * Main game loop, triggered by the Timer.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (isFallingFinished || isPaused) {
                return;
            }
            oneLineDown();
        }

        private void oneLineDown() {
            if (!move2(0, 1)) {
                pieceHasLanded();
            }
        }

        /**
         * Locks the current piece to the board.
         */
        private void pieceHasLanded() {
            for (Point p : currentPiece.getShape(currentRotation)) {
                int checkX = pieceOrigin.x + p.x;
                int checkY = pieceOrigin.y + p.y;
                if (checkY >= 0) { // Only lock parts of the piece that are on the board
                    board[checkX][checkY] = currentPiece.color;
                }
            }
            removeFullLines();

            if (!isFallingFinished) {
                spawnNewPiece();
            }
        }

        /**
         * Checks for and removes any full lines on the board.
         */
        private void removeFullLines() {
            int numFullLines = 0;
            for (int j = BOARD_HEIGHT - 1; j >= 0; j--) {
                boolean isLineFull = true;
                for (int i = 0; i < BOARD_WIDTH; i++) {
                    if (board[i][j] == null) {
                        isLineFull = false;
                        break;
                    }
                }

                if (isLineFull) {
                    numFullLines++;
                    // Shift all lines above this one down
                    for (int k = j; k > 0; k--) {
                        for (int i = 0; i < BOARD_WIDTH; i++) {
                            board[i][k] = board[i][k - 1];
                        }
                    }
                    j++; // Re-check the same line index as it's now filled with the line above
                }
            }

            if (numFullLines > 0) {
                // Scoring
                score += 100 * Math.pow(2, numFullLines - 1); // 100, 200, 400, 800
                linesRemoved += numFullLines;

                // Increase speed
                int newDelay = TIMER_DELAY - (linesRemoved / 10) * 50;
                timer.setDelay(Math.max(50, newDelay)); // set a minimum delay
            }
        }

        /**
         * Generic move function for moving and rotating.
         * Returns true if the move was successful, false otherwise.
         */
        private boolean tryMove(Tetrominoes piece, Point newPosition, int newRotation) {
            if (canMove(piece, newPosition, newRotation)) {
                currentPiece = piece;
                pieceOrigin = newPosition;
                currentRotation = newRotation;
                repaint();
                return true;
            }
            return false;
        }

        private boolean move2(int dx, int dy) {
            // Point newPosition = new Point(pieceOrigin.x + dx, pieceOrigin.y + dy);
            // return tryMove(currentPiece, newPosition, currentRotation);
            return true;
        }

        private void rotate() {
            int newRotation = (currentRotation + 1) % currentPiece.getShape().length;
            // Basic wall kick: try moving left or right if rotation is blocked
            if (!tryMove(currentPiece, pieceOrigin, newRotation)) {
                if(!tryMove(currentPiece, new Point(pieceOrigin.x - 1, pieceOrigin.y), newRotation)) {
                    tryMove(currentPiece, new Point(pieceOrigin.x + 1, pieceOrigin.y), newRotation);
                }
            }
        }

        private void hardDrop() {
            int y = pieceOrigin.y;
            while(canMove(currentPiece, new Point(pieceOrigin.x, y + 1), currentRotation)) {
                y++;
            }
            pieceOrigin.y = y;
            pieceHasLanded();
            repaint();
        }

        /**
         * Collision detection logic.
         * Checks if a piece can be placed at a given position and rotation.
         */
        private boolean canMove(Tetrominoes piece, Point position, int rotation) {
            for (Point p : piece.getShape(rotation)) {
                int checkX = position.x + p.x;
                int checkY = position.y + p.y;

                // Check board boundaries
                if (checkX < 0 || checkX >= BOARD_WIDTH || checkY >= BOARD_HEIGHT) {
                    return false;
                }

                // Check if colliding with another piece (but allow parts of piece above the board)
                if (checkY >= 0 && board[checkX][checkY] != null) {
                    return false;
                }
            }
            return true;
        }

        /**
         * Custom drawing method for the game.
         */
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Draw the landed blocks on the board
            for (int i = 0; i < BOARD_WIDTH; i++) {
                for (int j = 0; j < BOARD_HEIGHT; j++) {
                    if (board[i][j] != null) {
                        drawBlock(g, i * BLOCK_SIZE, j * BLOCK_SIZE, board[i][j]);
                    }
                }
            }

            // Draw the currently falling piece
            if (currentPiece != Tetrominoes.NoShape) {
                for (Point p : currentPiece.getShape(currentRotation)) {
                    drawBlock(g, (pieceOrigin.x + p.x) * BLOCK_SIZE,
                                 (pieceOrigin.y + p.y) * BLOCK_SIZE,
                                 currentPiece.color);
                }
            }

            drawUI(g);

            // Draw overlay messages
            if (isPaused) {
                drawOverlay(g, "PAUSED");
            } else if (isFallingFinished) {
                drawOverlay(g, "GAME OVER");
            }

            Toolkit.getDefaultToolkit().sync(); // Helps with smooth animation on some systems
        }

        private void drawBlock(Graphics g, int x, int y, Color color) {
            g.setColor(color);
            g.fillRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
            g.setColor(color.darker());
            g.drawRect(x, y, BLOCK_SIZE - 1, BLOCK_SIZE - 1);
        }

        private void drawUI(Graphics g) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Monospaced", Font.BOLD, 18));
            g.drawString("Score: " + score, BOARD_WIDTH * BLOCK_SIZE + 10, 30);
            g.drawString("Lines: " + linesRemoved, BOARD_WIDTH * BLOCK_SIZE + 10, 60);

            // Draw "Next Piece" area
            g.drawString("Next:", BOARD_WIDTH * BLOCK_SIZE + 10, 100);
            if (nextPiece != null && nextPiece != Tetrominoes.NoShape) {
                for (Point p : nextPiece.getShape(0)) {
                    drawBlock(g, (BOARD_WIDTH + 1) * BLOCK_SIZE + (p.x * BLOCK_SIZE),
                                 120 + (p.y * BLOCK_SIZE),
                                 nextPiece.color);
                }
            }

            // Draw controls
            g.setFont(new Font("Monospaced", Font.PLAIN, 12));
            int uiBaseY = 300;
            g.drawString("Controls:", BOARD_WIDTH * BLOCK_SIZE + 10, uiBaseY);
            g.drawString("← → : Move", BOARD_WIDTH * BLOCK_SIZE + 10, uiBaseY + 20);
            g.drawString("↑     : Rotate", BOARD_WIDTH * BLOCK_SIZE + 10, uiBaseY + 40);
            g.drawString("↓     : Soft Drop", BOARD_WIDTH * BLOCK_SIZE + 10, uiBaseY + 60);
            g.drawString("SPACE : Hard Drop", BOARD_WIDTH * BLOCK_SIZE + 10, uiBaseY + 80);
            g.drawString("P     : Pause", BOARD_WIDTH * BLOCK_SIZE + 10, uiBaseY + 100);

        }

        private void drawOverlay(Graphics g, String text) {
            g.setColor(new Color(0, 0, 0, 150)); // Semi-transparent black
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.WHITE);
            g.setFont(new Font("Monospaced", Font.BOLD, 40));
            FontMetrics fm = g.getFontMetrics();
            int x = (BOARD_WIDTH * BLOCK_SIZE - fm.stringWidth(text)) / 2;
            int y = (BOARD_HEIGHT * BLOCK_SIZE) / 2;
            g.drawString(text, x, y);
        }

        /**
         * Handles keyboard input.
         */
        class GameKeyAdapter extends KeyAdapter {
            @Override
            public void keyPressed(KeyEvent e) {
                if (currentPiece == Tetrominoes.NoShape || isFallingFinished) {
                    return;
                }

                int keycode = e.getKeyCode();

                if (keycode == 'p' || keycode == 'P') {
                    isPaused = !isPaused;
                    if (isPaused) {
                        timer.stop();
                    } else {
                        timer.start();
                    }
                    repaint();
                    return;
                }

                if (isPaused) {
                    return;
                }

                switch (keycode) {
                    case KeyEvent.VK_LEFT:
                        move2(-1, 0);
                        break;
                    case KeyEvent.VK_RIGHT:
                        move2(1, 0);
                        break;
                    case KeyEvent.VK_DOWN:
                        oneLineDown();
                        break;
                    case KeyEvent.VK_UP:
                        rotate();
                        break;
                    case KeyEvent.VK_SPACE:
                        hardDrop();
                        break;
                }
            }
        }
    }

    /**
     * Enum to define the shapes of the Tetris pieces (Tetrominoes).
     * Each piece has its shape defined by a set of points for each rotation.
     */
    enum Tetrominoes {
        NoShape, ZShape, SShape, LineShape, TShape, SquareShape, LShape, MirroredLShape;

        public Point[][] shape;
        public Color color;

        static {
            NoShape.shape = new Point[][]{{new Point(0, 0)}};
            NoShape.color = new Color(0, 0, 0, 0); // Transparent

            ZShape.shape = new Point[][]{
                {new Point(0, -1), new Point(0, 0), new Point(-1, 0), new Point(-1, 1)},
                {new Point(-1, -1), new Point(0, -1), new Point(0, 0), new Point(1, 0)}
            };
            ZShape.color = new Color(204, 102, 102); // Red

            SShape.shape = new Point[][]{
                {new Point(0, -1), new Point(0, 0), new Point(1, 0), new Point(1, 1)},
                {new Point(1, -1), new Point(0, -1), new Point(0, 0), new Point(-1, 0)}
            };
            SShape.color = new Color(102, 204, 102); // Green

            LineShape.shape = new Point[][]{
                {new Point(0, -1), new Point(0, 0), new Point(0, 1), new Point(0, 2)},
                {new Point(-1, 0), new Point(0, 0), new Point(1, 0), new Point(2, 0)}
            };
            LineShape.color = new Color(102, 204, 204); // Cyan

            TShape.shape = new Point[][]{
                {new Point(-1, 0), new Point(0, 0), new Point(1, 0), new Point(0, 1)},
                {new Point(0, -1), new Point(0, 0), new Point(1, 0), new Point(0, 1)},
                {new Point(-1, 0), new Point(0, 0), new Point(1, 0), new Point(0, -1)},
                {new Point(0, -1), new Point(-1, 0), new Point(0, 0), new Point(0, 1)}
            };
            TShape.color = new Color(204, 102, 204); // Purple

            SquareShape.shape = new Point[][]{
                {new Point(0, 0), new Point(1, 0), new Point(0, 1), new Point(1, 1)}
            };
            SquareShape.color = new Color(204, 204, 102); // Yellow

            LShape.shape = new Point[][]{
                {new Point(-1, -1), new Point(0, -1), new Point(0, 0), new Point(0, 1)},
                {new Point(-1, 1), new Point(-1, 0), new Point(0, 0), new Point(1, 0)},
                {new Point(1, 1), new Point(0, 1), new Point(0, 0), new Point(0, -1)},
                {new Point(1, -1), new Point(1, 0), new Point(0, 0), new Point(-1, 0)}
            };
            LShape.color = new Color(204, 153, 102); // Orange

            MirroredLShape.shape = new Point[][]{
                {new Point(1, -1), new Point(0, -1), new Point(0, 0), new Point(0, 1)},
                {new Point(1, 1), new Point(1, 0), new Point(0, 0), new Point(-1, 0)},
                {new Point(-1, 1), new Point(0, 1), new Point(0, 0), new Point(0, -1)},
                {new Point(-1, -1), new Point(-1, 0), new Point(0, 0), new Point(1, 0)}
            };
            MirroredLShape.color = new Color(102, 102, 204); // Blue
        }

        public Point[][] getShape() {
            return shape;
        }

        public Point[] getShape(int rotation) {
            return shape[rotation % shape.length];
        }

        public static Tetrominoes getRandomShape() {
            Random r = new Random();
            Tetrominoes[] values = Tetrominoes.values();
            return values[r.nextInt(values.length - 1) + 1]; // Exclude NoShape
        }
    }

    @Override
    public String toString() {
        return "TesterTetrisGame []";
    }
}