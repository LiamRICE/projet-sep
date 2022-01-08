package com.fastandflavorous.projetsep;

import com.fastandflavorous.projetsep.facade.costs.AbstractCostsFacade;
import com.fastandflavorous.projetsep.facade.costs.CostListViewCell;
import com.fastandflavorous.projetsep.facade.costs.CostsFacade;
import com.fastandflavorous.projetsep.model.costs.Cost;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class CostController implements Initializable {

    @FXML
    private ListView<Cost> costListView;

    private ObservableList<Cost> costObservableList;

    @FXML
    Button add_cost;

    @FXML
    TextField label_cost_input;

    private AbstractCostsFacade facade;

    // Edit cost

    @FXML
    TextField amount_cost_input;

    private static Cost currentCost;

    public CostController(){

    }

    public void setCostListView(){
        costObservableList = FXCollections.observableArrayList();
        costObservableList.addAll(facade.getAllCosts());
        for(Cost cost: facade.getAllCosts() ){
            System.out.println(cost);
        }
        costListView.setItems(costObservableList);
        costListView.setCellFactory(costListView -> new CostListViewCell(this));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        this.facade = new CostsFacade();
        if(costListView != null){
            setCostListView();
        }
        if(amount_cost_input != null){
            label_cost_input.setText(currentCost.getLabel());
            amount_cost_input.setText(String.valueOf(currentCost.getAmount()));
        }
    }

    public void addCost() throws IOException {
        facade.addCost(label_cost_input.getText());
        FastAndFlavorousApplication.switchToDirectorCosts();

    }

    public void switchingToAddCost() throws IOException{
        FastAndFlavorousApplication.switchToDirectorAddCost();
    }

   public void returnDirectorCosts() throws IOException {
       FastAndFlavorousApplication.switchToDirectorCosts();
   }

    public void deleteCost(Cost cost){
        facade.deleteCost(cost.getIdCost());
        setCostListView();
    }

    public static void switchingToEditCost(Cost cost) throws IOException {
        currentCost = cost;
        FastAndFlavorousApplication.switchToDirectorEditCost();
    }

    public void editCost() throws IOException {
        if(!label_cost_input.getText().equals(currentCost.getLabel())){
            facade.setLabel(currentCost.getIdCost(),label_cost_input.getText());

        }
        float valueAmountInput = Float.parseFloat(amount_cost_input.getText());
        if(valueAmountInput != (currentCost.getAmount())){
            facade.setAmount(currentCost.getIdCost(), Float.parseFloat(amount_cost_input.getText()));

        }
        FastAndFlavorousApplication.switchToDirectorCosts();
    }

    public void returnToDirectorHome() throws IOException{
        FastAndFlavorousApplication.switchToDirectorHome();
    }
}
