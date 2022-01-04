package com.fastandflavorous.projetsep.facade.menus;

import com.fastandflavorous.projetsep.MenuController;
import com.fastandflavorous.projetsep.StockController;
import com.fastandflavorous.projetsep.model.menus.Menu;
import com.fastandflavorous.projetsep.model.stocks.Stock;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

public class StockCell extends ListCell<Stock> {
    HBox hbox = new HBox();
    Label label = new Label("(empty)");
    Pane pane = new Pane();
    Button deleteButton = new Button("Add/Remove");
    Stock stockItem;

    public StockCell() {
        super();
        hbox.getChildren().addAll(label, pane, deleteButton);
        HBox.setHgrow(pane, Priority.ALWAYS);
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StockController.switchToDirectorAddStock(stockItem);
            }
        });
    }

    @Override
    protected void updateItem(Stock item, boolean empty) {
        super.updateItem(item, empty);
        setText(null);  // No text in label of super class
        if (empty) {
            stockItem = null;
            setGraphic(null);
        } else {
            stockItem = item;
            label.setText(item!=null ? item.toString() : "<null>");
            setGraphic(hbox);
        }
    }
}
