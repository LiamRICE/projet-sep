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

    /**
     * Constructor creates a new facade for access to Business Logic methods
     */
    public LoginController(){
        this.facade = new UserFacade();
    }

    /**
     * This method handles redirection from the login type page to either the employee login page or client login page
     * @param e is the action event that is used to determine which button was pressed
     * @throws IOException if FXMLLoader can't get or load the required fxml file
     */
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

    /**
     * This method serves to return the GUI to the login type screen
     * @param e is the button that is pressed by the user to call this event
     * @throws IOException if FXMLLoader can't get and load the correct fxml file
     */
    @FXML
    protected void returnToLoginType(ActionEvent e) throws IOException{
        Stage stage = (Stage)((Button)e.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method handles pulling the token from the input fields and submitting it for validation, and forwarding the user if their credentials are valid
     */
    @FXML
    protected void handleEmployeeLogin(){
        if(employeeLogin(emailInput.getText(), passwordInput.getText())) {
            this.employeeWelcomeLabel.setText("Welcome to Fast and Flavorous "+facade.getUserName()+"!\nWork hard, we're watching you...");
        }else{
            this.employeeWelcomeLabel.setText("DENIED!");
        }
    }

    /**
     * This method handles pulling the token from the input field and submitting it for validation, and forwarding the user if their credentials are valid
     * @param e is the ActionEvent generated by the GUI once a button is called
     */
    @FXML
    protected void handleClientLogin(ActionEvent e){
        if(e.getSource() == clientSubmit){
            if(clientLogin(tokenField.getText())) {
                this.clientWelcomeLabel.setText("Welcome to Fast and Flavorous "+facade.getUserName()+"!\nEnjoy your meal!");
            }else{
                this.clientWelcomeLabel.setText("Sorry, we don't recognise your token!\nTry again maybe?");
            }
        }else{
            this.clientWelcomeLabel.setText("Welcome to Fast and Flavorous!\nEnjoy your meal!");
        }
    }

    /**
     * This method checks whether the client's token was valid or not
     * @param token the token that allows the client to log in to the application
     * @return It returns true if the client credential is right otherwise it returns false
     */
    public boolean clientLogin(String token) {
        return facade.checkClientLogin(token);
    }

    /**
     * This method checks whether the employee's credentials are valid
     * @param email the email that allows the employee to log in to the application
     * @param password the password that allows the employee to log in to the application
     * @return It returns true if the employee credentials is right otherwise it returns false
     */
    public boolean employeeLogin(String email, String password) {
        return facade.checkEmployeeLogin(email, password);
    }

}