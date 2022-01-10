package com.fastandflavorous.projetsep.tests;

import com.fastandflavorous.projetsep.LoginController;
import com.fastandflavorous.projetsep.facade.menus.AbstractMenuFacade;
import com.fastandflavorous.projetsep.facade.stocks.AbstractStockFacade;
import com.fastandflavorous.projetsep.model.menus.Menu;
import com.fastandflavorous.projetsep.model.stocks.Stock;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.Assert.*;

public class ControllerTests {

    LoginController lc = new LoginController();

    @Test
    @DisplayName("Checking if token 'fastAndFlavorous' is regognised :")
    public void clientLoginTestTrue() {
        assertEquals(true, lc.clientLogin("fastAndFlavorous"));
    }
    @Test
    @DisplayName("Checking if token 'meWantFood' is rejected :")
    public void clientLoginTestFalse() {
        assertEquals(false, lc.clientLogin("meWantFood"));
    }
    @Test
    @DisplayName("Checking if employee 'fast@fast.com' with password 'fast' is recognised :")
    public void employeeLoginTestTrue() {
        assertEquals(true, lc.employeeLogin("dir@fast.com", "dir"));
    }
    @Test
    @DisplayName("Checking if employee 'hacker@hacking.com' with password 'fast' is rejected :")
    public void employeeLoginTestFalse() {
        assertEquals(false, lc.employeeLogin("hacker@hacking.com", "fast"));
    }
    @Test
    @DisplayName("Checking if employee 'fast@fast.com' with password 'wrong' is rejected :")
    public void employeeLoginTestWrongPswd() {
        assertEquals(false, lc.employeeLogin("dir@fast.com", "wrong"));
    }


    AbstractMenuFacade amf = AbstractMenuFacade.getFacade();
    AbstractStockFacade asf = AbstractStockFacade.getFacade();

    private boolean checkMenu(){
        amf.addMenu("TestMenu", "Image", "Description", 15f);
        List<Menu> menus = amf.getMenus();
        boolean ret = false;
        for(Menu m : menus){
            if(m.getName().equals("TestMenu") && m.getImage().equals("Image") && m.getDescription().equals("Description") && m.getPrice() == 15f){
                ret = true;
            }
        }
        return ret;
    }

    @Test
    @DisplayName("Checking if adding a menu works :")
    public void checkAddMenu(){
        assertEquals(true, checkMenu());
    }

    private boolean checkStock(){
        amf.addMenu("AnotherTest", "Image", "Description", 12f);
        List<Stock> stocks = asf.getStocks();
        boolean ret = false;
        for(Stock s : stocks){
            if(s.getName().equals("AnotherTest")){
                ret = true;
            }
        }
        return ret;
    }

    @Test
    @DisplayName("Checking if adding a menu adds a stock :")
    public void checkStockAdded(){
        assertEquals(true, checkStock());
    }
}