package com.fastandflavorous.projetsep;

import com.fastandflavorous.projetsep.facade.login.AbstractUserFacade;
import com.fastandflavorous.projetsep.facade.login.UserFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.fastandflavorous.projetsep.model.users.*;

import java.io.IOException;

/**
 * 
 */
public class LoginController {

    @FXML
    private Button employeeButton, clientSubmit, clientSubmitWithoutToken;

    @FXML
    private Label employeeWelcomeLabel, clientWelcomeLabel;

    @FXML
    private TextField tokenField, emailInput;

    @FXML
    private PasswordField passwordInput;

    private AbstractUserFacade facade;

    public LoginController(){
        this.facade = new UserFacade();
    }

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
    protected void handleEmployeeLogin(){
        if(employeeLogin(emailInput.getText(), passwordInput.getText())) {
            this.employeeWelcomeLabel.setText("Welcome to Fast and Flavorous "+emailInput.getText()+"!\nWork hard, we're watching you...");
        }
    }

    @FXML
    protected void handleClientLogin(ActionEvent e){
        if(e.getSource() == clientSubmit){
            if(clientLogin(tokenField.getText())) {
                this.clientWelcomeLabel.setText("Welcome to Fast and Flavorous!\nEnjoy your meal!");
            }
        }else{
            this.clientWelcomeLabel.setText("Welcome to Fast and Flavorous!\nEnjoy your meal!");
        }
    }

    /**
     * This method logs the client in to the application according to the validity of their credential
     * @param token the token that allows the client to log in to the application
     * @return It returns true if the client credential is right otherwise it returns false
     */
    public boolean clientLogin(String token) {
        Client client = facade.checkClientLogin(token);
        if(client!=null){
            return true;
        }else {
            return false;
        }
    }

    /**
     * This method logs the employee in to the application according to the validity of their credentials
     * @param email the email that allows the employee to log in to the application
     * @param password the password that allows the employee to log in to the application
     * @return It returns true if the employee credentials is right otherwise it returns false
     */
    public boolean employeeLogin(String email, String password) {
        Employee employee = facade.checkEmployeeLogin(email, password);
        if(employee!=null){
            return true;
        }else {
            return false;
        }
    }

}