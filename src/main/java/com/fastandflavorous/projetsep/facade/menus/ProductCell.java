package com.fastandflavorous.projetsep.facade.menus;

import com.fastandflavorous.projetsep.MenuController;
import com.fastandflavorous.projetsep.model.menus.Product;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class ProductCell extends ListCell<Product> {
    HBox hbox = new HBox();
    Label label = new Label("(empty)");
    Pane pane = new Pane();
    Button editButton = new Button("Edit");
    Button deleteButton = new Button("DEL");
    Product productItem;

    public ProductCell() {
        super();
        hbox.getChildren().addAll(label, pane, editButton, deleteButton);
        HBox.setHgrow(pane, Priority.ALWAYS);
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MenuController.deleteProduct(productItem);
            }
        });
        editButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MenuController.editProduct(productItem);
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