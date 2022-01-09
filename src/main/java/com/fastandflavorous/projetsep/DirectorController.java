package com.fastandflavorous.projetsep;

import com.fastandflavorous.projetsep.FastAndFlavorousApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class DirectorController {

    public void switchToDirectorMenus() throws IOException {
        FastAndFlavorousApplication.switchToDirectorMenus();
    }

    public void switchToDirectorStocks() throws IOException {
        FastAndFlavorousApplication.switchToDirectorStocks();
    }

    public void switchToDirectorEmployees() throws IOException {
        FastAndFlavorousApplication.switchToDirectorEmployees();
    }

    public void switchToDirectorCosts() throws IOException {
        FastAndFlavorousApplication.switchToDirectorCosts();
    }

    public void logOut() throws IOException {
        FastAndFlavorousApplication.logOff();
    }
}
