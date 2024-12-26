package lk.ijse.gdse71.projecttictactoe.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import lk.ijse.gdse71.projecttictactoe.service.*;

import java.io.Serializable;

public class BoardController implements BoardUI, Serializable {  // Implement BoardController class with BoardUI Interface and Serializable Interface(Java Bean Specification)

    private Player humanPlayer;
    private Player aiPlayer;
    private Board newBoard;
    private boolean gameOver = false;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private Label lblWinner;

    public BoardController() {  // No argument constructor(Java Bean Specification)
        newBoard = new BoardImpl(this); // Create a new BoardImpl object for this BoardController and assign it to newBoard
        humanPlayer = new HumanPlayer(newBoard); // Create a new HumanPlayer object for the BoardImpl object and assign it to humanPlayer
        aiPlayer = new AiPlayer(newBoard); // Create a new HumanPlayer object for the BoardImpl object and assign it to aiPlayer
    }

    public Player getHumanPlayer() {    // Getter methods for object state and buttons(Java Bean Specification)
        return humanPlayer;
    }

    public Player getAiPlayer() {
        return aiPlayer;
    }

    public Board getNewBoard() {
        return newBoard;
    }

    public Button getBtn1() {
        return btn1;
    }

    public Button getBtn2() {
        return btn2;
    }

    public Button getBtn4() {
        return btn4;
    }

    public Button getBtn3() {
        return btn3;
    }

    public Button getBtn5() {
        return btn5;
    }

    public Button getBtn6() {
        return btn6;
    }

    public Button getBtn7() {
        return btn7;
    }

    public Button getBtn8() {
        return btn8;
    }

    public Button getBtn9() {
        return btn9;
    }

    public Label getLblWinner() {
        return lblWinner;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setHumanPlayer(Player humanPlayer) {    // Setter methods for object state and buttons(Java Bean Specification)
        this.humanPlayer = humanPlayer;
    }

    public void setAiPlayer(Player aiPlayer) {
        this.aiPlayer = aiPlayer;
    }

    public void setNewBoard(Board newBoard) {
        this.newBoard = newBoard;
    }

    public void setBtn1(Button btn1) {
        this.btn1 = btn1;
    }

    public void setBtn2(Button btn2) {
        this.btn2 = btn2;
    }

    public void setBtn3(Button btn3) {
        this.btn3 = btn3;
    }

    public void setBtn4(Button btn4) {
        this.btn4 = btn4;
    }

    public void setBtn5(Button btn5) {
        this.btn5 = btn5;
    }

    public void setBtn6(Button btn6) {
        this.btn6 = btn6;
    }

    public void setBtn7(Button btn7) {
        this.btn7 = btn7;
    }

    public void setBtn8(Button btn8) {
        this.btn8 = btn8;
    }

    public void setBtn9(Button btn9) {
        this.btn9 = btn9;
    }

    public void setLblWinner(Label lblWinner) {
        this.lblWinner = lblWinner;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    private void initializeGame() { // Clear game board buttons and winner label
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        lblWinner.setText("");
    }

    private void disableBoard(boolean b) {  // Disable game board buttons
        btn1.setDisable(b);
        btn2.setDisable(b);
        btn3.setDisable(b);
        btn4.setDisable(b);
        btn5.setDisable(b);
        btn6.setDisable(b);
        btn7.setDisable(b);
        btn8.setDisable(b);
        btn9.setDisable(b);
    }

    @FXML
    void clickBtn1(ActionEvent event) { // Call update method and set button1 text to X if move is valid
        Boolean validMove = update(0, 0);
        setBtnText(btn1, "X", validMove);
    }

    @FXML
    void clickBtn2(ActionEvent event) { // Call update method and set button2 text to X if move is valid
        Boolean validMove = update(0, 1);
        setBtnText(btn2, "X", validMove);
    }

    @FXML
    void clickBtn3(ActionEvent event) { // Call update method and set button3 text to X if move is valid
        Boolean validMove = update(0, 2);
        setBtnText(btn3, "X", validMove);
    }

    @FXML
    void clickBtn4(ActionEvent event) { // Call update method and set button4 text to X if move is valid
        Boolean validMove = update(1, 0);
        setBtnText(btn4, "X", validMove);
    }

    @FXML
    void clickBtn5(ActionEvent event) { // Call update method and set button5 text to X if move is valid
        Boolean validMove = update(1, 1);
        setBtnText(btn5, "X", validMove);
    }

    @FXML
    void clickBtn6(ActionEvent event) { // Call update method and set button6 text to X if move is valid
        Boolean validMove = update(1, 2);
        setBtnText(btn6, "X", validMove);
    }

    @FXML
    void clickBtn7(ActionEvent event) { // Call update method and set button7 text to X if move is valid
        Boolean validMove = update(2, 0);
        setBtnText(btn7, "X", validMove);
    }

    @FXML
    void clickBtn8(ActionEvent event) { // Call update method and set button8 text to X if move is valid
        Boolean validMove = update(2, 1);
        setBtnText(btn8, "X", validMove);
    }

    @FXML
    void clickBtn9(ActionEvent event) { // Call update method and set button9 text to X if move is valid
        Boolean validMove = update(2, 2);
        setBtnText(btn9, "X", validMove);
    }

    @FXML
    void clickBtnReset(ActionEvent event) {
        humanPlayer.reset();    // Reset pieces array
        initializeGame();   // Clear the game board
        gameOver = false;    // Move game over state to false
        disableBoard(false);    // Enable game board
    }

    @Override
    public Boolean update(int row, int col) {
        Boolean hPlayer = humanPlayer.move(row, col);   // Pass the player's move to the HumanPlayer class and assign the returned boolean value to hPlayer

        if (hPlayer == true && gameOver == false) {

            int[] ran = aiPlayer.makeMove();    // Call the AiPlayer class for the computer's next move if player's move is valid and assign that move to ran int array

            if(ran != null) {   // Show computer's move in the game board if ran is not null
                switch (ran[0]) {   // Find the correct position of the move in the game board and set its text as O
                    case 0:
                        switch (ran[1]) {
                            case 0:
                                btn1.setText("O");
                                break;
                            case 1:
                                btn2.setText("O");
                                break;
                            case 2:
                                btn3.setText("O");
                                break;
                        }
                        break;
                    case 1:
                        switch (ran[1]) {
                            case 0:
                                btn4.setText("O");
                                break;
                            case 1:
                                btn5.setText("O");
                                break;
                            case 2:
                                btn6.setText("O");
                                break;
                        }
                        break;
                    case 2:
                        switch (ran[1]) {
                            case 0:
                                btn7.setText("O");
                                break;
                            case 1:
                                btn8.setText("O");
                                break;
                            case 2:
                                btn9.setText("O");
                                break;
                        }
                }
            }
        }

        return hPlayer; // return whether the player's move is valid or not
    }

    @Override
    public void notifyWinner(Winner winner) {
        disableBoard(true); // Disable the game board

        switch (winner.getWinningPiece().toString()) {
            case "X", "O" : lblWinner.setText(winner.getWinningPiece().toString() + " WINS!");  // Announce winner
            break;
            default: lblWinner.setText("GAME IS TIED!");
        }

        gameOver = true;    // Move game over state to true
    }

    public void setBtnText(Button btn, String text, Boolean validMove) {
        if (validMove) {
            btn.setText(text);  // Set the given text to the given button if validMove is true
        }
    }
}
