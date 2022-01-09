package com.fastandflavorous.projetsep.facade.orders;

import com.fastandflavorous.projetsep.MenuController;
import com.fastandflavorous.projetsep.OrderController;
import com.fastandflavorous.projetsep.model.menus.Menu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

public class OrderCell extends ListCell<Menu> {
    HBox hbox = new HBox();
    Label label = new Label("(empty)");
    Pane pane = new Pane();
    Button deleteButton = new Button("Remove");
    Menu menuItem;

    public OrderCell() {
        super();
        hbox.getChildren().addAll(label, pane, deleteButton);
        HBox.setHgrow(pane, Priority.ALWAYS);
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                OrderController.removeMenuFromOrder(menuItem);
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
