package com.fastandflavorous.projetsep;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FastAndFlavorousApplication extends Application {

    private static LoginController loginController;
    private static Stage stage;

    @Override
    public void start(Stage st) throws IOException {
        stage = st;
        FXMLLoader fxmlLoader = new FXMLLoader(FastAndFlavorousApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Fast and Flavorous");
        stage.setScene(scene);
        stage.show();
    }

    public static LoginController getLoginController(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FastAndFlavorousApplication.class.getResource("client_login.fxml"));
        loginController = (LoginController) loader.getController();
        return loginController;
    }

    public static void update(){
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void switchToClientLogin() throws IOException {
        Parent root = FXMLLoader.load(FastAndFlavorousApplication.class.getResource("client_login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void switchToEmployeeLogin() throws IOException {
        Parent root = FXMLLoader.load(FastAndFlavorousApplication.class.getResource("employee_login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void returnToLoginType() throws IOException {
        Parent root = FXMLLoader.load(FastAndFlavorousApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void switchToDirectorMenus() throws IOException {
        Parent root = FXMLLoader.load(FastAndFlavorousApplication.class.getResource("director_menus.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void switchToDirectorAddMenus() throws IOException {
        Parent root = FXMLLoader.load(FastAndFlavorousApplication.class.getResource("director_add_menu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}