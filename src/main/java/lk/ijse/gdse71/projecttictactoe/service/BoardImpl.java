package lk.ijse.gdse71.projecttictactoe.service;

import java.io.Serializable;

public class BoardImpl implements Board, Serializable {  // Implement BoardImpl class with Board Interface and Serializable Interface(Java Bean Specification)
    static Piece[][] pieces = new Piece[3][3];  // Piece 2D array containing the game board state
    private BoardUI boardUI;

    public BoardImpl(BoardUI boardUI) { // Overriding the constructor in Board Interface and initialize boardUI
        this.boardUI = boardUI;
        initializeBoard();  // Call initializeBoard to reset the pieces 2D array to EMPTY
    }

    public Piece[][] getPieces() {    // Getter methods for object state(Java Bean Specification)
        return pieces;
    }

    public BoardUI getBoardUI() {
        return boardUI;
    }

    public void setPieces(Piece[][] pieces) {    // Setter methods for object state(Java Bean Specification)
        this.pieces = pieces;
    }

    public void setBoardUI(BoardUI boardUI) {
        this.boardUI = boardUI;
    }

    public void initializeBoard() { // Reset the pieces 2D array to EMPTY
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                pieces[i][j] = Piece.EMPTY;
            }
        }
    }

    public Boolean isLegalMove(int row, int col) {  // Check if given move is legal and return true if it is false if not
        if(pieces[row][col] == Piece.EMPTY) {
            return true;
        }
        return false;
    }

    public void updateMove(int row, int col, Piece piece) { // Update the pieces 2D array with the given move
        pieces[row][col] = piece;
    }

    public boolean checkWinner(Piece piece) {   // Check if there is a winner according to the current game board state
        for (int i = 0; i < 3; i++) {
            if (pieces[i][0] == piece && pieces[i][1] == piece && pieces[i][2] == piece) {  // Horizontal
                boardUI.notifyWinner(new Winner(piece, 0, i, 1, i, 2, i));  // Call notifyWinner in BoardController with a new Winner object with the winning piece and columns and rows
                return true;
            }
            if (pieces[0][i] == piece && pieces[1][i] == piece && pieces[2][i] == piece) {  // Vertical
                boardUI.notifyWinner(new Winner(piece, i, 0, i, 1, i, 2));  // Call notifyWinner in BoardController with a new Winner object with the winning piece and columns and rows
                return true;
            }
        }
        if (pieces[0][0] == piece && pieces[1][1] == piece && pieces[2][2] == piece) {  // Diagonal
            boardUI.notifyWinner(new Winner(piece, 0, 0, 1, 1, 2, 2));  // Call notifyWinner in BoardController with a new Winner object with the winning piece and columns and rows
            return true;
        }
        if (pieces[0][2] == piece && pieces[1][1] == piece && pieces[2][0] == piece) {  // Diagonal
            boardUI.notifyWinner(new Winner(piece, 2, 0, 1, 1, 0, 2));  // Call notifyWinner in BoardController with a new Winner object with the winning piece and columns and rows
            return true;
        }
        return false;
    }

    public boolean checkFutureWinner(Piece piece) {   // Check if there is a winner according to the minimax game board state
        for (int i = 0; i < 3; i++) {
            if (pieces[i][0] == piece && pieces[i][1] == piece && pieces[i][2] == piece) {  // Horizontal
                return true;
            }
            if (pieces[0][i] == piece && pieces[1][i] == piece && pieces[2][i] == piece) {  // Vertical
                return true;
            }
        }
        if (pieces[0][0] == piece && pieces[1][1] == piece && pieces[2][2] == piece) {  // Diagonal
            return true;
        }
        if (pieces[0][2] == piece && pieces[1][1] == piece && pieces[2][0] == piece) {  // Diagonal
            return true;
        }
        return false;
    }

    public boolean checkTie() { // Check if the game is tied according to the current game board state
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (pieces[i][j] == Piece.EMPTY) {
                    return false;
                }
            }
        }
        boardUI.notifyWinner(new Winner(Piece.EMPTY));  // Call notifyWinner in BoardController with a new Winner object with the winning piece as EMPTY
        return true;
    }

    public boolean checkFutureTie() { // Check if the game is tied according to the minimax game board state
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (pieces[i][j] == Piece.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard() {} // According to the assignment pdf given(since we created the UI ourselves I couldn't find a use for it)
}
