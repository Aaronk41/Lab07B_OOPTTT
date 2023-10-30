import javax.swing.*;
import java.awt.Font;

public class TTTTileButton extends JButton {
    private int row;
    private int col;

    public TTTTileButton(int row, int col) {
        this.row = row;
        this.col = col;
        setText("");
        setFont(new Font("Arial", Font.PLAIN, 48));
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}

