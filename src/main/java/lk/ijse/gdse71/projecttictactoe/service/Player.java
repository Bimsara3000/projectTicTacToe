package lk.ijse.gdse71.projecttictactoe.service;

import java.io.Serializable;

abstract public class Player implements Serializable {// Specify methods to be overridden in AiPlayer and HumanPlayer classes   // Implement Player abstract class with Serializable Interface(Java Bean Specification)
    Board board;

    public Player() {}  // No argument constructor(Java Bean Specification)

    public Player(Board board) {}

    public Board getBoard() {    // Getter methods for class state(Java Bean Specification)
        return board;
    }

    public void setBoard(Board board) {    // Setter methods for class state(Java Bean Specification)
        this.board = board;
    }

    public Boolean move(int row, int col) {
        return false;
    }

    public void reset() {}

    public int[] makeMove() {
        return null;
    }
}
