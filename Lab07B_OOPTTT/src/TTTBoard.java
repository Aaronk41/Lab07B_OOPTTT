import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TTTBoard {
    private TTTTileButton[][] buttons;

    public TTTBoard() {
        buttons = new TTTTileButton[3][3];
    }

    public void initializeButtons() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new TTTTileButton(row, col);
            }
        }
    }

    public TTTTileButton getTile(int row, int col) {
        return buttons[row][col];
    }

    public void resetBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("");
            }
        }
    }

    public TTTTileButton[][] getButtons() {
        return new TTTTileButton[0][];
    }
}
