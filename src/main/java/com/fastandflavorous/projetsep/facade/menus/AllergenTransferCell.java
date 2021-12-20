package com.fastandflavorous.projetsep.facade.menus;

import com.fastandflavorous.projetsep.MenuController;
import com.fastandflavorous.projetsep.model.menus.Allergen;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

public class AllergenTransferCell extends ListCell<Allergen> {
    HBox hbox = new HBox();
    Label label = new Label("(empty)");
    Pane pane = new Pane();
    Button button;
    Allergen allergenItem;

    public AllergenTransferCell(boolean available) {
        super();
        if(available){
            button = new Button("=>");
        }else{
            button = new Button("<=");
        }
        hbox.getChildren().addAll(label, pane, button);
        HBox.setHgrow(pane, Priority.ALWAYS);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MenuController.shiftAllergenInTempList(allergenItem);
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