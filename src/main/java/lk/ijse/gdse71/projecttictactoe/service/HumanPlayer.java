package lk.ijse.gdse71.projecttictactoe.service;

import javafx.scene.control.Alert;

import java.io.Serializable;

public class HumanPlayer extends Player implements Serializable {  // Extend HumanPlayer class with Player abstract class and implement it by Serializable Interface(Java Bean Specification)
    private Board board;

    public HumanPlayer() {}  // No argument constructor(Java Bean Specification)

    public HumanPlayer(Board board) {   // Override constructor in Player and initialize board variable
        super(board);
        this.board = board;
    }

    public Board getBoard() {    // Getter method for board(Java Bean Specification)
        return board;
    }

    public void setBoard(Board board) {    // Setter method for board(Java Bean Specification)
        this.board = board;
    }

    @Override
    public Boolean move(int row, int col) {
        Boolean legalMove = board.isLegalMove(row, col);    // Check if the player's move is legal and assign the boolean value to legalMove variable
        if (legalMove) {    // Check if the player's move is valid
            board.updateMove(row, col, Piece.X); // Updating the actual game
            board.checkWinner(Piece.X); // Checking if X won
            board.checkTie();   // Checking if the game is tied
            return true;    // Return true when the game bord is updated
        } else {
            new Alert(Alert.AlertType.ERROR, "Illegal move").show();    // Show error message when player's move is invalid
            return false;    // Return false when the game bord is not updated
        }
    }

    @Override
    public void reset() {
        board.initializeBoard();    // Call initializeBoard in BoardImpl to reset the pieces array to empty
    }
}
