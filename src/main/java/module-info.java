module lk.ijse.gdse71.projecttictactoe {
    requires javafx.controls;
    requires javafx.fxml;


    opens lk.ijse.gdse71.projecttictactoe.controller to javafx.fxml;
    exports lk.ijse.gdse71.projecttictactoe;
    exports lk.ijse.gdse71.projecttictactoe.controller;
    exports lk.ijse.gdse71.projecttictactoe.service;
    opens lk.ijse.gdse71.projecttictactoe.service to javafx.fxml;
    opens lk.ijse.gdse71.projecttictactoe to javafx.fxml;
}