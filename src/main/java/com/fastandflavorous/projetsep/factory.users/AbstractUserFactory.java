package com.fastandflavorous.projetsep.factory.users;

import com.fastandflavorous.projetsep.dao.users.UserDAO;
import com.fastandflavorous.projetsep.dao.users.UserDAOSQL;
import com.fastandflavorous.projetsep.model.users.Client;
import com.fastandflavorous.projetsep.model.users.ClientManager;
import com.fastandflavorous.projetsep.model.users.Employee;
import com.fastandflavorous.projetsep.model.users.EmployeeManager;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

/**
 * 
 */
public class AbstractUserFactory {

    private UserDAO dao;
    private EmployeeManager employeeManager;
    private ClientManager clientManager;

    /**
     * Default constructor
     */
    public AbstractUserFactory() {
        this.dao = new UserDAOSQL();
        this.employeeManager = EmployeeManager.getEmployeeManager();
        this.clientManager = ClientManager.getClientManager();
    }

    /**
     * @param token
     * @return
     */
    public Client checkClientLogin(String token) {
        Client client = dao.getClient(token);
        if(client!=null){
            clientManager.addClient(client);
        }
        return client;
    }

    /**
     * @param email
     * @param password
     * @return
     */
    public Employee checkEmployeeLogin(String email, String password) {
        Employee e = dao.getEmployee(email);
        if(e!=null) {
            SecureRandom random = new SecureRandom();
            byte[] salt = "fastAndFlavorous".getBytes();
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
            String base64encoded ="";
            try{
                SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
                byte[] hash = factory.generateSecret(spec).getEncoded();
                base64encoded = Base64.getEncoder().encodeToString(hash);
            }catch (NoSuchAlgorithmException| InvalidKeySpecException ex){
                System.err.println(ex);

            }

            if (base64encoded.equals(e.getPassword())) {
                employeeManager.addEmployee(e);
                return e;
            } else {
                return null;
            }
        }else{
            return e;
        }
    }

    /**
     * @param employee
     * @return
     */
    public void addEmployeeToManager(Employee employee) {
        // TODO implement here
    }

    /**
     * @param client
     * @return
     */
    public void addClientToManager(Client client) {
        // TODO implement here
    }

}