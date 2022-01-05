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
    Button get_costs,add_cost;

    @FXML
    Label test;

    private AbstractCostsFacade facade;

    public CostController(){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        this.facade = new CostsFacade();

        costObservableList = FXCollections.observableArrayList();
        costObservableList.addAll(facade.getAllCosts());
        for(Cost cost: facade.getAllCosts() ){
            System.out.println(cost);
        }
        costListView.setItems(costObservableList);
        costListView.setCellFactory(costListView -> new CostListViewCell(this));
    }

    public void getAllCosts(){

    }

    public void addCost(){

    }
}
