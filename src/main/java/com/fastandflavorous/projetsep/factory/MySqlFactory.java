package com.fastandflavorous.projetsep.factory;

import com.fastandflavorous.projetsep.dao.users.AbstractUserDAO;
import com.fastandflavorous.projetsep.dao.users.MySQLUserDAO;

public class MySqlFactory extends AbstractFactory{
    public MySqlFactory(){
        super();
    }

    public AbstractUserDAO getUserDAO(){
        return new MySQLUserDAO();
    }

}
