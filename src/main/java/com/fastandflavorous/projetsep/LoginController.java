package com.fastandflavorous.projetsep;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button clientButton, employeeButton, returnToSelectLogin, employeeSubmit, clientSubmit, clientSubmitWithoutToken;
    @FXML
    private Label employeeWelcomeLabel, clientWelcomeLabel;

    @FXML
    protected void handleLoginType(ActionEvent e) throws IOException {
        Stage stage;
        Parent root;
        Object src = e.getSource();

        if(src == employeeButton) {
            stage = (Stage)employeeButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("employee_login.fxml"));
        }else{
            stage = (Stage)employeeButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("client_login.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void returnToLoginType(ActionEvent e) throws IOException{
        Stage stage = (Stage)((Button)e.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void handleEmployeeLogin(ActionEvent e){
        // check if login is valid
        this.employeeWelcomeLabel.setText("Welcome to Fast and Flavorous!\nWork hard, we're watching you...");
    }

    @FXML
    protected void handleClientLogin(ActionEvent e){
        System.out.println("method called");
        // check if login is valid
        this.clientWelcomeLabel.setText("Welcome to Fast and Flavorous!\nEnjoy your meal!");
    }
}