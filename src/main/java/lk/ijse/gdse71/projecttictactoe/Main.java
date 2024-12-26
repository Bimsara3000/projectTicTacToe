package lk.ijse.gdse71.projecttictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;

public class Main extends Application implements Serializable {  // Extend Main class with Application abstract class and implement it by Serializable Interface(Java Bean Specification)

    public Main() {}  // No argument constructor(Java Bean Specification)

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/Board.fxml")); // Load fxml file Board.fxml
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("OOP Coursework");   // Set title as OOP Coursework"

        Image icon = new Image(getClass().getResourceAsStream("/images/TicTacToeGame.png"));  // Load image Tic Tac Toe.jpg
        stage.getIcons().add(icon);  // Set icon as Tic Tac Toe.jpg

        stage.setScene(scene);
        stage.show();   // Show UI
    }

    public static void main(String[] args) {
        launch();
    }   // Launch application
}