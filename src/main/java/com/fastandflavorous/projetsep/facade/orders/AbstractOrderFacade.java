package com.fastandflavorous.projetsep.facade.orders;


import com.fastandflavorous.projetsep.facade.stocks.AbstractStockFacade;
import com.fastandflavorous.projetsep.factory.AbstractFactory;
import com.fastandflavorous.projetsep.model.menus.Menu;
import com.fastandflavorous.projetsep.model.menus.MenuManager;
import com.fastandflavorous.projetsep.model.orders.Order;


import java.util.List;

public class AbstractOrderFacade {

    private AbstractFactory factory;

    private AbstractStockFacade stockFacade;
    /**
     * Default constructor
     */

    protected AbstractOrderFacade() {
        this.factory = AbstractFactory.getFactory();
        this.stockFacade = AbstractStockFacade.getFacade();
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
        for(Menu m : order.getMenus()){
            stockFacade.useStock(m.getName(), 1);
        }
    }

    public List<Order> getOrders(){return factory.getOrderDAO().getOrders();}

    public Order getOrder(int id){return factory.getOrderDAO().getOrder(id);}

    public void editOrder(Order order){
        factory.getOrderDAO().editOrder(order);
    }

}
