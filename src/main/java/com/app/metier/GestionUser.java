package com.app.metier;

import com.app.dao.IGestionUserDAO;

public class GestionUser {
    private IGestionUserDAO userDAO;

    public GestionUser(IGestionUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean authenticate(String username, String password) {
        User user = userDAO.getUserByUsername(username);
        return user != null && user.getPassword().equals(password);
    }


}

