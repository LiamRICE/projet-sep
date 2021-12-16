package com.fastandflavorous.projetsep;

import com.fastandflavorous.projetsep.facade.login.AbstractUserFacade;
import com.fastandflavorous.projetsep.facade.login.UserFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
     * @throws IOException if FXMLLoader can't get or load the required fxml file
     */
    @FXML
    public void handleLoginType(ActionEvent e) throws IOException {
        Object src = e.getSource();
        if(src == employeeButton) {
            FastAndFlavorousApplication.switchToEmployeeLogin();
        }else{
            FastAndFlavorousApplication.switchToClientLogin();
        }
    }

    /**
     * This method serves to return the GUI to the login type screen
     * @throws IOException if FXMLLoader can't get and load the correct fxml file
     */
    @FXML
    public void returnToLoginType() throws IOException{
        FastAndFlavorousApplication.returnToLoginType();
    }

    /**
     * This method handles pulling the token from the input fields and submitting it for validation, and forwarding the user if their credentials are valid
     */
    @FXML
    public void handleEmployeeLogin() throws IOException {
        if(employeeLogin(emailInput.getText(), passwordInput.getText())) {
            FastAndFlavorousApplication.switchToDirectorMenus();
        }else{
            this.employeeWelcomeLabel.setText("DENIED!");
        }
    }

    public AbstractUserFacade getUserFacade(){
        return this.facade;
    }

    /**
     * This method handles pulling the token from the input field and submitting it for validation, and forwarding the user if their credentials are valid
     * @param e is the ActionEvent generated by the GUI once a button is called
     */
    @FXML
    public void handleClientLogin(ActionEvent e){
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