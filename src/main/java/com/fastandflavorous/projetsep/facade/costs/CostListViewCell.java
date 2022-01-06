package com.fastandflavorous.projetsep.facade.costs;
import com.fastandflavorous.projetsep.CostController;
import com.fastandflavorous.projetsep.FastAndFlavorousApplication;
import com.fastandflavorous.projetsep.model.costs.Cost;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CostListViewCell extends ListCell<Cost> {

    @FXML
    private Label costLabel,amount,lastModificationDate;

    @FXML
    private Button edit,delete;

    private FXMLLoader mLLoader;

    private CostController parent;

    @FXML
    private GridPane gridPane;

    public CostListViewCell(CostController parent){
        this.parent = parent;
    }

    /*
    public CostListViewCell() {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(CostController.class.getResource("director_costs.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Fast and Flavorous");
        stage.setScene(scene);
        stage.show();
        try{
            mLLoader = FXMLLoader.load(getClass().getResource("../../costCell.fxml"));
        }catch(Exception e){
            System.err.println(e);
        }
        hbox.getChildren().addAll(label, pane, editButton, deleteButton);
        HBox.setHgrow(pane, Priority.ALWAYS);
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //CostController.deleteCost(costItem);
            }
        });
        editButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //CostController.editCost(costItem);
            }
        });
    }
*/
    @Override
    protected void updateItem(Cost cost, boolean empty) {
        super.updateItem(cost, empty);
        setText(null);  // No text in label of super class
        if (empty || cost == null) {
            setText(null);
            setGraphic(null);
        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(FastAndFlavorousApplication.class.getResource("costCell.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.getCause();
                    e.printStackTrace();
                }

            }
            costLabel.setText(cost.getLabel());
            amount.setText(String.valueOf(cost.getAmount()));
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            lastModificationDate.setText(dateFormat.format(cost.getLastModificationDate()));
            setText(null);
            setGraphic(gridPane);
        }
    }
}