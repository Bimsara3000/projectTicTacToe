package lk.ijse.gdse71.projecttictactoe.service;

public interface Board {// Specify methods to be overridden in BoardImpl class

    BoardUI getBoardUI();

    void initializeBoard();

    Boolean isLegalMove(int row, int col);

    void updateMove(int row, int col, Piece piece);

    boolean checkWinner(Piece piece);

    void printBoard();

    boolean checkTie();

    boolean checkFutureWinner(Piece piece);

    boolean checkFutureTie();
}
