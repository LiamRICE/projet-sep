package com.fastandflavorous.projetsep.model.users;

/**
 * 
 */
public class Client extends User {

    /**
     * Default constructor
     */
    public Client(String name, String token, int loyaltyPoints) {
        super(name);
        this.token = token;
        this.loyaltyPoints = loyaltyPoints;
    }

    /**
     * 
     */
    private String token;

    /**
     * 
     */
    private int loyaltyPoints;

    /**
     * @return the token of the client
     */
    public String getToken() {
        return getToken();
    }

    /**
     * @return the loyaltyPoints of the client
     */
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    /**
     * @return
     */
    public int useLoyaltyPoints() {
        // TODO implement here
        return 0;
    }

}