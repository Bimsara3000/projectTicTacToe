package lk.ijse.gdse71.projecttictactoe.service;

public interface BoardUI {// Specify methods to be overridden in BoardController class
    Boolean update(int row, int col);
    void notifyWinner(Winner winner);
}
