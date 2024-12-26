package lk.ijse.gdse71.projecttictactoe.service;

import java.io.Serializable;

public class AiPlayer extends Player implements Serializable {  // Extend AiPlayer class with Player abstract class and implement it by Serializable Interface(Java Bean Specification)
    private Board board;

    public AiPlayer() {}  // No argument constructor(Java Bean Specification)

    public AiPlayer(Board board) {   // Override constructor in Player and initialize board variable
        super(board);
        this.board = board;

    }

    public Board getBoard() {    // Getter method for board(Java Bean Specification)
        return board;
    }

    public void setBoard(Board board) {    // Setter method for board(Java Bean Specification)
        this.board = board;
    }

    public int[] makeMove() {   // determine the computer's next move

        int[] move = new int[2];    // Creating an integer array to store moves
        int bestScore = Integer.MIN_VALUE;  // Assigning the least possible integer score to bestScore

        for (int i = 0; i < 3; i++) {   // Cycling through all positions of the game board
            for (int j = 0; j < 3; j++) {
                if (BoardImpl.pieces[i][j] == Piece.EMPTY) {    // Checking for empty positions in the game board
                    BoardImpl.pieces[i][j] = Piece.O;   // Assigning O to the empty position
                    int score = minimax(0, false);  // Calling the minimax function(for best move X can perform)
                    BoardImpl.pieces[i][j] = Piece.EMPTY;   // Undoing the change to the game board
                    if (score > bestScore) {    // determining if the new score is better than the current bestScore
                        bestScore = score;  // If it's better assigning it to bestScore
                        move[0] = i;    // Saving the move in the integer array
                        move[1] = j;
                    }
                }
            }
        }
        board.updateMove(move[0], move[1], Piece.O); // Updating the actual game
        board.checkWinner(Piece.O); // Checking if O won
        board.checkTie();   // Checking if the game is tied
        return move;    // Returning the move to the BoardController
    }

    public Integer minimax(int depth, boolean isMaximizing) {   // Simple AI for determining computer's next move

        if(board.checkFutureWinner(Piece.O)) return 10 - depth; // Returning the score = (10 - depth)[to find the optimal move] if O won
        if (board.checkFutureWinner(Piece.X)) return depth - 10; // Returning the score = (10 - depth)[to find the optimal move] if X won
        if (board.checkFutureTie()) return 0; // Returning 0 if the game is tied

        if (isMaximizing) { // Checking if it's O's turn
            int bestScore = Integer.MIN_VALUE;  // Assigning the least possible integer score to bestScore
            for (int i = 0; i < 3; i++) {   // Cycling through all positions of the game board
                for (int j = 0; j < 3; j++) {
                    if (BoardImpl.pieces[i][j] == Piece.EMPTY) {    // Checking for empty positions in the game board
                        BoardImpl.pieces[i][j] = Piece.O;   // Assigning O to the empty position
                        int score = minimax(depth + 1, false);  // Calling the minimax function(for best move X can perform)
                        BoardImpl.pieces[i][j] = Piece.EMPTY;   // Undoing the chane to the game board
                        bestScore = Math.max(score, bestScore);    // determining if the new score is better than the current bestScore and assigning it to bestScore if it is
                    }
                }
            }
            return bestScore;   // Returning bestScore
        } else {  // Deciding that it's X's turn
            int bestScore = Integer.MAX_VALUE;  // Assigning the most possible integer score to bestScore
            for (int i = 0; i < 3; i++) {   // Cycling through all positions of the game board
                for (int j = 0; j < 3; j++) {
                    if (BoardImpl.pieces[i][j] == Piece.EMPTY) {    // Checking for empty positions in the game board
                        BoardImpl.pieces[i][j] = Piece.X;   // Assigning X to the empty position
                        int score = minimax(depth + 1, true);  // Calling the minimax function(for best move O can perform)
                        BoardImpl.pieces[i][j] = Piece.EMPTY;   // Undoing the chane to the game board
                        bestScore = Math.min(score, bestScore);    // determining if the new score is better than the current bestScore and assigning it to bestScore if it isn't
                    }
                }
            }
            return bestScore;   // Returning bestScore
        }
    }
}
