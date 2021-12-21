package com.fastandflavorous.projetsep.facade.menus;

import com.fastandflavorous.projetsep.MenuController;
import com.fastandflavorous.projetsep.model.menus.Menu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

public class MenuCell extends ListCell<Menu> {
    HBox hbox = new HBox();
    Label label = new Label("(empty)");
    Pane pane = new Pane();
    Button editButton = new Button("Edit");
    Button deleteButton = new Button("DEL");
    Menu menuItem;

    public MenuCell() {
        super();
        hbox.getChildren().addAll(label, pane, editButton, deleteButton);
        HBox.setHgrow(pane, Priority.ALWAYS);
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MenuController.deleteMenu(menuItem);
            }
        });
        editButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MenuController.editMenu(menuItem);
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
