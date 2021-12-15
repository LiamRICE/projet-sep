package com.fastandflavorous.projetsep.factory;

import com.fastandflavorous.projetsep.dao.menus.MenuDAO;
import com.fastandflavorous.projetsep.dao.users.UserDAO;
import com.fastandflavorous.projetsep.factory.menus.AbstractMenuFactory;
import com.fastandflavorous.projetsep.factory.menus.MenuFactory;
import com.fastandflavorous.projetsep.model.menus.MenuManager;
import com.fastandflavorous.projetsep.model.users.ClientManager;
import com.fastandflavorous.projetsep.model.users.EmployeeManager;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public abstract class AbstractFactory {
    protected AbstractFactory() {
        this.menuDAO = MenuDAO.getMenuDAO();
        this.menuManager = MenuManager.getMenuManager();
        this.dao = UserDAO.getDAO(configDAO);
        this.employeeManager = EmployeeManager.getEmployeeManager();
        this.clientManager = ClientManager.getClientManager();
    }

    // static and tools
    private String configDAO = "MySQL";
    private static AbstractFactory factory;
    private static Object sync = new Object();
    private static final String SALT = "fastAndFlavorous";
    private static final String ALGORITHM = "PBKDF2WithHmacSHA1";

    // objects to be created
    private MenuManager menuManager;
    private MenuDAO menuDAO;
    private UserDAO dao;
    private EmployeeManager employeeManager;
    private ClientManager clientManager;

    public static AbstractFactory getFactory() {
        if(factory == null){
            synchronized (sync){
                if(factory == null){
                    factory = new Factory();
                }
            }
        }
        return factory;
    }

    public MenuDAO getMenuDAO(){
        return this.menuDAO;
    }

    public MenuManager getMenuManager(){
        return this.menuManager;
    }

    public UserDAO getUserDAO(){
        return this.dao;
    }

    public ClientManager getClientManager(){
        return this.clientManager;
    }

    public EmployeeManager getEmployeeManager(){
        return this.employeeManager;
    }

    /**
     * This methods hashes the password passed in parameter depending on the static constants SALT and ALGORITHM
     * @param password password to hash
     * @return The hashed password
     */
    public String getHashedPassword(String password){
        byte[] salt = SALT.getBytes();
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        String base64encoded ="";
        try{
            SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
            byte[] hash = factory.generateSecret(spec).getEncoded();
            base64encoded = Base64.getEncoder().encodeToString(hash);
        }catch (NoSuchAlgorithmException | InvalidKeySpecException ex){
            System.err.println(ex);
        }
        return base64encoded;
    }
}
