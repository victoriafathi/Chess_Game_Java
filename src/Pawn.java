import javax.swing.*;

public class Pawn extends Piece {

    public Pawn(boolean isWhite) {
        super(isWhite);
        if(isWhite){
            icon = new ImageIcon("Images/wp.png");
        }
        else{
            icon = new ImageIcon("Images/bp.png");
        }
        image = new JLabel(icon);
    }
    public boolean canMove(Board b, Square start, Square end) {
        if (start.equals(end))
            return false;

        // If piece with same color
        if (end.piece.getColor() == this.getColor()) {
            return false;
        }
        // Pawns can only move forward
        if (end.x < start.x) {
            return false;
        }

        // Diagonal move to eat a piece
        if (Math.abs(end.x-start.x) != 1 || Math.abs(end.y-start.y) != 1) {
            return false;
        }
        return true;
    }
}
