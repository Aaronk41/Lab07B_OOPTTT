import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TTTGame extends JFrame {
    private TTTBoard board;
    private TTTPlayer currentPlayer;
    private boolean gameWon;
    private int moveCount;

    public TTTGame() {
        board = new TTTBoard();
        currentPlayer = new TTTPlayer('X');
        gameWon = false;
        moveCount = 0;

        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLayout(new GridLayout(3, 3));

        initializeGame();
    }

    private void initializeGame() {
        board.initializeButtons();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                TTTTileButton button = board.getTile(row, col);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        handleButtonClick(button);
                    }
                });
                add(button);
            }
        }
    }

    private void handleButtonClick(TTTTileButton button) {
        if (!gameWon && button.getText().isEmpty()) {
            button.setText(String.valueOf(currentPlayer.getSymbol()));
            moveCount++;

            if (checkForWin(button.getRow(), button.getCol())) {
                JOptionPane.showMessageDialog(null, currentPlayer.getSymbol() + " wins!");
                gameWon = true;
                restartGame();
            } else if (moveCount == 9) {
                JOptionPane.showMessageDialog(null, "It's a tie!");
                restartGame();
            } else {
                currentPlayer = (currentPlayer.getSymbol() == 'X') ? new TTTPlayer('O') : new TTTPlayer('X');
            }
        }
    }



    private boolean checkForWin(int row, int col) {
        // Check the current row
        if (board.getTile(row, 0).getText().equals(board.getTile(row, 1).getText()) &&
                board.getTile(row, 0).getText().equals(board.getTile(row, 2).getText())) {
            return true;
        }

        // Check the current column
        if (board.getTile(0, col).getText().equals(board.getTile(1, col).getText()) &&
                board.getTile(0, col).getText().equals(board.getTile(2, col).getText())) {
            return true;
        }

        // Check the main diagonal (top-left to bottom-right)
        if (row == col &&
                board.getTile(0, 0).getText().equals(board.getTile(1, 1).getText()) &&
                board.getTile(0, 0).getText().equals(board.getTile(2, 2).getText())) {
            return true;
        }

        // Check the other diagonal (top-right to bottom-left)
        if (row + col == 2 &&
                board.getTile(0, 2).getText().equals(board.getTile(1, 1).getText()) &&
                board.getTile(0, 2).getText().equals(board.getTile(2, 0).getText())) {
            return true;
        }

        return false;
    }



    private void restartGame() {
        int choice = JOptionPane.showConfirmDialog(null, "Play another game?", "Restart Game", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            board.resetBoard();
            currentPlayer = new TTTPlayer('X');
            gameWon = false;
            moveCount = 0;
        } else {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TTTGame game = new TTTGame();
            game.setVisible(true);
        });

    }
}




