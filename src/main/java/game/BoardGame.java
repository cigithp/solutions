package game;

/**
 * a 2 player board game - chess as a reference
 */
public class BoardGame implements Game<BoardGame> {
    private BoardGame b;
    private Board board;
    private Player player1, player2;
    private boolean start = false;

    public BoardGame(BoardGame b, Board board, Player player1, Player player2) {
        this.b = b;
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public void start(BoardGame b) {
        this.start = true;
    }

    @Override
    public void stop(BoardGame b) {
        this.start = false;
    }

    @Override
    public void selectSide(BoardGame b) {

    }

    @Override
    public void winner() {

    }

    @Override
    public void lastMoves() {

    }
}
