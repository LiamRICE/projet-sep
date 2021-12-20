package com.fastandflavorous.projetsep;

import com.fastandflavorous.projetsep.facade.menus.*;
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
// TODO - menus and products cannot be shown in the same list
public class MenuController {

    @FXML
    AnchorPane listPane;
    @FXML
    ListView menuListView, productListView, allergenListView, products_available_to_add, products_added, allergens_available_to_add, allergens_added;
    @FXML
    TextField name_input, image_input, price_input, p_cost_input, p_name_input, a_name_input;
    @FXML
    TextArea description_input;

    private static List<Product> tempAddedProducts = new ArrayList<>();;
    private static List<Allergen> tempAddedAllergens = new ArrayList<>();;

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

    public void showProductInputPane() throws IOException {
        FastAndFlavorousApplication.switchToDirectorAddProducts();
    }

    public void showAllergenInputPane() throws IOException {
        FastAndFlavorousApplication.switchToDirectorAddAllergens();
    }

    public void returnToDirectorMenus() throws IOException {
        FastAndFlavorousApplication.switchToDirectorMenus();
    }

    public void switchToDirectorAddProductToMenu() throws IOException{
        FastAndFlavorousApplication.switchToDirectorAddProductsToMenu();
    }

    public void switchToDirectorAddAllergenToProduct() throws IOException{
        FastAndFlavorousApplication.switchToDirectorAddAllergensToProduct();
    }

    public void getAllMenus(){
        Stage stage = (Stage) this.listPane.getScene().getWindow();
        ObservableList<Menu> list = FXCollections.observableArrayList();
        // TODO - pull list of menu and store them in our observableList.
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

    public void getAllProducts(){
        Stage stage = (Stage) this.listPane.getScene().getWindow();
        ObservableList<Product> list = FXCollections.observableArrayList();
        // TODO - pull list of menu and store them in our observableList.
        list.addAll(getProducts());
        productListView.setItems(list);
        productListView.setCellFactory(new Callback<ListView<Product>, ListCell<Product>>() {
            @Override
            public ListCell<Product> call(ListView<Product> param) {
                return new ProductCell();
            }
        });
        stage.show();
    }

    public void getAllAllergens(){
        Stage stage = (Stage) this.listPane.getScene().getWindow();
        ObservableList<Allergen> list = FXCollections.observableArrayList();
        // TODO - pull list of menu and store them in our observableList.
        list.addAll(getAllergens());
        allergenListView.setItems(list);
        allergenListView.setCellFactory(new Callback<ListView<Allergen>, ListCell<Allergen>>() {
            @Override
            public ListCell<Allergen> call(ListView<Allergen> param) {
                return new AllergenCell();
            }
        });
        stage.show();
    }

    public void getAllProductsNotAdded(){
        Stage stage = (Stage) this.listPane.getScene().getWindow();
        ObservableList<Product> list = FXCollections.observableArrayList();
        list.addAll(getProducts());
        list.removeAll(this.tempAddedProducts);
        products_available_to_add.setItems(list);
        products_available_to_add.setCellFactory(new Callback<ListView<Product>, ListCell<Product>>() {
            @Override
            public ListCell<Product> call(ListView<Product> param) {
                return new ProductTransferCell(true);
            }
        });
        stage.show();
    }

    public void getAllProductsAdded(){
        Stage stage = (Stage) this.listPane.getScene().getWindow();
        ObservableList<Product> list = FXCollections.observableArrayList();
        list.addAll(this.tempAddedProducts);
        products_added.setItems(list);
        products_added.setCellFactory(new Callback<ListView<Product>, ListCell<Product>>() {
            @Override
            public ListCell<Product> call(ListView<Product> param) {
                return new ProductTransferCell(false);
            }
        });
        stage.show();
    }

    public void getAllAllergensNotAdded(){
        Stage stage = (Stage) this.listPane.getScene().getWindow();
        ObservableList<Allergen> list = FXCollections.observableArrayList();
        list.addAll(getAllergens());
        list.removeAll(this.tempAddedAllergens);
        allergens_available_to_add.setItems(list);
        allergens_available_to_add.setCellFactory(new Callback<ListView<Allergen>, ListCell<Allergen>>() {
            @Override
            public ListCell<Allergen> call(ListView<Allergen> param) {
                return new AllergenTransferCell(true);
            }
        });
        stage.show();
    }

    public void getAllAllergensAdded(){
        Stage stage = (Stage) this.listPane.getScene().getWindow();
        ObservableList<Allergen> list = FXCollections.observableArrayList();
        list.addAll(this.tempAddedAllergens);
        allergens_added.setItems(list);
        allergens_added.setCellFactory(new Callback<ListView<Allergen>, ListCell<Allergen>>() {
            @Override
            public ListCell<Allergen> call(ListView<Allergen> param) {
                return new AllergenTransferCell(false);
            }
        });
        stage.show();
    }

    public static void shiftProductInTempList(Product product){
        if(tempAddedProducts.contains(product)){
            tempAddedProducts.remove(product);
        }else {
            tempAddedProducts.add(product);
        }
    }

    public static void shiftAllergenInTempList(Allergen allergen){
        if(tempAddedAllergens.contains(allergen)){
            tempAddedAllergens.remove(allergen);
        }else{
            tempAddedAllergens.add(allergen);
        }
    }

    public void refreshAddProductToMenuLists(){
        this.getAllProductsAdded();
        this.getAllProductsNotAdded();
    }

    public void refreshAddAllergenToProductLists(){
        this.getAllAllergensAdded();
        this.getAllAllergensNotAdded();
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
        Menu menu = this.facade.addMenu(name, image, description, price);
        this.addProductsToMenu(menu);
        tempAddedProducts.clear();
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
        Product product = this.facade.addProduct(name, cost);
        this.addAllergensToProduct(product);
        tempAddedAllergens.clear();
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
        String name = a_name_input.getText() == null? "": a_name_input.getText();
        this.facade.addAllergen(name);
        try{
            this.returnToDirectorMenus();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * @param menu
     * @return
     */
    public void addProductsToMenu(Menu menu) {
        for(Product p : tempAddedProducts){
            facade.addProductToMenu(menu, p);
        }
    }

    /**
     * @param product
     * @return
     */
    public void addAllergensToProduct(Product product) {
        for(Allergen a : tempAddedAllergens){
            facade.addAllergenToProduct(product, a);
        }
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
        return facade.getAllergens();
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
    public static void deleteAllergen(Allergen allergen) {
        facade.deleteAllergen(allergen);
    }

}