package com.fastandflavorous.projetsep;

import com.fastandflavorous.projetsep.facade.menus.AbstractMenuFacade;
import com.fastandflavorous.projetsep.facade.menus.MenuCell;
import com.fastandflavorous.projetsep.facade.orders.AbstractOrderFacade;
import com.fastandflavorous.projetsep.facade.orders.MenusCell;
import com.fastandflavorous.projetsep.facade.orders.OrderCell;
import com.fastandflavorous.projetsep.model.menus.Menu;
import com.fastandflavorous.projetsep.model.orders.Order;
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
import java.util.List;

public class OrderController {
    @FXML
    AnchorPane listPane;
    @FXML
    ListView menuListView, menuOrderedListView;
    @FXML
    TextField client_name;
    @FXML
    TextArea client_input;

    private static Order currentOrder = new Order(0, false, false, false, 0.);

    private static AbstractOrderFacade orderFacade;

    /**
     * Default constructor
     */
    public OrderController() {
        this.orderFacade = AbstractOrderFacade.getFacade();
    }

    public void showPaymentPane() throws IOException {
        FastAndFlavorousApplication.switchToClientPayment();
    }

    public void returnToHome() throws IOException{
        FastAndFlavorousApplication.returnToLoginType();
    }

    public void getMenusOrdered(){
        Stage stage = (Stage) this.listPane.getScene().getWindow();
        ObservableList<Menu> list = FXCollections.observableArrayList();
        list.addAll(currentOrder.getMenus());
        menuOrderedListView.setItems(list);
        menuOrderedListView.setCellFactory(new Callback<ListView<Menu>, ListCell<Menu>>() {
            @Override
            public ListCell<Menu> call(ListView<Menu> param) {
                return new OrderCell();
            }
        });
        stage.show();
    }

    public void refresh(){
        getAllMenus();
        getMenusOrdered();
    }

    public void getAllMenus(){
        Stage stage = (Stage) this.listPane.getScene().getWindow();
        ObservableList<Menu> list = FXCollections.observableArrayList();
        list.addAll(getMenus());
        menuListView.setItems(list);
        menuListView.setCellFactory(new Callback<ListView<Menu>, ListCell<Menu>>() {
            @Override
            public ListCell<Menu> call(ListView<Menu> param) {
                return new MenusCell();
            }
        });
        stage.show();
    }

    public static void addMenuToOrder(Menu menu){
        currentOrder.addMenuToOrder(menu);
    }

    public static void removeMenuFromOrder(Menu menu){
        currentOrder.removeMenuFromOrder(menu);
    }

    public List<Menu> getMenus() {
        return orderFacade.getMenus();
    }

    public void commitOrder(){
        orderFacade.addOrder(currentOrder);
    }
}
