package com.fastandflavorous.projetsep.facade.menus;

import com.fastandflavorous.projetsep.MenuController;
import com.fastandflavorous.projetsep.model.menus.Allergen;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class AllergenCell extends ListCell<Allergen> {
    HBox hbox = new HBox();
    Label label = new Label("(empty)");
    Pane pane = new Pane();
    Button deleteButton = new Button("DEL");
    Allergen allergenItem;

    public AllergenCell() {
        super();
        hbox.getChildren().addAll(label, pane, deleteButton);
        HBox.setHgrow(pane, Priority.ALWAYS);
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MenuController.deleteAllergen(allergenItem);
            }
        });
    }

    @Override
    protected void updateItem(Allergen item, boolean empty) {
        super.updateItem(item, empty);
        setText(null);  // No text in label of super class
        if (empty) {
            allergenItem = null;
            setGraphic(null);
        } else {
            allergenItem = item;
            label.setText(item!=null ? item.toString() : "<null>");
            setGraphic(hbox);
        }
    }
}