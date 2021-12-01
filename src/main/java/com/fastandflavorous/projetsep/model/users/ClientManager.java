package com.fastandflavorous.projetsep.model.users;

import java.util.*;

/**
 * 
 */
public class ClientManager {

    private List<Client> clients;
    private static Object syncronizer = new Object();

    /**
     * Default constructor
     */
    public ClientManager() {
        this.clients = new ArrayList<>();
    }

    private static ClientManager clientManager;

    public static ClientManager getClientManager(){
        if(ClientManager.clientManager == null){
            synchronized (ClientManager.syncronizer){
                if(ClientManager.clientManager == null){
                    ClientManager.clientManager = new ClientManager();
                }
            }
        }
        return ClientManager.clientManager;
    }

    public void addClient(Client client){
        if(client!=null){
            clients.add(client);
        }
    }

    /**
     * @param client
     * @return
     */
    public boolean checkToken(String client) {
        // TODO implement here
        return false;
    }

    /**
     * @param client
     * @return
     */
    public int getLoyaltyPoints(Client client) {
        // TODO implement here
        return 0;
    }

    /**
     * @param client
     * @return
     */
    public String getName(Client client) {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public List<Client> getAllClients() {
        // TODO implement here
        return null;
    }

}