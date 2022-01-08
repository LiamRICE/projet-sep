package com.fastandflavorous.projetsep;

import com.fastandflavorous.projetsep.facade.menus.AbstractMenuFacade;
import com.fastandflavorous.projetsep.facade.menus.MenuCell;
import com.fastandflavorous.projetsep.facade.stocks.AbstractStockFacade;
import com.fastandflavorous.projetsep.facade.stocks.StockCell;
import com.fastandflavorous.projetsep.model.menus.Menu;
import com.fastandflavorous.projetsep.model.stocks.Stock;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StockController {

    @FXML
    AnchorPane listPane;
    @FXML
    ListView stockListView;
    @FXML
    TextField quantity_input;

    private static Stock currentStock;

    private static AbstractStockFacade facade;

    /**
     * Default constructor
     */
    public StockController() {
        this.facade = AbstractStockFacade.getFacade();
    }

    public void returnToDirectorStocks() throws IOException {
        FastAndFlavorousApplication.switchToDirectorStocks();
    }

    public void returnToDirectorHome() throws IOException{
        FastAndFlavorousApplication.switchToDirectorHome();
    }

    public static void switchToDirectorAddStock(Stock stock) {
        currentStock = stock;
        try {
            FastAndFlavorousApplication.switchToDirectorAddStock();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getAllStocks(){
        Stage stage = (Stage) this.listPane.getScene().getWindow();
        ObservableList<Stock> list = FXCollections.observableArrayList();
        list.addAll(getStocks());
        stockListView.setItems(list);
        stockListView.setCellFactory(new Callback<ListView<Stock>, ListCell<Stock>>() {
            @Override
            public ListCell<Stock> call(ListView<Stock> param) {
                return new StockCell();
            }
        });
        stage.show();
    }

    public List<Stock> getStocks(){
        return facade.getStocks();
    }

    public void editStock() throws IOException {
        String value = quantity_input.getText() == "" ? "0" : quantity_input.getText();
        int quantity = Integer.parseInt(value);
        if(quantity >= 0){
            facade.buyStock(currentStock.getName(), quantity);
        }else{
            facade.dumpStock(currentStock.getName(), -quantity);
        }
        currentStock = null;
        returnToDirectorStocks();
    }

}
