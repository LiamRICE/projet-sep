package com.fastandflavorous.projetsep.facade.login;

import com.fastandflavorous.projetsep.dao.users.AbstractUserDAO;
import com.fastandflavorous.projetsep.factory.AbstractFactory;
import com.fastandflavorous.projetsep.model.users.*;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

/**
 * 
 */
public class UserFacade extends AbstractUserFacade {
    private static final String SALT = "fastAndFlavorous";
    private static final String ALGORITHM = "PBKDF2WithHmacSHA1";
    private final AbstractUserDAO userDao;
    private User currentUser;

    /**
     * Default constructor
     */
    public UserFacade() {
        userDao = AbstractFactory.getFactory().getUserDAO();
    }

    /**
     * Ask the business logic to check the client credential
     * @param token the token that allows the client to log in to the application
     * @return It returns the client if the credential is right otherwise it returns the null
     */
    public boolean checkClientLogin(String token) {
        Client client = userDao.getClient(token);
        this.currentUser = client;
        if(this.currentUser!=null){
            ClientManager.getClientManager().addClient((Client) this.currentUser);
        }
        if(this.currentUser == null){
            return false;
        }else{
            return true;
        }
    }

    public String getUserName(){
        if(currentUser != null) {
            return this.currentUser.getName();
        }else{
            return "UNKNOWN";
        }
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
        System.out.println(base64encoded);
        return base64encoded;
    }

    /**
     * Ask the business logic to check the employee credentials
     * @param email the email that allows the employee to log in to the application
     * @param password the password that allows the employee to log in to the application
     * @return It returns the employee if the credentials were right otherwise it returns the null
     */
    public boolean checkEmployeeLogin(String email, String password) {
        Employee e = userDao.getEmployee(email);
        this.currentUser = e;
        if(e!=null) {
            String hashedEnteredPassword = getHashedPassword(password);
            if (hashedEnteredPassword.equals(e.getPassword())) {
               EmployeeManager.getEmployeeManager().addEmployee(e);
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public boolean isCurrentUserDirector(){
        return ((Employee) this.currentUser).isDirector();
    }


}