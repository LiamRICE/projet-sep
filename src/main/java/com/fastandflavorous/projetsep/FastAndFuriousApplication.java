package com.fastandflavorous.projetsep;

import com.mysql.jdbc.log.Log;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class FastAndFuriousApplication extends Application {

    private static LoginController loginController;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FastAndFuriousApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Fast and Flavorous");
        stage.setScene(scene);
        stage.show();
    }

    public static LoginController getLoginController(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FastAndFuriousApplication.class.getResource("client_login.fxml"));
        loginController = (LoginController) loader.getController();
        return loginController;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void returnToLoginType(ActionEvent e) throws IOException {
        Stage stage = (Stage)((Button)e.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(FastAndFuriousApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}