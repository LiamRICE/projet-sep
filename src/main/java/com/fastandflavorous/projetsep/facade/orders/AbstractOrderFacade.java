package com.fastandflavorous.projetsep.facade.orders;


import com.fastandflavorous.projetsep.factory.AbstractFactory;
import com.fastandflavorous.projetsep.model.menus.Menu;
import com.fastandflavorous.projetsep.model.menus.MenuManager;
import com.fastandflavorous.projetsep.model.orders.Order;


import java.util.List;

public class AbstractOrderFacade {

    private AbstractFactory factory;
    /**
     * Default constructor
     */

    protected AbstractOrderFacade() {
        this.factory = AbstractFactory.getFactory();
    }

    public static AbstractOrderFacade getFacade(){
        return new OrderFacade();
    }

    /**
     * @return
     */
    public List<Menu> getMenus() {
        return factory.getMenuDAO().getMenus();
    }

    public void addOrder(Order order){
        factory.getOrderDAO().addOrder(order);

    }

    public List<Order> getOrders(){return factory.getOrderDAO().getOrders();}

    public Order getOrder(int id){return factory.getOrderDAO().getOrder(id);}



}
