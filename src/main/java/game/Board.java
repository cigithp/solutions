package game;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int[][] board;
    public enum Piece {
        PAWN(8),
        KING(1),
        QUEEN(1),
        BISHOP(2),
        KNIGHT(2),
        ROOK(2);
        Piece(int maxAllowed) {
        }
    };

    private List<Piece> removedPieces = new ArrayList<>();

    public Board(int[][] board) {
        this.board = board;
    }
}
