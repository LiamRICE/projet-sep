package com.fastandflavorous.projetsep;

import com.fastandflavorous.projetsep.facade.menus.*;
import com.fastandflavorous.projetsep.model.menus.Menu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.*;

/**
 * 
 */
public class MenuController {

    @FXML
    AnchorPane listPane;
    @FXML
    ListView menuListView, productListView, allergenListView, products_available_to_add, products_added, allergens_available_to_add, allergens_added;
    @FXML
    TextField name_input, image_input, image_edit, price_input, price_edit, p_cost_input, p_cost_edit, p_name_input, a_name_input;
    @FXML
    TextArea description_input, description_edit;

    private static Menu currentMenu;

    private static AbstractMenuFacade facade;

    /**
     * Default constructor
     */
    public MenuController() {
        this.facade = AbstractMenuFacade.getFacade();
    }

    public void showMenuInputPane() throws IOException {
        FastAndFlavorousApplication.switchToDirectorAddMenus();
    }

    public void returnToDirectorMenus() throws IOException {
        FastAndFlavorousApplication.switchToDirectorMenus();
    }

    public void returnToDirectorHome() throws IOException{
        FastAndFlavorousApplication.switchToDirectorHome();
    }

    public void getAllMenus(){
        Stage stage = (Stage) this.listPane.getScene().getWindow();
        ObservableList<Menu> list = FXCollections.observableArrayList();
        list.addAll(getMenus());
        menuListView.setItems(list);
        menuListView.setCellFactory(new Callback<ListView<Menu>, ListCell<Menu>>() {
            @Override
            public ListCell<Menu> call(ListView<Menu> param) {
                return new MenuCell();
            }
        });
        stage.show();
    }

    /**
     * @return
     */
    public void addMenu() {
        String name = name_input.getText() == ""? "": name_input.getText();
        String image = image_input.getText() == ""? "": image_input.getText();
        String description = description_input.getText() == ""? "": description_input.getText();
        float price = price_input.getText() == ""? 0f : Float.parseFloat(price_input.getText());
        Menu menu = this.facade.addMenu(name, image, description, price);
        try {
            this.returnToDirectorMenus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param menu
     * @return
     */
    public static void editMenu(Menu menu) {
        currentMenu = menu;
        try {
            FastAndFlavorousApplication.switchToDirectorEditMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void refreshMenuObjects(){
        this.image_edit.setText(currentMenu.getImage());
        this.description_edit.setText(currentMenu.getDescription());
        this.price_edit.setText(String.valueOf(currentMenu.getPrice()));
    }

    public void commitMenu(){
        String desc = description_edit.getText() == ""? currentMenu.getDescription() : description_edit.getText();
        String img = image_edit.getText() == ""? currentMenu.getImage() : image_edit.getText();
        float prc = price_edit.getText() == ""? currentMenu.getPrice() : Float.parseFloat(price_edit.getText());
        currentMenu.setDescription(desc);
        currentMenu.setImage(img);
        currentMenu.setPrice(prc);
        facade.setMenu(currentMenu);
        currentMenu = null;
        try {
            FastAndFlavorousApplication.switchToDirectorMenus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return
     */
    public List<Menu> getMenus() {
        return facade.getMenus();
    }

    /**
     * @param menu
     * @return
     */
    public static void deleteMenu(Menu menu) {
        facade.deleteMenu(menu);
    }

}