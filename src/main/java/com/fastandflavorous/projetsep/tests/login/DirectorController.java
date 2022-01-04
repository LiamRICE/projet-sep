package com.fastandflavorous.projetsep.tests.login;

import com.fastandflavorous.projetsep.FastAndFlavorousApplication;
import javafx.fxml.FXML;

import java.io.IOException;

public class DirectorController {

    public void switchToDirectorMenus() throws IOException {
        FastAndFlavorousApplication.switchToDirectorMenus();
    }

    public void logOut() throws IOException {
        FastAndFlavorousApplication.logOff();
    }
}
