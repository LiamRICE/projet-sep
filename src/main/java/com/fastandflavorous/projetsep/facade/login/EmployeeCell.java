package com.fastandflavorous.projetsep.facade.login;

import com.fastandflavorous.projetsep.EmployeeController;
import com.fastandflavorous.projetsep.StockController;
import com.fastandflavorous.projetsep.model.stocks.Stock;
import com.fastandflavorous.projetsep.model.users.Employee;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

public class EmployeeCell extends ListCell<Employee> {
    HBox hbox = new HBox();
    Label label = new Label("(empty)");
    Pane pane = new Pane();
    Button deleteButton = new Button("Edit Contract");
    Employee empItem;

    public EmployeeCell() {
        super();
        hbox.getChildren().addAll(label, pane, deleteButton);
        HBox.setHgrow(pane, Priority.ALWAYS);
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                EmployeeController.switchToDirectorEditEmployee(empItem);
            }
        });
    }

    @Override
    protected void updateItem(Employee item, boolean empty) {
        super.updateItem(item, empty);
        setText(null);  // No text in label of super class
        if (empty) {
            empItem = null;
            setGraphic(null);
        } else {
            empItem = item;
            label.setText(item!=null ? item.toString() : "<null>");
            setGraphic(hbox);
        }
    }
}
