package com.fastandflavorous.projetsep;

import com.fastandflavorous.projetsep.facade.menus.AbstractMenuFacade;
import com.fastandflavorous.projetsep.facade.menus.MenuCell;
import com.fastandflavorous.projetsep.facade.orders.AbstractOrderFacade;
import com.fastandflavorous.projetsep.facade.orders.MenusCell;
import com.fastandflavorous.projetsep.facade.orders.OrderCell;
import com.fastandflavorous.projetsep.facade.orders.OrdersCell;
import com.fastandflavorous.projetsep.model.menus.Menu;
import com.fastandflavorous.projetsep.model.orders.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderController {
    @FXML
    AnchorPane listPane;
    @FXML
    ListView menuListView, menuOrderedListView, employeeOrderListView;
    @FXML
    Button payNow;

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

    public void getOrdersForEmployees(){
        Stage stage = (Stage) this.listPane.getScene().getWindow();
        ObservableList<Order> list = FXCollections.observableArrayList();
        list.addAll(getOrders());
        employeeOrderListView.setItems(list);
        employeeOrderListView.setCellFactory(new Callback<ListView<Order>, ListCell<Order>>() {
            @Override
            public ListCell<Order> call(ListView<Order> param) {
                return new OrdersCell();
            }
        });
        stage.show();
    }

    public List<Order> getOrders(){
        List<Order> orders = orderFacade.getOrders();
        List<Order> ret = new ArrayList<>();
        for(Order o : orders){
            if(!o.isPaid() || !o.isFullfilled()){
                ret.add(o);
            }
        }
        return ret;
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

    public void commitOrder(ActionEvent e) throws IOException{
        Object src = e.getSource();
        if(src == payNow){
            currentOrder.setPaid(true);
        }
        orderFacade.addOrder(currentOrder);
        returnToHome();
    }

    public static void fulfillOrder(Order order){
        System.out.println(order);
        order.setFullfilled(true);
        orderFacade.editOrder(order);
    }

    public static void payOrder(Order order){
        order.setPaid(true);
        orderFacade.editOrder(order);
    }
}
