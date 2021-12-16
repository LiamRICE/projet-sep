package com.fastandflavorous.projetsep;

import com.fastandflavorous.projetsep.facade.menus.AbstractMenuFacade;
import com.fastandflavorous.projetsep.model.menus.Allergen;
import com.fastandflavorous.projetsep.model.menus.Menu;
import com.fastandflavorous.projetsep.model.menus.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
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
    ListView mainList;
    @FXML
    TextField name_input, image_input, price_input, p_cost_input, p_name_input;
    @FXML
    TextArea description_input;

    private static AbstractMenuFacade facade;

    /**
     * Default constructor
     */
    public MenuController() {
        this.facade = AbstractMenuFacade.getFacade();
    }

    // TODO - WORK IN PROGRESS
    static class MenuCell extends ListCell<Menu> {
        HBox hbox = new HBox();
        Label label = new Label("(empty)");
        Pane pane = new Pane();
        Button button = new Button("DEL");
        Menu menuItem;

        public MenuCell() {
            super();
            hbox.getChildren().addAll(label, pane, button);
            HBox.setHgrow(pane, Priority.ALWAYS);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    MenuController.deleteMenu(menuItem);
                }
            });
        }

        @Override
        protected void updateItem(Menu item, boolean empty) {
            super.updateItem(item, empty);
            setText(null);  // No text in label of super class
            if (empty) {
                menuItem = null;
                setGraphic(null);
            } else {
                menuItem = item;
                label.setText(item!=null ? item.toString() : "<null>");
                setGraphic(hbox);
            }
        }
    }

    static class ProductCell extends ListCell<Product> {
        HBox hbox = new HBox();
        Label label = new Label("(empty)");
        Pane pane = new Pane();
        Button button = new Button("DEL");
        Product productItem;

        public ProductCell() {
            super();
            hbox.getChildren().addAll(label, pane, button);
            HBox.setHgrow(pane, Priority.ALWAYS);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    MenuController.deleteProduct(productItem);
                }
            });
        }

        @Override
        protected void updateItem(Product item, boolean empty) {
            super.updateItem(item, empty);
            setText(null);  // No text in label of super class
            if (empty) {
                productItem = null;
                setGraphic(null);
            } else {
                productItem = item;
                label.setText(item!=null ? item.toString() : "<null>");
                setGraphic(hbox);
            }
        }
    }

    public void showMenuInputPane() throws IOException {
        FastAndFlavorousApplication.switchToDirectorAddMenus();
    }

    public void showProductInputPane() throws IOException {
        FastAndFlavorousApplication.switchToDirectorAddProducts();
    }

    public void returnToDirectorMenus() throws IOException {
        FastAndFlavorousApplication.switchToDirectorMenus();
    }

    public void getAllMenus(){
        Stage stage = (Stage) this.listPane.getScene().getWindow();
        ObservableList<Menu> list = FXCollections.observableArrayList();
        // TODO - pull list of menu and store them in our observableList.
        list.addAll(getMenus());
        mainList.setItems(list);
        mainList.setCellFactory(new Callback<ListView<Menu>, ListCell<Menu>>() {
            @Override
            public ListCell<Menu> call(ListView<Menu> param) {
                return new MenuCell();
            }
        });
        stage.show();
    }

    public void getAllProducts(){
        Stage stage = (Stage) this.listPane.getScene().getWindow();
        ObservableList<Product> list = FXCollections.observableArrayList();
        // TODO - pull list of menu and store them in our observableList.
        list.addAll(getProducts());
        mainList.setItems(list);
        mainList.setCellFactory(new Callback<ListView<Product>, ListCell<Product>>() {
            @Override
            public ListCell<Product> call(ListView<Product> param) {
                return new ProductCell();
            }
        });
        stage.show();
    }

    /**
     * @return
     */
    public void addMenu() {
        String name = name_input.getText() == null? "": name_input.getText();
        String image = image_input.getText() == null? "": image_input.getText();
        String description = description_input.getText() == null? "": description_input.getText();
        String p = price_input.getText() == null? "": price_input.getText();
        float price = Float.parseFloat(p);
        this.facade.addMenu(name, image, description, price);
        try {
            this.returnToDirectorMenus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return
     */
    public void addProduct() {
        String name = p_name_input.getText() == null? "": p_name_input.getText();
        String p = p_cost_input.getText() == null? "": p_cost_input.getText();
        float cost = Float.parseFloat(p);
        this.facade.addProduct(name, cost);
        try{
            this.returnToDirectorMenus();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * @return
     */
    public void addAllergen() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void addProductToMenu() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void addAllergenToProduct() {
        // TODO implement here
    }

    /**
     * @param e
     * @return
     */
    public void editMenu(ActionEvent e) {
        // TODO implement here
    }

    /**
     * @param e
     * @return
     */
    public void editProduct(ActionEvent e) {
        // TODO implement here
    }

    /**
     * @param e
     * @return
     */
    public void editAllergen(ActionEvent e) {
        // TODO implement here
    }

    /**
     * @return
     */
    public List<Menu> getMenus() {
        return facade.getMenus();
    }

    /**
     * @return
     */
    public List<Product> getProducts() {
        return facade.getProducts();
    }

    /**
     * @return
     */
    public List<Allergen> getAllergens() {
        // TODO implement here
        return null;
    }

    /**
     * @param menu
     * @return
     */
    public static void deleteMenu(Menu menu) {
        facade.deleteMenu(menu);
    }

    /**
     * @param product
     * @return
     */
    public static void deleteProduct(Product product) {
        facade.deleteProduct(product);
    }

    /**
     * @param allergen
     * @return
     */
    public void deleteAllergen(Allergen allergen) {
        // TODO implement here
    }

}