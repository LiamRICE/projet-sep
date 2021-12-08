package com.fastandflavorous.projetsep;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.controlsfx.control.action.Action;

import java.util.*;

/**
 * 
 */
public class MenuController {

    @FXML
    AnchorPane listPane;
    @FXML
    ListView menuList;

    /**
     * Default constructor
     */
    public MenuController() {
    }

    // TODO - WORK IN PROGRESS
    static class MenuCell extends ListCell<String> {
        HBox hbox = new HBox();
        Label label = new Label("(empty)");
        Pane pane = new Pane();
        Button button = new Button("(>)");
        String lastItem;

        public MenuCell() {
            super();
            hbox.getChildren().addAll(label, pane, button);
            HBox.setHgrow(pane, Priority.ALWAYS);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println(lastItem + " : " + event);
                }
            });
        }

        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            setText(null);  // No text in label of super class
            if (empty) {
                lastItem = null;
                setGraphic(null);
            } else {
                lastItem = item;
                label.setText(item!=null ? item : "<null>");
                setGraphic(hbox);
            }
        }
    }

    public void getAllMenus(){
        Stage stage = (Stage) this.listPane.getScene().getWindow();
        // TEMPORARY OBSERVABLE LIST - NEED TO PUT DATABASE INFO INTO OBSERVABLE LIST IN FINAL VERSION
        ObservableList<String> list = FXCollections.observableArrayList("Menu1", "Menu2");
        menuList.setItems(list);
        menuList.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new MenuCell();
            }
        });
        stage.show();
    }


    /**
     * @return
     */
    public void addMenu() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void addProduct() {
        // TODO implement here
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
    public void showMenus() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void showProducts() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void showAllergens() {
        // TODO implement here
    }

    /**
     * @param e
     * @return
     */
    public void deleteMenu(ActionEvent e) {
        // TODO implement here
    }

    /**
     * @param e
     * @return
     */
    public void deleteProduct(ActionEvent e) {
        // TODO implement here
    }

    /**
     * @param e
     * @return
     */
    public void deleteAllergen(ActionEvent e) {
        // TODO implement here
    }

}