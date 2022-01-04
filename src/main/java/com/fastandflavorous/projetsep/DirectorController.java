package com.fastandflavorous.projetsep;

import com.fastandflavorous.projetsep.FastAndFlavorousApplication;
import javafx.fxml.FXML;

import java.io.IOException;

public class DirectorController {

    public void switchToDirectorMenus() throws IOException {
        FastAndFlavorousApplication.switchToDirectorMenus();
    }

    public void switchToDirectorStocks() throws IOException {
        FastAndFlavorousApplication.switchToDirectorStocks();
    }

    public void logOut() throws IOException {
        FastAndFlavorousApplication.logOff();
    }
}
