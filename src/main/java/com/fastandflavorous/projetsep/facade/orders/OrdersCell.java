package com.fastandflavorous.projetsep.facade.orders;

import com.fastandflavorous.projetsep.MenuController;
import com.fastandflavorous.projetsep.OrderController;
import com.fastandflavorous.projetsep.model.menus.Menu;
import com.fastandflavorous.projetsep.model.orders.Order;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

public class OrdersCell extends ListCell<Order> {
    HBox hbox = new HBox();
    Label label = new Label("(empty)");
    Pane pane = new Pane();
    Button fButton = new Button("Fulfill");
    Button pButton = new Button("Paid");
    Order menuItem;

    public OrdersCell() {
        super();
        hbox.getChildren().addAll(label, pane, fButton, pButton);
        HBox.setHgrow(pane, Priority.ALWAYS);
        fButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                OrderController.fulfillOrder(menuItem);
            }
        });
        pButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                OrderController.payOrder(menuItem);
            }
        });
    }

    @Override
    protected void updateItem(Order item, boolean empty) {
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
